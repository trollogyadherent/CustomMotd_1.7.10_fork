/*     */ package org.apache.commons.validator.routines;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class RegexValidator
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8832409930574867162L;
/*     */   private final Pattern[] patterns;
/*     */   
/*     */   public RegexValidator(String regex) {
/*  84 */     this(regex, true);
/*     */   }
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
/*     */   public RegexValidator(String regex, boolean caseSensitive) {
/*  97 */     this(new String[] { regex }, caseSensitive);
/*     */   }
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
/*     */   public RegexValidator(String[] regexs) {
/* 110 */     this(regexs, true);
/*     */   }
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
/*     */   public RegexValidator(String[] regexs, boolean caseSensitive) {
/* 123 */     if (regexs == null || regexs.length == 0) {
/* 124 */       throw new IllegalArgumentException("Regular expressions are missing");
/*     */     }
/* 126 */     this.patterns = new Pattern[regexs.length];
/* 127 */     int flags = caseSensitive ? 0 : 2;
/* 128 */     for (int i = 0; i < regexs.length; i++) {
/* 129 */       if (regexs[i] == null || regexs[i].length() == 0) {
/* 130 */         throw new IllegalArgumentException("Regular expression[" + i + "] is missing");
/*     */       }
/* 132 */       this.patterns[i] = Pattern.compile(regexs[i], flags);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid(String value) {
/* 144 */     if (value == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     for (Pattern pattern : this.patterns) {
/* 148 */       if (pattern.matcher(value).matches()) {
/* 149 */         return true;
/*     */       }
/*     */     } 
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] match(String value) {
/* 164 */     if (value == null) {
/* 165 */       return null;
/*     */     }
/* 167 */     for (Pattern pattern : this.patterns) {
/* 168 */       Matcher matcher = pattern.matcher(value);
/* 169 */       if (matcher.matches()) {
/* 170 */         int count = matcher.groupCount();
/* 171 */         String[] groups = new String[count];
/* 172 */         for (int j = 0; j < count; j++) {
/* 173 */           groups[j] = matcher.group(j + 1);
/*     */         }
/* 175 */         return groups;
/*     */       } 
/*     */     } 
/* 178 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String validate(String value) {
/* 190 */     if (value == null) {
/* 191 */       return null;
/*     */     }
/* 193 */     for (Pattern pattern : this.patterns) {
/* 194 */       Matcher matcher = pattern.matcher(value);
/* 195 */       if (matcher.matches()) {
/* 196 */         int count = matcher.groupCount();
/* 197 */         if (count == 1) {
/* 198 */           return matcher.group(1);
/*     */         }
/* 200 */         StringBuilder buffer = new StringBuilder();
/* 201 */         for (int j = 0; j < count; j++) {
/* 202 */           String component = matcher.group(j + 1);
/* 203 */           if (component != null) {
/* 204 */             buffer.append(component);
/*     */           }
/*     */         } 
/* 207 */         return buffer.toString();
/*     */       } 
/*     */     } 
/* 210 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buffer = new StringBuilder();
/* 220 */     buffer.append("RegexValidator{");
/* 221 */     for (int i = 0; i < this.patterns.length; i++) {
/* 222 */       if (i > 0) {
/* 223 */         buffer.append(",");
/*     */       }
/* 225 */       buffer.append(this.patterns[i].pattern());
/*     */     } 
/* 227 */     buffer.append("}");
/* 228 */     return buffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\org\apache\commons\validator\routines\RegexValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */