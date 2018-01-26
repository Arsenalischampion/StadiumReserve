package com.example.po.stadiummanagement3.Gson;

/**
 * Created by 13701 on 2018/1/11.
 */

public class UserInstance {
    public static UserInfo userInfo;

    public static void init(){
        if(userInfo==null){
            userInfo = new UserInfo();
        }else{

        }
    }

    public static void logOut(){
        if(userInfo != null){
            userInfo = null;
        }else {

        }
    }


}

class UserInfo{
    UserInfo(){

    }
}