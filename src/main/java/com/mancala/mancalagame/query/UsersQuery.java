package com.mancala.mancalagame.query;

import java.util.ArrayList;

public class UsersQuery {
    private static final String LOGIN_QUERY = "SELECT password, is_Active, is_admin, profileImage from user where username= ? AND is_admin = 0";
    private static final String ADMIN_LOGIN_QUERY = "SELECT password from user where username= ? AND is_admin = 1";
    private String SIGNUP = "INSERT INTO user (username, password, name, profileImage) VALUES (?, ?, ?, ?)";
    private static final String SAVE_SESSION = "INSERT INTO loginsessions (sessionId, username) VALUES (?, ?)";
    private static final String GET_USER_PROFILE = "SELECT u.username, u.profileImage, MAX(logins.logInDateTime) AS lastLogin, (SELECT COUNT(player1) FROM gamerecord WHERE player1 = ?) AS totalGame, (SELECT COUNT(winner) FROM gamerecord WHERE winner = ?) AS totalWin FROM USER AS u\n" +
            "LEFT JOIN loginsessions AS logins ON logins.username = u.username\n" +
            "WHERE u.username = ?";
    private static final String GET_ALL_USERS = "SELECT username FROM User WHERE is_admin = false AND is_Active = true";
    private static final String FAVOURITE = "INSERT INTO favourites VALUES (?, ?)";
    private static final String UNFAVOURITE = "DELETE FROM favourites WHERE (username1=? AND username2=?)";
    private static final String GET_FAVOURITES = "SELECT username2 FROM favourites WHERE username1=?";
    public String getLOGIN_QUERY() {
        return LOGIN_QUERY;
    }

    public String getSIGNUP() {
        return SIGNUP;
    }

    public String getAdminLoginQuery() {
        return ADMIN_LOGIN_QUERY;
    }
    public  String getSaveSession() { return  SAVE_SESSION; }
    public String getUserProfileInfo(){
        return GET_USER_PROFILE;
    }
    public String getAllUsers() {
        return GET_ALL_USERS;
    }

    public String getFavourite(){
        return FAVOURITE;
    }

    public String getUnfavourite(){
        return UNFAVOURITE;
    }

    public String getAllFavourites() {
        return GET_FAVOURITES;
    }

}