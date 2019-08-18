package cn.chinotan.reliabletransmission;

import java.io.Serializable;

/**
 * @program: test
 * @description: 包装消息
 * @author: xingcheng
 * @create: 2018-09-24 15:32
 **/
public class MessageWithTime implements Serializable {

    private String id;
    private long time;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
