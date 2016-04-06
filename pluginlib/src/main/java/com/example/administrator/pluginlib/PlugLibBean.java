package com.example.administrator.pluginlib;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/6.
 */
public class PlugLibBean implements Serializable{

    public String pakageName;

    @Override
    public String toString() {
        return "PlugLibBean{" +
                "pakageName='" + pakageName + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

    public String label;
}
