package com.example.chatappbackend.entites;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms") // Corrected from 'collation'
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private String id; // MongoDB unique identifier

    private String roomid; // Changed 'Roomid' to 'roomid'

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    private List<Message> messages = new ArrayList<>();
}
