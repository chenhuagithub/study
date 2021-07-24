package quick.start;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.maoyan.bean.User;
import com.maoyan.utils.Result;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhua11
 * @date 2021/5/11  5:42 下午
 */
public class ClassicApiDemo {
    public static void main(String[] args) throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8080/test/get");
            /*
                底层HTTP连接仍由响应对象保留，以允许直接从网络套接字流式传输响应内容。
                为了确保正确释放系统资源，用户必须从finally子句中调用CloseableHttpResponse＃close（）。
                请注意，如果未完全使用响应内容，则无法安全地重用基础连接，连接管理器将关闭并丢弃该连接。
             */
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
                HttpEntity entity1 = response1.getEntity();
                // 对响应主体做一些有用的事情，并确保它被完全消耗
                String res = EntityUtils.toString(entity1);
                Result<List<User>> result = JSON.parseObject(res, new TypeReference<Result<List<User>>>() {});
                System.out.println(result);
                EntityUtils.consume(entity1);
            }
        
            HttpPost httpPost = new HttpPost("http://localhost:8080/test/post");
            List<NameValuePair> nvps = new ArrayList<>();
            // 设置请求参数
            nvps.add(new BasicNameValuePair("username", "vip"));
            nvps.add(new BasicNameValuePair("password", "secret"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        
            try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
                System.out.println(response2.getCode() + " " + response2.getReasonPhrase());
                HttpEntity entity2 = response2.getEntity();
                String res = EntityUtils.toString(entity2);
                Result<List<User>> result = JSON.parseObject(res, new TypeReference<Result<List<User>>>() {});
                System.out.println(result);
                // 对响应主体做一些有用的事情，并确保它被完全消耗
                EntityUtils.consume(entity2);
            }
        }
    }
}