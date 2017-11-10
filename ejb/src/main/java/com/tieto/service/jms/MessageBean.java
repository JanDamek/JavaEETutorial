package com.tieto.service.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 10/11/2017.
 */
@MessageDriven(name = "MessageEJB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/JavaEEQueue")})
public class MessageBean implements MessageListener {

    private final Logger logger = Logger.getLogger("MessageBean");

    @Override
    public void onMessage(final Message message) {
        this.logger.log(Level.INFO, "Received message.");
        try {
            final Long id = message.getLongProperty("id");
            final String name = message.getStringProperty("text");
            this.logger.log(Level.INFO, "ID: {0} Name:{1}", new Object[]{id, name});
        } catch (final JMSException ignore) {
        }
    }
}
