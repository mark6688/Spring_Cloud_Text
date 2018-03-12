package com.cloud;

/**
 * Created by mk on 2018/3/9.
 */
public class text {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        System.out.println("第1次j："+j);
        if((i>++j)&&(i++ ==j)){
            System.out.println("第2次j："+j);
            i +=j;
            System.out.println("第3次j："+j);
        }
        System.out.println("第4次j："+j);
    }
}
