package de.mathema.abersicher.middleware.cashtransfer;

import de.mathema.abersicher.middleware.MiddlewareService;
import de.mathema.abersicher.middleware.MiddlewareMessage;
import de.mathema.abersicher.SystemException;
import de.mathema.abersicher.backend.cashtransfer.*;

public class CashTransferMiddlewareService implements MiddlewareService<CashTransferMiddlewareRequest, CashTransferMiddlewareResponse> {
   @Override
   public CashTransferMiddlewareResponse call(CashTransferMiddlewareRequest request) throws SystemException {
      CashTransferMiddlewareResponse response = new CashTransferMiddlewareResponse();

      CashTransferBackendRequest backendRequest = new CashTransferBackendRequest();
      backendRequest.setAmount(request.getAmount());
      backendRequest.setTargetAccount(request.getTargetAccount());
      CashTransferBackendResponse backendResponse = new CashTransferBackendService().call(backendRequest);

      return response;
   }
}


