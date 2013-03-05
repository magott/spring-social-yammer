package org.springframework.social.yammer.api;

public class Activity {

    private String actionId;
    private String objectId;
    private String actorId;


    public Activity(String actionId, String actorId, String objectId) {
        this.actionId = actionId;
        this.objectId = objectId;
        this.actorId = actorId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

//    action_id":313251,"object_id":348672046288643,"actor_id":1489338262
}
