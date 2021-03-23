package com.siwoo.classes;

import java.util.Date;

public class Event {
    private User user;
    private String data;
    private Date generatedTime;
    private Date publishTime;
    private Topic topic;

    public Event(){
        this(null);
    }

    public Event(User user){
        this(user, "");
    }

    public Event(User user, String data){
        this(user, data, new Date());
    }

    public Event(User user, String data, Date generatedTime){
        this(user, data, generatedTime, new Date());
    }

    public Event(User user, String data, Date generatedTime, Date publishTime){
        this(user, data, generatedTime, publishTime, null);
    }

    public Event(User user, String data, Date generatedTime, Date publishTime, Topic topic) {
        this.user = user;
        this.data = data;
        this.generatedTime = generatedTime;
        this.publishTime = publishTime;
        this.topic = topic;
    }
}

class Topic{
    private String topicName;
}


