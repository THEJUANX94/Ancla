package data;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import Models.User;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Credentials {

    private ArrayList<User> userList;

    public Credentials(){
        userList = new ArrayList<User>();
    }

    public ArrayList<User> readUser() throws FileNotFoundException{
        JsonReader reader = new JsonReader(new FileReader("data/Credentials.json"));
        User[] users = new Gson().fromJson(reader, User[].class);
        for (int i = 0; i < users.length; i++) {
            userList.add(users[i]);
        }
        return userList;
    }
}
