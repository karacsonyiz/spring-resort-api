package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.model.Room;
import com.karacsonyizoli.demo.service.RoomService;
import com.karacsonyizoli.demo.service.RoomServiceHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomServiceHibernate roomServiceHibernate;

    @RequestMapping("/api/rooms")
    public List<RoomEntity> listUsers() {
        //return roomService.listRooms();
        return roomServiceHibernate.list();
    }

    @RequestMapping("/api/room/{id}")
    public Room getRoomByName(@PathVariable int id){
        return null;
    }
}
