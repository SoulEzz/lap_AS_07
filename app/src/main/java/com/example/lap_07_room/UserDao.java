package com.example.lap_07_room;

import android.view.View;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<EntityUser> getAll();


    @Insert
    void insertAll(EntityUser users);

    @Delete
    void delete(EntityUser user);
}
