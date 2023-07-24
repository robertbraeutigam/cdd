package dev.robertbrautigam.cdd.middleware;

public class MiddlewareMessage {
   private Severity severity;
   private String message;

   public MiddlewareMessage(Severity severity, String message) {
      this.severity = severity;
      this.message = message;
   }

   public Severity getSeverity() {
      return severity;
   }

   public String getMessage() {
      return message;
   }

   public static enum Severity {
      INFO,
      SUCCESS,
      WARN,
      ERROR,
   }
}


