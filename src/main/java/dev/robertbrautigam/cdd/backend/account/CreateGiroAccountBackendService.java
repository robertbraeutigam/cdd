package dev.robertbrautigam.cdd.backend.account;

import dev.robertbrautigam.cdd.backend.BackendService;
import dev.robertbrautigam.cdd.backend.BackendMessage;
import dev.robertbrautigam.cdd.SystemException;

public class CreateGiroAccountBackendService implements BackendService<CreateGiroAccountBackendRequest, CreateGiroAccountBackendResponse> {
   @Override
   public CreateGiroAccountBackendResponse call(CreateGiroAccountBackendRequest request) throws SystemException {
      CreateGiroAccountBackendResponse response = new CreateGiroAccountBackendResponse();
      response.setAccountNo("123456790");
      response.addMessage(new BackendMessage("MSG1011", "GIRO account created with account #123456790 (Billing account: #"+request.getClearingAccountNo()+")"));
      return response;
   }
}


