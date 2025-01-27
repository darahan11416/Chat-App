package com.example.chatappbackend.controllers;

import com.example.chatappbackend.entites.Message;
import com.example.chatappbackend.entites.Room;
import com.example.chatappbackend.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController
{

    @Autowired
    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //create room
    @PostMapping
    public ResponseEntity<?> createRoom(String roomId)
    {
        if (roomRepository.findByroomid(roomId) != null)
        {
            return ResponseEntity.badRequest().body("Room already exists");


        }

        //create new room 

        Room room = new Room();
        room.setRoomid(roomId);
        Room savedRoom =  roomRepository.save(room);
        return  ResponseEntity.status(HttpStatus.CREATED).body(room);



    }


    //get room

    @GetMapping("/{roomId}")
    public  ResponseEntity<?> joinRoom(@PathVariable String roomId)
        {

            Room room =  roomRepository.findByroomid(roomId);
            if(room == null)
            {
                return ResponseEntity.badRequest()
                        .body("room not found");

            }
            return ResponseEntity.ok(room);


        }





    //get message of rooms

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0" , required = false) int page,
            @RequestParam(value = "size", defaultValue = "20",required = false) int size
    ){
        Room room =  roomRepository.findByroomid(roomId);
        if(room == null)
        {
            return ResponseEntity.badRequest().build();
        }
        List<Message> messages =  room.getMessages();

        int start = Math.max(0,messages.size() - (page + 1)*size);
        int end = Math.min(messages.size(),start+size);

        List<Message> paginatedMessages  = messages.subList(start,end);

        return ResponseEntity.ok(messages);




    }


}
