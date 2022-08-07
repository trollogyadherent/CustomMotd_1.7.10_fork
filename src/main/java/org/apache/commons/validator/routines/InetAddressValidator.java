/*     */ package org.apache.commons.validator.routines;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InetAddressValidator
/*     */   implements Serializable
/*     */ {
/*     */   private static final int IPV4_MAX_OCTET_VALUE = 255;
/*     */   private static final int MAX_UNSIGNED_SHORT = 65535;
/*     */   private static final int BASE_16 = 16;
/*     */   private static final long serialVersionUID = -919201640201914789L;
/*     */   private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
/*     */   private static final int IPV6_MAX_HEX_GROUPS = 8;
/*     */   private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
/*  58 */   private static final InetAddressValidator VALIDATOR = new InetAddressValidator();
/*     */ 
/*     */   
/*  61 */   private final RegexValidator ipv4Validator = new RegexValidator("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InetAddressValidator getInstance() {
/*  68 */     return VALIDATOR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid(String inetAddress) {
/*  77 */     return (isValidInet4Address(inetAddress) || isValidInet6Address(inetAddress));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidInet4Address(String inet4Address) {
/*  87 */     String[] groups = this.ipv4Validator.match(inet4Address);
/*     */     
/*  89 */     if (groups == null) {
/*  90 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  94 */     for (String ipSegment : groups) {
/*  95 */       if (ipSegment == null || ipSegment.length() == 0) {
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       int iIpSegment = 0;
/*     */       
/*     */       try {
/* 102 */         iIpSegment = Integer.parseInt(ipSegment);
/*     */       }
/* 104 */       catch (NumberFormatException e) {
/* 105 */         return false;
/*     */       } 
/*     */       
/* 108 */       if (iIpSegment > 255) {
/* 109 */         return false;
/*     */       }
/*     */       
/* 112 */       if (ipSegment.length() > 1 && ipSegment.startsWith("0")) {
/* 113 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidInet6Address(String inet6Address) {
/* 129 */     boolean containsCompressedZeroes = inet6Address.contains("::");
/* 130 */     if (containsCompressedZeroes && inet6Address.indexOf("::") != inet6Address.lastIndexOf("::")) {
/* 131 */       return false;
/*     */     }
/* 133 */     if ((inet6Address.startsWith(":") && !inet6Address.startsWith("::")) || (inet6Address.endsWith(":") && !inet6Address.endsWith("::"))) {
/* 134 */       return false;
/*     */     }
/* 136 */     String[] octets = inet6Address.split(":");
/* 137 */     if (containsCompressedZeroes) {
/* 138 */       List<String> octetList = new ArrayList<>(Arrays.asList(octets));
/* 139 */       if (inet6Address.endsWith("::")) {
/*     */         
/* 141 */         octetList.add("");
/*     */       }
/* 143 */       else if (inet6Address.startsWith("::") && !octetList.isEmpty()) {
/* 144 */         octetList.remove(0);
/*     */       } 
/* 146 */       octets = octetList.<String>toArray(new String[octetList.size()]);
/*     */     } 
/* 148 */     if (octets.length > 8) {
/* 149 */       return false;
/*     */     }
/* 151 */     int validOctets = 0;
/* 152 */     int emptyOctets = 0;
/* 153 */     int index = 0; while (true) { if (index < octets.length)
/* 154 */       { String octet = octets[index];
/* 155 */         if (octet.length() == 0)
/* 156 */         { emptyOctets++;
/* 157 */           if (emptyOctets > 1) {
/* 158 */             return false;
/*     */           } }
/*     */         else
/*     */         
/* 162 */         { emptyOctets = 0;
/* 163 */           if (octet.contains("."))
/* 164 */           { if (!inet6Address.endsWith(octet)) {
/* 165 */               return false;
/*     */             }
/* 167 */             if (index > octets.length - 1 || index > 6)
/*     */             {
/* 169 */               return false;
/*     */             }
/* 171 */             if (!isValidInet4Address(octet)) {
/* 172 */               return false;
/*     */             }
/* 174 */             validOctets += 2; }
/*     */           else
/*     */           
/* 177 */           { if (octet.length() > 4) {
/* 178 */               return false;
/*     */             }
/* 180 */             int octetInt = 0;
/*     */             try {
/* 182 */               octetInt = Integer.valueOf(octet, 16).intValue();
/*     */             }
/* 184 */             catch (NumberFormatException e) {
/* 185 */               return false;
/*     */             } 
/* 187 */             if (octetInt < 0 || octetInt > 65535) {
/* 188 */               return false;
/*     */             }
/*     */             
/* 191 */             validOctets++; }  index++; }  } else { break; }  validOctets++; }
/*     */     
/* 193 */     if (validOctets < 8 && !containsCompressedZeroes) {
/* 194 */       return false;
/*     */     }
/* 196 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\org\apache\commons\validator\routines\InetAddressValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */