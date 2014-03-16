package de.mathema.abersicher.backend.mandate;

import de.mathema.abersicher.backend.BackendBaseRequest;

public class CreateMandateBackendRequest extends BackendBaseRequest {
   private String targetAccount;

   public String getTargetAccount() {
      return targetAccount;
   }
   public void setTargetAccount(String targetAccount) {
      this.targetAccount=targetAccount;
   }

}


