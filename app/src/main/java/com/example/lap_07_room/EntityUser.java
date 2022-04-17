package com.example.lap_07_room;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class EntityUser {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public EntityUser(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
