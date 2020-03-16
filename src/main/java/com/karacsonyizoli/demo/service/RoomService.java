package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.RoomRepository;
import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> createRoom(RoomEntity roomEntity){
        try {
            roomRepository.save(roomEntity);
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateRoom(RoomEntity roomEntity) {
        try {
            roomRepository.save(roomEntity);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
