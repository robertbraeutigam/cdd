package de.mathema.abersicher.backend.cashtransfer;

import de.mathema.abersicher.backend.BackendBaseRequest;
import java.math.BigDecimal;

public class CashTransferBackendRequest extends BackendBaseRequest {
   private BigDecimal amount;
   private String targetAccount;

   public BigDecimal getAmount() {
      return amount;
   }
   public void setAmount(BigDecimal amount) {
      this.amount=amount;
   }

   public String getTargetAccount() {
      return targetAccount;
   }
   public void setTargetAccount(String targetAccount) {
      this.targetAccount=targetAccount;
   }

}


