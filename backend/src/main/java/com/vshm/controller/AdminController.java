package com.vshm.controller;

import com.vshm.entity.Role;
import com.vshm.entity.User;
import com.vshm.service.AdminService;
import com.vshm.service.ServiceRecordService;
import com.vshm.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final VehicleService vehicleService;
    private final ServiceRecordService serviceRecordService;

    @GetMapping("/users")
    public List<User> users() {
        return adminService.users();
    }

    @PatchMapping("/users/{id}/active")
    public User setActive(@PathVariable Long id, @RequestParam boolean active) {
        return adminService.setActive(id, active);
    }

    @PatchMapping("/users/{id}/role")
    public User setRole(@PathVariable Long id, @RequestParam Role role) {
        return adminService.setRole(id, role);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        adminService.deleteUser(id);
    }

    @GetMapping("/vehicles")
    public Object vehicles() {
        return vehicleService.allVehicles();
    }

    @GetMapping("/services")
    public Object services() {
        return serviceRecordService.all();
    }

    @GetMapping("/metrics")
    public Map<String, Object> metrics() {
        return Map.of(
                "totalUsers", adminService.users().size(),
                "totalVehicles", vehicleService.allVehicles().size(),
                "totalServices", serviceRecordService.all().size()
        );
    }
}
