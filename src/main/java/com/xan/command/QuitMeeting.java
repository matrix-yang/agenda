package com.xan.command;

import com.xan.service.UserService;
import com.yang.annotation.AutoCreate;
import com.yang.command.AbstractCommand;
import org.apache.commons.cli.*;

@AutoCreate
public class QuitMeeting extends AbstractCommand {
    UserService userService=new UserService();
    CommandLineParser parser;
    Options opts;

    String quitMeeting;
    String title;
    String userName;

    public boolean isMe() {
        if (args[0].equals("quitMeeting")) return true;
        return false;
    }

    public void buildOpts() {
        opts = new Options();
        opts.addOption("h", false, "帮助文档");
        opts.addOption("quitMeeting", false, "退出会议");
        opts.addOption("title", true, "会议名称");
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
                    title = cl.getOptionValue("title");
                    userName = cl.getOptionValue("userName");
                }
            } else {
                System.err.println("ERROR");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doCommand() {
        userService.quitMeeting(title,userName);
    }

    public void setUp(String[] args) {
        super.args=args;
    }
}
