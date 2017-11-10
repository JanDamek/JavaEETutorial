package com.tieto.service.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 10/11/2017.
 */
@Stateless
public class SendMessage implements Serializable {

    @Resource(mappedName = "java:/jms/queue/JavaEEQueue")
    private Queue queueExample;

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    public void send(final Long id, final String text) {
        try (Connection connection = this.cf.createConnection()) {

            try (Session session = connection.createSession()) {
                try (MessageProducer producer = session.createProducer(this.queueExample)) {

                    final Message message = session.createMessage();
                    message.setLongProperty("id", id);
                    message.setStringProperty("text", text);

                    producer.send(message);
                }
            }
        } catch (final JMSException e) {
            Logger.getLogger("SendMessage").log(Level.WARNING, e.getMessage());
        }
    }

}
