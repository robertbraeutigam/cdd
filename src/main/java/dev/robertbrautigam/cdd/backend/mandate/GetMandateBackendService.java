package dev.robertbrautigam.cdd.backend.mandate;

import dev.robertbrautigam.cdd.backend.*;
import dev.robertbrautigam.cdd.SystemException;

public class GetMandateBackendService implements BackendService<GetMandateBackendRequest, GetMandateBackendResponse> {
   @Override
   public GetMandateBackendResponse call(GetMandateBackendRequest request) throws SystemException {
      GetMandateBackendResponse response = new GetMandateBackendResponse();
      response.addMessage(new BackendMessage("MSG2055", "Mandat nicht gefunden für Konto: "+request.getTargetAccount()));
      return response;
   }
}


