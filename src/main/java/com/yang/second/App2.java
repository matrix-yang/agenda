package com.yang.second;

import com.yang.command.AbstractCommand;
import com.yang.command.AddUserCL;
import com.yang.command.Commands;
import com.yang.dao.UserDao;
import com.yang.model.User;
import com.yang.util.Util;
import net.sf.json.JSONArray;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App2
{
    public static void main(String[] args) throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        init();

        Commands commands =new Commands();
        commands.initCMD(args);
        commands.excute();

        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void init(){
        //初始化users
        try {
            JSONArray jsonArray = Util.readFile("users");
            UserDao.getInstance().init(Util.jsonArrayToList(jsonArray, User.class));
        } catch (IOException e) {
            UserDao.getInstance().init(new ArrayList<User>());
            e.printStackTrace();
        }

        //初始化agendas
    }

    public static void close() throws IOException {
        //持久化users
        List<User> users=UserDao.getInstance().getList();
        Util.writeFile("users",(Util.listToJSONArray(users)).toString());

        //持久化agendas
    }
}
