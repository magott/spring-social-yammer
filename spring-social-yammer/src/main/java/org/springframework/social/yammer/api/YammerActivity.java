package org.springframework.social.yammer.api;

public class YammerActivity {

    private String action;
    private String type;
    private YammerActivityActor actor;
    private YammerActivityObject object;




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public YammerActivityActor getActor() {
        return actor;
    }

    public void setActor(YammerActivityActor actor) {
        this.actor = actor;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public YammerActivityObject getObject() {
        return object;
    }

    public void setObject(YammerActivityObject object) {
        this.object = object;
    }


    public enum YammerAction
    {

        DELETE("delete"),
        LIKE("like"),
        UPDATE("update"),
        FOLLOW("follow"),
        CREATE("create");
        String name;
        YammerAction(String name) {

            this.name= name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }




}
