package com.example.sport_facility_3.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileManagement {
    public static List<UserRecord> userList;

    public static List<UserRecord> getUserList() {
        return userList;
    }
    public static void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (UserRecord entry : userList) {
                writer.write(entry.username() + "," + entry.password());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }

    public static void readUsersFromFile() {
        userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                userList.add(new UserRecord(parts[0], parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Error reading users from file: " + e.getMessage());
        }
    }
}
