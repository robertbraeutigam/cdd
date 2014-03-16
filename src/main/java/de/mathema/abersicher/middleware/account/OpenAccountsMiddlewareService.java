package de.mathema.abersicher.middleware.account;

import de.mathema.abersicher.middleware.MiddlewareService;
import de.mathema.abersicher.SystemException;
import de.mathema.abersicher.backend.account.*;

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

