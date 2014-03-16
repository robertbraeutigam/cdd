package de.mathema.abersicher.frontend;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.wicket.util.tester.WicketTester;

@Test
public class DashboardTests {
   private WicketTester tester;

   public void testDashboardRenders() {
      tester.startPage(Dashboard.class);
   }

   @BeforeMethod
   protected void setUp() {
      tester = new WicketTester(new Application());
   }
}


