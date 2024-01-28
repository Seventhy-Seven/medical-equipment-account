package com.example.medical.service;

import com.example.medical.model.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> findAll();
    List<Equipment> find(String keyword);
    void delete(Long id);
    Equipment get(Long id);
    void update(Long id, Equipment equipment);
}
