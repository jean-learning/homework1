package com.homework.repository;

import com.homework.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RunningAnalysisRepository extends JpaRepository<RunningInformation, Long> {
    Page<RunningInformation> findByUserName(@Param("userName") String userName, Pageable pageable);
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    Page<RunningInformation> findAllOrderByHealthWarningLevel(@Param("runningId") String runningId, Pageable pageable);

}

