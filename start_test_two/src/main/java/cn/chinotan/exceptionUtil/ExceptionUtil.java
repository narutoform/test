package cn.chinotan.exceptionUtil;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @program: test
 * @description: ExceptionUtil
 * @author: xingcheng
 * @create: 2019-01-12 18:47
 **/
public class ExceptionUtil {

    public static ClientHttpResponse handleException(HttpRequest request, byte[] body, 
                                                     ClientHttpRequestExecution execution, BlockException exception) {
        System.out.println("ExceptionUtil deal");
        
        return null;
    }
    
}
