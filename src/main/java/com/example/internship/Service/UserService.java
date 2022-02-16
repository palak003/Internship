package com.example.internship.Service;

import com.example.internship.Dto.UserDto;
import com.example.internship.Entity.Person;
import com.example.internship.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Person createUser(UserDto userDto) {
        Person appUser=new Person();
        return DTOtoEntity(userDto,appUser);
    }

    public List<Person> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Person getUser(int id) {
        if(!userRepository.existsById(id))
            throw new IllegalArgumentException("No such user exists");
        return this.userRepository.findById(id);
    }

    public String deleteUser(int id) {
        if(!userRepository.existsById(id))
            throw new IllegalArgumentException("No such user exists");
        this.userRepository.deleteById(id);
        return "User deleted";
    }

    public String updateUser(UserDto userDto, int updateId) {
        if(!userRepository.existsById(updateId))
            throw new IllegalArgumentException("No such user exists");
        Person appUser=this.userRepository.findById(updateId);
        DTOtoEntity(userDto,appUser);
        return "User updated";
    }

    public Person DTOtoEntity(UserDto userDto, Person appUser){
        if(checkEmail(userDto.getEmailId()))
            appUser.setEmailId(userDto.getEmailId());
        else
            throw new IllegalArgumentException("enter valid email id");
        appUser.setName(userDto.getName());
        if(checkPhoneNumber(userDto.getMobileNumber()))
            appUser.setMobileNumber(userDto.getMobileNumber());
        else
            throw new IllegalArgumentException("enter valid phone number");
        return this.userRepository.save(appUser);
    }

    public boolean checkEmail(String emailId){
        String regex= "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailId);
        return matcher.matches();
    }

    public boolean checkPhoneNumber(String phoneNumber){
        return phoneNumber.length() == 10;
    }
}
