/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package it.unifi.facpl.lib.pepFunction;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IPepAction;

public class MailTo implements IPepAction {

	@Override
	public void eval(List<Object> args) throws Throwable {
		Logger l = LoggerFactory.getLogger(MailTo.class);

		l.debug("Send mail to " + args.get(0));

		String to = (String) args.get(0);
		String text = (String) args.get(1);
		String subject = "Auto-Generated FACPL mail";
		// String subject = (String) args.get(2);
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("./config.properties"));

			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("mail.smtp.user")));

			InternetAddress toAddress = new InternetAddress();
			toAddress = new InternetAddress(to);

			message.addRecipient(Message.RecipientType.TO, toAddress);

			message.setSubject(subject);
			message.setText(text);

			Transport transport = session.getTransport("smtp");
			transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("mail.smtp.user"),
					props.getProperty("mail.smtp.password"));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			l.debug("Message sent");
		} catch (Exception e) {
			l.debug("EXCEPTION MAIL FUNCTION - Check config.properties");
			e.printStackTrace();
			throw e;
		}

	}

}
