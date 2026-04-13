package com.ra.ptit_cntt2_it210_btvn_ex5.controller;

import com.ra.ptit_cntt2_it210_btvn_ex5.model.Combo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/combo")
public class ComboController {
    private static List<Combo> comboList = new ArrayList<>();

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("combo", new Combo());
        model.addAttribute("availableItems", Arrays.asList("Gà rán", "Pizza", "Coca", "Khoai tây chiên", "Burger"));
        return "combo-add";
    }

    @PostMapping("/add")
    public String saveCombo(@ModelAttribute("combo") Combo combo,
                            @RequestParam("banner") MultipartFile file,
                            Model model) {
        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Một siêu combo phải có ít nhất 2 món ăn!");
            model.addAttribute("availableItems", Arrays.asList("Gà rán", "Pizza", "Coca", "Khoai tây chiên", "Burger"));
            return "combo-add";
        }


        System.out.println("{");
        System.out.println("  \"comboName\": \"" + combo.getComboName() + "\",");
        System.out.println("  \"items\": " + combo.getItemList());
        System.out.println("}");

        return "redirect:/combo/success";
    }
}