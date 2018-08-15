package com.projectlibrary.library;

public class Settings {

    private int user_id;
    private int appLanguage;

    private short fontSize;

    private String mainColor;
    private String backColor;
    private String backImage;
    private String fontColor;

    private static Settings singleton = new Settings( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Settings() { }

    /* Static 'instance' method */
    public static Settings getInstance( ) {
        return singleton;
    }


    public int getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(int appLanguage) {
        this.appLanguage = appLanguage;
    }

    public short getFontSize() {
        return fontSize;
    }

    public void setFontSize(short fontSize) {
        this.fontSize = fontSize;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
