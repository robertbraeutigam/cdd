package dev.robertbrautigam.cdd.backend.account;

import dev.robertbrautigam.cdd.backend.BackendBaseRequest;

public class CreateGiroAccountBackendRequest extends BackendBaseRequest {
   private String clearingAccountNo;
   
   public String getClearingAccountNo() {
      return clearingAccountNo;
   }
   public void setClearingAccountNo(String clearingAccountNo) {
      this.clearingAccountNo=clearingAccountNo;
   }

}


