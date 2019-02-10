package mvestro.android.quizinparis.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Friend {
    int id;
    @SerializedName("first_name")
    String firstName;
    String lastName;
    String token;
    int score;

    public Friend(int id, String token){
        this.id = id;
        this.token = token;

    }

    public Friend(int id, String firstName, String lastName, String token, int score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
        this.score = score;
    }

    public static Friend getFriendFromJson(JsonObject json){
        Friend friend;
        return friend = new Gson().fromJson(json, Friend.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
