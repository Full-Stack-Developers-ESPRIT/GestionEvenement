package com.example.amineprojet.Service;

import com.example.amineprojet.Entities.Evenement;
import com.example.amineprojet.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    @Autowired
private EvenementRepository evenementRepository;

public Evenement AddEvent(Evenement e ) {

    return  evenementRepository.save(e);
}

public List<Evenement> GetEvents(){

return  evenementRepository.findAll();

}

    public Optional<Evenement> GetEventyyId(Long id) {

        return evenementRepository.findById(id);
    }


    public Evenement updateEvent(Long id, String eventName , String description , Date startDate, Date endDate,String location) {
        if (evenementRepository.findById(id).isPresent()) {
            Evenement existantEvent = evenementRepository.findById(id).get();
            existantEvent.setEventName(eventName);
            existantEvent.setDescription(description);
            existantEvent.setStartDate(startDate);
            existantEvent.setEndDate(endDate);
            existantEvent.setLocation(location);

            return evenementRepository.save(existantEvent);
        } else {
            return null;
        }

    }

    public String DeleteEvent( Long id){

        if (evenementRepository.findById(id).isPresent()){
            evenementRepository.deleteById(id);
            return "evenement supprimé";
        }else
            return "evenement non supprimé";
    }



}
