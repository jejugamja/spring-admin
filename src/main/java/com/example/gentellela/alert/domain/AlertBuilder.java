package com.example.gentellela.alert.domain;

import com.example.gentellela.common.entityBuilder.EntityBuilder;
import lombok.Data;
import lombok.Getter;

@Data
public class AlertBuilder implements EntityBuilder<Alert> {

    private Long fromId;
    private String  fromUserName;
    private Long toId;
    private String toUserName;
    private String message;

    @Override
    public Alert build() {
        return new Alert(new AlertUser(fromId, fromUserName), new AlertUser(toId, toUserName), message);
    }
}
