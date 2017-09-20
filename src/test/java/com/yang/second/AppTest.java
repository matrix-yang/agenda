package com.yang.second;

import com.yang.model.User;
import com.yang.util.Util;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        List<User> list=new ArrayList<User>();
        User user =new User();
        user.seteMail("222");
        user.setPassWord("222");
        user.setPhone("212312");
        user.setUserName("哈哈哈");
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        System.out.println(Util.listToJSONArray(list));
        try {
            Util.writeFile("hello",Util.listToJSONArray(list).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray array = null;
        try {
            array=Util.readFile("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(array);

        List<User> list1 =Util.jsonArrayToList(array,User.class);
        System.out.println(list1.size());
    }
}
