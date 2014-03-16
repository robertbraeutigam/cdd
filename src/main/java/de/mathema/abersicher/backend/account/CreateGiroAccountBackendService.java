package de.mathema.abersicher.backend.account;

import de.mathema.abersicher.backend.BackendService;
import de.mathema.abersicher.backend.BackendMessage;

public class CreateGiroAccountBackendService implements BackendService<CreateGiroAccountBackendRequest, CreateGiroAccountBackendResponse> {
   @Override
   public CreateGiroAccountBackendResponse call(CreateGiroAccountBackendRequest request) {
      CreateGiroAccountBackendResponse response = new CreateGiroAccountBackendResponse();
      response.setAccountNo("123456790");
      response.addMessage(new BackendMessage("MSG1011", "GIRO Konto angelegt mit Kontonummer: 123456790 (Abrechnungskonto: "+request.getClearingAccountNo()+")"));
      return response;
   }
}


