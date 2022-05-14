package com.BookStore.Sklad.controllers;

import com.BookStore.Sklad.models.Offices;
import com.BookStore.Sklad.repository.OfficesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OfficeController {

    @Autowired
    private OfficesRepository officesRepository;

    @GetMapping("/block/office")
    public String blockMain(Model model)
    {
        Iterable<Offices> office = officesRepository.findAll();
        model.addAttribute("office", office);
        return "office_block";
    }

    @GetMapping("/block/office/add")
    public String blockAdd(Model model)
    {return "office_add";}


    @PostMapping("/block/office/add")
    public String blockPostAdd(@RequestParam String name,
                               @RequestParam int count,
                               @RequestParam int price,Model model)
    {
        Offices offices = new Offices(name,count,price);
        officesRepository.save(offices);
        return "redirect:/block";
    }
}
