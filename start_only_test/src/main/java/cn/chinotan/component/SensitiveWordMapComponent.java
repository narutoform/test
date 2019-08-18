package cn.chinotan.component;

import cn.chinotan.enums.SensitiveWordIsEndEnum;
import cn.chinotan.service.SensitiveWordInitService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

/**
 * @program: test
 * @description: 敏感词库
 * @author: xingcheng
 * @create: 2018-12-16 11:06
 **/
@Component
public class SensitiveWordMapComponent {

    @Autowired
    SensitiveWordInitService sensitiveWordInitService;

    public Map sensitiveWordMap;

    Logger LOGGER = LoggerFactory.getLogger(SensitiveWordMapComponent.class);

    /**
     * 结尾字标志
     */
    public static final String isEnd = "isEnd";

    @Bean("sensitiveWordMap")
    public Map sensitiveWordMap() {
        long start = System.currentTimeMillis();
        ApplicationContext applicationContext = MyApplicationContext.getApplicationContext();
        Resource resource = applicationContext.getResource("classpath:sensitivewordSimple.txt");
        Set<String> sets = Sets.newHashSet();
        InputStream ins = null;
        BufferedReader reader = null;
        try {
            ins = resource.getInputStream();
            reader = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sets.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Map sensitiveWordMap = initKeyWord(sets);
        long end = System.currentTimeMillis();
        System.out.println("初始化敏感词库耗时：" + (end - start) + " 毫秒");
        return sensitiveWordMap;
    }

    public Map initKeyWord(Set<String> sensitiveWords) {
        sensitiveWordMap = Maps.newHashMapWithExpectedSize(sensitiveWords.size());
        sensitiveWords.stream().forEach(sensitiveWord -> {
            String sensitiveWordTrim = sensitiveWord.trim();
            int length = sensitiveWordTrim.length();
            Map newWordMap;
            Map nowMap = sensitiveWordMap;
            for (int i = 0; i < length; i++) {
                char c = sensitiveWordTrim.charAt(i);
                Object wordMap = nowMap.get(c);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    newWordMap = Maps.newHashMap();
                    newWordMap.put(isEnd, SensitiveWordIsEndEnum.NOT_END.getType());
                    nowMap.put(c, newWordMap);
                    nowMap = newWordMap;
                }
                // 如果该字是当前敏感词的最后一个字，则标识为结尾字
                if (i == length - 1) {
                    nowMap.put(isEnd, SensitiveWordIsEndEnum.END.getType());
                }
            }
        });

        LOGGER.info("封装词库过程结束，词库为：{}", JSON.toJSONString(sensitiveWordMap));
        return sensitiveWordMap;
    }

}
