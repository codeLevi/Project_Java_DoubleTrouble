package com.projfinal.agentie.repo;

import com.projfinal.agentie.model.Imobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImobilRepo extends JpaRepository<Imobil, Integer> {
}
