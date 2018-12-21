package com.projectlibrary.library;

public class Achievement {
    /***
     * @author Lyuboslav Karev
     * @version 0.1
     * @since 0.1
     *
     * What is the purpose of this class ?
     * The purpose of this class is to store the info for an achievement (duh)
     */
    private int ID; //The id of the achievemt

    private String name; //The name of the achievement
    private String description; //The description of the achievement
    private String pictureLink; //The link to the image

    Achievement() //Default constructor
    {

    }
    Achievement(int id, String name, String description, String pictureLink)
    {
        this.ID = id;
        this.name = name;
        this.description = description;
        this.pictureLink = pictureLink;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPictureLink() {
        return pictureLink;
    }
}
