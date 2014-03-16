package de.mathema.abersicher.frontend;

import org.apache.wicket.markup.html.WebPage;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import org.apache.wicket.model.Model;

public class Dashboard extends WebPage {

   @Override
   public void onInitialize() {
      super.onInitialize();

      Navbar navbar = new Navbar("navbar");
      navbar.brandName(Model.of("Aber Sicher!"));
      add(navbar);
   }
}

