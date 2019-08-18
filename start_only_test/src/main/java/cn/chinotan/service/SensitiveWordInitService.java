package cn.chinotan.service;

import cn.chinotan.enums.SensitiveWordEnum;
import cn.chinotan.enums.SensitiveWordIsEndEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: test
 * @description: 敏感词库初始化
 * @author: xingcheng
 * @create: 2018-12-15 18:25
 **/
@Service
public class SensitiveWordInitService {
    
    Logger LOGGER = LoggerFactory.getLogger(SensitiveWordInitService.class);

    /**
     * 敏感词Map
     */
    @Autowired
    @Qualifier("sensitiveWordMap")
    public Map sensitiveWordMap;

    /**
     * 结尾字标志
     */
    public static final String isEnd = "isEnd";

    /**
     * 敏感词库敏感词数量
     *
     * @return
     */
    public int getWordSize() {
        if (sensitiveWordMap == null) {
            return 0;
        }
        return sensitiveWordMap.size();
    }

    /**
     * 是否包含敏感词
     *
     * @param txt
     * @param matchType
     * @return
     */
    public boolean isContaintSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = checkSensitiveWord(txt, i, matchType);
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取敏感词内容
     *
     * @param txt
     * @param matchType
     * @return 敏感词内容
     */
    public Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<String>();

        for (int i = 0; i < txt.length(); i++) {
            int length = checkSensitiveWord(txt, i, matchType);
            if (length > 0) {
                // 将检测出的敏感词保存到集合中
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }

        return sensitiveWordList;
    }

    /**
     * 替换敏感词
     *
     * @param txt
     * @param matchType
     * @param replaceChar
     * @return
     */
    public String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }

    /**
     * 替换敏感词内容
     *
     * @param replaceChar
     * @param length
     * @return
     */
    private static String getReplaceChars(String replaceChar, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(replaceChar);
        for (int i = 1; i < length; i++) {
            sb.append(replaceChar);
        }

        return sb.toString();
    }

    /**
     * 检查敏感词数量
     *
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return
     */
    public int checkSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;
        // 记录敏感词数量
        int matchFlag = 0;
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            // 判断该字是否存在于敏感词库中
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                matchFlag++;
                // 判断是否是敏感词的结尾字，如果是结尾字则判断是否继续检测
                if (Objects.equals(SensitiveWordIsEndEnum.END.getType(), nowMap.get("isEnd"))) {
                    flag = true;
                    // 判断过滤类型，如果是小过滤则跳出循环，否则继续循环
                    if (Objects.equals(SensitiveWordEnum.MIN_MATCH_TYPE.getType(), matchType)) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (!flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }

}
