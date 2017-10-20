package com.yang.command;

public abstract class AbstractCommand implements Command{
    public String[] args;
    public abstract boolean isMe();
    public abstract void buildOpts();
    public abstract void parser();
    public abstract void doCommand();
    public abstract void setUp(String[] args);
    public void excute(){
        buildOpts();
        parser();
        doCommand();
    }
}
