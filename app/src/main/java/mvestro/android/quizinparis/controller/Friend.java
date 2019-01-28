package mvestro.android.quizinparis.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Friend {
    int id;
    @SerializedName("first_name")
    String firstName;
    String lastName;
    String token;
    int score;

    public Friend(int id){
        this.id = id;

    }

    public static Friend getFriendFromJson(JsonObject json){
        Friend friend;
        return friend = new Gson().fromJson(json, Friend.class);
    }
}