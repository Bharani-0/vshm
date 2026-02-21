package com.vshm.service;

import com.vshm.dto.VehicleDto;
import com.vshm.entity.User;
import com.vshm.entity.Vehicle;
import com.vshm.exception.ResourceNotFoundException;
import com.vshm.repository.UserRepository;
import com.vshm.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public Vehicle create(VehicleDto dto, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Vehicle vehicle = Vehicle.builder()
                .vehicleName(dto.getVehicleName())
                .model(dto.getModel())
                .registrationNumber(dto.getRegistrationNumber())
                .purchaseDate(dto.getPurchaseDate())
                .fuelType(dto.getFuelType())
                .owner(user)
                .build();
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> listUserVehicles(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return vehicleRepository.findByOwner(user);
    }

    public Vehicle update(Long id, VehicleDto dto, String email) {
        Vehicle vehicle = getOwnedVehicle(id, email);
        vehicle.setVehicleName(dto.getVehicleName());
        vehicle.setModel(dto.getModel());
        vehicle.setRegistrationNumber(dto.getRegistrationNumber());
        vehicle.setPurchaseDate(dto.getPurchaseDate());
        vehicle.setFuelType(dto.getFuelType());
        return vehicleRepository.save(vehicle);
    }

    public void delete(Long id, String email) {
        vehicleRepository.delete(getOwnedVehicle(id, email));
    }

    public Vehicle getOwnedVehicle(Long id, String email) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        if (!vehicle.getOwner().getEmail().equals(email)) {
            throw new ResourceNotFoundException("Vehicle not found for user");
        }
        return vehicle;
    }

    public List<Vehicle> allVehicles() {
        return vehicleRepository.findAll();
    }
}
