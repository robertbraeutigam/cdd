package dev.robertbrautigam.cdd.backend.account;

import dev.robertbrautigam.cdd.backend.BackendBaseResponse;

public class CreateAccountsBackendResponse extends BackendBaseResponse {
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


