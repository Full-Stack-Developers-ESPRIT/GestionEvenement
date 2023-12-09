package com.example.amineprojet.Entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@Getter
@Entity
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
