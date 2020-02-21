package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.RoomDao;
import com.karacsonyizoli.demo.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public List<Room> listRooms() {
        return roomDao.listRooms();
    }
}
