package de.mathema.abersicher.backend.directdebit;

import de.mathema.abersicher.backend.BackendBaseRequest;

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


