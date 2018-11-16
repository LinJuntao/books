package infunction.demo.common.bookStore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import infunction.demo.start;

public class userCSclick {
    /**
     * 这个类是写用户的其中的购物车以及收藏的功能 收藏： 包括： 1.根据用户名查找对应的kindid，以及书籍id
     * 2.根据用户名查找到的kindid，i返回对应的书籍数据 3.根据前端返回的书籍的kingId，id，新添加一条数据到collcetion_book 表中
     * 4.根据collcetion_id 对应的数据删除数据
     * 
     */
    // 添加数据
    public static boolean addcollcetion_book(Integer collcetion_book_id, Integer collcetion_book_kindid,
            String collcetion_username, Integer collcetion_userId) {
        try {
            Db.update(
                    "insert into collcetion_book(collcetion_book_id,collcetion_book_kindid,collcetion_username,collcetion_userId) values(?,?,?,?)",
                    collcetion_book_id, collcetion_book_kindid, collcetion_username, collcetion_userId);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 删除数据
    public static boolean delectcollcetion_book(Integer collcetionId) {
        try {
            Db.update("delete from collcetion_book where collcetion_id= ?", collcetionId);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 根据用户名查找到对应的kindid，id */
    public static List<Record> findcollcetion_name(String collocetion_username) {
        List<Record> list = Db.find(
                "select * from collcetion_book  where collcetion_username like ? order by collcetion_id  desc",
                "%" + collocetion_username + "%");
        return list;
    }

    /** 返回根据kindid和id 已查找到的所有数据 */
    public JSONArray findAllCollcetionData(String collocetion_username) {
        List<Record> ls;
        ls = findcollcetion_name(collocetion_username);
        JSONArray findCollkind = new JSONArray();
        for (Record record : ls) {
            findCollkind.add(record.getColumns());
        }
        JSONArray findAllCollcetionDataJsonArray = new JSONArray();
        Integer kindid, id;
        for (int i = 0; i < findCollkind.size(); i++) {
            kindid = findCollkind.getJSONObject(i).getInteger("collcetion_book_kindid");
            id = findCollkind.getJSONObject(i).getInteger("collcetion_book_id");
            JSONArray dataCollcetion = new booksWare().findOneBookDownload(id, kindid);
            JSONObject jsonObject = findCollkind.getJSONObject(i);
            JSONObject jsonObject2 = dataCollcetion.getJSONObject(0);
            jsonObject.putAll(jsonObject2);
            findAllCollcetionDataJsonArray.add(jsonObject);
        }
        return findAllCollcetionDataJsonArray;
    }

    /** 添加收藏 */
    public boolean addCollerction(JSONObject addFrom) {
        Integer collcetion_book_id = Integer.parseInt(addFrom.getString("collcetion_book_id"));
        Integer collcetion_book_kindid = Integer.parseInt(addFrom.getString("collcetion_book_kindid"));
        String collcetion_username = addFrom.getString("collocetion_username");
        Integer collcetion_userId = Integer.parseInt(addFrom.getString("collcetion_userId"));
        boolean addcoller = addcollcetion_book(collcetion_book_id, collcetion_book_kindid, collcetion_username,
                collcetion_userId);
        return addcoller;
    }

    /** 删除收藏 */
    public boolean delCollerction(Integer collcetionId) {
        return delectcollcetion_book(collcetionId);
    }

    /**
     * 这个类是写用户的其中的购物车以及收藏的功能 购物车: 包括： 1.根据用户名查找对应的kindid，以及书籍id
     * 2.根据用户名查找到的kindid，i返回对应的书籍数据 3.根据前端返回的书籍的kingId，id，新添加一条数据到shopping_book 表中
     * 4.根据shopping_id 对应的数据删除数据
     * 
     */

    // 添加购物车
    public static boolean addshopping_book(Integer shopping_book_id, Integer shopping_book_kindid,
            String shopping_username, Integer shopping_userId) {
        try {
            Db.update(
                    "insert into shopping_book(shopping_book_id,shopping_book_kindid,shopping_username,shopping_userId) values(?,?,?,?)",
                    shopping_book_id, shopping_book_kindid, shopping_username, shopping_userId);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 删除购物车/已下载时，取消购物车
    public static boolean delectshopping_book(Integer shoppingId) {
        Integer shopping_statue = 1;
        try {
            Db.update("update shopping_book set shopping_statue = ?  where shopping_id=?", shopping_statue, shoppingId);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 根据用户名查找到对应的kindid，id */
    public static List<Record> findshopping_name(String shopping_username) {
        List<Record> list = Db.find(
                "select * from shopping_book  where shopping_username like ? and shopping_statue = 0  order by shopping_id  desc",
                "%" + shopping_username + "%");
        return list;
    }

    /** 返回根据kindid和id 已查找到的所有数据 */
    public JSONArray findAllshoppingData(String shopping_username) {
        List<Record> ls;
        ls = findshopping_name(shopping_username);
        JSONArray findShopping = new JSONArray();
        for (Record record : ls) {
            findShopping.add(record.getColumns());
        }
        JSONArray findShoppingJsonArray = new JSONArray();
        Integer kindid, id;
        for (int i = 0; i < findShopping.size(); i++) {
            kindid = findShopping.getJSONObject(i).getInteger("shopping_book_kindid");
            id = findShopping.getJSONObject(i).getInteger("shopping_book_id");
            JSONArray dataShopping = new booksWare().findOneBookDownload(id, kindid);
            JSONObject jsonObject = findShopping.getJSONObject(i);
            JSONObject jsonObject2 = dataShopping.getJSONObject(0);
            jsonObject.putAll(jsonObject2);
            findShoppingJsonArray.add(jsonObject);
        }

        return findShoppingJsonArray;
    }

    /** 添加购物车 */
    public boolean addShopping(JSONObject addFrom) {
        Integer shopping_book_id = Integer.parseInt(addFrom.getString("shopping_book_id"));
        Integer shopping_book_kindid = Integer.parseInt(addFrom.getString("shopping_book_kindid"));
        String shopping_username = addFrom.getString("shopping_username");
        Integer shopping_userId = Integer.parseInt(addFrom.getString("shopping_userId"));
        boolean addshopping = addshopping_book(shopping_book_id, shopping_book_kindid, shopping_username,
                shopping_userId);
        return addshopping;
    }

    /** 删除购物车,已下载时，取消购物车 */
    public boolean delShopping(Integer shoppingId) {
        return delectshopping_book(shoppingId);
    }

}