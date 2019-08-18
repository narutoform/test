package cn.chinotan.controller;

import cn.chinotan.dto.Location;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: 位置服务
 * @author: xingcheng
 * @create: 2018-11-17 19:42
 **/
@RestController
public class LocationController {

    @GetMapping("/location")
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            locations.add(new Location(StringUtils.join("London", i)));
        }

        return locations;
    }

}
