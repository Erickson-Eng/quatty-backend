package com.example.quattybackend.application.controller.controllers;

import com.example.quattybackend.application.controller.dtos.request.AthleteRequest;
import com.example.quattybackend.application.controller.dtos.response.AthleteResponse;
import com.example.quattybackend.domain.entities.Athlete;
import com.example.quattybackend.domain.services.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/athlete")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AthleteController {

    private AthleteService athleteService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid AthleteRequest athleteRequest){
        Athlete entity = athleteService.insert(athleteRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AthleteResponse> findById(@PathVariable Integer id){
        AthleteResponse athleteResponse = athleteService.findById(id);
        return ResponseEntity.ok().body(athleteResponse);
    }

    @GetMapping
    public ResponseEntity<List<AthleteResponse>> findAll(){
        List<AthleteResponse> athleteResponses = athleteService.findAll();
        return ResponseEntity.ok().body(athleteResponses);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        athleteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
