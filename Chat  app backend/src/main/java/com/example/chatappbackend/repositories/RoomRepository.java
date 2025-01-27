package com.example.chatappbackend.repositories;

import com.example.chatappbackend.entites.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String>
{

    //get room by roomid

    Room findByroomid(String roomid);



}
