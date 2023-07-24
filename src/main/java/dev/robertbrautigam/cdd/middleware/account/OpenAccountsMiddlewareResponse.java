package dev.robertbrautigam.cdd.middleware.account;

import dev.robertbrautigam.cdd.middleware.MiddlewareBaseResponse;

public class OpenAccountsMiddlewareResponse extends MiddlewareBaseResponse {
   private String clearingAccountNo;
   private String giroAccountNo;

   public String getClearingAccountNo() {
      return clearingAccountNo;
   }
   public void setClearingAccountNo(String clearingAccountNo) {
      this.clearingAccountNo=clearingAccountNo;
   }

   public String getGiroAccountNo() {
      return giroAccountNo;
   }
   public void setGiroAccountNo(String giroAccountNo) {
      this.giroAccountNo=giroAccountNo;
   }

}


