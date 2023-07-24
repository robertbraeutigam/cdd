package dev.robertbrautigam.cdd.middleware.cashtransfer;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.cashtransfer.*;

public class CashTransferMiddlewareService implements MiddlewareService<CashTransferMiddlewareRequest, CashTransferMiddlewareResponse> {
   @Override
   public CashTransferMiddlewareResponse call(CashTransferMiddlewareRequest request) throws SystemException {
      CashTransferBackendRequest backendRequest = new CashTransferBackendRequest();
      backendRequest.setAmount(request.getAmount());
      backendRequest.setTargetAccount(request.getTargetAccount());
      CashTransferBackendResponse backendResponse = new CashTransferBackendService().call(backendRequest);

      CashTransferMiddlewareResponse response = new CashTransferMiddlewareResponse();
      response.setTransferId(backendResponse.getTransferId());
      return response;
   }
}


