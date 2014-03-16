package de.mathema.abersicher.backend.mandate;

import de.mathema.abersicher.backend.BackendBaseResponse;

public class CreateMandateBackendResponse extends BackendBaseResponse {
   private String mandateId;

   public String getMandateId() {
      return mandateId;
   }
   public void setMandateId(String mandateId) {
      this.mandateId=mandateId;
   }

}


