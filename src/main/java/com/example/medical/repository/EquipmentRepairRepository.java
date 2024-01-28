package com.example.medical.repository;

import com.example.medical.model.EquipmentUnderRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepairRepository extends JpaRepository<EquipmentUnderRepair, Long> {
    List<EquipmentUnderRepair> findEquipmentByNameContainingIgnoreCase(String keyword);
}
