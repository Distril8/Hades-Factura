/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.service;

import ec.edu.espe.distribuidas.hades.factura.model.Cliente;
import ec.edu.espe.distribuidas.hades.factura.model.Factura;
import ec.edu.espe.distribuidas.hades.factura.model.FacturaDetalle;
import java.io.UnsupportedEncodingException;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 *
 * @author H201m25
 */
@Stateless
@LocalBean
public class MailService {

    @Resource(name = "java/mail/prueba")
    private Session mailSession;

    //@Asynchronous
    public void enviarEmail(Cliente cliente, Factura factura, List<FacturaDetalle> facturaDetalle) throws MessagingException, UnsupportedEncodingException {
        Message message = new MimeMessage(mailSession);
        message.setSubject("Factura electronica numero: "+factura.getCodigo());
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(cliente.getMail(), cliente.getNombre() + " " + cliente.getRuc()));
        StringBuilder contenido = new StringBuilder();
        contenido.append("<h1>Le enviamos su factura electronica</h1>");
        contenido.append("<h3>Cualquier error porfavor notificar con E-FACT</h3>");
        contenido.append("<table border=1>");
        contenido.append("<tr>");
        contenido.append("<th>Dia</th>");
        contenido.append("<th>Ejercicio</th>");
        contenido.append("<th>Material</th>");
        contenido.append("</tr>");
        for (int i = 0; i < facturaDetalle.size(); i++) {
            contenido.append("<tr>");
            contenido.append("<td>");
            contenido.append("------");
            contenido.append("</td>");
            contenido.append("<td>");
            contenido.append("------");
            contenido.append("</td>");
            contenido.append("<td>");
            contenido.append("------");
            contenido.append("</td>");
            contenido.append("</tr>");
        }
        contenido.append("</table>");
        message.setContent(contenido.toString(), "text/html");
        Transport.send(message);
    }

}
