package com.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mk on 2017/12/7.
 */
@SpringBootApplication
public class ConfigServerApplication {
    public static void main(String[] args) {
        //SpringApplication.run(ConfigServerApplication.class,args);
        String str ="adt";
        String content ="asdfasdfasaaaaaa";
        int str1 =str.length();
        int content1 =content.length();
        int num = (str1*100)/content1;
        System.out.println("=========="+num+"%==========");

    }

   /* public static void main(String[] args)
    {
        String s1 = "135adbfg67";
        String s2 = "125dbf59";
        String s3 = s2;
        int begin = 0;
        int end = s2.length();
        int i = 1;
        while (!s1.contains(s3))
        {
            if (end == s2.length())
            {
                begin = 0;
                end = (s2.length()) - (i++);
            }
            else
            {
                begin++;end++;
            }
            s3 = s2.substring(begin, end);
        }
        System.out.println(s3);
    }*/

}
