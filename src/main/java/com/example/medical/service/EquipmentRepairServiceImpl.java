package com.example.medical.service;

import com.example.medical.model.EquipmentUnderRepair;
import com.example.medical.repository.EquipmentRepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentRepairServiceImpl implements EquipmentRepairService {

    @Autowired
    private EquipmentRepairRepository repository;

    @Override
    public List<EquipmentUnderRepair> findAll() {
        return repository.findAll();
    }

    @Override
    public List<EquipmentUnderRepair> find(String keyword) {
        return repository.findEquipmentByNameContainingIgnoreCase(keyword);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EquipmentUnderRepair get(Long id) {
        return repository.getById(id);
    }

    @Override
    public void update(Long id, EquipmentUnderRepair updated) {
        EquipmentUnderRepair equipment = repository.getById(id);

        repository.save(EquipmentUnderRepair.builder()
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
