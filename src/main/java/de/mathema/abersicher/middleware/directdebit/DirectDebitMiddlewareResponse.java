package de.mathema.abersicher.middleware.directdebit;

import de.mathema.abersicher.middleware.MiddlewareBaseResponse;

public class DirectDebitMiddlewareResponse extends MiddlewareBaseResponse {
   private String transferId;

   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


