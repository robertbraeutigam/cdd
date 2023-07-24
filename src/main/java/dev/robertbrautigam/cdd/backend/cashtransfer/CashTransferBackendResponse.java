package dev.robertbrautigam.cdd.backend.cashtransfer;

import dev.robertbrautigam.cdd.backend.BackendBaseResponse;

public class CashTransferBackendResponse extends BackendBaseResponse {
   private String transferId;

   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


