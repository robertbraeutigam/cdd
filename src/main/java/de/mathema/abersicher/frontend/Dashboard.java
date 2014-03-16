package de.mathema.abersicher.frontend;

import org.apache.wicket.markup.html.WebPage;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import org.apache.wicket.model.Model;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.mathema.abersicher.SystemException;
import de.mathema.abersicher.middleware.*;
import de.mathema.abersicher.middleware.test.*;
import de.mathema.abersicher.middleware.cashtransfer.*;
import de.mathema.abersicher.middleware.directdebit.*;
import org.apache.wicket.Session;
import java.math.BigDecimal;

public class Dashboard extends WebPage {

   @Override
   public void onInitialize() {
      super.onInitialize();

      add(new FeedbackPanel("feedback"));

      Navbar navbar = new Navbar("navbar");
      navbar.brandName(Model.of("Aber Sicher!"));
      add(navbar);

      BootstrapForm<Void> testForm = new BootstrapForm<Void>("testForm");
      add(testForm);
      testForm.add(new BootstrapButton("testException", Model.of("Fehler"), Buttons.Type.Danger) {
         @Override
         public void onSubmit() {
            TestRequest request = new TestRequest();
            request.setError(true);
            call(new TestMiddlewareService(), request);
         }
      });
      testForm.add(new BootstrapButton("testMessages", Model.of("Nachrichten"), Buttons.Type.Primary) {
         @Override
         public void onSubmit() {
            TestRequest request = new TestRequest();
            call(new TestMiddlewareService(), request);
         }
      });

      BootstrapForm<Void> cashtransferForm = new BootstrapForm<Void>("cashtransferForm");
      add(cashtransferForm);
      cashtransferForm.add(new BootstrapButton("testException", Model.of("Negativer Betrag"), Buttons.Type.Danger) {
         @Override
         public void onSubmit() {
            CashTransferMiddlewareRequest request = new CashTransferMiddlewareRequest();
            request.setAmount(new BigDecimal("-12.34"));
            request.setTargetAccount("DE751234567890123456");
            call(new CashTransferMiddlewareService(), request);
         }
      });
      cashtransferForm.add(new BootstrapButton("testMessages", Model.of("Normal"), Buttons.Type.Primary) {
         @Override
         public void onSubmit() {
            CashTransferMiddlewareRequest request = new CashTransferMiddlewareRequest();
            request.setAmount(new BigDecimal("12.34"));
            request.setTargetAccount("DE751234567890123456");
            call(new CashTransferMiddlewareService(), request);
         }
      });

      BootstrapForm<Void> directdebitForm = new BootstrapForm<Void>("directdebitForm");
      add(directdebitForm);
      directdebitForm.add(new BootstrapButton("testMessages", Model.of("Aufruf"), Buttons.Type.Primary) {
         @Override
         public void onSubmit() {
            DirectDebitMiddlewareRequest request = new DirectDebitMiddlewareRequest();
            request.setTargetAccount("DE751234567890123456");
            call(new DirectDebitMiddlewareService(), request);
         }
      });
   }

   private<REQ extends MiddlewareBaseRequest, RES extends MiddlewareBaseResponse> void call(MiddlewareService<REQ, RES> service, REQ request) {
      try {
         RES response = service.call(request);
         for (MiddlewareMessage message : response.getMessages()) {
            switch (message.getSeverity()) {
               case SUCCESS:
                  Session.get().success(message.getMessage());
                  break;
               case WARN:
                  Session.get().warn(message.getMessage());
                  break;
               case ERROR:
                  Session.get().error(message.getMessage());
                  break;
               default:
                  Session.get().info(message.getMessage());
            }
         }
      } catch (SystemException exception) {
         Session.get().error(exception.getMessage());
      }
   }
}

