package dev.robertbrautigam.cdd.backend.mandate;

import dev.robertbrautigam.cdd.backend.BackendBaseRequest;

public class CreateMandateBackendRequest extends BackendBaseRequest {
   private String targetAccount;

   public String getTargetAccount() {
      return targetAccount;
   }
   public void setTargetAccount(String targetAccount) {
      this.targetAccount=targetAccount;
   }

}


