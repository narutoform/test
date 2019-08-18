package cn.chinotan.enums;

/**
 * @program: test
 * @description: 敏感词匹配类型枚举
 * @author: xingcheng
 * @create: 2018-12-16 11:15
 **/
public enum SensitiveWordEnum {

    /**
     * 只过滤最小敏感词
     */
    MIN_MATCH_TYPE(1, "最小匹配类型"),
    /**
     * 过滤所有敏感词
     */
    MAX_MATCH_TYPE(2, "最大匹配类型")
    ;

    private int type;

    private String context;

    SensitiveWordEnum(int type, String context) {
        this.type = type;
        this.context = context;
    }

    public int getType() {
        return type;
    }


    public String getContext() {
        return context;
    }
}
