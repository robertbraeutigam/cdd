package dev.robertbrautigam.cdd.backend.account;

import dev.robertbrautigam.cdd.backend.BackendBaseResponse;

public class CreateClearingAccountBackendResponse extends BackendBaseResponse {
   private String accountNo;

   public String getAccountNo() {
      return accountNo;
   }
   public void setAccountNo(String accountNo) {
      this.accountNo=accountNo;
   }

}


