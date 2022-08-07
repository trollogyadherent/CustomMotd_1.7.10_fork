/*     */ package org.apache.commons.validator.util;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class Flags
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 8481587558770237995L;
/*  48 */   private long flags = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flags() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flags(long flags) {
/*  64 */     this.flags = flags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFlags() {
/*  73 */     return this.flags;
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
/*     */   public boolean isOn(long flag) {
/*  85 */     return ((this.flags & flag) == flag);
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
/*     */   public boolean isOff(long flag) {
/*  97 */     return ((this.flags & flag) == 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void turnOn(long flag) {
/* 107 */     this.flags |= flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void turnOff(long flag) {
/* 117 */     this.flags &= flag ^ 0xFFFFFFFFFFFFFFFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void turnOffAll() {
/* 124 */     this.flags = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 132 */     this.flags = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void turnOnAll() {
/* 139 */     this.flags = -1L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/*     */     try {
/* 151 */       return super.clone();
/*     */     }
/* 153 */     catch (CloneNotSupportedException e) {
/* 154 */       throw new RuntimeException("Couldn't clone Flags object.");
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
/*     */   
/*     */   public boolean equals(Object obj) {
/* 167 */     if (!(obj instanceof Flags)) {
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     if (obj == this) {
/* 172 */       return true;
/*     */     }
/*     */     
/* 175 */     Flags f = (Flags)obj;
/*     */     
/* 177 */     return (this.flags == f.flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 188 */     return (int)this.flags;
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
/*     */   public String toString() {
/* 200 */     StringBuilder bin = new StringBuilder(Long.toBinaryString(this.flags));
/* 201 */     for (int i = 64 - bin.length(); i > 0; i--) {
/* 202 */       bin.insert(0, "0");
/*     */     }
/* 204 */     return bin.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\org\apache\commons\validato\\util\Flags.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */