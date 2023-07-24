package dev.robertbrautigam.cdd.middleware.cashtransfer;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.cashtransfer.*;

import java.math.BigDecimal;

public class CashTransferMiddlewareService implements MiddlewareService<CashTransferMiddlewareRequest, CashTransferMiddlewareResponse> {
   @Override
   public CashTransferMiddlewareResponse call(CashTransferMiddlewareRequest request) throws SystemException {
      String transferId = submitCashTransfer(request.getAmount(), request.getTargetAccount());

      CashTransferMiddlewareResponse response = new CashTransferMiddlewareResponse();
      response.setTransferId(transferId);
      return response;
   }

   private String submitCashTransfer(BigDecimal amount, String targetAccount) throws SystemException {
      CashTransferBackendRequest backendRequest = new CashTransferBackendRequest();
      backendRequest.setAmount(amount);
      backendRequest.setTargetAccount(targetAccount);
      return new CashTransferBackendService().call(backendRequest).getTransferId();
   }
}


