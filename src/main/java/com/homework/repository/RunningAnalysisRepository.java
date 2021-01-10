package com.homework.repository;

import com.homework.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RunningAnalysisRepository extends JpaRepository<RunningInformation, Long> {
    Page<RunningInformation> findByUserInfoUserName(@Param("userName") String userName, Pageable pageable);
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);
    void deleteByRunningId(String runningId);
}

