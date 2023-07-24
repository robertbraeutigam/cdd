package dev.robertbrautigam.cdd.backend.directdebit;

import dev.robertbrautigam.cdd.backend.BackendBaseRequest;

public class DirectDebitBackendRequest extends BackendBaseRequest {
   private String mandateId;
   private String targetAccount;

   public String getMandateId() {
      return mandateId;
   }
   public void setMandateId(String mandateId) {
      this.mandateId=mandateId;
   }

   public String getTargetAccount() {
      return targetAccount;
   }
   public void setTargetAccount(String targetAccount) {
      this.targetAccount=targetAccount;
   }

}


