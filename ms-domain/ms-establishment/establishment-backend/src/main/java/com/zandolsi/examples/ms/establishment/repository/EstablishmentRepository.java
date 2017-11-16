package com.zandolsi.examples.ms.establishment.repository;

import com.zandolsi.examples.ms.establishment.model.Establishment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends CrudRepository<Establishment, String> {
}
