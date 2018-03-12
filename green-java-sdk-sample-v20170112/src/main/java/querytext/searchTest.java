package querytext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 class SearchTest {
    //为了生成随机查询的词列表
    private static final List<String> DIC_FOR_TEST = new ArrayList<String>();
    //通过更改这里DIC的实现来比较不同实现之间的性能
    private static final List<String> DIC = new ArrayList<String>();
    static{
        try {
            System.out.println("开始初始化词典");
            int count=0;
            List<String> lines = Files.readAllLines(Paths.get("D:/dic/dic.txt"), Charset.forName("utf-8"));
            for(String line : lines){
                DIC.add(line);
                DIC_FOR_TEST.add(line);
                count++;
            }
            System.out.println("完成初始化词典，词数目："+count);
        } catch (IOException ex) {
            System.err.println("词典装载失败:"+ex.getMessage());
        }
    }
    public static void main(String[] args){
        //选取随机值
        List<String> words = new ArrayList<String>();
        for(int i=0;i<100000;i++){
            words.add(DIC_FOR_TEST.get(new Random(System.nanoTime()+i).nextInt(427452)));
        }
        long start = System.currentTimeMillis();
        for(String word : words){
            DIC.contains(word);
        }
        long cost = System.currentTimeMillis()-start;
        System.out.println("cost time:"+cost+" ms");
    }
}