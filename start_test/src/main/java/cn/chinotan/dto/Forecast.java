package cn.chinotan.dto;

/**
 * @program: test
 * @description: 天气预报
 * @author: xingcheng
 * @create: 2018-11-17 19:37
 **/
public class Forecast implements Comparable<Forecast> {

    private Location location;

    private Temperature temperature;
    
    public Forecast(Location location) {
        this.location = location;
    }

    public Forecast setTemperature(final Temperature temperature) {
        this.temperature = temperature;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public int compareTo(Forecast o) {
        if (o.getTemperature().getTemperature() > temperature.getTemperature()) {
            return 1;
        } else {
            return -1;
        }
    }
}
