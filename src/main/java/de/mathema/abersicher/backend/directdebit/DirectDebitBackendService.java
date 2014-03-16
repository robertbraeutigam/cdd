package de.mathema.abersicher.backend.directdebit;

import de.mathema.abersicher.backend.BackendService;
import de.mathema.abersicher.backend.BackendMessage;

public class DirectDebitBackendService implements BackendService<DirectDebitBackendRequest, DirectDebitBackendResponse> {
   @Override
   public DirectDebitBackendResponse call(DirectDebitBackendRequest request) {
      DirectDebitBackendResponse response = new DirectDebitBackendResponse();
      response.addMessage(new BackendMessage("MSG1002", "Lastschrift erfolgreich registriert auf das Konto: "+request.getTargetAccount()));
      return response;
   }
}


