package de.mathema.abersicher.middleware;

import java.util.List;
import java.util.ArrayList;
import static java.util.Collections.*;

public class MiddlewareBaseResponse {
   private List<MiddlewareMessage> messages = new ArrayList<>();
   
   public List<MiddlewareMessage> getMessages() {
      return unmodifiableList(messages);
   }

   public void addMessage(MiddlewareMessage message) {
      messages.add(message);
   }
}


