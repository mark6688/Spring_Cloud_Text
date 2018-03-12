import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * 文件名称为：URLAvailability.java
 *
 * 文件功能简述： 描述一个URL或图片地址是否有效
 *
 *  */
@SuppressWarnings("unused")
public class URLAvailability {
    private static URL urlStr;
    private static HttpURLConnection connection;
    private static int state = -1;
    private static String succ;
    /**
     * 功能描述 : 检测当前URL是否可连接或是否有效,
     * 最多连接网络 5 次, 如果 5 次都不成功说明该地址不存在或视为无效地址.
     *
     * @param url
     * 指定URL网络地址
     *
     * @return String
     */
    public synchronized Integer isConnect(String url) {
        int counts = 0;
        succ = null;
        if (url == null || url.length() <= 0) {
            return -1;
        }
        while (counts < 5) {
            try {
                urlStr = new URL(url);
                connection = (HttpURLConnection) urlStr.openConnection();
                state = connection.getResponseCode();
                if (state == 200) {
                    //succ = connection.getURL().toString();
                    System.out.println("========图片地址正确========");
                }else{
                    System.out.println("====错误的地址========");
                }
                break;
            } catch (Exception ex) {
                counts++;
                System.out.println("=========图片正在检测===========loop :" + counts);
                continue;
            }
        }
        return state;
    }

    public static void main(String[] args) {
        String url ="http://192.168.0.34/oss/onair/QMTNRK_YUNSHI/AF116B139F5C493BAF526FD71EDED010/67e7ebf8ef1f48b783d94ff55d61f834.jpg";
        URLAvailability urlAvailability = new URLAvailability();
        Integer code = urlAvailability.isConnect(url);
//        isConnect("http://osstest.huayun.cdvcloud.com/onair/QMTNRK_YUNSHI/5a3b83397f4b664174988b42/a4f9c8e21dd67d626491a8d4b04a5bb6.jpg");
        //isConnect("http://osstest.huayun.cdvcloud.com/onair/QMTNRK_YUNSHI/5a3b83397f4b664174988b42/a4f9c8e21dd67d626491a8d4b04a5bb.jpg");
    }

}