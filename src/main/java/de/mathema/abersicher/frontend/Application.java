package de.mathema.abersicher.frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import de.agilecoders.wicket.core.Bootstrap;

public class Application extends WebApplication {
   @Override
   public Class<? extends WebPage> getHomePage() {
      return Dashboard.class;
   }

   @Override
   public void init() {
      super.init();
      Bootstrap.install(this);
   }
}

