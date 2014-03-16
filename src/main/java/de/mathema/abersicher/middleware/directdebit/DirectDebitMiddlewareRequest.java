package de.mathema.abersicher.middleware.directdebit;

import de.mathema.abersicher.middleware.MiddlewareBaseRequest;
import java.math.BigDecimal;

public class DirectDebitMiddlewareRequest extends MiddlewareBaseRequest {
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


