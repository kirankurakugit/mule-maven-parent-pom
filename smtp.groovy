#!/usr/bin/env groovy
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

MAILER_HOST = "mailtrap.io"
MAILER_USER = "<user account>"
MAILER_PASS = "<password>"
MAILER_PORT = 2525

private void runScript() {
    Session session = Session.getDefaultInstance(new Properties())

    MimeMessage message = new MimeMessage(session)
    message.setFrom("kiran.kurakula@cloudvisory.com")
    message.setRecipient(Message.RecipientType.TO, new InternetAddress("kiran.kurakula@cloudvisory.com"))
    message.setSubject("Important message!")
    message.setText("Here is an important email message!")

    Transport transport = session.getTransport("smtp")
    transport.connect(MAILER_HOST, MAILER_PORT, MAILER_USER, MAILER_PASS)
    transport.sendMessage(message, message.getAllRecipients())
    transport.close()
}

runScript()




