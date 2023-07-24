package dev.robertbrautigam.cdd.backend;

import java.util.List;
import java.util.ArrayList;
import static java.util.Collections.*;

public class BackendBaseResponse {
   private List<BackendMessage> messages = new ArrayList<>();
   
   public List<BackendMessage> getMessages() {
      return unmodifiableList(messages);
   }

   public void addMessage(BackendMessage message) {
      messages.add(message);
   }
}


