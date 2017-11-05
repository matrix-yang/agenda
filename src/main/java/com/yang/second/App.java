package com.yang.second;

import com.yang.annotation.AutoCreate;
import com.yang.command.AbstractCommand;
import com.yang.command.Commands;
import org.apache.commons.cli.*;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Commands commands =new Commands();
        commands.initCMD(args);
        commands.excute();
    }

}
