package de.mathema.abersicher.backend.account;

import de.mathema.abersicher.backend.BackendBaseResponse;

public class CreateGiroAccountBackendResponse extends BackendBaseResponse {
   private String accountNo;
   
   public String getAccountNo() {
      return accountNo;
   }
   public void setAccountNo(String accountNo) {
      this.accountNo=accountNo;
   }

}


