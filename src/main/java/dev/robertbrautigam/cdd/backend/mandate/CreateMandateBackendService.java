package dev.robertbrautigam.cdd.backend.mandate;

import dev.robertbrautigam.cdd.backend.*;
import dev.robertbrautigam.cdd.SystemException;

public class CreateMandateBackendService implements BackendService<CreateMandateBackendRequest, CreateMandateBackendResponse> {
   @Override
   public CreateMandateBackendResponse call(CreateMandateBackendRequest request) throws SystemException {
      CreateMandateBackendResponse response = new CreateMandateBackendResponse();
      response.addMessage(new BackendMessage("MSG1055", "Mandat angelegt für Konto: "+request.getTargetAccount()));
      response.setMandateId("Mandat-1123");
      return response;
   }
}


