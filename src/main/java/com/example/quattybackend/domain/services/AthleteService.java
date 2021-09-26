package com.example.quattybackend.domain.services;

import com.example.quattybackend.application.controller.dtos.mapper.AthleteMapper;
import com.example.quattybackend.application.controller.dtos.request.AthleteRequest;
import com.example.quattybackend.application.controller.dtos.response.AthleteResponse;
import com.example.quattybackend.domain.entities.Athlete;
import com.example.quattybackend.domain.services.exceptions.DataIntegrityViolationException;
import com.example.quattybackend.domain.services.exceptions.ObjectNotFoundException;
import com.example.quattybackend.resource.repositories.AthleteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AthleteService {

    private AthleteRepository athleteRepository;
    private AthleteMapper athleteMapper;
    
    
    public Athlete insert(AthleteRequest request){
        try{
            return athleteRepository.save(athleteMapper.toEntity(request));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Unable to save athlete.\n" +
                    "Required arguments are missing");
        }
    }

    public List<AthleteResponse> findAll(){
        return athleteRepository.findAll()
                .stream().map(athleteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AthleteResponse findById(Integer id){
        Athlete obj = verifyIfExist(id);
        return athleteMapper.toDTO(obj);
    }


    public void delete(Integer id){
        verifyIfExist(id);
        athleteRepository.deleteById(id);
    }

    private Athlete verifyIfExist(Integer id) {
        return athleteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Athlete not found! id:"+id));
    }
    



}
