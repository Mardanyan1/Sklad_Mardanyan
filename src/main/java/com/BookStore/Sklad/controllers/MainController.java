package com.BookStore.Sklad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/block")
    public String tovar(Model model) {
        model.addAttribute("title", "Main page");
        return "tovar";
    }

}