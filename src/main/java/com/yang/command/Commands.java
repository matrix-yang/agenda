package com.yang.command;

import com.yang.annotation.AutoCreate;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Commands {
    private List<AbstractCommand> commands = new ArrayList();
    private String[] args;

    public void initCMD(String[] args) throws URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.args = args;
        Class clazz = AbstractCommand.class;
        ClassLoader loader = clazz.getClassLoader();
        // 1. 通过classloader载入包路径，得到url
        URL url = loader.getResource("");
        URI uri = new URI(url + "com/yang/command/");
        System.out.println(uri);
        // 2. 通过File获得uri下的所有文件
        File file = new File(uri);
        File[] files = file.listFiles();
        for (File f : files) {
            String fName = f.getName();
            if (!fName.endsWith(".class")) {
                continue;
            }
            fName = fName.substring(0, fName.length() - 6);
            String allName = "com.yang.command." + fName;
            // 3. 通过反射加载类
            System.out.println(allName);
            clazz = Class.forName(allName);
            System.out.println(clazz);
            boolean flag = clazz.isAnnotationPresent(AutoCreate.class);
            if (flag) {
                AbstractCommand temp = (AbstractCommand) clazz.newInstance();
                temp.setUp(this.args);
                commands.add(temp);
            }
        }
    }

    public void excute() {
        AbstractCommand abstractCommand = null;
        if (args[0].equals("-h")){
            for (AbstractCommand command : commands) {
                command.excute();
            }
        }else {
            for (AbstractCommand command : commands) {
                if (command.isMe()) abstractCommand = command;
            }
            abstractCommand.excute();
        }
    }
}
