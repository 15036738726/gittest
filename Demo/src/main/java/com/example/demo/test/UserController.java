package com.example.demo.test;

import com.example.demo.init.ParamInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    // fuq_test01分支提交的代码
    private String fuq_test01;
    // fuq_test02分支提交的代码
    private String fuq_test02;


    // fuq-test01分支提交的代码,14:16
    private String fuq_1416;

    // fuq_test02分支提交的代码,14:35
    private String fuq_1435;


    @Autowired
    private ParamInit paramInit;

    @RequestMapping("/query")
    @ResponseBody
    public String queryUser(){
        return "哈喽";
    }


    @RequestMapping("shgh")
    @ResponseBody
    public Map queryShgh(){
        Connection connection = null;
        PreparedStatement ps = null;
        Map<String, String> map = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bxfundacc", "bxfundacc");
            ps = connection.prepareStatement("SELECT * from A001HzJkHZ");
            ResultSet result = ps.executeQuery();
            int i = 1;
            map = new HashMap<>();
            while (result.next()){
                Map<String, String> tempMap = new HashMap<>();
                String fdate = result.getString("FDATE");
                String fzqdm = result.getString("FZQDM");
                tempMap.put("fadate",fdate);
                tempMap.put("fzqdm",fzqdm);
                map.put("第"+ i++ +"条数据" ,tempMap.toString());
            }
            result.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return map;
    }


    @RequestMapping("shgh2")
    @ResponseBody
    public Map queryShgh2(){
        Connection connection = null;
        PreparedStatement ps = null;
        Map<String, String> map = null;
        try {
            Class.forName(paramInit.getCACHE().get("driver-class-name"));
            connection = DriverManager.getConnection(paramInit.getCACHE().get("url"), paramInit.getCACHE().get("username"),paramInit.getCACHE().get("password"));
            ps = connection.prepareStatement("SELECT * from A001HzJkHZ");
            ResultSet result = ps.executeQuery();
            int i = 1;
            map = new HashMap<>();
            while (result.next()){
                Map<String, String> tempMap = new HashMap<>();
                String fdate = result.getString("FDATE");
                String fzqdm = result.getString("FZQDM");
                tempMap.put("fadate",fdate);
                tempMap.put("fzqdm",fzqdm);
                map.put("第"+ i++ +"条数据" ,tempMap.toString());
            }
            result.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return map;
    }

}
