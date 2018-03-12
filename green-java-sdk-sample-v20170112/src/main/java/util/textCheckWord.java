package util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mk on 2018/1/11.
 */
public class textCheckWord {


    //读取敏感词库
   public static Set<String> keyWordSet = new SensitiveWordInit().keyWordSet();


    public static void main(String[] args) {
		String str = "17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录,17年前,我看到了一个18岁的儿童，破了1989年世界纪录";
        long beginTime = System.currentTimeMillis();
        Set<String> set = new HashSet <String>();
        for (String str1:keyWordSet) {
            int index = 0;
            while((index= str.indexOf(str1,index))!=-1)
            {
                set.add(str1);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));

	}


    public static String getSubCount_1(String str,String key)
    {
        int index = 0;
        while((index= str.indexOf(key,index))!=-1)
        {
            return key;
            //break;
        }
        return "";
    }


    /*
练习三，方式二。
*/
    public static int getSubCount_2(String str,String key)
    {
        int count = 0;
        int index = 0;
        while((index= str.indexOf(key,index))!=-1)
        {
            sop("index="+index);
            index = index + key.length();

            count++;
        }
        return count;
    }

    public static void sop(String str)
    {
        System.out.println(str);
    }

}
