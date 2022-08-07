/*     */ package org.apache.commons.validator;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.validator.routines.InetAddressValidator;
/*     */ import org.apache.commons.validator.util.Flags;
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
/*     */ public class UrlValidator
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 24137157400029593L;
/*     */   public static final int ALLOW_ALL_SCHEMES = 1;
/*     */   public static final int ALLOW_2_SLASHES = 2;
/*     */   public static final int NO_FRAGMENTS = 4;
/*     */   private static final String ALPHA_CHARS = "a-zA-Z";
/*     */   private static final String SPECIAL_CHARS = ";/@&=,.?:+$";
/*     */   private static final String VALID_CHARS = "[^\\s;/@&=,.?:+$]";
/*     */   private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
/*     */   private static final String ATOM = "[^\\s;/@&=,.?:+$]+";
/*     */   private static final String URL_REGEX = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
/* 115 */   private static final Pattern URL_PATTERN = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?");
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PARSE_URL_SCHEME = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PARSE_URL_AUTHORITY = 4;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PARSE_URL_PATH = 5;
/*     */ 
/*     */   
/*     */   private static final int PARSE_URL_QUERY = 7;
/*     */ 
/*     */   
/*     */   private static final int PARSE_URL_FRAGMENT = 9;
/*     */ 
/*     */   
/* 136 */   private static final Pattern SCHEME_PATTERN = Pattern.compile("^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*");
/*     */   
/*     */   private static final String AUTHORITY_REGEX = "^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?";
/*     */   
/* 140 */   private static final Pattern AUTHORITY_PATTERN = Pattern.compile("^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?");
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PARSE_AUTHORITY_HOST_IP = 1;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PARSE_AUTHORITY_PORT = 2;
/*     */ 
/*     */   
/* 151 */   private static final Pattern PATH_PATTERN = Pattern.compile("^(/[-\\w:@&?=+,.!/~*'%$_;]*)?$");
/*     */   
/* 153 */   private static final Pattern QUERY_PATTERN = Pattern.compile("^(.*)$");
/*     */   
/* 155 */   private static final Pattern LEGAL_ASCII_PATTERN = Pattern.compile("^\\p{ASCII}+$");
/*     */   
/* 157 */   private static final Pattern DOMAIN_PATTERN = Pattern.compile("^[^\\s;/@&=,.?:+$]+(\\.[^\\s;/@&=,.?:+$]+)*$");
/*     */   
/* 159 */   private static final Pattern PORT_PATTERN = Pattern.compile("^:(\\d{1,5})$");
/*     */   
/* 161 */   private static final Pattern ATOM_PATTERN = Pattern.compile("^([^\\s;/@&=,.?:+$]+).*?$");
/*     */   
/* 163 */   private static final Pattern ALPHA_PATTERN = Pattern.compile("^[a-zA-Z]");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Flags options;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   private final Set<String> allowedSchemes = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   protected String[] defaultSchemes = new String[] { "http", "https", "ftp" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UrlValidator() {
/* 186 */     this((String[])null);
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
/*     */   public UrlValidator(String[] schemes) {
/* 198 */     this(schemes, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UrlValidator(int options) {
/* 208 */     this(null, options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UrlValidator(String[] schemes, int options) {
/* 219 */     this.options = new Flags(options);
/*     */     
/* 221 */     if (this.options.isOn(1L)) {
/*     */       return;
/*     */     }
/*     */     
/* 225 */     if (schemes == null) {
/* 226 */       schemes = this.defaultSchemes;
/*     */     }
/*     */     
/* 229 */     this.allowedSchemes.addAll(Arrays.asList(schemes));
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
/* 240 */     if (value == null) {
/* 241 */       return false;
/*     */     }
/* 243 */     if (!LEGAL_ASCII_PATTERN.matcher(value).matches()) {
/* 244 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 248 */     Matcher urlMatcher = URL_PATTERN.matcher(value);
/* 249 */     if (!urlMatcher.matches()) {
/* 250 */       return false;
/*     */     }
/*     */     
/* 253 */     if (!isValidScheme(urlMatcher.group(2))) {
/* 254 */       return false;
/*     */     }
/*     */     
/* 257 */     if (!isValidAuthority(urlMatcher.group(4))) {
/* 258 */       return false;
/*     */     }
/*     */     
/* 261 */     if (!isValidPath(urlMatcher.group(5))) {
/* 262 */       return false;
/*     */     }
/*     */     
/* 265 */     if (!isValidQuery(urlMatcher.group(7))) {
/* 266 */       return false;
/*     */     }
/*     */     
/* 269 */     if (!isValidFragment(urlMatcher.group(9))) {
/* 270 */       return false;
/*     */     }
/*     */     
/* 273 */     return true;
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
/*     */   protected boolean isValidScheme(String scheme) {
/* 285 */     if (scheme == null) {
/* 286 */       return false;
/*     */     }
/*     */     
/* 289 */     if (!SCHEME_PATTERN.matcher(scheme).matches()) {
/* 290 */       return false;
/*     */     }
/*     */     
/* 293 */     if (this.options.isOff(1L) && !this.allowedSchemes.contains(scheme)) {
/* 294 */       return false;
/*     */     }
/*     */     
/* 297 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidAuthority(String authority) {
/* 307 */     if (authority == null) {
/* 308 */       return false;
/*     */     }
/*     */     
/* 311 */     InetAddressValidator inetAddressValidator = InetAddressValidator.getInstance();
/*     */     
/* 313 */     Matcher authorityMatcher = AUTHORITY_PATTERN.matcher(authority);
/* 314 */     if (!authorityMatcher.matches()) {
/* 315 */       return false;
/*     */     }
/*     */     
/* 318 */     boolean hostname = false;
/*     */     
/* 320 */     String hostIP = authorityMatcher.group(1);
/* 321 */     boolean ipV4Address = inetAddressValidator.isValid(hostIP);
/*     */     
/* 323 */     if (!ipV4Address)
/*     */     {
/* 325 */       hostname = DOMAIN_PATTERN.matcher(hostIP).matches();
/*     */     }
/*     */ 
/*     */     
/* 329 */     if (hostname) {
/*     */ 
/*     */       
/* 332 */       char[] chars = hostIP.toCharArray();
/* 333 */       int size = 1;
/* 334 */       for (char c : chars) {
/* 335 */         if (c == '.') {
/* 336 */           size++;
/*     */         }
/*     */       } 
/* 339 */       String[] domainSegment = new String[size];
/* 340 */       boolean match = true;
/* 341 */       int segmentCount = 0;
/* 342 */       int segmentLength = 0;
/*     */       
/* 344 */       while (match) {
/* 345 */         Matcher atomMatcher = ATOM_PATTERN.matcher(hostIP);
/* 346 */         match = atomMatcher.matches();
/* 347 */         if (match) {
/* 348 */           domainSegment[segmentCount] = atomMatcher.group(1);
/* 349 */           segmentLength = domainSegment[segmentCount].length() + 1;
/* 350 */           hostIP = (segmentLength >= hostIP.length()) ? "" : hostIP.substring(segmentLength);
/*     */           
/* 352 */           segmentCount++;
/*     */         } 
/*     */       } 
/* 355 */       String topLevel = domainSegment[segmentCount - 1];
/* 356 */       if (topLevel.length() < 2 || topLevel.length() > 4) {
/* 357 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 361 */       if (!ALPHA_PATTERN.matcher(topLevel.substring(0, 1)).matches()) {
/* 362 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 366 */       if (segmentCount < 2) {
/* 367 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 371 */     if (!hostname && !ipV4Address) {
/* 372 */       return false;
/*     */     }
/*     */     
/* 375 */     String port = authorityMatcher.group(2);
/* 376 */     if (port != null && !PORT_PATTERN.matcher(port).matches()) {
/* 377 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidPath(String path) {
/* 394 */     if (path == null) {
/* 395 */       return false;
/*     */     }
/*     */     
/* 398 */     if (!PATH_PATTERN.matcher(path).matches()) {
/* 399 */       return false;
/*     */     }
/*     */     
/* 402 */     int slash2Count = countToken("//", path);
/* 403 */     if (this.options.isOff(2L) && slash2Count > 0) {
/* 404 */       return false;
/*     */     }
/*     */     
/* 407 */     int slashCount = countToken("/", path);
/* 408 */     int dot2Count = countToken("..", path);
/* 409 */     if (dot2Count > 0 && slashCount - slash2Count - 1 <= dot2Count) {
/* 410 */       return false;
/*     */     }
/*     */     
/* 413 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidQuery(String query) {
/* 422 */     if (query == null) {
/* 423 */       return true;
/*     */     }
/*     */     
/* 426 */     return QUERY_PATTERN.matcher(query).matches();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidFragment(String fragment) {
/* 435 */     if (fragment == null) {
/* 436 */       return true;
/*     */     }
/*     */     
/* 439 */     return this.options.isOff(4L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int countToken(String token, String target) {
/* 449 */     int tokenIndex = 0;
/* 450 */     int count = 0;
/* 451 */     while (tokenIndex != -1) {
/* 452 */       tokenIndex = target.indexOf(token, tokenIndex);
/* 453 */       if (tokenIndex > -1) {
/* 454 */         tokenIndex++;
/* 455 */         count++;
/*     */       } 
/*     */     } 
/* 458 */     return count;
/*     */   }
/*     */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\org\apache\commons\validator\UrlValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */