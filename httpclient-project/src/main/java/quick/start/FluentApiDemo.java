package quick.start;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.maoyan.bean.User;
import com.maoyan.utils.Result;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author chenhua11
 * @date 2021/5/21  11:42 上午
 */
public class FluentApiDemo {
    
    public static void main(String[] args) throws Exception {
        Response getResponse = Request.get("http://localhost:8080/test/get")
                .execute();
        // 获取Http相应码
//        System.out.println(getResponse.returnResponse().getCode());
        // 获取响应结果并设置解析字符编码
        String getResStr = getResponse.returnContent().asString(StandardCharsets.UTF_8);
        // 把json字符串转换为具体对象
        Result<List<User>> getResult = JSON.parseObject(getResStr, new TypeReference<Result<List<User>>>() {});
        System.out.println(getResult);
    
        Response postResponse = Request.post("http://localhost:8080/test/post")
                .bodyForm(Form.form().add("username", "vip").add("password", "secret").build())
                .execute();
        String postResStr = postResponse.returnContent().asString(StandardCharsets.UTF_8);
        Result<List<User>> postResult = JSON.parseObject(postResStr, new TypeReference<Result<List<User>>>() {});
        System.out.println(postResult);
    }


}