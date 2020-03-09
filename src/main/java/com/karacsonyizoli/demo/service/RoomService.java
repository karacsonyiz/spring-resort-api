package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.RoomRepository;
import com.karacsonyizoli.demo.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomEntity> list(){
        return roomRepository.findAll();
    }

    public Optional<RoomEntity> getRoom(int id){
        return roomRepository.findById(id);
    }

}
