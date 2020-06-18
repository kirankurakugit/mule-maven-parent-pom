import javax.mail.*
import javax.mail.internet.*

/**
 * Send mail via SSL/TLS enabled SMTP server.
 * @param addresser Could be different with sender email.
 * @param password  Password of sender email.
 * @param subject   Subject of mail.
 * @param to        Addressee.
 * @param cc        Carbon copy.
 * @param bcc       Blind carbon copy.
 * @param content   Content of mail.
 * @Param mimeType  MIME type of {@param content}， e.g. -> 'text/plain', 'text/html;charset=utf-8'
 * @return
 */
public static void send(String addresser, String subject, String to, String cc, String bcc, String content, String mimeType) {
	// Init constants of sender email account.
	String email = "kiran.kurakula@cloudvisory.com"
	String password = 'Ni$hal12'
	String host = "smtp.office365.com" // e.g. -> "smtp.google.com"
	String port = "587" // e.g. -> "465" "587"

	// Set up properties.
	Properties props = System.getProperties()
	props.put("mail.smtp.user", email)
	props.put("mail.smtp.host", host)
	props.put("mail.smtp.port", port)
	props.put("mail.smtp.starttls.enable","true")
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
	props.put("mail.smtp.ssl.trust", host) // Change host to "*" if you want to trust all host.

	// Set up message.
	MimeMessage message = new MimeMessage(Session.getDefaultInstance(props))
	message.setFrom(new InternetAddress(addresser))
	message.addRecipients(Message.RecipientType.TO, new InternetAddress(to))
	message.addRecipients(Message.RecipientType.CC, new InternetAddress(cc))
	message.addRecipients(Message.RecipientType.CC, new InternetAddress(bcc))
	message.setSubject(subject)
	message.setContent(content, mimeType)

	try {
		// Send mail.
		Transport.send(message, email, password)
	} catch (MessagingException e) {
		e.printStackTrace()
	}
}


