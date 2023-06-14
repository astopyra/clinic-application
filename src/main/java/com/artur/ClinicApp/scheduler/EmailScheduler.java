package com.artur.ClinicApp.scheduler;

import com.artur.ClinicApp.domain.entity.Visit;
import com.artur.ClinicApp.service.SimpleEmailService;
import com.artur.ClinicApp.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    public static final String SUBJECT = "Visit remainder";
    public static final String MESSAGE = "We would like to remind you about your tomorrow's visit in our clinic";
    private final SimpleEmailService simpleEmailService;
    private final VisitDbService visitDbService;

    @Scheduled(cron = "0 0 20 * * *")
    public void sendInfoEmail() {
        List<Visit> allVisits = visitDbService.allVisits();

        allVisits.stream()
                .filter(visit -> visit.getDateOfVisit().isAfter(LocalDateTime.now().plusHours(24)))
                .map(email -> email.getPatient().getEmail())
                .forEach(m -> simpleEmailService.send(m, SUBJECT, MESSAGE));
    }
}
