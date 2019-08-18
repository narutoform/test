package cn.chinotan.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * @program: test
 * @description: 基础实体
 * @author: xingcheng
 * @create: 2019-02-16 19:39
 **/
public class BaseEntity implements Serializable {

    @TableField(exist = false)
    private Boolean isTest;

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }
}
