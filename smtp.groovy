#!/usr/bin/env groovy


import javax.mail.*
import javax.mail.internet.*

MAILER_HOST = "smtp.office365.com"  // "smtp-relay.gmail.com"
RECIPIENT_EMAIL = "kiran.kurakula@fireeye.com"
date_time = new Date().format("yyyy-MM-dd hh:mm")
props = new Properties()

private void runScript() {
    props.put("mail.host", MAILER_HOST);
    Session session = Session.getDefaultInstance(props)
    session.setDebug(true);

    MimeMessage message = new MimeMessage(session)
    message.setFrom("kiran.kurakula@cloudvisory.com")
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT_EMAIL))
    message.setSubject("A Test email ${date_time}")
    message.setText("This is a sample email message!")

    Transport.send(message)
}

runScript()
