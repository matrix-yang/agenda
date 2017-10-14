package com.yang.command;

public abstract class AbstractCommand implements Command{
    public abstract boolean isMe(String[] args);
    public abstract void buildOpts();
    public abstract void parser(String[] args);
    public abstract void doCommand();
    public abstract void setUp();
    public void excute(String[] args){
        buildOpts();
        parser(args);
        doCommand();
    }
}
