package de.mathema.abersicher.middleware.account;

import de.mathema.abersicher.middleware.MiddlewareService;
import de.mathema.abersicher.SystemException;
import de.mathema.abersicher.backend.account.*;

public class OpenAccountsMiddlewareService implements MiddlewareService<OpenAccountsMiddlewareRequest, OpenAccountsMiddlewareResponse> {
   @Override
   public OpenAccountsMiddlewareResponse call(OpenAccountsMiddlewareRequest request) throws SystemException {
      OpenAccountsMiddlewareResponse response = new OpenAccountsMiddlewareResponse();
      CreateAccountsBackendRequest backendRequest = new CreateAccountsBackendRequest();
      backendRequest.setOwnerName(request.getOwnerName());
      new CreateAccountsBackendService().call(backendRequest);

      return response;
   }
}

