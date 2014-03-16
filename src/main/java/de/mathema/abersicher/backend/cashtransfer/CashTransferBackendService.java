package de.mathema.abersicher.backend.cashtransfer;

import de.mathema.abersicher.backend.BackendService;
import de.mathema.abersicher.backend.BackendMessage;
import de.mathema.abersicher.SystemException;

public class CashTransferBackendService implements BackendService<CashTransferBackendRequest, CashTransferBackendResponse> {
   @Override
   public CashTransferBackendResponse call(CashTransferBackendRequest request) throws SystemException {
      if (request.getAmount().signum() != 1) {
         throw new SystemException("Sie haben versucht "+request.getAmount()+" zu überweisen, Betrag muss aber größer als 0 sein.");
      }
      CashTransferBackendResponse response = new CashTransferBackendResponse();
      response.addMessage(new BackendMessage("MSG1001", "Überweisung auf Konto "+request.getTargetAccount()+", mit Betrag "+request.getAmount()+" war entgegengenommen, wird am nächsten Arbeitstag ausgeführt"));
      response.setTransferId("TX-1");
      return response;
   }
}


