package dev.robertbrautigam.cdd.backend.cashtransfer;

import dev.robertbrautigam.cdd.backend.BackendService;
import dev.robertbrautigam.cdd.backend.BackendMessage;
import dev.robertbrautigam.cdd.SystemException;

public class CashTransferBackendService implements BackendService<CashTransferBackendRequest, CashTransferBackendResponse> {
   @Override
   public CashTransferBackendResponse call(CashTransferBackendRequest request) throws SystemException {
      if (request.getAmount().signum() != 1) {
         throw new SystemException("Tried to transfer an amount of "+request.getAmount()+", amount must be greater than 0.");
      }
      CashTransferBackendResponse response = new CashTransferBackendResponse();
      response.addMessage(new BackendMessage("MSG1001", "Cash transfer to #"+request.getTargetAccount()+", with amount "+request.getAmount()+" submitted, execution on the next business day."));
      response.setTransferId("TX-1");
      return response;
   }
}


