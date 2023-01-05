package com.larry.fc.finalproject.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final JavaMailSender emailSender;

    @GetMapping("/api/mail")
    public void sendTestMail() {
        final MimeMessagePreparator preparator = message -> {
            final MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo("dlcnddjs12345@gmail.com");
            helper.setSubject("테스트 발송용 입니다.");
            helper.setText("spring boot calendar project 에서 발송합니다.");
        };
        emailSender.send(preparator);
    }
}
