package de.mathema.abersicher.backend.account;

import de.mathema.abersicher.backend.BackendBaseRequest;

public class CreateGiroAccountBackendRequest extends BackendBaseRequest {
   private String clearingAccountNo;
   
   public String getClearingAccountNo() {
      return clearingAccountNo;
   }
   public void setClearingAccountNo(String clearingAccountNo) {
      this.clearingAccountNo=clearingAccountNo;
   }

}


