package com.homework.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {
    @Id
    @GeneratedValue
    private long id;

    private String runningId;
    private double latitude;
    private double longitud;
    private String runningDistance;
    private double totalRunningTime;
    private  int heartRate;
    private String timestamp;

    @JsonIgnoreProperties
    enum HealthWarningLevel{
        LOW, HIGH, NORMAL
    }

    @Embedded
    private UserInfo userInfo;

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.userInfo = new UserInfo(runningId);
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getRunningId() {
        return this.userInfo == null ? null : this.userInfo.getRunningId();
    }
}
