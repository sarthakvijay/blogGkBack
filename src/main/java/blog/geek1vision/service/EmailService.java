package blog.geek1vision.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	// Replace sender@example.com with your "From" address.
	// This address must be verified.
	static final String FROM = "contact@geek1vision.com";
	static final String FROMNAME = "Geek1Vision";

	// Replace recipient@example.com with a "To" address. If your account
	// is still in the sandbox, this address must be verified.
//    static final String TO = "recipient@example.com";

	// Replace smtp_username with your Amazon SES SMTP user name.
	static final String SMTP_USERNAME = "AKIA26XOUNLCGY425SHN";

	// Replace smtp_password with your Amazon SES SMTP password.
	static final String SMTP_PASSWORD = "BM/IsfPbJ/yH7rXLWyZcx9/kAxL1Ep54fJ4SnLY540s1";

	// The name of the Configuration Set to use for this message.
	// If you comment out or remove this variable, you will also need to
	// comment out or remove the header below.
	static final String CONFIGSET = "gkvision_config_set";

	// Amazon SES SMTP host name. This example uses the US West (Oregon) region.
	// See
	// https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
	// for more information.
	static final String HOST = "email-smtp.us-east-1.amazonaws.com";

	// The port you will connect to on the Amazon SES SMTP endpoint.
	static final int PORT = 587;

//    static final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";

//	static final String BODY = String.join(System.getProperty("line.separator"), "<h1>Amazon SES SMTP Email Test</h1>",
//			"<p>This email was sent with Amazon SES using the ",
//			"<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
//			" for <a href='https://www.java.com'>Java</a>.");
	
//	static final String BODY = message;

	public String sendMail(String to, Long mobile, String email, String message, String name) throws Exception {

		// Create a Properties object to contain connection configuration information.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		// Create a Session object to represent a mail session with the specified
		// properties.
		Session session = Session.getDefaultInstance(props);

		String responses = "";

		// Create a message with the specified information.
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(FROM, FROMNAME));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setSubject(email);
		msg.setContent(message, "text/html");

		// Add a configuration set header. Comment or delete the
		// next line if you are not using a configuration set
		msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

		// Create a transport.
		Transport transport = session.getTransport();

		// Send the message.
		try {
			System.out.println("Sending...");

			// Connect to Amazon SES using the SMTP username and password you specified
			// above.
			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

			// Send the email.
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Email sent!");
			responses = "Email Sent successfully";
			return responses;
		} catch (Exception ex) {
			System.out.println("The email is not sent, some error occured");
			System.out.println("Error message: " + ex.getMessage());
			responses = "The email was not sent";
			return responses;
		} finally {
			// Close and terminate the connection.
			transport.close();
		}
	}
}