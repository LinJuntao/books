package infunction.demo.common.bookStore;

import com.jfinal.plugin.activerecord.Db;

public class deleteBooks {
    /** 删除表格 */
    /** 1.b_literature */
    public boolean delectLiterature(Integer id) {
        try {
            Db.update("delete from b_literature where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 2.b_biography */
    public boolean delectBiography(Integer id) {
        try {
            Db.update("delete from b_biography where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 3.b_cartoon */
    public boolean delectCartoon(Integer id) {
        try {
            Db.update("delete from b_cartoon where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 4.b_art */
    public boolean delectArt(Integer id) {
        try {
            Db.update("delete from b_art where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 5.b_children */
    public boolean delectChildren(Integer id) {
        try {
            Db.update("delete from b_children where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 6.b_social */
    public boolean delectSocial(Integer id) {
        try {
            Db.update("delete from b_social where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 7.b_history */
    public boolean delectHistory(Integer id) {
        try {
            Db.update("delete from b_history where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 8.b_succer */
    public boolean delectSuccer(Integer id) {
        try {
            Db.update("delete from b_succer where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 9.b_fun */
    public boolean delectFun(Integer id) {
        try {
            Db.update("delete from b_fun where id= ?", id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 10.b_traval */
    public boolean delectTraval(Integer id) {
        try {
            Db.update("delete from b_traval where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 11.b_life */
    public boolean delectLife(Integer id) {
        try {
            Db.update("delete from b_life where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 12.b_language */
    public boolean delectLanguage(Integer id) {
        try {
            Db.update("delete from b_language where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 13.b_novel */
    public boolean delectNovel(Integer id) {
        try {
            Db.update("delete from b_novel where id= ?", id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

}