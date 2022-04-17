package com.example.lap_07_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText txtNhap;
    private  UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private ArrayList<EntityUser> entityUsers;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNhap =findViewById(R.id.txtFind);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.list_item);
        entityUsers = new ArrayList<>();
        userAdapter = new UserAdapter();
        userAdapter.setData(entityUsers);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view) {addUser();}
        });
    }
    private void addUser() {

        String name =txtNhap.getText().toString().trim();
        if(name.isEmpty()){
            return;
        }
        EntityUser entityUser= new EntityUser(name);
        UserDB.getInstance(this).userDao().insertAll(entityUser);
        Toast.makeText(this, "Thanh Cong", Toast.LENGTH_SHORT).show();
        txtNhap.setText("");
        entityUsers= (ArrayList<EntityUser>) UserDB.getInstance(this).userDao().getAll();
        userAdapter.setData(entityUsers);
    }
}