package sample.data.jpa.emailService;

import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class AmazonSESSample {

    // Replace sender@example.com with your "From" address.
    // This address must be verified.
    static final String FROM = "saumitra90@gmail.com";
    static final String FROMNAME = "iCare";

    // Replace recipient@example.com with a "To" address. If your account
    // is still in the sandbox, this address must be verified.
   // static final String TO = "saumitra90@gmail.com";

    // Replace smtp_username with your Amazon SES SMTP user name.
    static final String SMTP_USERNAME = "AKIAJOOXGT5IKCQO6PSQ";

    // Replace smtp_password with your Amazon SES SMTP password.
    static final String SMTP_PASSWORD = "AsQ+ar7BCaNmE130y294bKrd7QZNRSmv6PBIsD7klVe5";

    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    //static final String CONFIGSET = "ConfigSet";

    // Amazon SES SMTP host name. This example uses the US West (Oregon) Region.
    static final String HOST = "email-smtp.us-west-2.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint.
    static final int PORT = 587;

    static final String SUBJECT = "iCare Alerts";



    public void sendEmail(String emailId, List<Double> alertValues) throws UnsupportedEncodingException, AddressException {

         String TO = emailId;


        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

         String BODY = String.join(
                System.getProperty("line.separator"),
                "<h3>Hi User</h3>",
                "<p>This email is sent from iCare developement team </p> ",
                "<p>We are constantly monitoring your vitals and have noticed some unusual change users vitals ",
                ", please consult a doctor. </p>",
                 System.getProperty("line.separator"),

                 "<h4>Vital signs :: </h4>" +
                         System.getProperty("line.separator"),

                 "<h4>Temperature :: </h4>" +alertValues.get(0).intValue() +

                 "<h4>Heart Rate :: </h4>"  +alertValues.get(1).intValue() +

                 "<h4> SPO2 level  :: </h4>" +alertValues.get(2).intValue()
        );
         //


        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(FROM,FROMNAME));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setSubject(SUBJECT);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setContent(BODY,"text/html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        Transport transport = null;
        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        // Send the message.
        try
        {
            System.out.println("Sending...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}