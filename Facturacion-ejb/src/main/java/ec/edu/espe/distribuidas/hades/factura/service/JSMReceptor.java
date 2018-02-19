package ec.edu.espe.distribuidas.hades.factura.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;


@JMSDestinationDefinition(
    name="java:global/queue/FacturacionElectronica",
    interfaceName="javax.jms.Queue",
    destinationName = "FacturacionElectronica"
)
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "java:global/queue/FacturacionElectronica"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class JSMReceptor implements MessageListener {
    
    public JSMReceptor() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(MessageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}