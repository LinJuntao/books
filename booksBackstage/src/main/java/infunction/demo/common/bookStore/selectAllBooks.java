package infunction.demo.common.bookStore;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class selectAllBooks {

    /**
     * 打印表格所有数据 L
     */

    // 1.b_literature
    public List<Record> selectAllLiterature() {
        List<Record> list = Db
                .find("select * from b_literature as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 2.b_biography
    public List<Record> selectAllBiography() {
        List<Record> list = Db
                .find("select * from b_biography as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 3.b_cartoon
    public List<Record> selectAllCartoon() {
        List<Record> list = Db
                .find("select * from b_cartoon as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 4.b_art
    public List<Record> selectAllArt() {
        List<Record> list = Db
                .find("select * from b_art as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 5.b_children
    public List<Record> selectAllChildren() {
        List<Record> list = Db
                .find("select * from b_children as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 6.b_social
    public List<Record> selectAllSocial() {
        List<Record> list = Db
                .find("select * from b_social as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 7.b_history
    public List<Record> selectAllHistory() {
        List<Record> list = Db
                .find("select * from b_history as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 8.b_succer
    public List<Record> selectAllSuccer() {

        List<Record> list = Db
                .find("select * from b_succer as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 9.b_fun
    public List<Record> selectAllFun() {
        List<Record> list = Db
                .find("select * from b_fun as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 10. b_traval
    public List<Record> selectAllTraval() {
        List<Record> list = Db
                .find("select * from b_traval as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 11.b_life
    public List<Record> selectAllLife() {
        List<Record> list = Db
                .find("select * from b_life as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 12.b_language
    public List<Record> selectAllLanguage() {
        List<Record> list = Db
                .find("select * from b_language as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    // 13.b_novel
    public List<Record> selectAllNovel() {
        List<Record> list = Db
                .find("select * from b_novel as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

}
