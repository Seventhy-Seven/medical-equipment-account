package com.example.medical.service;

import com.example.medical.model.EquipmentUnderRepair;

import java.util.List;

public interface EquipmentRepairService {
    List<EquipmentUnderRepair> findAll();
    List<EquipmentUnderRepair> find(String keyword);
    void delete(Long id);
    EquipmentUnderRepair get(Long id);
    void update(Long id, EquipmentUnderRepair equipmentUnderRepair);
}
