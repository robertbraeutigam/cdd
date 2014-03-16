package de.mathema.abersicher.middleware.test;

import de.mathema.abersicher.middleware.MiddlewareBaseRequest;

public class TestRequest extends MiddlewareBaseRequest {
   private boolean error;

   public boolean getError() {
      return error;
   }
   public void setError(boolean error) {
      this.error=error;
   }

}


