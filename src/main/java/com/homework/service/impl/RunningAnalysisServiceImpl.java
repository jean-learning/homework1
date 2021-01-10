package com.homework.service.impl;

import com.homework.domain.RunningInformation;
import com.homework.repository.RunningAnalysisRepository;
import com.homework.service.RunningAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningAnalysisServiceImpl implements RunningAnalysisService {

    @Autowired
    private RunningAnalysisRepository runningAnalysisRepository;

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return runningAnalysisRepository.save(runningInformations);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningAnalysisRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findByUserName(String userName, Pageable pageable) {
        return runningAnalysisRepository.findByUserInfoUserName(userName, pageable);
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return runningAnalysisRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInformation> findAllOrderByHealthWarningLevelDesc(Pageable pageable) {
        return runningAnalysisRepository.findAllByOrderByHeartRateDesc(pageable);
    }
}
