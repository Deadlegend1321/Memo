package com.example.memo;

import java.util.ArrayList;

public class mex {
    String title,body;
    public mex() {
    }

    public mex(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static ArrayList<String> getRandommemo(){
        ArrayList<String> mu=new ArrayList<>();
        return mu;
    }

    @Override
    public String toString() {
        return "mex{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
