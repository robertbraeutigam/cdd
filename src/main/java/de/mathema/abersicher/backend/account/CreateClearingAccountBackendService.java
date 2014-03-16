package de.mathema.abersicher.backend.account;

import de.mathema.abersicher.backend.BackendService;
import de.mathema.abersicher.backend.BackendMessage;
import de.mathema.abersicher.SystemException;

public class CreateClearingAccountBackendService implements BackendService<CreateClearingAccountBackendRequest, CreateClearingAccountBackendResponse> {
   @Override
   public CreateClearingAccountBackendResponse call(CreateClearingAccountBackendRequest request) throws SystemException {
      CreateClearingAccountBackendResponse response = new CreateClearingAccountBackendResponse();
      response.setAccountNo("123456789");
      response.addMessage(new BackendMessage("MSG1010", "Abrechnungskonto angelegt mit Kontonummer: 123456789"));
      return response;
   }
}


