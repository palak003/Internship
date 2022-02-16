package com.example.internship.Repository;

import com.example.internship.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person,Integer> {
    Person findById(int id);
}
