package dev.robertbrautigam.cdd.middleware.directdebit;

import dev.robertbrautigam.cdd.middleware.MiddlewareService;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.backend.mandate.*;
import dev.robertbrautigam.cdd.backend.directdebit.*;

public class DirectDebitMiddlewareService implements MiddlewareService<DirectDebitMiddlewareRequest, DirectDebitMiddlewareResponse> {
   @Override
   public DirectDebitMiddlewareResponse call(DirectDebitMiddlewareRequest request) throws SystemException {
      String mandateId = getOrCreateMandateId(request);
      return createDirectDebit(request, mandateId);
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
      GetMandateBackendResponse mandateGetResponse = new GetMandateBackendService().call(mandateGetRequest);
      return mandateGetResponse.getMandateId();
   }

   private String createMandateId(DirectDebitMiddlewareRequest request) throws SystemException {
      CreateMandateBackendRequest mandateCreateRequest = new CreateMandateBackendRequest();
      mandateCreateRequest.setTargetAccount(request.getTargetAccount());
      CreateMandateBackendResponse mandateCreateResponse = new CreateMandateBackendService().call(mandateCreateRequest);
      return mandateCreateResponse.getMandateId();
   }

   private DirectDebitMiddlewareResponse createDirectDebit(DirectDebitMiddlewareRequest request, String mandateId) throws SystemException {
      DirectDebitBackendRequest directDebitCreateRequest = new DirectDebitBackendRequest();
      directDebitCreateRequest.setTargetAccount(request.getTargetAccount());
      directDebitCreateRequest.setMandateId(mandateId);
      DirectDebitBackendResponse backendResponse = new DirectDebitBackendService().call(directDebitCreateRequest);

      DirectDebitMiddlewareResponse response = new DirectDebitMiddlewareResponse();
      response.setTransferId(backendResponse.getTransferId());
      return response;
   }
}


