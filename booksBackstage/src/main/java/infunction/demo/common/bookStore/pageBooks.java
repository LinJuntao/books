package infunction.demo.common.bookStore;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class pageBooks {

    /**
     * 分页
     */

    // 1.b_literature
    public List<Record> pageLiterature(Integer pageNum) {
        List<Record> list = Db.find("select * from b_literature order by id desc limit ?,10", pageNum);
        return list;
    }

    // 2.b_biography
    public List<Record> pageBiography(Integer pageNum) {
        List<Record> list = Db.find("select * from b_biography order by id desc limit ?,10", pageNum);
        return list;
    }

    // 3.b_cartoon
    public List<Record> pageCartoon(Integer pageNum) {
        List<Record> list = Db.find("select * from b_cartoon order by id desc limit ?,10", pageNum);
        return list;
    }

    // 4.b_art
    public List<Record> pageArt(Integer pageNum) {
        List<Record> list = Db.find("select * from b_art order by id desc limit ?,10", pageNum);
        return list;
    }

    // 5.b_children
    public List<Record> pageChildren(Integer pageNum) {
        List<Record> list = Db.find("select * from b_children order by id desc limit ?,10", pageNum);
        return list;
    }

    // 6.b_social
    public List<Record> pageSocial(Integer pageNum) {
        List<Record> list = Db.find("select * from b_social order by id desc limit ?,10", pageNum);
        return list;
    }

    // 7.b_history
    public List<Record> pageHistory(Integer pageNum) {
        List<Record> list = Db.find("select * from b_history order by id desc limit ?,10", pageNum);
        return list;
    }

    // 8.b_succer
    public List<Record> pageSuccer(Integer pageNum) {

        List<Record> list = Db.find("select * from b_succer order by id desc limit ?,10", pageNum);
        return list;
    }

    // 9.b_fun
    public List<Record> pageFun(Integer pageNum) {
        List<Record> list = Db.find("select * from b_fun order by id desc limit ?,10", pageNum);
        return list;
    }

    // 10. b_traval
    public List<Record> pageTraval(Integer pageNum) {
        List<Record> list = Db.find("select * from b_traval order by id desc limit ?,10", pageNum);
        return list;
    }

    // 11.b_life
    public List<Record> pageLife(Integer pageNum) {
        List<Record> list = Db.find("select * from b_life order by id desc limit ?,10", pageNum);
        return list;
    }

    // 12.b_language
    public List<Record> pageLanguage(Integer pageNum) {
        List<Record> list = Db.find("select * from b_language order by id desc limit ?,10", pageNum);
        return list;
    }

    // 13.b_novel
    public List<Record> pageNovel(Integer pageNum) {
        List<Record> list = Db.find("select * from b_novel order by id desc limit ?,10", pageNum);
        return list;
    }

}