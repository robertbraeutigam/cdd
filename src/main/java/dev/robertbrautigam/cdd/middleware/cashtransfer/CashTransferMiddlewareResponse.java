package dev.robertbrautigam.cdd.middleware.cashtransfer;

import dev.robertbrautigam.cdd.middleware.MiddlewareBaseResponse;

public class CashTransferMiddlewareResponse extends MiddlewareBaseResponse {
   private String transferId;
   
   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


