package com.example.sport_facility_3.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.sport_facility_3.data.UserFileManagement.userList;


/**
 * Class of the validators for the register class
 * @author AngelPinaGonzalez
 */

public class Validator {

    /**
     * Method to check exist a user with the Username
     * @param ExistUN A String to check
     * @return A Boolean true if exist
     */

    public static boolean ExistUsername(String ExistUN) {
        if (userList != null) {
            for (UserRecord userRecord : userList) {
                if (userRecord.username().equals(ExistUN)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to check if the password is secure
     *
     * @param verifyPassword A String to check
     * @return A String telling if the password is secure
     */

    public static boolean SecurityPassword(String verifyPassword) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{5,20}$";
        return verifyPassword.matches(regex);
    }
}
