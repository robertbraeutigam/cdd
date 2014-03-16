package de.mathema.abersicher.middleware.account;

import de.mathema.abersicher.middleware.MiddlewareBaseResponse;

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


