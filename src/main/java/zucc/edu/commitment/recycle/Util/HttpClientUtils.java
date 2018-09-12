package zucc.edu.commitment.recycle.Util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpClientUtils {//跨项目调用接口
    public static JSONObject sendHttpPost(String httpUrl, Map<String, Object> maps) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(httpUrl);
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for(Map.Entry<String, Object> entry : maps.entrySet()){
            NameValuePair n = new BasicNameValuePair(entry.getKey(), entry.getValue()+"") ;
            formparams.add(n);
    }
        UrlEncodedFormEntity uefEntity=new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(uefEntity);
        System.out.println("executing request " + httppost.getURI());
        CloseableHttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        String result=null;
        JSONObject jo=new JSONObject();
        if (entity != null) {
         result= EntityUtils.toString(entity, "UTF-8");
             jo=JSONObject.parseObject(result);
        }

        return jo;
    }
}
