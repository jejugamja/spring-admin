package com.example.gentellela.alert.ui;

import com.example.gentellela.alert.domain.Alert;
import com.example.gentellela.common.specification.Specificationable;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

@Data
public class AlertSpecification implements Specificationable<Alert> {

    private Long toUserId;
    private Long fromUserId;

    @Override
    public Specification<Alert> specification() {
        return where(eq("toUserId", Optional.ofNullable(toUserId)));
    }
}
