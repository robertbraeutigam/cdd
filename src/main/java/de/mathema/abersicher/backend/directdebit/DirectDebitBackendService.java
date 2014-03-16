package de.mathema.abersicher.backend.directdebit;

import de.mathema.abersicher.backend.BackendService;
import de.mathema.abersicher.backend.BackendMessage;
import de.mathema.abersicher.SystemException;

public class DirectDebitBackendService implements BackendService<DirectDebitBackendRequest, DirectDebitBackendResponse> {
   @Override
   public DirectDebitBackendResponse call(DirectDebitBackendRequest request) throws SystemException {
      DirectDebitBackendResponse response = new DirectDebitBackendResponse();
      response.addMessage(new BackendMessage("MSG1002", "Lastschrift erfolgreich registriert auf das Konto: "+request.getTargetAccount()));
      response.setTransferId("TX-2");
      return response;
   }
}


