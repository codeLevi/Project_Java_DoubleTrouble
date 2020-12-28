package com.projfinal.agentie.service;

import com.projfinal.agentie.model.Imobil;
import com.projfinal.agentie.repo.ImobilRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImobilService {
    private final ImobilRepo imobilRepo;

    public ImobilService(ImobilRepo imobilRepo) {
        this.imobilRepo = imobilRepo;
    }

    //CRUD

    public Imobil save(Imobil imobil) {
        return imobilRepo.save(imobil);
    }

    public Imobil findById(Imobil imobil) {
        return imobilRepo.getOne(imobil.getId());
    }

    public void delete(Imobil imobil) {
        imobilRepo.delete(imobil);
    }

    public void update(Imobil imobil) {
        Imobil i = findById(imobil);
        i.setAdresa(imobil.getAdresa());
        i.setAgent(imobil.getAgent());
        i.setNrCamere(imobil.getNrCamere());
        i.setSuprafata(imobil.getSuprafata());
        i.setTipul(imobil.getTipul());
        save(i);
    }

    public List<Imobil> getAllImobil() {
        return imobilRepo.findAll();
    }
}
