package com.example.medical.service;

import com.example.medical.model.Equipment;
import com.example.medical.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    @Override
    public List<Equipment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Equipment> find(String keyword) {
        return repository.findEquipmentByNameContainingIgnoreCase(keyword);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Equipment get(Long id) {
        return repository.getById(id);
    }

    @Override
    public void update(Long id, Equipment updated) {
        Equipment equipment = repository.getById(id);

        repository.save(Equipment.builder()
                .id(equipment.getId())
                .name(updated.getName())
                .status(updated.getStatus())
                .location(updated.getLocation())
                .serialNumber(updated.getSerialNumber())
                .inventoryNumber(updated.getInventoryNumber())
                .manufacturer(updated.getManufacturer())
                .quantity(updated.getQuantity())
                .typesOfWork(updated.getTypesOfWork())
                .pastInventoryDate(updated.getPastInventoryDate())
                .futureInventoryDate(updated.getFutureInventoryDate())
                .pastCalibrationDate(updated.getPastCalibrationDate())
                .futureCalibrationDate(updated.getFutureCalibrationDate())
                .build());
    }
}
