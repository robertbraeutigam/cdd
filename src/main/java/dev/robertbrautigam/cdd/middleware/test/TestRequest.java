package dev.robertbrautigam.cdd.middleware.test;

import dev.robertbrautigam.cdd.middleware.MiddlewareBaseRequest;

public class TestRequest extends MiddlewareBaseRequest {
   private boolean error;

   public boolean getError() {
      return error;
   }
   public void setError(boolean error) {
      this.error=error;
   }

}


