package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.RoomDao;
import com.karacsonyizoli.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDao roomDao;

    public List<Room> listRooms() {
        return roomDao.listRooms();
    }
}
