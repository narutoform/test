package cn.chinotan.enums;

/**
 * @program: test
 * @description: 敏感词是否末尾字节
 * @author: xingcheng
 * @create: 2018-12-16 11:15
 **/
public enum SensitiveWordIsEndEnum {

    /**
     * 未结束
     */
    NOT_END(0, "未结束"),
    /**
     * 结束
     */
    END(1, "结束")
    ;
    
    private Integer type;
    
    private String context;

    SensitiveWordIsEndEnum(Integer type, String context) {
        this.type = type;
        this.context = context;
    }

    public Integer getType() {
        return type;
    }


    public String getContext() {
        return context;
    }
}
