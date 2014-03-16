package de.mathema.abersicher.middleware;

public class MiddlewareException extends Exception {
   private MiddlewareMessage backendMessage;

   public MiddlewareException(MiddlewareMessage backendMessage) {
      super(backendMessage.getMessage());
      this.backendMessage = backendMessage;
   }

   public MiddlewareMessage getMiddlewareMessage() {
      return backendMessage;
   }
}


