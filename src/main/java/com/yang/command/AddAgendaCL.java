package com.yang.command;

import com.yang.annotation.AutoCreate;
import org.apache.commons.cli.*;
@AutoCreate
public class AddAgendaCL extends AbstractCommand {
    AgendaService agendaService=new AgendaService();
    CommandLineParser parser;
    Options opts;
    String t;
    String p;
    String s;
    String e;

    @Override
    public boolean isMe() {
        if (args[0].equals("addAgenda")) return true;
        String addAgenda;
        return false;
    }

    @Override
    public void buildOpts() {
        opts = new Options();
        opts.addOption("h", false, "帮助文档");
        opts.addOption("addAgenda", false, "创建会议");
        opts.addOption("t", true, "会议主题");
        opts.addOption("p", true, "会议参与者");
        opts.addOption("s", true, "会议起始时间");
        opts.addOption("e", true, "会议结束时间");
    }

    @Override
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
                    t = cl.getOptionValue("t");
                    p = cl.getOptionValue("p");
                    s = cl.getOptionValue("s");
                    e = cl.getOptionValue("e");
                }
            } else {
                System.err.println("ERROR_NOARGS");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doCommand() {
        userAgenda.addAgenda(n,p,e,c);
    }

    @Override
    public void setUp(String[] args) {
        super.args=args;
    }
}
