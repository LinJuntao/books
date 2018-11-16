package infunction.demo.common;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class qkNews {
    // 拿到快讯全部数据
    public static List<Record> selectAllNews() {
        List<Record> list = Db.find("select * from qk_news order by newsid  desc");
        return list;
    }

    /** 以下为增删查改 功能块 */
    // add 增
    public boolean addNews(String title, String context, String newstime, String issuer, String titleimg) {
        try {
            Db.update("insert into qk_news (title, context , newstime, issuer,titleimg ) values(?,?,? ,?,?)", title,
                    context, newstime, issuer, titleimg);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // delect 删
    public boolean delectNews(Integer id) {
        try {
            Db.update("delete from qk_news where newsid= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // find 查
    public static List<Record> findNews(String findInputNews) {
        List<Record> list = Db.find("select * from qk_news  where title like ?", "%" + findInputNews + "%");
        return list;
    }

    // 单个查
    public static List<Record> findOneNews(Integer newsid) {
        List<Record> list = Db.find("select * from qk_news  where newsid=?", newsid);
        return list;
    }

    // updata 改
    public boolean updateNews(String title, String context, String newstime, String issuer, String titleimg,
            Integer id) {
        try {
            Db.update("update qk_news set title=? ,context=?,newstime=?,issuer=? ,titleimg=? where newsid=?", title,
                    context, newstime, issuer, titleimg, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 返回数据

    public JSONArray selNewsData() {
        List<Record> ls;
        JSONArray allnews = new JSONArray();
        ls = selectAllNews();
        for (Record record : ls) {
            allnews.add(record.getColumns());
        }
        return allnews;
    }

    // 返回查找数据
    public JSONArray findAllNewsData(String findInputNews) {
        List<Record> ls = findNews(findInputNews);
        JSONArray findNewsJsonArray = new JSONArray();
        for (Record record : ls) {
            findNewsJsonArray.add(record.getColumns());
        }
        return findNewsJsonArray;
    }

    // 返回单个数据，根据newsid查找
    public JSONArray findOneNewsData(Integer newsid) {
        List<Record> ls = findOneNews(newsid);
        JSONArray findOneArray = new JSONArray();
        for (Record record : ls) {
            findOneArray.add(record.getColumns());
        }
        return findOneArray;
    }

}