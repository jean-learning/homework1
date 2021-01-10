package com.homework.service;

import com.homework.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningAnalysisService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findByUserName(String userName, Pageable pageable);

    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);

    Page<RunningInformation> findAllOrderByHealthWarningLevelDesc(Pageable pageable);
}
