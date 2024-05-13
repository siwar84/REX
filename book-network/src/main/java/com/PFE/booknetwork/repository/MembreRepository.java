package com.PFE.booknetwork.repository;

import com.PFE.booknetwork.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Integer> {
}
