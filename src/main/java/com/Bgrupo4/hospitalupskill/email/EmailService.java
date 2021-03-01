package com.Bgrupo4.hospitalupskill.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;

    @Override
    @Async // We should do a Queue
    public void senad(String to, String email) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirme o seu email Centro Hospitalar Upskill");
            helper.setFrom("getSierralta@gmail.com");
            javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
