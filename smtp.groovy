print("Loaded class smtp.groovy")

import javax.mail.*
import javax.mail.internet.*

host = "smtp.gmail.com"  // "smtp-relay.gmail.com"
email="kirantesting1984@gmail.com"
port=465
RECIPIENT_EMAIL = "kirantesting1984@gmail.com"
date_time = new Date().format("yyyy-MM-dd hh:mm")
props = new Properties()

public string runScript() {
   // props.put("mail.host", MAILER_HOST);
    //props.put("mail.smtp.user", email)
	props.put("mail.smtp.host", host)
	props.put("mail.smtp.port", port)
	props.put("mail.smtp.starttls.enable","true")
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
	props.put("mail.smtp.ssl.trust", host) 
    Session session = Session.getDefaultInstance(props)
    session.setDebug(true);

    MimeMessage message = new MimeMessage(Session.getDefaultInstance(props))
    message.setFrom(new InternetAddress("kirantesting1984@gmail.com"))
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT_EMAIL))
    message.setSubject("A Test email ${date_time}")
    message.setText("This is a sample email message!")

   retunr Transport.send(message)
}

return this
