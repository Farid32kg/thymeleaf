package com.thymeleaf.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @Autowired
    private ClientService clientService;

    public ThymeleafController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    public String allClients(Model model){
        model.addAttribute("names", clientService.getAll());
        return "names";
    }

}
