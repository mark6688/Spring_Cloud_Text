package com.cloud.text;

/**
 * Created by mk on 2017/12/11.
 */
public class MyThread implements Runnable {
    private String name;
    MyThread(String name){
        this.name = name;
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("名字："+name+i);
        }
    }
}
