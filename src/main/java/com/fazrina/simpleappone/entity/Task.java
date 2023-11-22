package com.fazrina.simpleappone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private String id;
    private String activity;
    private String description;
    private String priority;
    private String reward;
    private String status;
}
