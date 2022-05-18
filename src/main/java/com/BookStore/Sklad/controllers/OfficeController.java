package com.BookStore.Sklad.controllers;

import com.BookStore.Sklad.models.Offices;
import com.BookStore.Sklad.repository.OfficesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class OfficeController {

    @Autowired
    private OfficesRepository officesRepository;

    @GetMapping("/office")
    public String blockMain(Model model)
    {
        Iterable<Offices> office = officesRepository.findAll();
        model.addAttribute("office", office);
        return "get_block";
    }

    @GetMapping("/office/add")
    public String blockAdd(Model model)
    {return "block_add";}


    @PostMapping("/office/add")
    public String blockPostAdd(@RequestParam String name,
                               @RequestParam int count,
                               @RequestParam int price,Model model)
    {
        Offices offices = new Offices(name,count,price);
        officesRepository.save(offices);
        return "redirect:/";
    }


    @GetMapping("/office/{id}")
    public String officeDetails(@PathVariable(value = "id") long id, Model model)
    {
        if(!officesRepository.existsById(id))
        {
            return "redirect:/";
        }
        Optional<Offices> office = officesRepository.findAllById(id);
        ArrayList<Offices> res = new ArrayList<>();
        office.ifPresent(res::add);
        model.addAttribute("office", res);
        return "office_details";
    }


    @GetMapping("/office/{id}/edit")
    public String officeEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(!officesRepository.existsById(id))
        {
            return "redirect:/";
        }
        Optional<Offices> office = officesRepository.findAllById(id);
        ArrayList<Offices> res = new ArrayList<>();
        office.ifPresent(res::add);
        model.addAttribute("office", res);
        return "office_edit";
    }

    @PostMapping("/office/{id}/edit")
    public String officePostEdit(@PathVariable(value = "id") long id,
                               @RequestParam String name,
                               @RequestParam int count,
                               @RequestParam int price, Model model)
    {
        Offices office = officesRepository.findAllById(id).orElseThrow();
        office.setName(name);
        office.setCount(count);
        office.setPrice(price);
        officesRepository.save(office);
        return "redirect:/office";
    }


    @PostMapping("/office/{id}/remove")
    public String officePostDelete(@PathVariable(value = "id") long id, Model model)
    {
        Offices offices = officesRepository.findAllById(id).orElseThrow();
        officesRepository.delete(offices);
        return "redirect:/office";
    }

}
