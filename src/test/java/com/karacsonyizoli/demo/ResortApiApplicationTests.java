package com.karacsonyizoli.demo;

import com.karacsonyizoli.demo.controller.RoomController;
import com.karacsonyizoli.demo.controller.UserController;
import com.karacsonyizoli.demo.entity.RoomEntity;
import com.karacsonyizoli.demo.entity.UserEntity;
import com.karacsonyizoli.demo.model.UserRole;
import com.karacsonyizoli.demo.service.RoomService;
import com.karacsonyizoli.demo.service.UserService;
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
	private RoomService roomService;

	@Autowired
	private UserService userService;

	@Test
	public void testListRooms(){
		List<RoomEntity> roomList = roomService.list();
		assertEquals(roomList.size(),13);
		assertEquals(roomList.get(0).getId(),1);
	}

	@Test
	public void testUser(){
		UserEntity user = userService.findUserByUserName("user");
		UserEntity admin = userService.findUserByUserName("admin");
		assertEquals(user.getRole(), UserRole.ROLE_USER.name());
		assertEquals(admin.getRole(), UserRole.ROLE_ADMIN.name());
	}

}
