package com.njupt.shijimoshiDemo;

import com.njupt.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class test {
    public static void main(String[] args) {
        /*String utcTime = "2018-03-24T01:29Z";
        String n = utcTime.substring(0,10);
        String n1 = utcTime.substring(11,16);*/
        User user = new User();
        user.setLevel(1);
        user.setName("xxxx");

        User user1 = new User();
        user1.setLevel(1);
        user1.setName("xxxx");

        if(!user.equals(user1)){
            System.out.println("****************");
        }



    }
}
