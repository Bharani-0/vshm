package com.vshm.controller;

import com.vshm.repository.VehicleRepository;
import com.vshm.service.ServiceRecordService;
import com.vshm.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final VehicleService vehicleService;
    private final ServiceRecordService serviceRecordService;
    private final VehicleRepository vehicleRepository;

    @GetMapping("/user")
    public Map<String, Object> userDashboard(Authentication auth) {
        return Map.of(
                "totalVehicles", vehicleService.listUserVehicles(auth.getName()).size(),
                "upcomingServices", serviceRecordService.upcoming().size(),
                "overdueServices", serviceRecordService.overdue().size()
        );
    }

    @GetMapping("/admin")
    public Map<String, Object> adminDashboard() {
        return Map.of(
                "totalVehicles", vehicleRepository.count(),
                "totalServices", serviceRecordService.all().size(),
                "upcomingServices", serviceRecordService.upcoming().size()
        );
    }
}
