package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/api/rooms", method = RequestMethod.GET)
    public List<RoomEntity> listRooms() {
        return roomService.list();
    }

    @RequestMapping(value = "/api/room/{id}", method = RequestMethod.GET)
    public RoomEntity getRoomById(@PathVariable int id){
        return roomService.getRoom(id).get();
    }

    @RequestMapping(value = "/api/createRoom", method = RequestMethod.POST)
    public ResponseEntity<String> createRoom(@RequestBody RoomEntity room){
        return roomService.createRoom(room);
    }

    @RequestMapping(value = "/api/updateRoom", method = RequestMethod.POST)
    public ResponseEntity<String> updateRoom(@RequestBody RoomEntity room){
        return roomService.updateRoom(room);
    }
}
