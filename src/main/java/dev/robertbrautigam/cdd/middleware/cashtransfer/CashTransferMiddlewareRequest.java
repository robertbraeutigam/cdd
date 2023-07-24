package dev.robertbrautigam.cdd.middleware.cashtransfer;

import dev.robertbrautigam.cdd.middleware.MiddlewareBaseRequest;
import java.math.BigDecimal;

public class CashTransferMiddlewareRequest extends MiddlewareBaseRequest {
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


