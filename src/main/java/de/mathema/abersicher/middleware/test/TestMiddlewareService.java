package de.mathema.abersicher.middleware.test;

import de.mathema.abersicher.middleware.MiddlewareService;
import de.mathema.abersicher.SystemException;
import de.mathema.abersicher.middleware.MiddlewareMessage;
import static de.mathema.abersicher.middleware.MiddlewareMessage.Severity.*;

public class TestMiddlewareService implements MiddlewareService<TestRequest, TestResponse> {
   @Override
   public TestResponse call(TestRequest request) throws SystemException {
      TestResponse response = new TestResponse();
      if (request.getError()) {
         throw new SystemException("Test Service Fehler");
      } else {
         response.addMessage(new MiddlewareMessage(INFO, "Info Nachricht von Test Service"));
         response.addMessage(new MiddlewareMessage(SUCCESS, "Erfolgsnachricht von Test Service"));
         response.addMessage(new MiddlewareMessage(WARN, "Warnung von Test Service"));
      }
      return response;
   }
}


