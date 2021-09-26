package com.example.quattybackend.application.controller.controllers;

import com.example.quattybackend.application.controller.dtos.request.AddressRequest;
import com.example.quattybackend.application.controller.dtos.response.AddressResponse;
import com.example.quattybackend.domain.entities.Address;
import com.example.quattybackend.domain.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid AddressRequest addressRequest){
        Address entity = addressService.insert(addressRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable Integer id){
        AddressResponse addressResponse = addressService.findById(id);
        return ResponseEntity.ok().body(addressResponse);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll(){
        List<AddressResponse> addressResponses = addressService.findAll();
        return ResponseEntity.ok().body(addressResponses);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
