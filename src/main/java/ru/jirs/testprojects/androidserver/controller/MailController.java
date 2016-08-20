package ru.jirs.testprojects.androidserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jirs.testprojects.androidserver.form.MailSenderForm;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by irs on 19.08.16.
 */
@Controller
public class MailController {

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public String testMailForm(ModelMap model) {
        model.addAttribute("mail", new MailSenderForm());
        return "testMail";
    }



    @RequestMapping(value = "/mailsend", method = RequestMethod.POST)
    public String requestMethodPost(@ModelAttribute("mail") MailSenderForm mailForm, BindingResult result, ModelMap modelMap) {

        final String username = "**********gmail.com";
        final String password = "*******************";

        String mail_from = "**********@gmail.com";
        String mail_to = mailForm.getMailTo();
        String mail_subject = "Test mail";
        String mail_text = mailForm.getText();


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail_from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_to));
            message.setSubject(mail_subject);
            message.setText(mail_text);

            Transport.send(message);

            System.out.println("Done");

        } catch (javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        return "testMail";
    }


}
