package com.syzn.sms.service.sms.impl;

import com.syzn.sms.service.MaiSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/21 9:40
 * @email: myskybeyond@gmail.com
 */
@Service
@Slf4j
public class MailSendServiceWy163Impl implements MaiSendService {

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender mailSender;

    public MailSendServiceWy163Impl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String to, String subject, String content) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);
            mailSender.send(message);
            log.info("邮件发送成功,from:{},to:{},subject:{},content:{}...", from, to, subject, content);
        } catch (MessagingException ex) {
            log.error("mail send error,msg:{}", ex.getMessage());
        }

    }
}
