package com.example.gentellela.alert.ui;

import com.example.gentellela.alert.domain.Alert;
import com.example.gentellela.alert.domain.AlertBuilder;
import com.example.gentellela.alert.service.AlertService;
import com.example.gentellela.user.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class AlertController {

    private AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send")
    public void send(AlertBuilder builder, User user) {
        alertService.send(builder);
    }

    @GetMapping("/{alertId}")
    public Alert getAlert(@PathVariable Long alertId) {
        return alertService.findOne(alertId);
    }

    @GetMapping
    public List<Alert> getAlerts(AlertSpecification alertSpecification) {
        return alertService.findAll(alertSpecification);
    }
}
