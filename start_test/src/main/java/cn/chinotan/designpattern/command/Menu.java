package cn.chinotan.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: 菜单
 * @author: xingcheng
 * @create: 2018-09-02 15:36
 **/
public class Menu {

    private List<Command> commands;

    public Menu() {
        this.commands = new ArrayList<>();
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
