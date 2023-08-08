package org.example.exs2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeJson {
    private File file;

    public MakeJson(File file) {
        this.file = file;
    }

    public void makeJson(){
        List<User> userList = readUsersFromFile(file);
        String json = convertToJson(userList);
        writeJsonToFile(json);
        System.out.println("Jason created");
    }

    private List<User> readUsersFromFile(File file) {
        List<User> userList = new ArrayList<>();
        this.file = file;
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(" ");
                if (columns.length == 2) {
                    String name = columns[0];
                    int age = Integer.parseInt(columns[1]);
                    userList.add(new User(name, age));
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }

        return userList;
    }

   private String convertToJson(List<User> userList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(userList);
    }

    private void writeJsonToFile(String json) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
