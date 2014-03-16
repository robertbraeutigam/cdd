package de.mathema.abersicher.middleware.account;

import de.mathema.abersicher.middleware.MiddlewareBaseRequest;

public class OpenAccountsMiddlewareRequest extends MiddlewareBaseRequest {
   private String ownerName;

   public String getOwnerName() {
      return ownerName;
   }
   public void setOwnerName(String ownerName) {
      this.ownerName=ownerName;
   }

}


