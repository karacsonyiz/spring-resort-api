package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.model.Room;
import com.karacsonyizoli.demo.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping("/api/rooms")
    public List<Room> listUsers() {
        return roomService.listRooms();
    }
}
