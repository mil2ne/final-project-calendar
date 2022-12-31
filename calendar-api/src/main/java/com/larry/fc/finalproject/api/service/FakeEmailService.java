package com.larry.fc.finalproject.api.service;

import com.larry.fc.finalproject.core.domain.entity.Engagement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class FakeEmailService implements EmailService {
    @Override
    public void sendEngagement(Engagement engagement) {
        System.out.println(
                "send email\n" +
                        "email : " + engagement.getAttendee().getEmail() + "\n" +
                        "scheduleId : " + engagement.getSchedule().getId()
        );
    }
}
