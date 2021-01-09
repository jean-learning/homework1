package com.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER")
public class UserInfo {
    private String runningId;
    private String userName;
    private String address;

    public UserInfo(String runningId){
        this.runningId=runningId;
    }
}
