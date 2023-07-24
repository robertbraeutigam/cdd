package dev.robertbrautigam.cdd.middleware.directdebit;

import dev.robertbrautigam.cdd.middleware.MiddlewareBaseResponse;

public class DirectDebitMiddlewareResponse extends MiddlewareBaseResponse {
   private String transferId;

   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


