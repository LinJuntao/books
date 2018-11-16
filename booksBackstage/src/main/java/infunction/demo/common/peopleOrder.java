package infunction.demo.common;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;
import com.alibaba.fastjson.JSONArray;
import com.jfinal.plugin.activerecord.Db;

public class peopleOrder {
    // 打印用户列表
    public static List<Record> selectUsers() {
        List<Record> list = Db.find("select * from s_user");
        return list;
    }

    public static List<Record> selectManagers() {
        List<Record> list = Db.find("select * from g_user");
        return list;
    }

    /** 以下为删查改(增加，在注册的时候运行)) */
    // 删
    public boolean delectUser(Integer id) {
        try {
            Db.update("delete from s_user where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 用户查找
    public static List<Record> findUser(String findInput) {
        List<Record> list = Db.find("select * from s_user  where username like ?", "%" + findInput + "%");
        return list;
    }

    // 管理员查找
    // public static List<Record> findManager(String findInput) {
    // List<Record> list = Db.find("select * from g_user where username like ?", "%"
    // + findInput + "%");
    // return list;
    // }

    // 修改用户
    public boolean updateUser(String username, String password, String remark, String date, Integer id) {
        try {
            Db.update("update s_user set username=? ,password=?,remark=?,date=? where id=?", username, password, remark,
                    date, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 修改管理员
    public boolean updateManager(String username, String password, String remark, String date, Integer id) {
        try {
            Db.update("update g_user set username=? ,password=?,remark=?,date=? where id=?", username, password, remark,
                    date, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 返回成员数据
    public JSONArray selectPeopleData(Integer anox) {
        List<Record> ls;
        switch (anox) {
        case 0:
            JSONArray allusers = new JSONArray();
            ls = selectUsers();
            for (Record record : ls) {
                allusers.add(record.getColumns());
            }
            return allusers;
        case 1:
            JSONArray allmanager = new JSONArray();
            ls = selectManagers();
            for (Record record : ls) {
                allmanager.add(record.getColumns());
            }
            return allmanager;
        default:
            System.out.println("数据出错");
            return null;
        }
    }

    // 返回用户查找
    public JSONArray finduser(String fInputuser) {
        List<Record> ls = findUser(fInputuser);
        JSONArray finduserNow = new JSONArray();
        for (Record record : ls) {
            finduserNow.add(record.getColumns());
        }
        return finduserNow;
    }

}