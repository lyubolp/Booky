package com.projectlibrary.library;

public class Achievement {
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
