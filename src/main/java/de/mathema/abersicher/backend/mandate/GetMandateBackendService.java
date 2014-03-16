package de.mathema.abersicher.backend.mandate;

import de.mathema.abersicher.backend.*;

public class GetMandateBackendService implements BackendService<GetMandateBackendRequest, GetMandateBackendResponse> {
   @Override
   public GetMandateBackendResponse call(GetMandateBackendRequest request) {
      GetMandateBackendResponse response = new GetMandateBackendResponse();
      response.addMessage(new BackendMessage("MSG2055", "Mandat nicht gefunden für Konto: "+request.getTargetAccount()));
      return response;
   }
}


