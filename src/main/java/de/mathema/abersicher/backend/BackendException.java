package de.mathema.abersicher.backend;

public class BackendException extends Exception {
   private BackendMessage backendMessage;

   public BackendException(BackendMessage backendMessage) {
      super(backendMessage.getMessage());
      this.backendMessage = backendMessage;
   }

   public BackendMessage getBackendMessage() {
      return backendMessage;
   }
}


