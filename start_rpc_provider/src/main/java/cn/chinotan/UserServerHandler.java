package cn.chinotan;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @program: test
 * @description: 自定义 handler 逻辑
 * @author: xingcheng
 * @create: 2018-12-30 19:45
 **/
public class UserServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 如何符合约定，则调用本地方法，返回数据
        if (msg.toString().startsWith("UserService")) {
            String result = new UserServiceImpl()
                    .sayHello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }
    
}
