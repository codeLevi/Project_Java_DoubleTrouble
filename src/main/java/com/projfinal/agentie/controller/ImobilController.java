package com.projfinal.agentie.controller;

import com.projfinal.agentie.model.Imobil;
import com.projfinal.agentie.service.ImobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//API comunicare inter aplicati
public class ImobilController {

    @Autowired
    private ImobilService imobilService;

    @GetMapping("/imobile")
    private List<Imobil> getAllImobile(){
        return imobilService.getAllImobil();
    }

    @GetMapping("/imobile/{indexIncepere}/{indexDeFinal}")
    private List<Imobil> getAllImobilePaginat(@PathVariable("indexIncepere") int start, @PathVariable("indexDeFinal") int stop){
        return getAllImobile().subList(start, stop);
    }

    @GetMapping("/imobile/{id}")
    private Imobil getById(@PathVariable("id") int id){
        Imobil imobil = new Imobil();
        imobil.setId(id);
        return imobilService.findById(imobil);
    }

    @GetMapping("/imobile/remove/{id}")
    private void removeById(@PathVariable("id") int id){
        Imobil imobil = new Imobil();
        imobil.setId(id);
        imobilService.delete(imobil);
    }

    @PostMapping("/imobile")
    private int saveImobil(@RequestBody Imobil imobil){
       return  imobilService.save(imobil).getId();
    }

}
