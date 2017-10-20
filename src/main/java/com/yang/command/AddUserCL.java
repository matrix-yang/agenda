package com.yang.command;

import com.yang.annotation.AutoCreate;
import com.yang.service.UserService;
import org.apache.commons.cli.*;

@AutoCreate
public class AddUserCL extends AbstractCommand {
    UserService userService=new UserService();
    CommandLineParser parser;
    Options opts;

    String addUser;
    String n;
    String p;
    String e;
    String c;

    public boolean isMe() {
        if (args[0].equals("addUser")) return true;
        return false;
    }

    public void buildOpts() {
        opts = new Options();
        opts.addOption("h", false, "帮助文档");
        opts.addOption("addUser", false, "创建用户");
        opts.addOption("n", true, "姓名");
        opts.addOption("p", true, "密码");
        opts.addOption("e", true, "邮箱");
        opts.addOption("c", true, "电话");
    }

    public void parser() {
        parser = new BasicParser();
        CommandLine cl;
        try {
            cl = parser.parse(opts, args);
            if (cl.getOptions().length > 0) {
                if (cl.hasOption('h')) {
                    HelpFormatter hf = new HelpFormatter();
                    hf.printHelp("帮助", opts);
                } else {
                    n = cl.getOptionValue("n");
                    p = cl.getOptionValue("p");
                    e = cl.getOptionValue("e");
                    c = cl.getOptionValue("c");
                }
            } else {
                System.err.println("ERROR_NOARGS");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doCommand() {
        userService.addUser(n,p,e,c);
    }

    public void setUp(String[] args) {
        super.args=args;
    }
}
