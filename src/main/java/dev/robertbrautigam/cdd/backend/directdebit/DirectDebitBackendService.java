package dev.robertbrautigam.cdd.backend.directdebit;

import dev.robertbrautigam.cdd.backend.BackendService;
import dev.robertbrautigam.cdd.backend.BackendMessage;
import dev.robertbrautigam.cdd.SystemException;

public class DirectDebitBackendService implements BackendService<DirectDebitBackendRequest, DirectDebitBackendResponse> {
   @Override
   public DirectDebitBackendResponse call(DirectDebitBackendRequest request) throws SystemException {
      DirectDebitBackendResponse response = new DirectDebitBackendResponse();
      response.addMessage(new BackendMessage("MSG1002", "Direct debit successfully submitted against account #"+request.getTargetAccount()));
      response.setTransferId("TX-2");
      return response;
   }
}


