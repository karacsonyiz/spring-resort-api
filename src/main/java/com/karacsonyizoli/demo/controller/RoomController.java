package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("/api/rooms")
    public List<RoomEntity> listUsers() {
        return roomService.list();
    }

    @RequestMapping("/api/room/{id}")
    public RoomEntity getRoomById(@PathVariable int id){
        return roomService.getRoom(id).get();
    }
}
