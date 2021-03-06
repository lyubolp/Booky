package com.projectlibrary.library;

import java.util.Date;

/**
 * @author: Lyuboslav Karev
 * @version: 0.1
 * @since: 0.1
 */
public class Friend {

    /**
     * Description of this class:
     *  Class that stores the information of the user's friends
     *  It has fields for the ID, if the user is online, the nickname, avatar, last online
     *  All fields has getters
     *  Has a constructor with all parameters, default one, and only with the id
     */

    private int ID; //The user-id of the friend

    private boolean isOnline; //If the user is online

    private String nickname; //The nickname of the user (his username is not visible)
    private String avatarLink; //The link to the user avatar

    private Date lastOnline; //When was the user last online TODO - Check the Date type for its methods and format

    Friend()
    {
        ID = -1;
        isOnline = false;
        nickname = "Default";
        avatarLink = "none";
    }
    Friend (int id)
    {
        ID = id;
    }
    Friend(int id, boolean isOnline, String nickname, String avatarLink, Date lastOnline) {
        ID = id;
        this.isOnline = isOnline;
        this.nickname = nickname;
        this.avatarLink = avatarLink;
        this.lastOnline = lastOnline;
    }

    public int getID() {
        return ID;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public Date getLastOnline() {
        return lastOnline;
    }
}
