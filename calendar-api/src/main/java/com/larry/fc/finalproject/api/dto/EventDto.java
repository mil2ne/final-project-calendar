package com.larry.fc.finalproject.api.dto;

import com.larry.fc.finalproject.core.domain.ScheduleType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class EventDto implements ScheduleDto{

    private final Long scheduleId;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
    private final String title;
    private final String description;
    private Long writerId;


    @Override
    public ScheduleType getScheduleType() {
        return ScheduleType.EVENT;
    }
}
