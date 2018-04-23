package com.example.gentellela.alert.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AlertUser {

    private Long userId;
    private String userName;

    public AlertUser(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
