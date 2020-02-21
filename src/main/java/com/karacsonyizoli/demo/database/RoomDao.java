package com.karacsonyizoli.demo.database;

import com.karacsonyizoli.demo.model.Room;
import com.karacsonyizoli.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDao {

    private JdbcTemplate jdbcTemplate;

    public RoomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Room> listRooms() {
        return jdbcTemplate.query("select id, name, slug, type, capacity, price, size, breakfast, featured, description, extras0, fileurl1  from rooms",new RoomMapper());
    }

    private static class RoomMapper implements RowMapper<Room> {
        @Override
        public Room mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String slug = resultSet.getString("slug");
            String type = resultSet.getString("type");
            int capacity = resultSet.getInt("capacity");
            int price = resultSet.getInt("price");
            int size = resultSet.getInt("size");
            boolean breakfast = resultSet.getBoolean("breakfast");
            boolean featured = resultSet.getBoolean("featured");
            String description = resultSet.getString("description");
            String extras = resultSet.getString("extras0");
            String imgUrl = resultSet.getString("fileurl1");
            Room room = new Room(id,name,slug,type,capacity,price,size,breakfast,featured,description,extras,imgUrl);
            return room;
        }
    }

}
