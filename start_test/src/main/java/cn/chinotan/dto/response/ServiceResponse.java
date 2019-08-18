package cn.chinotan.dto.response;

import cn.chinotan.dto.Forecast;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: 服务响应
 * @author: xingcheng
 * @create: 2018-11-17 19:39
 **/
public class ServiceResponse {

    private long processingTime;

    private List<Forecast> forecasts = new ArrayList<>();

    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }

    public ServiceResponse forecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}
