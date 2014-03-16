package de.mathema.abersicher.backend.account;

import de.mathema.abersicher.backend.BackendBaseRequest;

public class CreateClearingAccountBackendRequest extends BackendBaseRequest {
   private String ownerName;

   public String getOwnerName() {
      return ownerName;
   }
   public void setOwnerName(String ownerName) {
      this.ownerName=ownerName;
   }

}


