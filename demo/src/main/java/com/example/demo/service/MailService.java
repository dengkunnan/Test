package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {
@Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    public void sayHello() {
        System.out.println("xxx");
    }

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
    }

    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);
        mailSender.send(message);
    }

    public  void sendAttachmentsMail(String to, String subject, String content ,String filePath) throws MessagingException{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileNamee = file.getFilename();
        helper.addAttachment(fileNamee,file);
        mailSender.send(message);
    }

    public void sendInlinResourceMaile(String to, String subject, String content ,String resPath, String rscId) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);
        FileSystemResource resource =new FileSystemResource(new File(resPath));
        helper.addInline(rscId,resource);
        String fileNamee = resource.getFilename();
        helper.addAttachment(fileNamee,resource);
        mailSender.send(message);
    }
}
