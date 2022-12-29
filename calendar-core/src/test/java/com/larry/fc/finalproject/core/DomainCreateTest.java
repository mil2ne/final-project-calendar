package com.larry.fc.finalproject.core;


import com.larry.fc.finalproject.core.domain.Engagement;
import com.larry.fc.finalproject.core.domain.Event;
import com.larry.fc.finalproject.core.domain.RequestStatus;
import com.larry.fc.finalproject.core.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User writer = new User(
                "writer", "writer@test.com", "pw", LocalDate.of(1983,12,8),
                LocalDateTime.now()
        );

        final User attendee = new User(
                "attendee", "attendee@test.com", "pw", LocalDate.of(1984,12,8),
                LocalDateTime.now()
        );


        final Event event = new Event(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "title", "desc",
                writer,
                LocalDateTime.now()

        );
        event.addEngagement(new Engagement(
                event,attendee,LocalDateTime.now(), RequestStatus.REQUESTED
        ));
        assertEquals(event.getEngagements().get(0).getEvent().getWriter().getName(), "writer");


    }
}
