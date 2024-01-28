package com.example.medical.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentUnderRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String name;
    private String location;
    private String serialNumber;
    private String inventoryNumber;
    private String manufacturer;
    private int quantity;
    private String typesOfWork;
    private String pastInventoryDate;
    private String futureInventoryDate;
    private String pastCalibrationDate;
    private String futureCalibrationDate;
}
