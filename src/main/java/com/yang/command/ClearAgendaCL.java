package com.yang.command;

import com.yang.annotation.AutoCreate;
import com.yang.service.UserService;
import org.apache.commons.cli.*;

/**
 * Created by kouisen on 2017/11/4.
 */
@AutoCreate
public class ClearAgendaCL extends AbstractCommand{
    UserService userService=new UserService();
    CommandLineParser parser;
    Options opts;

    String clearAgenda;
    String userName;

    public boolean isMe() {
        if (args[0].equals("clearAgenda")) return true;
        return false;
    }

    public void buildOpts() {
        opts = new Options();
        opts.addOption("h", false, "帮助文档");
        opts.addOption("clearAgenda", false, "取消会议");
        opts.addOption("userName", true, "姓名");
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
                    userName = cl.getOptionValue("userName");

                }
            } else {
                System.err.println("ERROR_NOARGS");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doCommand() {
        userService.clearAgenda(userName);
    }

    public void setUp(String[] args) {
        super.args=args;
    }
}
