package de.mathema.abersicher.backend.directdebit;

import de.mathema.abersicher.backend.BackendBaseResponse;

public class DirectDebitBackendResponse extends BackendBaseResponse {
   private String transferId;
   
   public String getTransferId() {
      return transferId;
   }
   public void setTransferId(String transferId) {
      this.transferId=transferId;
   }

}


