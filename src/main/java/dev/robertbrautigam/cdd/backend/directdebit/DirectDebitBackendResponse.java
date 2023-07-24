package dev.robertbrautigam.cdd.backend.directdebit;

import dev.robertbrautigam.cdd.backend.BackendBaseResponse;

public class DirectDebitBackendResponse extends BackendBaseResponse {
   private String transferId;
   
   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


