package com.vshm.controller;

import com.vshm.dto.ServiceRecordDto;
import com.vshm.entity.ServiceRecord;
import com.vshm.service.ServiceRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceRecordController {

    private final ServiceRecordService serviceRecordService;

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceRecord> listByVehicle(@PathVariable Long vehicleId, Authentication auth) {
        return serviceRecordService.listByVehicle(vehicleId, auth.getName());
    }

    @PostMapping("/vehicle/{vehicleId}")
    public ServiceRecord create(@PathVariable Long vehicleId, @Valid @RequestBody ServiceRecordDto dto, Authentication auth) {
        return serviceRecordService.create(vehicleId, dto, auth.getName());
    }

    @PutMapping("/{id}")
    public ServiceRecord update(@PathVariable Long id, @Valid @RequestBody ServiceRecordDto dto, Authentication auth) {
        return serviceRecordService.update(id, dto, auth.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, Authentication auth) {
        serviceRecordService.delete(id, auth.getName());
    }

    @GetMapping("/reminders/upcoming")
    public List<ServiceRecord> upcoming() {
        return serviceRecordService.upcoming();
    }

    @GetMapping("/reminders/overdue")
    public List<ServiceRecord> overdue() {
        return serviceRecordService.overdue();
    }
}
