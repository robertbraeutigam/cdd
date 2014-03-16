package de.mathema.abersicher.backend.cashtransfer;

import de.mathema.abersicher.backend.BackendBaseResponse;

public class CashTransferBackendResponse extends BackendBaseResponse {
   private String transferId;

   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


