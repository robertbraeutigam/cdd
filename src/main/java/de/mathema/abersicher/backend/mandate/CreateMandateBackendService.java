package de.mathema.abersicher.backend.mandate;

import de.mathema.abersicher.backend.*;

public class CreateMandateBackendService implements BackendService<CreateMandateBackendRequest, CreateMandateBackendResponse> {
   @Override
   public CreateMandateBackendResponse call(CreateMandateBackendRequest request) {
      CreateMandateBackendResponse response = new CreateMandateBackendResponse();
      response.addMessage(new BackendMessage("MSG1055", "Mandat angelegt für Konto: "+request.getTargetAccount()));
      response.setMandateId("Mandat-1123");
      return response;
   }
}


