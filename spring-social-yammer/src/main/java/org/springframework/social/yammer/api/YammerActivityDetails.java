package org.springframework.social.yammer.api;

import java.util.ArrayList;
import java.util.List;

public class YammerActivityDetails {

    private Boolean isPrivate = Boolean.FALSE;
    private String message;

    private YammerActivity activity;
    private List<YammerActivityUser> users = new ArrayList<YammerActivityUser>();



    public String getPrivate() {
        return isPrivate ? "true" : "false";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public YammerActivity getActivity() {
        return activity;
    }

    public void setActivity(YammerActivity activity) {
        this.activity = activity;
    }

    public List<YammerActivityUser> getUsers() {
        return users;
    }

    public void setUsers(List<YammerActivityUser> users) {
        this.users = users;
    }
}

