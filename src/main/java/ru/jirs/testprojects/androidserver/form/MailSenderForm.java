package ru.jirs.testprojects.androidserver.form;

/**
 * Created by irs on 19.08.16.
 */
public class MailSenderForm {

    private String mailTo;
    private String text;

    public MailSenderForm() {
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
