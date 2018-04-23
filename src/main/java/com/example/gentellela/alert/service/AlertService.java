package com.example.gentellela.alert.service;

import com.example.gentellela.alert.domain.Alert;
import com.example.gentellela.alert.domain.AlertBuilder;
import com.example.gentellela.alert.domain.repository.AlertRepository;
import com.example.gentellela.alert.ui.AlertSpecification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    private AlertRepository alertRepository;
    private AlertValidate alertValidate;

    public AlertService(AlertRepository alertRepository, AlertValidate alertValidate) {
        this.alertRepository = alertRepository;
        this.alertValidate = alertValidate;
    }

    @Transactional
    public void send(AlertBuilder builder) {
        builder.validate(alertValidate);

        builder.build(alertRepository::save);
    }

    @Transactional
    public Alert findOne(Long alertId) {
        Optional<Alert> alert = alertRepository.findById(alertId);
        alert.ifPresent(Alert::read);

        return alert.orElseThrow(() -> new RuntimeException("Alert를 찾을 수 없습니다."));
    }

    public List<Alert> findAll(AlertSpecification alertSpecification) {
        return alertRepository.findAll(alertSpecification.specification());
    }
}
