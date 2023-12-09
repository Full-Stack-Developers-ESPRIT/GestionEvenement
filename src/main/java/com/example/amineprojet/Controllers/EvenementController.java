package com.example.amineprojet.Controllers;

import com.example.amineprojet.Entities.Evenement;
import com.example.amineprojet.Service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("event")


public class EvenementController {

    @Autowired
    private EvenementService evenementService;




    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<Evenement> createEvent(@RequestBody Evenement event){

        return  new ResponseEntity<>(evenementService.AddEvent(event), HttpStatus.OK);
    }


    @GetMapping("/events")
    public  ResponseEntity<List<Evenement>> getEvents(){

        List<Evenement> events= evenementService.GetEvents();


        return ResponseEntity.ok(events);
    }





    @GetMapping("/{id}")
    public ResponseEntity<Evenement> getEventById(@PathVariable Long id) {
        Optional<Evenement> event = evenementService.GetEventyyId(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evenement> updateEvent(
            @PathVariable Long id,
            @RequestParam String eventName,
            @RequestParam String description,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam String location) {

        Evenement updatedEvent = evenementService.updateEvent(id, eventName, description, startDate, endDate, location);

        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        String resultMessage = evenementService.DeleteEvent(id);

        if (resultMessage.equals("evenement supprimé")) {
            return ResponseEntity.ok(resultMessage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultMessage);
        }
    }
}

