package cs.templates;

import java.sql.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

import cs.db.ConnectionDB;

import javax.activation.*;

public class FirstTemplate {
	public void sendMail(String subj, String msgContent, String recipient) {
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myEmail = "dalaganx@gmail.com";
		String myPass = "zin2001222";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, myPass);
			}
		});
		String subject = subj;
		ConnectionDB db = new ConnectionDB();
		try {
			Connection cn = db.getConnection();
			String query = "SELECT * FROM students_dbs";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				try {
					String htmlmail = "<body data-new-gr-c-s-loaded=\"14.1060.0\" style=\"width:100%;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">"
							+
							"<div class=\"es-wrapper-color\" style=\"background-color:#F8F9FD\"><!--[if gte mso 9]>" +
							"<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">" +
							"<v:fill type=\"tile\" color=\"#f8f9fd\"></v:fill>" +
							"</v:background>" +
							"<![endif]-->" +
							"<table class=\"es-wrapper\" width=\"650px\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\">"
							+
							"<tr>" +
							"<td valign=\"top\" style=\"padding:0;Margin:0\">" +
							"<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header es-visible-simple-html-only\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">"
							+
							"<tr>" +
							"<td class=\"es-stripe-html\" align=\"center\" bgcolor=\"#c4c4c4\" style=\"padding:0;Margin:0;background-color:#c4c4c4\">"
							+
							"<table bgcolor=\"#ffffff\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">"
							+
							"<tr>" +
							"<td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:15px;padding-left:30px;padding-right:30px\">"
							+
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:540px\">" +
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:25px;font-size:0px\"><img class=\"adapt-img\" src=\"https://wegqww.stripocdn.email/content/guids/baefbdd3-0bfb-426a-bf55-3615ea205b43/images/tsulogo.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"200\"></td>"
							+
							"</tr>" +
							"<tr>" +
							"<td align=\"center\" style=\"padding:0;Margin:0\"><h1 style=\"Margin:0;line-height:38px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:32px;font-style:normal;font-weight:bold;color:#660000\">Tarlac State University</h1></td>"
							+
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table>" +
							"<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content es-visible-simple-html-only\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">"
							+
							"<tr>" +
							"<td class=\"es-stripe-html\" align=\"center\" bgcolor=\"#660000\" style=\"padding:0;Margin:0;background-color:#660000\">"
							+
							"<table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;border-top:10px solid transparent;width:600px\">"
							+
							"<tr>" +
							"<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">"
							+
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">" +
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" style=\"padding:0;Margin:0\"><h1 style=\"Margin:0;line-height:48px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:40px;font-style:normal;font-weight:bold;color:#f4f2f2\">Announcements</h1></td>"
							+
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"<tr>" +
							"<td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:20px;padding-right:20px\">"
							+
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">" +
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#f9f7f7;font-size:16px\">"
							+ msgContent + "</p></td>"
							+
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"<tr>" +
							"<td class=\"es-m-p15t es-m-p0b es-m-p0r es-m-p0l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:15px\">"
							+
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\">" +
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://wegqww.stripocdn.email/content/guids/CABINET_3384edfcd1d4174920db12488e67095c/images/pngtreeoriginal_commercial_materials_for_book_3699919_zP3.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"350\"></td>"
							+
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table>" +
							"<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content es-visible-simple-html-only\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">"
							+
							"<tr>" +
							"<td class=\"es-stripe-html\" align=\"center\" bgcolor=\"#835E00\" style=\"padding:0;Margin:0;background-color:#835e00\">"
							+
							"<table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">"
							+
							"<tr>" +
							"<td align=\"left\" style=\"Margin:0;padding-left:30px;padding-right:30px;padding-top:40px;padding-bottom:40px\">"
							+
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:540px\">" +
							"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">"
							+
							"<tr>" +
							"<td align=\"center\" height=\"20\" style=\"padding:0;Margin:0\"></td>" +
							"</tr>" +
							"<tr>" +
							"<td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#ffffff;font-size:16px\">© Event Emailer</p></td>"
							+
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table></td>" +
							"</tr>" +
							"</table>" +
							"</div>" +
							"</body>";
					String firstFilter = htmlmail.replace("<?name>",
							rs.getString("firstname") + " " + rs.getString("lastname"));
					String secondFilter = firstFilter.replace("<?email>", rs.getString("email"));
					String thirdFilter = secondFilter.replace("<?course>", rs.getString("course"));
					String fourthFilter = thirdFilter.replace("<?section>", rs.getString("section"));
					String fifthFilter = fourthFilter.replace("<?year>", rs.getString("year"));
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(myEmail));
					message.setRecipient(Message.RecipientType.TO, new InternetAddress(rs.getString("email")));
					message.setSubject(subject);
					MimeMultipart multipart = new MimeMultipart();
					BodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(fifthFilter, "text/html; charset=utf-8");
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);
					Transport.send(message);
					JOptionPane.showMessageDialog(null, "Emails is successfully send");
				} catch (MessagingException e) {
					JOptionPane.showMessageDialog(null, "Error " + e);
					System.out.println(e);
				}
			}
		} catch (Exception err) {
			System.out.println(err);
		}
	}
}
