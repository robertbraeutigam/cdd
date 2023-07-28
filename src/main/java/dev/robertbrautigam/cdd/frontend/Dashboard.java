package dev.robertbrautigam.cdd.frontend;

import org.apache.wicket.markup.html.WebPage;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import org.apache.wicket.model.Model;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import dev.robertbrautigam.cdd.SystemException;
import dev.robertbrautigam.cdd.middleware.*;
import dev.robertbrautigam.cdd.middleware.cashtransfer.*;
import dev.robertbrautigam.cdd.middleware.account.*;
import org.apache.wicket.Session;
import java.math.BigDecimal;

public class Dashboard extends WebPage {

   @Override
   public void onInitialize() {
      super.onInitialize();

      add(new FeedbackPanel("feedback"));

      Navbar navbar = new Navbar("navbar");
      navbar.brandName(Model.of("Compiler Driven Development"));
      add(navbar);

      BootstrapForm<Void> cashtransferForm = new BootstrapForm<>("cashtransferForm");
      add(cashtransferForm);
      cashtransferForm.add(new BootstrapButton("testMessages", Model.of("Call"), Buttons.Type.Primary) {
         @Override
         public void onSubmit() {
            CashTransferMiddlewareRequest request = new CashTransferMiddlewareRequest();
            request.setAmount(new BigDecimal("12.34"));
            request.setTargetAccount("DE751234567890123456");
            call(new CashTransferMiddlewareService(), request);
         }
      });

      BootstrapForm<Void> accountForm = new BootstrapForm<>("accountForm");
      add(accountForm);
      accountForm.add(new BootstrapButton("testMessages", Model.of("Call"), Buttons.Type.Primary) {
         @Override
         public void onSubmit() {
            OpenAccountsMiddlewareRequest request = new OpenAccountsMiddlewareRequest();
            request.setOwnerName("Owner Name");
            call(new OpenAccountsMiddlewareService(), request);
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

