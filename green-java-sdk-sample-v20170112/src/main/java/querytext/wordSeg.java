package querytext;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mk on 2018/1/17.
 */
class WordSeg {
    private static final List<String> DIC = new ArrayList<String>();
    public int MAX_LENGTH ;

    public int getMAX_LENGTH() {
        return MAX_LENGTH;
    }

    public void setMAX_LENGTH(int MAX_LENGTH) {
        this.MAX_LENGTH = MAX_LENGTH;
    }

    static{
        try {
            System.out.println("开始初始化词典");
            int max=1;
            int count=0;
            List<String> lines = Files.readAllLines(Paths.get("D:/dic/dic.txt"), Charset.forName("utf-8"));
            for(String line : lines){
                DIC.add(line);
                count++;
                if(line.length()>max){
                    max=line.length();
                }
            }
            WordSeg wordSeg = new WordSeg();
            wordSeg.setMAX_LENGTH(max);
            //MAX_LENGTH = max;
            System.out.println("完成初始化词典，词数目："+count);
            System.out.println("最大分词长度："+max);
        } catch (IOException ex) {
            System.err.println("词典装载失败:"+ex.getMessage());
        }

    }
    public static void main(String[] args){
        String text = "杨尚川是APDPlat应用级产品开发平台的作者";
        WordSeg wordSeg = new WordSeg();
        List<String> result111 =seg(text,wordSeg);
        System.out.println(result111);
    }


    public static List<String> seg(String text,WordSeg wordSeg){
        List<String> result = new ArrayList<String>();
        while(text.length()>0){

            int len=wordSeg.getMAX_LENGTH();
            if(text.length()<len){
                len=text.length();
            }
            //取指定的最大长度的文本去词典里面匹配
            String tryWord = text.substring(0, 0+len);
            while(!DIC.contains(tryWord)){
                //如果长度为一且在词典中未找到匹配，则按长度为一切分
                if(tryWord.length()==1){
                    break;
                }
                //如果匹配不到，则长度减一继续匹配
                tryWord=tryWord.substring(0, tryWord.length()-1);
            }
            result.add(tryWord);
            //从待分词文本中去除已经分词的文本
            text=text.substring(tryWord.length());
        }
        return result;
    }
}
