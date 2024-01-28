package com.example.medical.controller;

import com.example.medical.model.Equipment;
import com.example.medical.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/equip")
    public String getEquipPage(Model model) {
        model.addAttribute("equipmentList", equipmentService.findAll());
        return "equip";
    }

    @PostMapping("/equip")
    public String find(@RequestParam String keyword, Model model) {
        model.addAttribute("equipmentList", equipmentService.find(keyword));
        return "equip";
    }

    @GetMapping("/equip/{id}")
    public String get(@PathVariable("id") Long id, Model model) {
        model.addAttribute("equipment", equipmentService.get(id));
        model.addAttribute("role", getUserRole());
        return "equip_detail";
    }

    @PostMapping("/equip/delete")
    public String delete(@RequestParam("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/equip";
    }

    @PostMapping("/equip/{id}")
    public String updateEquip(@RequestParam("id") Long id, @ModelAttribute("equipment")Equipment equipment,
                              Model model) {
        equipmentService.update(id, equipment);
        model.addAttribute("role", getUserRole());
        return "redirect:/equip/{id}";
    }

    private static String getUserRole() {
        return SecurityContextHolder
                .getContext().getAuthentication().getAuthorities().toString();
    }
}
