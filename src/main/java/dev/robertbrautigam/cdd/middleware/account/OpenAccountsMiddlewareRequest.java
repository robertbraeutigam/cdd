package dev.robertbrautigam.cdd.middleware.account;

import dev.robertbrautigam.cdd.middleware.MiddlewareBaseRequest;

public class OpenAccountsMiddlewareRequest extends MiddlewareBaseRequest {
   private String ownerName;

   public String getOwnerName() {
      return ownerName;
   }
   public void setOwnerName(String ownerName) {
      this.ownerName=ownerName;
   }

}


