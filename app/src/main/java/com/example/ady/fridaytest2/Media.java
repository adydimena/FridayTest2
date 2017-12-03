
package com.example.ady.fridaytest2;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media implements Serializable
{

    @SerializedName("m")
    @Expose
    private String m;
    private final static long serialVersionUID = -2307883192743400798L;

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

}
