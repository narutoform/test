package cn.chinotan.dto;

/**
 * @program: test
 * @description: 温度
 * @author: xingcheng
 * @create: 2018-11-17 19:35
 **/
public class Temperature {

    private Double temperature;
    
    private String scale;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
