package com.vshm.controller;

import com.vshm.dto.VehicleDto;
import com.vshm.entity.Vehicle;
import com.vshm.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> list(Authentication auth) {
        return vehicleService.listUserVehicles(auth.getName());
    }

    @PostMapping
    public Vehicle create(@Valid @RequestBody VehicleDto dto, Authentication auth) {
        return vehicleService.create(dto, auth.getName());
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @Valid @RequestBody VehicleDto dto, Authentication auth) {
        return vehicleService.update(id, dto, auth.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, Authentication auth) {
        vehicleService.delete(id, auth.getName());
    }
}
