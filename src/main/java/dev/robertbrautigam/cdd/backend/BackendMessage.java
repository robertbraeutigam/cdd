package dev.robertbrautigam.cdd.backend;

public class BackendMessage {
   private String id;
   private String message;

   public BackendMessage(String id, String message) {
      this.id = id;
      this.message = message;
   }

   public String getId() {
      return id;
   }

   public String getMessage() {
      return message;
   }
}


