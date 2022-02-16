package com.example.internship.Controller;

import com.example.internship.Dto.GroupDto;
import com.example.internship.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/addGroup")
    public ResponseEntity<?> addGroup(@RequestBody GroupDto groupDto) {
        try {
            return new ResponseEntity<>(this.groupService.addGroup(groupDto), HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateGroup")
    public ResponseEntity<?> updateGroup(@RequestBody GroupDto groupDto,@RequestParam(value="groupId") int groupId){
        try {
            return new ResponseEntity<>(this.groupService.updateGroup(groupDto, groupId), HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteGroup")
    public ResponseEntity<?> deleteGroup(@RequestParam(value="groupId") int groupId){
        try{
            return new ResponseEntity<>(this.groupService.deleteGroup(groupId),HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllGroupsOfUser")
    public ResponseEntity<?> getAllGroupsOfUser(@RequestParam(value="userId") int userId){
        try{
            return new ResponseEntity<>(this.groupService.getAllGroupsOfUser(userId),HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
