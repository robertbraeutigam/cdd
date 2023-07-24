package dev.robertbrautigam.cdd.middleware.account;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.account.*;

public class OpenAccountsMiddlewareService implements MiddlewareService<OpenAccountsMiddlewareRequest, OpenAccountsMiddlewareResponse> {
   @Override
   public OpenAccountsMiddlewareResponse call(OpenAccountsMiddlewareRequest request) throws SystemException {
      CreateAccountsBackendRequest backendRequest = new CreateAccountsBackendRequest();
      backendRequest.setOwnerName(request.getOwnerName());
      CreateAccountsBackendResponse backendResponse = new CreateAccountsBackendService().call(backendRequest);

      OpenAccountsMiddlewareResponse response = new OpenAccountsMiddlewareResponse();
      response.setClearingAccountNo(backendResponse.getClearingAccountNo());
      response.setGiroAccountNo(backendResponse.getGiroAccountNo());
      return response;
   }
}

