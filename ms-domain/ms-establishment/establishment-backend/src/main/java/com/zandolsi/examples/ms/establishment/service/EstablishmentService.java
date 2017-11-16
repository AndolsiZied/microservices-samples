package com.zandolsi.examples.ms.establishment.service;

import com.zandolsi.examples.ms.establishment.model.Establishment;
import com.zandolsi.examples.ms.establishment.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public Establishment get(String id) {
        return establishmentRepository.findOne(id);
    }

    public Establishment save(Establishment establishment) {
        return establishmentRepository.save(establishment);
    }
}
