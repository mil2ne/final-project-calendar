package com.larry.fc.finalproject.api.controller;

import com.larry.fc.finalproject.api.dto.*;
import com.larry.fc.finalproject.api.service.EventService;
import com.larry.fc.finalproject.api.service.NotificationService;
import com.larry.fc.finalproject.api.service.ScheduleQueryService;
import com.larry.fc.finalproject.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import static com.larry.fc.finalproject.api.service.LoginService.LOGIN_SESSION_KEY;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleQueryService scheduleQueryService;
    private final TaskService taskService;
    private final EventService eventService;
    private final NotificationService notificationService;

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(
            @RequestBody TaskCreateReq taskCreateReq,
            AuthUser authUser
    ) {

        taskService.create(taskCreateReq, authUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/events")
    public ResponseEntity<Void> createEvent(
            @Valid @RequestBody EventCreateReq eventCreateReq,
            AuthUser authUser
    ) {

        eventService.create(eventCreateReq, authUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/notifications")
    public ResponseEntity<Void> createNotification(
            @RequestBody NotificationCreateReq notificationCreateReq,
            AuthUser authUser
    ) {

        notificationService.create(notificationCreateReq, authUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/day")
    public List<ScheduleDto> getScheduleByDay(
            AuthUser authUser,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date
            ) {

        return scheduleQueryService.getScheduleByDay(authUser, date == null ? LocalDate.now() : date);

    }

    @GetMapping("/week")
    public List<ScheduleDto> getScheduleByWeek(
            AuthUser authUser,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startOfWeek
    ) {

        return scheduleQueryService.getScheduleByWeek(authUser, startOfWeek == null ? LocalDate.now() : startOfWeek);

    }

    @GetMapping("/month")
    public List<ScheduleDto> getScheduleByMonth(
            AuthUser authUser,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM")String yearMonth
    ) {

        return scheduleQueryService.getScheduleByMonth(authUser, yearMonth == null ? YearMonth.now() : YearMonth.parse(yearMonth));

    }
}
