import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20170112.VideoAsyncScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.*;

/**
 * Created by hyliu on 16/3/2.
 * 视频异步检测接口
 */
public class VideoAsyncScanRequestSample extends BaseSample {

    public static void main(String[] args) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(getEndPointName(), regionId, "Green", getDomain());
        IAcsClient client = new DefaultAcsClient(profile);

        VideoAsyncScanRequest videoAsyncScanRequest = new VideoAsyncScanRequest();
        videoAsyncScanRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
        videoAsyncScanRequest.setContentType(FormatType.JSON);
        videoAsyncScanRequest.setMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法

        Map<String, Object> task = new LinkedHashMap<String, Object>();
        task.put("dataId", UUID.randomUUID().toString());
        task.put("interval", 5);
        task.put("maxFrames", 50);
        task.put("url", "https://master.sensetime.com/web/demo/video_audit6.mp4");


        JSONObject data = new JSONObject();
        data.put("scenes", Arrays.asList("porn","terrorism"));
        data.put("tasks", task);
        data.put("callback", "http://192.168.1.175:2000/callback");
        data.put("seed", "12346578");

        videoAsyncScanRequest.setContent(data.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        videoAsyncScanRequest.setConnectTimeout(3000);
        videoAsyncScanRequest.setReadTimeout(6000);
        try {
            HttpResponse httpResponse = client.doAction(videoAsyncScanRequest);

            if(httpResponse.isSuccess()){
                JSONObject jo = JSON.parseObject(new String(httpResponse.getContent(), "UTF-8"));
                System.out.println(JSON.toJSONString(jo, true));
            }else{
                System.out.println("response not success. status:" + httpResponse.getStatus());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
