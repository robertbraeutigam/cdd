package de.mathema.abersicher.middleware.directdebit;

import de.mathema.abersicher.middleware.MiddlewareService;
import de.mathema.abersicher.SystemException;
import de.mathema.abersicher.backend.mandate.*;
import de.mathema.abersicher.backend.directdebit.*;

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
      DirectDebitBackendResponse directDebitCreateResponse = new DirectDebitBackendService().call(directDebitCreateRequest);

      return new DirectDebitMiddlewareResponse();
   }
}


