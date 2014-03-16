package de.mathema.abersicher.frontend;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessagesModel;
import de.agilecoders.wicket.core.markup.html.bootstrap.dialog.Alert;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.IModel;
import org.apache.wicket.Component;

public class FeedbackPanel extends Panel {
   private FeedbackListView listView;

   public FeedbackPanel(String id) {
      super(id);
   }

   @Override
   public void onInitialize() {
      super.onInitialize();
      listView = new FeedbackListView("messages");
      add(listView);
   }

   @Override
   public void onConfigure() {
      super.onConfigure();
      setVisible(!listView.getModelObject().isEmpty());
   }

   public static class FeedbackListView extends ListView<FeedbackMessage> {
      public FeedbackListView(String id) {
         super(id);
         setDefaultModel(new FeedbackMessagesModel(this));
      }

      @Override
      protected void populateItem(ListItem<FeedbackMessage> messageItem) {
         FeedbackMessage message = messageItem.getModelObject();
         message.markRendered();
         Alert alert = new Alert("message", Model.of(message.getMessage().toString())) {
            protected Component createMessage(final String markupId, final IModel<String> message) {
               Label label = new Label(markupId, message);
               label.setEscapeModelStrings(false);
               return label;
            }   
         };
         alert.setCloseButtonVisible(true);
         switch (message.getLevel()) {
            case FeedbackMessage.SUCCESS:
               alert.type(Alert.Type.Success);
               break;
            case FeedbackMessage.ERROR:
            case FeedbackMessage.FATAL:
               alert.type(Alert.Type.Danger);
               break;
            case FeedbackMessage.WARNING:
               alert.type(Alert.Type.Warning);
               break;
            default:
               alert.type(Alert.Type.Info);
         }
         messageItem.add(alert);
      }
   }
}


