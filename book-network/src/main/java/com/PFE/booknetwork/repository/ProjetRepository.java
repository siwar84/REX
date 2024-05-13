package com.PFE.booknetwork.repository;

import com.PFE.booknetwork.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {


}
