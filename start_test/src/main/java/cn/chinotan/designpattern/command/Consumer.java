package cn.chinotan.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: 顾客
 * @author: xingcheng
 * @create: 2018-09-02 15:34
 **/
public class Consumer {
    
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Milk milk = new Milk();
        Mousse mousse = new Mousse();

        // 店小二记录菜单
        System.out.println("店小二记录菜单----------------------------------------------");
        Menu menu = new Menu();
        menu.writeMenu(new OrderFruit(fruit));
        menu.writeMenu(new OrderMilk(milk));
        menu.writeMenu(new OrderMousse(mousse));
        
        // 店小二将菜单交给厨师
        menu.giveCooker();

        // 顾客取消菜单--太贵了不吃了╭(╯^╰)╮
        System.out.println("顾客取消菜单--太贵了不吃了╭(╯^╰)╮----------------------------");
        Menu menuCancel = new Menu();
        menuCancel.writeMenu(new CancelFruit(fruit));
        menuCancel.writeMenu(new CancelMilk(milk));
        menuCancel.writeMenu(new CancelMousse(mousse));
        menuCancel.giveCooker();

        System.out.println("宏命令----------------------------");
        List<Command> commands = new ArrayList<>();
        commands.add(new CancelFruit(fruit));
        commands.add(new CancelMilk(milk));
        commands.add(new CancelMousse(mousse));
        MutilCommand mutilCommand = new MutilCommand(commands);
        mutilCommand.giveCooker();
    }
    
}
