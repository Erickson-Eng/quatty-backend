package com.example.quattybackend.domain.services;

import com.example.quattybackend.application.controller.dtos.mapper.AddressMapper;
import com.example.quattybackend.application.controller.dtos.request.AddressRequest;
import com.example.quattybackend.application.controller.dtos.response.AddressResponse;
import com.example.quattybackend.domain.entities.Address;
import com.example.quattybackend.domain.services.exceptions.DataIntegrityViolationException;
import com.example.quattybackend.domain.services.exceptions.ObjectNotFoundException;
import com.example.quattybackend.resource.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    public Address insert(AddressRequest request){
        try{
            return addressRepository.save(addressMapper.toEntity(request));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Unable to save address.\n" +
                    "Required arguments are missing");
        }
    }

    public List<AddressResponse> findAll(){
        return addressRepository.findAll()
                .stream().map(addressMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AddressResponse findById(Integer id){
        Address obj = verifyIfExist(id);
        return addressMapper.toDTO(obj);
    }


    public void delete(Integer id){
        verifyIfExist(id);
        addressRepository.deleteById(id);
    }

    private Address verifyIfExist(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Athlete not found! id:"+id));
    }
}
