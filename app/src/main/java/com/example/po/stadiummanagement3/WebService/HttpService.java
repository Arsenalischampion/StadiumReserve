package com.example.po.stadiummanagement3.WebService;

/**
 * Created by 13701 on 2017/11/25.
 */

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import okhttp3.*;
/**
 * Created by 13701 on 2017/11/23.
 */

public class HttpService {
    private static OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
    //private static final String LOGIN_URL = "http://180.160.26.153:8080/JDBC/Hello";
    public static final String junUrl = "http://192.168.1.105:8888/";
    public static void sendOkHttpRequest(final String _url,okhttp3.Callback callback){                       //发送请求的动作
        //OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();//在builder的时候就实例化了一个dispatcher
        final Request request = new Request.Builder().get()                 //用到build的设计模式
                .url(junUrl+_url).build();
        client.newCall(request).enqueue(callback);                      //newCall 返回call 通过call来调用enqueue
        //client.newCall(request).execute();
        //okhttp 异步请求方法
        //1.创建okhttpClient和Request对象
        //2.将Request封装为call对象
        //3.调用Call的enqueue方法进行异步请求
    }

    public static void  sendOkHttpPostRequest(String command,okhttp3.RequestBody requestBody,okhttp3.Callback callback){
        //OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        final Request request = new Request.Builder().post(requestBody).url(junUrl+command).build();
        client.newCall(request).enqueue(callback);
    }

    public static Response sendGetRequest(final String url) throws ExecutionException, InterruptedException
    {
        FutureTask<Response> task=new FutureTask<Response>(new Callable<Response>() {
            @Override
            public Response call() throws IOException {

                OkHttpClient client = new OkHttpClient();
                Response response;
                Request request=new Request.Builder().url(junUrl+url).build();
                String s="";
                response = client.newCall(request).execute();
                return response;
            }
        });
        new Thread(task).start();
        return task.get();
    }

}