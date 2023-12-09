package com.example.amineprojet.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Evenement implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    private  String eventName;

    private  String description ;

    private Date startDate;
    private  Date endDate;

    private  String location;


}
