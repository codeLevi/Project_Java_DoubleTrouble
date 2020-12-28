package com.projfinal.agentie.controller;

import com.projfinal.agentie.model.Imobil;
import com.projfinal.agentie.service.ImobilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //asta controleaza partea de html -> index.html
public class ImobilUIController {

    private static final String INDEX = "redirect:/index";

    private final ImobilService imobilService;

    public ImobilUIController(ImobilService imobilService) {
        this.imobilService = imobilService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Imobil> listaImobile = imobilService.getAllImobil();
        model.addAttribute("imobilList", listaImobile);
        model.addAttribute("imobilNou", new Imobil());
        model.addAttribute("imobilVechi", new Imobil());
        return "index";
    }


    @PostMapping("/addImobil")
    public String addImobil(@ModelAttribute Imobil imobil){
        imobilService.save(imobil);
        return INDEX;
    }

    @PostMapping("/updateImobil")
    public String updateImobil(@ModelAttribute Imobil imobil){
        imobilService.update(imobil);
        return INDEX;
    }


    @GetMapping("/deleteImobil/{imobilId}")
    public String deleteImobil(@PathVariable String imobilId){
        Imobil imobil = new Imobil();
        imobil.setId(Integer.parseInt(imobilId));
        imobilService.delete(imobil);
        return INDEX;
    }

}
