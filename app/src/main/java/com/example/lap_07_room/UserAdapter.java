package com.example.lap_07_room;


import android.content.Context;
import android.content.Entity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserView> {

    private Context context;

    private ArrayList<EntityUser> entityUsers;
    public void setData(ArrayList<EntityUser> data) {
        this.entityUsers = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name,parent,false);
        return new UserView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserView holder, int position) {
        EntityUser entityUser=entityUsers.get(position);
        if(entityUser==null) {
            return;
        }
        holder.tvName.setText(entityUser.getName());
    }

    @Override
    public int getItemCount() {
        if (entityUsers!=null){
            return entityUsers.size();
        }
        return 0;
    }

    public class  UserView extends RecyclerView.ViewHolder{
        private TextView tvName;

        public UserView(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.txtName);
        }
    }
}
