package com.example.ady.fridaytest2;

/**
 * Created by Ady on 12/1/2017.
 */

public class image {
    String link;
    String M;
    String Author;
    String Title;


    public image(String link, String m, String author, String title) {
        this.link = link;
        M = m;
        Author = author;
        Title = title;

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
