package com.karacsonyizoli.demo;

import com.karacsonyizoli.demo.controller.RoomController;
import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.model.Room;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class ResortApiApplicationTests {

	@Autowired
	private RoomController roomController;

	@Test
	public void testGetters(){
		List<RoomEntity> roomList = roomController.listUsers();
		roomList.forEach(room -> System.out.println(room.toString()));
		assertEquals(roomList.size(),13);
		assertEquals(roomList.get(0).getId(),1);
	}

}
