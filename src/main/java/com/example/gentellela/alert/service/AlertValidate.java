package com.example.gentellela.alert.service;

import com.example.gentellela.alert.domain.AlertBuilder;
import com.example.gentellela.common.entityBuilder.ValidateFunction;
import com.example.gentellela.user.domain.User;
import com.example.gentellela.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertValidate implements ValidateFunction<AlertBuilder>{

    private UserRepository userRepository;

    public AlertValidate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(AlertBuilder alertBuilder) {
        checkAbleReceiveAlertUser(alertBuilder.getToId());
    }

    private void checkAbleReceiveAlertUser(Long userId) {
        userRepository.findById(userId)
                .filter(User::getIsAbleReceiveAlert)
                .orElseThrow(() -> new RuntimeException("메세지 수신을 거부한 사용자 입니다."));
    }
}
