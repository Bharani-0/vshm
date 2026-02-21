package com.vshm.repository;

import com.vshm.entity.ServiceRecord;
import com.vshm.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
    List<ServiceRecord> findByVehicle(Vehicle vehicle);
    List<ServiceRecord> findByNextServiceDateBetween(LocalDate start, LocalDate end);
    List<ServiceRecord> findByNextServiceDateBefore(LocalDate date);
}
