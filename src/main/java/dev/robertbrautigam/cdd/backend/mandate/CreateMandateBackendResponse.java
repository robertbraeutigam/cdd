package dev.robertbrautigam.cdd.backend.mandate;

import dev.robertbrautigam.cdd.backend.BackendBaseResponse;

public class CreateMandateBackendResponse extends BackendBaseResponse {
   private String mandateId;

   public String getMandateId() {
      return mandateId;
   }
   public void setMandateId(String mandateId) {
      this.mandateId=mandateId;
   }

}


