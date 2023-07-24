package dev.robertbrautigam.cdd.middleware.account;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.account.*;

public class OpenAccountsMiddlewareService implements MiddlewareService<OpenAccountsMiddlewareRequest, OpenAccountsMiddlewareResponse> {
   @Override
   public OpenAccountsMiddlewareResponse call(OpenAccountsMiddlewareRequest request) throws SystemException {
      String clearingAccountNo = createClearingAccount(request.getOwnerName());
      String giroAccountNo = createGiroAccount(clearingAccountNo);

      OpenAccountsMiddlewareResponse response = new OpenAccountsMiddlewareResponse();
      response.setClearingAccountNo(clearingAccountNo);
      response.setGiroAccountNo(giroAccountNo);
      return response;
   }

    private String createClearingAccount(String ownerName) throws SystemException {
        CreateClearingAccountBackendRequest clearingRequest = new CreateClearingAccountBackendRequest();
        clearingRequest.setOwnerName(ownerName);
        CreateClearingAccountBackendResponse clearingResponse = new CreateClearingAccountBackendService().call(clearingRequest);
        return clearingResponse.getAccountNo();
    }

    private String createGiroAccount(String clearingAccountNo) throws SystemException {
        CreateGiroAccountBackendRequest giroRequest = new CreateGiroAccountBackendRequest();
        giroRequest.setClearingAccountNo(clearingAccountNo);
        CreateGiroAccountBackendResponse giroResponse = new CreateGiroAccountBackendService().call(giroRequest);
        return giroResponse.getAccountNo();
    }

}
