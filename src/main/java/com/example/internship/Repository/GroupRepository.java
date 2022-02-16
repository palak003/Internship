package com.example.internship.Repository;

import com.example.internship.Entity.Groups;
import com.example.internship.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Groups,Integer> {
    Groups findById(int id);

    @Query("SELECT grp from Groups grp where grp.person=?1")
    List<Groups> findAllGroups(Person user);
}