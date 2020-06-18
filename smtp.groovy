#!/usr/bin/env groovy


import javax.mail.*
import javax.mail.internet.*

MAILER_HOST = "aspmx.l.google.com"  // "smtp-relay.gmail.com"
RECIPIENT_EMAIL = "my+test@example.com"
date_time = new Date().format("yyyy-MM-dd hh:mm")
props = new Properties()

private void runScript() {
    props.put("mail.host", MAILER_HOST);
    Session session = Session.getDefaultInstance(props)
    session.setDebug(true);

    MimeMessage message = new MimeMessage(session)
    message.setFrom("no.reply@example.org")
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT_EMAIL))
    message.setSubject("A Test email ${date_time}")
    message.setText("This is a sample email message!")

    Transport.send(message)
}

runScript()
