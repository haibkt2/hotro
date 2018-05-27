package  control;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailProjectClass {

public static void main(String[] args) {

    final String username = "thanhhai13t2@gmail.com";
    final String password = "hai140494";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.EnableSSL.enable","true");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("thanhhai13t2@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("thanhhai13t2@gmail.com"));
        message.setSubject("Testing Subject");
        message.setText("textdksajdsadjasdjasldsds;lds");

//        BodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("conttent", "text/html; charset=utf-8");
//        Multipart multipart = new MimeMultipart();
//
//        String file = "D:\\server_reponsitory\\datatables.min.css";
//        String fileName = "datatables.min.css";
//        DataSource source = new FileDataSource(file);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//        messageBodyPart.setFileName(fileName);
//        multipart.addBodyPart(messageBodyPart);
//
//        message.setContent(multipart);
//
//        System.out.println("Sending");
        String file = "D:\\server_reponsitory\\datatables.min.css";
      String fileName = "datatables.min.css";
      DataSource source = new FileDataSource(file);
        Multipart multipart = new MimeMultipart(); //1
     // Create the attachment part
     BodyPart attachmentBodyPart = new MimeBodyPart(); //2
     attachmentBodyPart.setDataHandler(new DataHandler(source)); //2
     attachmentBodyPart.setFileName(fileName); // 2
     multipart.addBodyPart(attachmentBodyPart); //3
     // Create the HTML Part
     BodyPart htmlBodyPart = new MimeBodyPart(); //4
     htmlBodyPart.setContent("htmlMessageAsString" , "text/html"); //5
     multipart.addBodyPart(htmlBodyPart); // 6
     // Set the Multipart's to be the email's content
     message.setContent(multipart); //7

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}