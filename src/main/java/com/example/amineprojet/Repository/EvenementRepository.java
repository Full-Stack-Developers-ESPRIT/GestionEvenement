package com.example.amineprojet.Repository;

import com.example.amineprojet.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository  extends JpaRepository<Evenement,Long> {


}
