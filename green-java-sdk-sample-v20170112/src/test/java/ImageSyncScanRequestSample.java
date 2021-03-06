import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20170112.ImageSyncScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.*;

/**
 * Created by liuhai.lh on 2017/2/17.
 * 图片同步检测接口
 * @author liuhai.lh
 * @date 2017/02/17
 */
public class ImageSyncScanRequestSample extends BaseSample {


    public static void main(String[] args) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(getEndPointName(), regionId, "Green", getDomain());
        IAcsClient client = new DefaultAcsClient(profile);

        ImageSyncScanRequest imageSyncScanRequest = new ImageSyncScanRequest();
        imageSyncScanRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
        imageSyncScanRequest.setContentType(FormatType.JSON);
        imageSyncScanRequest.setMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
        imageSyncScanRequest.setEncoding("utf-8");
        imageSyncScanRequest.setRegionId(regionId);


        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
        Map<String, Object> task = new LinkedHashMap<String, Object>();
        // task.put("dataId", UUID.randomUUID().toString());
        task.put("url", "https://master.sensetime.com/web/demo/terror6.jpg");
        //task.put("time", new Date());
        tasks.add(task);

        Map<String, Object> task1 = new LinkedHashMap<String, Object>();
        //task1.put("dataId", UUID.randomUUID().toString());
        task1.put("url", "https://master.sensetime.com/web/demo/terror9.jpg");
        //task1.put("time", new Date());
        tasks.add(task1);

        Map<String, Object> task2 = new LinkedHashMap<String, Object>();
        // task2.put("dataId", UUID.randomUUID().toString());
        task2.put("url", "https://nos.netease.com/yidun/2-0-0-e8bfc2e3c9d54201b0eaa889d5648953.jpg");
        //task2.put("time", new Date());
        tasks.add(task2);

        Map<String, Object> task3 = new LinkedHashMap<String, Object>();
        // task3.put("dataId", UUID.randomUUID().toString());
        task3.put("url", "http://osstest.huayun.cdvcloud.com/onair/QMTNRK_YUNSHI/5a3b83397f4b664174988b42/47362d4d2a160dc197a182750e5bc341.jpg");
        //task3.put("time", new Date());
        tasks.add(task3);

        Map<String, Object> task4 = new LinkedHashMap<String, Object>();
        // task4.put("dataId", UUID.randomUUID().toString());
        task4.put("url", "http://dun.163.com/res/web/case/sexy_normal_1.jpg");
        //task4.put("time", new Date());
        tasks.add(task4);

        Map<String, Object> task5 = new LinkedHashMap<String, Object>();
        // task5.put("dataId", UUID.randomUUID().toString());
        task5.put("url", "https://nos.netease.com/yidun/2-0-0-ef76c0b895b74d2f9868dbdde4446f7a.jpg");
        //task5.put("time", new Date());
        tasks.add(task5);

        Map<String, Object> task6 = new LinkedHashMap<String, Object>();
        // task6.put("dataId", UUID.randomUUID().toString());
        task6.put("url", "https://nos.netease.com/yidun/2-0-0-aa5c792f6721486a83c79a33db3486b9.jpg");
        // task6.put("time", new Date());
        tasks.add(task6);

        Map<String, Object> task7 = new LinkedHashMap<String, Object>();
        // task7.put("dataId", UUID.randomUUID().toString());
        task7.put("url", "https://nos.netease.com/yidun/2-0-0-c38e68acbc7d47f8bf620d62d3f7ec.jpg");
        // task7.put("time", new Date());
        tasks.add(task7);

        Map<String, Object> task8 = new LinkedHashMap<String, Object>();
        //task8.put("dataId", UUID.randomUUID().toString());
        task8.put("url", "http://dun.163.com/res/web/case/sexy_normal_1.jpg");
        //task8.put("time", new Date());
        tasks.add(task8);

        Map<String, Object> task9 = new LinkedHashMap<String, Object>();
        //task9.put("dataId", UUID.randomUUID().toString());
        task9.put("url", "https://nos.netease.com/yidun/2-0-0-6359257b8a47409c9b853dde0da90966.jpg");
        //task9.put("time", new Date());
        tasks.add(task9);

        JSONObject data = new JSONObject();
        /**
         * porn: 色情
         * terrorism: 暴恐
         * qrcode: 二维码
         * ad: 图片广告
         * ocr: 文字识别
         */
        data.put("scenes", Arrays.asList("porn", "terrorism"));
        data.put("tasks", tasks);

        imageSyncScanRequest.setContent(data.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        imageSyncScanRequest.setConnectTimeout(3000);
        imageSyncScanRequest.setReadTimeout(6000);

        try {
            HttpResponse httpResponse = client.doAction(imageSyncScanRequest);

            if (httpResponse.isSuccess()) {
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getContent(), "UTF-8"));
                System.out.println(JSON.toJSONString(scrResponse, true));
                if (200 == scrResponse.getInteger("code")) {
                    JSONArray taskResults = scrResponse.getJSONArray("data");
                    for (Object taskResult : taskResults) {
                        if(200 == ((JSONObject)taskResult).getInteger("code")){
                            JSONArray sceneResults = ((JSONObject)taskResult).getJSONArray("results");
                            for (Object sceneResult : sceneResults) {
                                String scene = ((JSONObject)sceneResult).getString("scene");
                                String suggestion = ((JSONObject)sceneResult).getString("suggestion");
                                //根据scene和suggetion做相关的处理
                                //do something
                                System.out.println("args = [" + scene + "]");
                                System.out.println("args = [" + suggestion + "]");
                            }
                        }else{
                            System.out.println("task process fail:" + ((JSONObject)taskResult).getInteger("code"));
                        }
                    }
                } else {
                    System.out.println("detect not success. code:" + scrResponse.getInteger("code"));
                }
            } else {
                System.out.println("response not success. status:" + httpResponse.getStatus());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
