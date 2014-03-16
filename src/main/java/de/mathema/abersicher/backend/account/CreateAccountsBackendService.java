package de.mathema.abersicher.backend.account;

import de.mathema.abersicher.backend.BackendService;
import de.mathema.abersicher.SystemException;

public class CreateAccountsBackendService implements BackendService<CreateAccountsBackendRequest, CreateAccountsBackendResponse> {
   @Override
   public CreateAccountsBackendResponse call(CreateAccountsBackendRequest request) throws SystemException {
      String clearingAccountNo = createClearingAccount(request);
      String giroAccountNo = createGiroAccount(clearingAccountNo);

      CreateAccountsBackendResponse response = new CreateAccountsBackendResponse();
      response.setClearingAccountNo(clearingAccountNo);
      response.setGiroAccountNo(giroAccountNo);
      return response;
   }

   private String createClearingAccount(CreateAccountsBackendRequest request) throws SystemException {
      CreateClearingAccountBackendRequest clearingRequest = new CreateClearingAccountBackendRequest();
      clearingRequest.setOwnerName(request.getOwnerName());
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


