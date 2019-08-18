package cn.chinotan.designpattern.command;

import java.util.List;

/**
 * @program: test
 * @description: 宏命令（组合命令）
 * @author: xingcheng
 * @create: 2018-09-02 15:59
 **/
public class MutilCommand {

    private List<Command> commands;

    public MutilCommand(List<Command> commands) {
        this.commands = commands;
    }

    /**
     * 记录顾客需要什么
     */
    public void writeMenu(Command command){
        commands.add(command);
    }

    /**
     * 将菜单交给厨师
     */
    public void giveCooker(){
        if (commands != null && commands.size() > 0){
            commands.forEach(command -> command.execute());
        }
    }
    
}
