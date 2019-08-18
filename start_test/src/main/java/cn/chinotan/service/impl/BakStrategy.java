package cn.chinotan.service.impl;

import cn.chinotan.service.Strategy;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: test
 * @description:
 * @author: xingcheng
 * @create: 2019-02-23 17:52
 **/
@Component("bak")
public class BakStrategy implements Strategy {

    @Override
    public String convert(String tableName) {
        StringBuilder sb=new StringBuilder(tableName);
        sb.append("_bak");
        return sb.toString();
    }
}
