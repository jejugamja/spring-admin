package com.example.gentellela.alert.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="userId",
                    column=@Column(name="FROM_USER_ID")),
            @AttributeOverride(name="userName",
                    column=@Column(name="FROM_USER_NAME"))
    })
    private AlertUser fromUser;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="userId",
                    column=@Column(name="TO_USER_ID")),
            @AttributeOverride(name="userName",
                    column=@Column(name="TO_USER_NAME"))
    })
    private AlertUser toUser;
    private String message;
    private Boolean isRead;
    private LocalDateTime sendDate;
    private LocalDateTime readDate;

    public Alert(AlertUser fromUser, AlertUser toUser, String message) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
        this.isRead = Boolean.FALSE;
        this.sendDate = LocalDateTime.now();
    }

    public void read() {
        this.isRead = Boolean.TRUE;
        this.readDate = LocalDateTime.now();
    }
}
