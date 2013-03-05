package org.springframework.social.yammer.api;


public class YammerActivityObject
{
    private String title = null;
    private String url = null;
    private String type = null;
    private String image = null;
    private String description = null;

    public YammerActivityObject(String title, String description, String url, String type, String image) {

        this.title = title;
        this.url = url;
        this.type = type;
        this.image = image;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
