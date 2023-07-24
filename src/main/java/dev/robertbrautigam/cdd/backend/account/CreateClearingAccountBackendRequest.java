package dev.robertbrautigam.cdd.backend.account;

import dev.robertbrautigam.cdd.backend.BackendBaseRequest;

public class CreateClearingAccountBackendRequest extends BackendBaseRequest {
   private String ownerName;

   public String getOwnerName() {
      return ownerName;
   }
   public void setOwnerName(String ownerName) {
      this.ownerName=ownerName;
   }

}


