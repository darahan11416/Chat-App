package com.example.chatappbackend.controllers;


import com.example.chatappbackend.entites.Message;
import com.example.chatappbackend.entites.Room;
import com.example.chatappbackend.playload.MessageRequest;
import com.example.chatappbackend.repositories.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("http://localhost:3000")
public class ChatController
{
    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //for sending and reciving msg

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    )
    {
         Room room= roomRepository.findByroomid(request.getRoomId());

         Message message = new Message();
         message.setContent(request.getContent());
         message.setSender(request.getSender());

         if(room!= null)
         {
             room.getMessages().add(message);
             roomRepository.save(room);

         }
         else {
             throw new RuntimeException("Room not found");
         }

         return message;


    }



}
