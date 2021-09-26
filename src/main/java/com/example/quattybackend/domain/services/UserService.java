package com.example.quattybackend.domain.services;

import com.example.quattybackend.application.controller.dtos.mapper.UserMapper;
import com.example.quattybackend.application.controller.dtos.request.UserRequest;
import com.example.quattybackend.application.controller.dtos.response.UserResponse;
import com.example.quattybackend.domain.entities.User;
import com.example.quattybackend.domain.services.exceptions.DataIntegrityViolationException;
import com.example.quattybackend.domain.services.exceptions.ObjectNotFoundException;
import com.example.quattybackend.resource.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public void insert(UserRequest request){
        try{
            userRepository.save(userMapper.toEntity(request));
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Unable to save user.\n" +
                    "Required arguments are missing");
        }

    }

    public List<UserResponse> findAll(){
        return userRepository.findAll()
                .stream().map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponse findById(Integer id){
        User obj = verifyIfExist(id);
        return userMapper.toDTO(obj);
    }


    public void delete(Integer id){
        verifyIfExist(id);
        userRepository.deleteById(id);
    }

    private User verifyIfExist(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found! id:"+id));
    }


}
