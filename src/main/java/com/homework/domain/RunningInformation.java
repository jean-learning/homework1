package com.homework.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {
    @Id
    @GeneratedValue
    private long id;

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private  int heartRate;
    private Date timestamp;
    private HealthWarningLevel healthWarningLevel;

//    @JsonIgnoreProperties
    enum HealthWarningLevel{
        LOW, HIGH, NORMAL, DANGER
    }

    @JsonCreator
    public RunningInformation(
            @JsonProperty("runningId") String runningId,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("runningDistance") String runningDistance,
            @JsonProperty("totalRunningTime") String totalRunningTime,
            @JsonProperty("heartRate") String heartRate,
            @JsonProperty("timestamp") String timestamp,
            @JsonProperty("userInfo") UserInfo userInfo) {

        this.runningId = runningId;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);
        this.timestamp = new Date();
        this.userInfo = userInfo;
        this.heartRate = getRandomHeartRate(60, 200);

        if (this.heartRate > 120) {
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        } else if (this.heartRate > 75) {
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        } else if (this.heartRate >= 60) {
            this.healthWarningLevel = HealthWarningLevel.LOW;
        } else {
            this.healthWarningLevel = HealthWarningLevel.DANGER;
        }
    }
    @Embedded
    private UserInfo userInfo;

//    @JsonCreator
//    public RunningInformation(@JsonProperty("runningId") String runningId) {
//        this.userInfo = new UserInfo(runningId);
//    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

//    public String getRunningId() {
//        return this.userInfo == null ? null : this.userInfo.getRunningId();
//    }

    private int getRandomHeartRate(int min, int max) {
        Random rn = new Random();
        return min + rn.nextInt(max - min + 1);
    }
}
