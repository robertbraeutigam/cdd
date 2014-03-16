package de.mathema.abersicher.middleware.cashtransfer;

import de.mathema.abersicher.middleware.MiddlewareBaseResponse;

public class CashTransferMiddlewareResponse extends MiddlewareBaseResponse {
   private String transferId;
   
   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


