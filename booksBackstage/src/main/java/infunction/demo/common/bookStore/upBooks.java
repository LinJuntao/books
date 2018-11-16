package infunction.demo.common.bookStore;

import com.jfinal.plugin.activerecord.Db;

public class upBooks {
    // 1.b_literature

    public boolean upLiterature(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_literature set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 2.b_biography
    public boolean upBiography(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_biography set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 3.b_cartoon
    public boolean upCartoon(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_cartoon set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 4.b_art
    public boolean upArt(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_art set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 5.b_children
    public boolean upChildren(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_children set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 6.b_social
    public boolean upSocial(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_social set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 7.b_history
    public boolean upHistory(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_history set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 8.b_succer
    public boolean upSuccer(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_succer set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 9.b_fun
    public boolean upFun(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_fun set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 10. b_traval
    public boolean upTraval(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_traval set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 11.b_life
    public boolean upLife(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_life set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 12.b_language
    public boolean upLanguage(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_language set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // 13.b_novel
    public boolean upNovel(String bookname, String altertime, String bookintro, String downloadIVN, Integer downlaodNUM,
            String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update b_novel set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}