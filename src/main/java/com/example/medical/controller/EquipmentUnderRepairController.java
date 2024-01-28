package com.example.medical.controller;

import com.example.medical.model.EquipmentUnderRepair;
import com.example.medical.service.EquipmentRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EquipmentUnderRepairController {

    @Autowired
    private EquipmentRepairService equipmentRepairService;

    @GetMapping("/equip_repair")
    public String getEquipRepairPage(Model model) {
        model.addAttribute("equipmentList", equipmentRepairService.findAll());
        return "equip_repair";
    }

    @PostMapping("/equip_repair")
    public String find(@RequestParam String keyword, Model model) {
        model.addAttribute("equipmentList", equipmentRepairService.find(keyword));
        return "equip_repair";
    }

    @GetMapping("/equip_repair/{id}")
    public String get(@PathVariable("id") Long id, Model model) {
        model.addAttribute("equipment", equipmentRepairService.get(id));
        model.addAttribute("role", getUserRole());
        return "equip_repair_detail";
    }

    @PostMapping("/equip_repair/delete")
    public String delete(@RequestParam("id") Long id) {
        equipmentRepairService.delete(id);
        return "redirect:/equip_repair";
    }

    @PostMapping("/equip_repair/{id}")
    public String updateEquip(@RequestParam("id") Long id, @ModelAttribute("equipment") EquipmentUnderRepair equipment,
                              Model model) {
        equipmentRepairService.update(id, equipment);
        model.addAttribute("role", getUserRole());
        return "redirect:/equip_repair/{id}";
    }

    private static String getUserRole() {
        return SecurityContextHolder
                .getContext().getAuthentication().getAuthorities().toString();
    }
}
