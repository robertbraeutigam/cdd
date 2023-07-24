package dev.robertbrautigam.cdd.middleware.directdebit;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.mandate.*;
import dev.robertbrautigam.cdd.backend.directdebit.*;

public class DirectDebitMiddlewareService implements MiddlewareService<DirectDebitMiddlewareRequest, DirectDebitMiddlewareResponse> {
   @Override
   public DirectDebitMiddlewareResponse call(DirectDebitMiddlewareRequest request) throws SystemException {
      String mandateId = getOrCreateMandateId(request);
      String transferId = createDirectDebit(request.getTargetAccount(), mandateId);

      DirectDebitMiddlewareResponse response = new DirectDebitMiddlewareResponse();
      response.setTransferId(transferId);
      return response;
   }

   private String getOrCreateMandateId(DirectDebitMiddlewareRequest request) throws SystemException {
      String mandateId = getMandateId(request);
      if (mandateId == null) {
         mandateId = createMandateId(request);
      }
      return mandateId;
   }

   private String getMandateId(DirectDebitMiddlewareRequest request) throws SystemException {
      GetMandateBackendRequest mandateGetRequest = new GetMandateBackendRequest();
      mandateGetRequest.setTargetAccount(request.getTargetAccount());
      return new GetMandateBackendService().call(mandateGetRequest).getMandateId();
   }

   private String createMandateId(DirectDebitMiddlewareRequest request) throws SystemException {
      CreateMandateBackendRequest mandateCreateRequest = new CreateMandateBackendRequest();
      mandateCreateRequest.setTargetAccount(request.getTargetAccount());
      return new CreateMandateBackendService().call(mandateCreateRequest).getMandateId();
   }

   private String createDirectDebit(String targetAccount, String mandateId) throws SystemException {
      DirectDebitBackendRequest directDebitCreateRequest = new DirectDebitBackendRequest();
      directDebitCreateRequest.setTargetAccount(targetAccount);
      directDebitCreateRequest.setMandateId(mandateId);
      return new DirectDebitBackendService().call(directDebitCreateRequest).getTransferId();
   }
}


