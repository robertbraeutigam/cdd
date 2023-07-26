package dev.robertbrautigam.cdd.middleware.account;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.account.*;

public class OpenAccountsMiddlewareService implements MiddlewareService<OpenAccountsMiddlewareRequest, OpenAccountsMiddlewareResponse> {
   @Override
   public OpenAccountsMiddlewareResponse call(OpenAccountsMiddlewareRequest request) throws SystemException {
      String giroAccountNo = createAccounts(request.getOwnerName());

      OpenAccountsMiddlewareResponse response = new OpenAccountsMiddlewareResponse();
      response.setGiroAccountNo(giroAccountNo);
      return response;
   }

   private String createAccounts(String ownerName) throws SystemException {
      String clearingAccountNo = createClearingAccount(ownerName);
      return createGiroAccount(clearingAccountNo);
   }

    private String createClearingAccount(String ownerName) throws SystemException {
        CreateClearingAccountBackendRequest clearingRequest = new CreateClearingAccountBackendRequest();
        clearingRequest.setOwnerName(ownerName);
        return new CreateClearingAccountBackendService().call(clearingRequest).getAccountNo();
    }

    private String createGiroAccount(String clearingAccountNo) throws SystemException {
        CreateGiroAccountBackendRequest giroRequest = new CreateGiroAccountBackendRequest();
        giroRequest.setClearingAccountNo(clearingAccountNo);
        return new CreateGiroAccountBackendService().call(giroRequest).getAccountNo();
    }

}

