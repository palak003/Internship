package com.example.internship.Service;

import com.example.internship.Dto.GroupDto;
import com.example.internship.Entity.Groups;
import com.example.internship.Entity.Person;
import com.example.internship.Repository.GroupRepository;
import com.example.internship.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public Groups addGroup(GroupDto groupDto) {
        Groups group=new Groups();
        return DTOtoEntity(groupDto,group);
    }

    public String updateGroup(GroupDto groupDto,int groupId) {
        if(!groupRepository.existsById(groupId))
            throw new IllegalArgumentException("No such group exists");
        Groups updateGroup=this.groupRepository.findById(groupId);
        DTOtoEntity(groupDto,updateGroup);
        return "Updated the group";
    }

    public String deleteGroup(int groupId) {
        if(!groupRepository.existsById(groupId))
            throw new IllegalArgumentException("No such group exists");
        this.groupRepository.deleteById(groupId);
        return "Group deleted successfully";
    }

    public List<Groups> getAllGroupsOfUser(int userId) {
        if(!userRepository.existsById(userId))
            throw new IllegalArgumentException("No such user exists");
        Person appUser=this.userRepository.findById(userId);
        return this.groupRepository.findAllGroups(appUser);
    }

    public Groups DTOtoEntity(GroupDto groupDto,Groups group){
        group.setGroupName(groupDto.getGroupName());
        group.setGroupStrength(groupDto.getGroupStrength());
        if(!userRepository.existsById(groupDto.getUserId()))
            throw new IllegalArgumentException("No such user exists");
        Person appUser=this.userRepository.findById(groupDto.getUserId());
        group.setPerson(appUser);
        return this.groupRepository.save(group);
    }
}

//docker

