package cn.chinotan.controller;

import cn.chinotan.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @program: test
 * @description: websocket控制器
 * @author: xingcheng
 * @create: 2019-06-01 15:13
 **/
@RestController
@RequestMapping("/webSocket")
public class WebSocketController {
    
    @Autowired
    WebSocketServer webSocketServer;

    @GetMapping("/server/push/{sid}")
    public void push(@PathVariable("sid") Integer sid) {
        if (0 == sid) {
            WebSocketServer.sendInfo(sid + "：全员注意啦！", null);
        } else {
            WebSocketServer.sendInfo(sid + "：注意啦！ -> " + (sid + 1), String.valueOf(sid + 1));
        }
    }
    
}
