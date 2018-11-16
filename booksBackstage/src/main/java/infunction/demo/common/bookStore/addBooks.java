package infunction.demo.common.bookStore;

import com.jfinal.plugin.activerecord.Db;

public class addBooks {
    /**
     * 在各自的表中添加数据
     */
    // 1.b_literature
    public boolean addLiterature(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_literature (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    // 2.b_biography
    public boolean addBiography(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_biography (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 3.b_cartoon
    public boolean addCartoon(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_cartoon (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 4.b_art
    public boolean addArt(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_art (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 5.b_children
    public boolean addChildren(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_children (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 6.b_social
    public boolean addSocial(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_social (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 7.b_history
    public boolean addHistory(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_history (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 8.b_succer
    public boolean addSuccer(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_succer (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 9.b_fun
    public boolean addFun(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_fun (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 10. b_traval
    public boolean addTraval(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_traval (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 11.b_life
    public boolean addLife(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_life (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 12.b_language
    public boolean addLanguage(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_language (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 13.b_novel
    public boolean addNovel(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage) {
        try {
            Db.update(
                    "insert into b_novel (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage) values(?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

}