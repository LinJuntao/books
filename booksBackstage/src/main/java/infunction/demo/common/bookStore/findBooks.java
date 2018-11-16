package infunction.demo.common.bookStore;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class findBooks {
    // 查找所有表的方法

    // 1.b_literature
    public List<Record> findLiterature(String findInput) {
        List<Record> list = Db.find("select * from b_literature  where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 2.b_biography
    public List<Record> findBiography(String findInput) {
        List<Record> list = Db.find("select * from b_biography  where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 3.b_cartoon
    public List<Record> findCartoon(String findInput) {
        List<Record> list = Db.find("select * from b_cartoon where bookintro like ? ", "%" + findInput + "%");
        return list;
    }

    // 4.b_art
    public List<Record> findArt(String findInput) {
        List<Record> list = Db.find("select * from b_art  where bookintro like ? ", "%" + findInput + "%");
        return list;
    }

    // 5.b_children
    public List<Record> findChildren(String findInput) {
        List<Record> list = Db.find("select * from b_children  where bookintro like ? ", "%" + findInput + "%");
        return list;
    }

    // 6.b_social
    public List<Record> findSocial(String findInput) {
        List<Record> list = Db.find("select * from b_social where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 7.b_history
    public List<Record> findHistory(String findInput) {
        List<Record> list = Db.find("select * from b_history where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 8.b_succer
    public List<Record> findSuccer(String findInput) {
        List<Record> list = Db.find("select * from b_succer where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 9.b_fun
    public List<Record> findFun(String findInput) {
        List<Record> list = Db.find("select * from b_fun where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 10. b_traval
    public List<Record> findTraval(String findInput) {
        List<Record> list = Db.find("select * from b_traval where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 11.b_life
    public List<Record> findLife(String findInput) {
        List<Record> list = Db.find("select * from b_life where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 12.b_language
    public List<Record> findLanguage(String findInput) {
        List<Record> list = Db.find("select * from b_language where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    // 13.b_novel
    public List<Record> findNovel(String findInput) {
        List<Record> list = Db.find("select * from b_novel where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    /***
     * 用于下载,按照ID进行查找
     */

    // 1.b_literature
    public List<Record> findOneLiteratureDownload(Integer id) {
        List<Record> list = Db.find("select * from b_literature  where id= ?", id);
        return list;
    }

    // 2.b_biography
    public List<Record> findOneBiographyDownload(Integer id) {
        List<Record> list = Db.find("select * from b_biography where id= ?", id);
        return list;
    }

    // 3.b_cartoon
    public List<Record> findOneCartoonDownload(Integer id) {
        List<Record> list = Db.find("select * from b_cartoon where id= ?", id);
        return list;
    }

    // 4.b_art
    public List<Record> findOneArtDownload(Integer id) {
        List<Record> list = Db.find("select * from b_art where id= ? ", id);
        return list;
    }

    // 5.b_children
    public List<Record> findOneChildrenDownload(Integer id) {
        List<Record> list = Db.find("select * from b_children  where id= ?  ", id);
        return list;
    }

    // 6.b_social
    public List<Record> findOneSocialDownload(Integer id) {
        List<Record> list = Db.find("select * from b_social where id= ? ", id);
        return list;
    }

    // 7.b_history
    public List<Record> findOneHistoryDownload(Integer id) {
        List<Record> list = Db.find("select * from b_history where id= ? ", id);
        return list;
    }

    // 8.b_succer
    public List<Record> findOneSuccerDownload(Integer id) {
        List<Record> list = Db.find("select * from b_succer where id= ? ", id);
        return list;
    }

    // 9.b_fun
    public List<Record> findOneFunDownload(Integer id) {
        List<Record> list = Db.find("select * from b_fun where id= ? ", id);
        return list;
    }

    // 10. b_traval
    public List<Record> findOneTravalDownload(Integer id) {
        List<Record> list = Db.find("select * from b_traval where id= ? ", id);
        return list;
    }

    // 11.b_life
    public List<Record> findOneLifeDownload(Integer id) {
        List<Record> list = Db.find("select * from b_life where id= ? ", id);
        return list;
    }

    // 12.b_language
    public List<Record> findOneLanguageDownload(Integer id) {
        List<Record> list = Db.find("select * from b_language where id= ? ", id);
        return list;
    }

    // 13.b_novel
    public List<Record> findOneNovelDownload(Integer id) {
        List<Record> list = Db.find("select * from b_novel where id= ? ", id);
        return list;
    }

    /***
     * 根据书名进行查找
     */

    // 1.b_literature
    public List<Record> findNameLiterature(String findInput) {
        List<Record> list = Db.find("select * from b_literature  where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 2.b_biography
    public List<Record> findNameBiography(String findInput) {
        List<Record> list = Db.find("select * from b_biography  where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 3.b_cartoon
    public List<Record> findNameCartoon(String findInput) {
        List<Record> list = Db.find("select * from b_cartoon where bookname like ? ", "%" + findInput + "%");
        return list;
    }

    // 4.b_art
    public List<Record> findNameArt(String findInput) {
        List<Record> list = Db.find("select * from b_art  where bookname like ? ", "%" + findInput + "%");
        return list;
    }

    // 5.b_children
    public List<Record> findNameChildren(String findInput) {
        List<Record> list = Db.find("select * from b_children  where bookname like ? ", "%" + findInput + "%");
        return list;
    }

    // 6.b_social
    public List<Record> findNameSocial(String findInput) {
        List<Record> list = Db.find("select * from b_social where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 7.b_history
    public List<Record> findNameHistory(String findInput) {
        List<Record> list = Db.find("select * from b_history where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 8.b_succer
    public List<Record> findNameSuccer(String findInput) {
        List<Record> list = Db.find("select * from b_succer where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 9.b_fun
    public List<Record> findNameFun(String findInput) {
        List<Record> list = Db.find("select * from b_fun where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 10. b_traval
    public List<Record> findNameTraval(String findInput) {
        List<Record> list = Db.find("select * from b_traval where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 11.b_life
    public List<Record> findNameLife(String findInput) {
        List<Record> list = Db.find("select * from b_life where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 12.b_language
    public List<Record> findNameLanguage(String findInput) {
        List<Record> list = Db.find("select * from b_language where bookname like ?", "%" + findInput + "%");
        return list;
    }

    // 13.b_novel
    public List<Record> findNameNovel(String findInput) {
        List<Record> list = Db.find("select * from b_novel where bookname like ?", "%" + findInput + "%");
        return list;
    }
}