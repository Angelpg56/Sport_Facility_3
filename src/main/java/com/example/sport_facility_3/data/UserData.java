package com.example.sport_facility_3.data;

public class UserData {
    private static UserData instance = null;
    private static UserRecord userRecord;

    private UserData() {}

    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public UserRecord getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(UserRecord newUserRecord) {
        userRecord = newUserRecord;
    }

    public static void resetInstance() {
        userRecord = null;
        instance = null;
    }
}
