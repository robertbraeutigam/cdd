package dev.robertbrautigam.cdd.backend.account;

import dev.robertbrautigam.cdd.backend.BackendService;
import dev.robertbrautigam.cdd.backend.BackendMessage;
import dev.robertbrautigam.cdd.SystemException;

public class CreateClearingAccountBackendService implements BackendService<CreateClearingAccountBackendRequest, CreateClearingAccountBackendResponse> {
   @Override
   public CreateClearingAccountBackendResponse call(CreateClearingAccountBackendRequest request) throws SystemException {
      CreateClearingAccountBackendResponse response = new CreateClearingAccountBackendResponse();
      response.setAccountNo("123456789");
      response.addMessage(new BackendMessage("MSG1010", "Billing account created with account #123456789"));
      return response;
   }
}


