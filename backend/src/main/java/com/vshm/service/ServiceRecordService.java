package com.vshm.service;

import com.vshm.dto.ServiceRecordDto;
import com.vshm.entity.ServiceRecord;
import com.vshm.entity.Vehicle;
import com.vshm.exception.ResourceNotFoundException;
import com.vshm.repository.ServiceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRecordService {

    private final ServiceRecordRepository serviceRecordRepository;
    private final VehicleService vehicleService;

    public ServiceRecord create(Long vehicleId, ServiceRecordDto dto, String email) {
        Vehicle vehicle = vehicleService.getOwnedVehicle(vehicleId, email);
        ServiceRecord record = map(dto);
        record.setVehicle(vehicle);
        return serviceRecordRepository.save(record);
    }

    public List<ServiceRecord> listByVehicle(Long vehicleId, String email) {
        Vehicle vehicle = vehicleService.getOwnedVehicle(vehicleId, email);
        return serviceRecordRepository.findByVehicle(vehicle);
    }

    public ServiceRecord update(Long id, ServiceRecordDto dto, String email) {
        ServiceRecord record = serviceRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));
        if (!record.getVehicle().getOwner().getEmail().equals(email)) {
            throw new ResourceNotFoundException("Service not found for user");
        }
        record.setServiceDate(dto.getServiceDate());
        record.setServiceType(dto.getServiceType());
        record.setCost(dto.getCost());
        record.setServiceCenter(dto.getServiceCenter());
        record.setNotes(dto.getNotes());
        record.setNextServiceDate(dto.getNextServiceDate());
        return serviceRecordRepository.save(record);
    }

    public void delete(Long id, String email) {
        ServiceRecord record = serviceRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));
        if (!record.getVehicle().getOwner().getEmail().equals(email)) {
            throw new ResourceNotFoundException("Service not found for user");
        }
        serviceRecordRepository.delete(record);
    }

    public List<ServiceRecord> upcoming() {
        return serviceRecordRepository.findByNextServiceDateBetween(LocalDate.now(), LocalDate.now().plusDays(30));
    }

    public List<ServiceRecord> overdue() {
        return serviceRecordRepository.findByNextServiceDateBefore(LocalDate.now());
    }

    public List<ServiceRecord> all() {
        return serviceRecordRepository.findAll();
    }

    private ServiceRecord map(ServiceRecordDto dto) {
        return ServiceRecord.builder()
                .serviceDate(dto.getServiceDate())
                .serviceType(dto.getServiceType())
                .cost(dto.getCost())
                .serviceCenter(dto.getServiceCenter())
                .notes(dto.getNotes())
                .nextServiceDate(dto.getNextServiceDate())
                .build();
    }
}
