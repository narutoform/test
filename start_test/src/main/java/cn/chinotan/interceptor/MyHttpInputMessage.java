package cn.chinotan.interceptor;

import cn.chinotan.dto.request.CommonRequest;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: test
 * @description:
 * @author: xingcheng
 * @create: 2019-03-02 18:08
 **/
public class MyHttpInputMessage implements HttpInputMessage {
    
    InputStream body;

    HttpHeaders headers;

    public MyHttpInputMessage(HttpInputMessage inputMessage) throws IOException {
        String body = IOUtils.toString(inputMessage.getBody(), "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(body);
        Object isTestObject = jsonObject.get("isTest");
        if (isTestObject != null && isTestObject instanceof Boolean) {
            Boolean isTestBoolean = (Boolean) isTestObject;
            CommonRequest.setTest(isTestBoolean);
        }
        // 添加header到body中
        jsonObject.putAll(headers);
        this.body = IOUtils.toInputStream(jsonObject.toString(), "UTF-8");
    }

    @Override
    public InputStream getBody() throws IOException {
        return body;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }
}
