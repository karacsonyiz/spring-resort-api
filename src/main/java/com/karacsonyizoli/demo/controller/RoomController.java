package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
