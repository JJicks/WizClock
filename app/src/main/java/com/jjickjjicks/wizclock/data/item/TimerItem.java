package com.jjickjjicks.wizclock.data.item;

import com.google.firebase.database.Exclude;
import com.jjickjjicks.wizclock.R;

import java.util.HashMap;
import java.util.Map;

public class TimerItem {
    final static int TYPE_ETC = 0;
    final static int TYPE_STUDY = 1;
    final static int TYPE_HEALTH = 2;
    final static int TYPE_COOK = 3;

    private String title, describe, authorName, authorEmail;
    private TimerData timerData;
    private int type;

    public TimerItem(String title, String describe, String authorName, String authorEmail, int type) {
        this.title = title;
        this.describe = describe;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescribe() {
        return describe;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public TimerData getTimerData() {
        return timerData;
    }

    public int getType() {
        return type;
    }

    public int getTypeIcon() {
        switch (this.type) {
            default:
                return R.drawable.ic_etc;
            case TYPE_STUDY:
                return R.drawable.ic_study;
            case TYPE_HEALTH:
                return R.drawable.ic_health;
            case TYPE_COOK:
                return R.drawable.ic_cook;
        }
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("describe", describe);
        result.put("authorName", authorName);
        result.put("authorEmail", authorEmail);
        result.put("type", type);
        result.put("timerData", timerData);
        return result;
    }
}
