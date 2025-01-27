package com.example.chatappbackend.playload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

public class MessageRequest
{
    public MessageRequest(String content, String sender, String roomId) {
        this.content = content;
        this.sender = sender;
        this.roomId = roomId;
    }

    private String content;
    private String sender;
    private String roomId;

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageRequest() {
    }
// private LocalDateTime messageTime;
}
