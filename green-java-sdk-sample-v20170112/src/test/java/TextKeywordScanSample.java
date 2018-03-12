import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20170112.TextScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.*;

/**
 * Created by hyliu on 16/3/2.
 * 文本检测
 */
public class TextKeywordScanSample extends BaseSample {

    public static void main(String[] args) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(getEndPointName(), regionId, "Green", getDomain());

        IAcsClient client = new DefaultAcsClient(profile);

        TextScanRequest textScanRequest = new TextScanRequest();
        textScanRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
        textScanRequest.setContentType(FormatType.JSON);
        textScanRequest.setMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
        textScanRequest.setEncoding("UTF-8");
        textScanRequest.setRegionId(regionId);


        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();


       /* Map<String, Object> task1 = new LinkedHashMap<String, Object>();
        task1.put("dataId", UUID.randomUUID().toString());
        task1.put("content", "法轮功");
        //task1.put("content", "这个裸体美女真性感，看的快要射了，色情很爽的，来试试吧,A片真的是这样的吗？,色情黄片，习大大");
        //task1.put("content", "蒙汗药法轮功,薄熙来,,,蒙汗药法轮功,薄熙来,,,蒙汗药法轮功,薄熙来,,,蒙汗药法轮功,薄熙来");
        tasks.add(task1);*/

        Map<String, Object> task = new LinkedHashMap<String, Object>();
        task.put("dataId", UUID.randomUUID().toString());
        task.put("content", "小张是国家主席");
        tasks.add(task);

        JSONObject data1 = new JSONObject();
        data1.put("scenes", Arrays.asList("keyword"));
        data1.put("tasks", tasks);

        textScanRequest.setContent(data1.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        textScanRequest.setConnectTimeout(3000);
        textScanRequest.setReadTimeout(6000);
        try {
            HttpResponse httpResponse = client.doAction(textScanRequest);

            ResponseObject resObj = new ResponseObject();

            if(httpResponse.isSuccess()){
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getContent(), "UTF-8"));
                System.out.println(scrResponse.toString());
                //最终返回的内容组装
                resObj.setCode(scrResponse.getInteger("code"));
                resObj.setMessage(scrResponse.getString("msg"));

                Map<String,Object> data = new HashMap<String,Object>();
                List<Map<String,Object>> results = new ArrayList <Map<String,Object>>();

                if (200 == scrResponse.getInteger("code")) {
                    JSONArray taskResults = scrResponse.getJSONArray("data");
                    for (Object taskResult : taskResults) {
                        if(200 == ((JSONObject)taskResult).getInteger("code")){
                            JSONArray sceneResults = ((JSONObject)taskResult).getJSONArray("results");
                            for (Object sceneResult : sceneResults) {
                                //向data中放入置信度和是否通过
                                if(!data.containsKey("rate")){
                                    data.put("rate",((JSONObject)sceneResult).getInteger("rate"));
                                }
                                if(!data.containsKey("suggestion")){
                                    data.put("suggestion",((JSONObject)sceneResult).getString("suggestion"));
                                }
                                if(((JSONObject)sceneResult).getInteger("rate") > Integer.valueOf(String.valueOf(data.get("rate")))){
                                    data.put("rate",((JSONObject)sceneResult).getInteger("rate"));
                                }
                                if(((JSONObject)sceneResult).getString("suggestion").equalsIgnoreCase("block")){
                                    data.put("suggestion",((JSONObject)sceneResult).getString("suggestion"));
                                }

                                JSONArray detaResults = ((JSONObject)sceneResult).getJSONArray("details");
                                for(Object detaResult : detaResults){
                                    String label = ((JSONObject)detaResult).getString("label");
                                    JSONArray contextsResults = ((JSONObject)detaResult).getJSONArray("contexts");
                                    if(label.equals("customized")){
                                        Map<String,Object> strEquals = new HashMap<String,Object>();
                                        for(Object contextsResult : contextsResults){
                                            String libName = ((JSONObject)contextsResult).getString("libName");
                                            String context = ((JSONObject)contextsResult).getString("context");
                                            if (!strEquals.containsKey(libName+context)){
                                                Map<String,Object> result = new HashMap<String,Object>();
                                                strEquals.put(libName+context,"");
                                                result.put("lebel",libName);
                                                result.put("context",context);
                                                results.add(result);
                                            }
                                        }
                                    }
                                }
                            }
                        }else{
                            System.out.println("task process fail:" + ((JSONObject)taskResult).getInteger("code"));
                        }
                    }

                    data.put("results",results);
                    resObj.setData(data);
                } else {
                    System.out.println("detect not success. code:" + scrResponse.getInteger("code"));
                }

                System.out.println(resObj.toString());
            }else{
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
