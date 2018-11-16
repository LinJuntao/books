package infunction.demo.common.bookStore;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import infunction.demo.start;

public class booksWare {
    // 封装show方法

    public JSONArray showAllData(Integer kindid) {
        List<Record> ls;
        switch (kindid) {
        case 1:
            JSONArray showLiterature = new JSONArray();
            ls = new selectAllBooks().selectAllLiterature();
            for (Record record : ls) {
                showLiterature.add(record.getColumns());
            }
            // JSONArray showLiterature = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllLiterature()));
            return showLiterature;
        case 2:
            JSONArray showBiography = new JSONArray();
            ls = new selectAllBooks().selectAllBiography();
            for (Record record : ls) {
                showBiography.add(record.getColumns());
            }
            // JSONArray showBiography = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllBiography()));
            return showBiography;

        case 3:
            JSONArray showCartoon = new JSONArray();
            ls = new selectAllBooks().selectAllCartoon();
            for (Record record : ls) {
                showCartoon.add(record.getColumns());
            }
            // JSONArray showCartoon = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllCartoon()));
            return showCartoon;

        case 4:
            JSONArray showArt = new JSONArray();
            ls = new selectAllBooks().selectAllArt();
            for (Record record : ls) {
                showArt.add(record.getColumns());
            }
            // JSONArray showArt = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllArt()));
            return showArt;

        case 5:
            JSONArray showChildren = new JSONArray();
            ls = new selectAllBooks().selectAllChildren();
            for (Record record : ls) {
                showChildren.add(record.getColumns());
            }
            // JSONArray showChildren = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllChildren()));
            return showChildren;

        case 6:
            JSONArray showSocial = new JSONArray();
            ls = new selectAllBooks().selectAllSocial();
            for (Record record : ls) {
                showSocial.add(record.getColumns());
            }
            // JSONArray showSocial = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllSocial()));
            return showSocial;

        case 7:
            JSONArray showHistory = new JSONArray();
            ls = new selectAllBooks().selectAllHistory();
            for (Record record : ls) {
                showHistory.add(record.getColumns());
            }
            // JSONArray showHistory = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllHistory()));
            return showHistory;

        case 8:
            JSONArray showSuccer = new JSONArray();
            ls = new selectAllBooks().selectAllSuccer();
            for (Record record : ls) {
                showSuccer.add(record.getColumns());
            }
            // JSONArray showSuccer = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllSuccer()));
            return showSuccer;

        case 9:
            JSONArray showFun = new JSONArray();
            ls = new selectAllBooks().selectAllFun();
            for (Record record : ls) {
                showFun.add(record.getColumns());
            }
            // JSONArray showFun = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllFun()));
            return showFun;

        case 10:
            JSONArray showTraval = new JSONArray();
            ls = new selectAllBooks().selectAllTraval();
            for (Record record : ls) {
                showTraval.add(record.getColumns());
            }
            // JSONArray showTraval = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllTraval()));
            return showTraval;

        case 11:
            JSONArray showLife = new JSONArray();
            ls = new selectAllBooks().selectAllLife();
            for (Record record : ls) {
                showLife.add(record.getColumns());
            }
            // JSONArray showLife = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllLife()));
            return showLife;

        case 12:
            JSONArray showLanguage = new JSONArray();
            ls = new selectAllBooks().selectAllLanguage();
            for (Record record : ls) {
                showLanguage.add(record.getColumns());
            }
            // JSONArray showLanguage = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllLanguage()));
            return showLanguage;

        case 13:
            JSONArray showNovel = new JSONArray();
            ls = new selectAllBooks().selectAllNovel();
            for (Record record : ls) {
                showNovel.add(record.getColumns());
            }
            // JSONArray showNovel = JSONArray.parseArray(JSON.toJSONString(new
            // selectAll().selectAllNovel()));
            return showNovel;
        default:
            System.out.println("default出错");
            return null;
        }

    }

    // 封装delect删除方法
    public boolean delectAllData(Integer tName, Integer id) {
        switch (tName) {
        case 1:
            return new deleteBooks().delectLiterature(id);
        case 2:
            return new deleteBooks().delectBiography(id);
        case 3:
            return new deleteBooks().delectCartoon(id);
        case 4:
            return new deleteBooks().delectArt(id);
        case 5:
            return new deleteBooks().delectChildren(id);
        case 6:
            return new deleteBooks().delectSocial(id);
        case 7:
            return new deleteBooks().delectHistory(id);
        case 8:
            return new deleteBooks().delectSuccer(id);
        case 9:
            return new deleteBooks().delectFun(id);
        case 10:
            return new deleteBooks().delectTraval(id);
        case 11:
            return new deleteBooks().delectLife(id);
        case 12:
            return new deleteBooks().delectLanguage(id);
        case 13:
            return new deleteBooks().delectNovel(id);
        default:
            System.out.println("default出错");
            return false;
        }

    }

    // 封装find查找方法
    public JSONArray findAllData(String findInput, Integer i) {
        List<Record> ls;
        switch (i) {
        case 1:
            JSONArray findLiterature = new JSONArray();
            ls = new findBooks().findLiterature(findInput);
            for (Record record : ls) {
                findLiterature.add(record.getColumns());
            }
            return findLiterature;
        case 2:
            JSONArray findBiography = new JSONArray();
            ls = new findBooks().findBiography(findInput);
            for (Record record : ls) {
                findBiography.add(record.getColumns());
            }
            return findBiography;

        case 3:
            JSONArray findCartoon = new JSONArray();
            ls = new findBooks().findCartoon(findInput);
            for (Record record : ls) {
                findCartoon.add(record.getColumns());
            }
            return findCartoon;

        case 4:
            JSONArray findArt = new JSONArray();
            ls = new findBooks().findArt(findInput);
            for (Record record : ls) {
                findArt.add(record.getColumns());
            }
            return findArt;

        case 5:
            JSONArray findChildren = new JSONArray();
            ls = new findBooks().findChildren(findInput);
            for (Record record : ls) {
                findChildren.add(record.getColumns());
            }
            return findChildren;

        case 6:
            JSONArray findSocial = new JSONArray();
            ls = new findBooks().findSocial(findInput);
            for (Record record : ls) {
                findSocial.add(record.getColumns());
            }
            return findSocial;

        case 7:
            JSONArray findHistory = new JSONArray();
            ls = new findBooks().findHistory(findInput);
            for (Record record : ls) {
                findHistory.add(record.getColumns());
            }
            return findHistory;

        case 8:
            JSONArray findSuccer = new JSONArray();
            ls = new findBooks().findSuccer(findInput);
            for (Record record : ls) {
                findSuccer.add(record.getColumns());
            }
            return findSuccer;

        case 9:
            JSONArray findFun = new JSONArray();
            ls = new findBooks().findFun(findInput);
            for (Record record : ls) {
                findFun.add(record.getColumns());
            }
            return findFun;

        case 10:
            JSONArray findTraval = new JSONArray();
            ls = new findBooks().findTraval(findInput);
            for (Record record : ls) {
                findTraval.add(record.getColumns());
            }
            return findTraval;

        case 11:
            JSONArray findLife = new JSONArray();
            ls = new findBooks().findLife(findInput);
            for (Record record : ls) {
                findLife.add(record.getColumns());
            }
            return findLife;

        case 12:
            JSONArray findLanguage = new JSONArray();
            ls = new findBooks().findLanguage(findInput);
            for (Record record : ls) {
                findLanguage.add(record.getColumns());
            }
            return findLanguage;

        case 13:
            JSONArray findNovel = new JSONArray();
            ls = new findBooks().findNovel(findInput);
            for (Record record : ls) {
                findNovel.add(record.getColumns());
            }
            return findNovel;
        default:
            System.out.println("default出错");
            return null;
        }
    }

    /** 根据书名进行查找 */
    public JSONArray findNameAllData(String findInput, Integer i) {
        List<Record> ls;
        switch (i) {
        case 1:
            JSONArray findLiterature = new JSONArray();
            ls = new findBooks().findNameLiterature(findInput);
            for (Record record : ls) {
                findLiterature.add(record.getColumns());
            }
            return findLiterature;
        case 2:
            JSONArray findBiography = new JSONArray();
            ls = new findBooks().findNameBiography(findInput);
            for (Record record : ls) {
                findBiography.add(record.getColumns());
            }
            return findBiography;

        case 3:
            JSONArray findCartoon = new JSONArray();
            ls = new findBooks().findNameCartoon(findInput);
            for (Record record : ls) {
                findCartoon.add(record.getColumns());
            }
            return findCartoon;

        case 4:
            JSONArray findArt = new JSONArray();
            ls = new findBooks().findNameArt(findInput);
            for (Record record : ls) {
                findArt.add(record.getColumns());
            }
            return findArt;

        case 5:
            JSONArray findChildren = new JSONArray();
            ls = new findBooks().findNameChildren(findInput);
            for (Record record : ls) {
                findChildren.add(record.getColumns());
            }
            return findChildren;

        case 6:
            JSONArray findSocial = new JSONArray();
            ls = new findBooks().findNameSocial(findInput);
            for (Record record : ls) {
                findSocial.add(record.getColumns());
            }
            return findSocial;

        case 7:
            JSONArray findHistory = new JSONArray();
            ls = new findBooks().findNameHistory(findInput);
            for (Record record : ls) {
                findHistory.add(record.getColumns());
            }
            return findHistory;

        case 8:
            JSONArray findSuccer = new JSONArray();
            ls = new findBooks().findNameSuccer(findInput);
            for (Record record : ls) {
                findSuccer.add(record.getColumns());
            }
            return findSuccer;

        case 9:
            JSONArray findFun = new JSONArray();
            ls = new findBooks().findNameFun(findInput);
            for (Record record : ls) {
                findFun.add(record.getColumns());
            }
            return findFun;

        case 10:
            JSONArray findTraval = new JSONArray();
            ls = new findBooks().findNameTraval(findInput);
            for (Record record : ls) {
                findTraval.add(record.getColumns());
            }
            return findTraval;

        case 11:
            JSONArray findLife = new JSONArray();
            ls = new findBooks().findNameLife(findInput);
            for (Record record : ls) {
                findLife.add(record.getColumns());
            }
            return findLife;

        case 12:
            JSONArray findLanguage = new JSONArray();
            ls = new findBooks().findNameLanguage(findInput);
            for (Record record : ls) {
                findLanguage.add(record.getColumns());
            }
            return findLanguage;

        case 13:
            JSONArray findNovel = new JSONArray();
            ls = new findBooks().findNameNovel(findInput);
            for (Record record : ls) {
                findNovel.add(record.getColumns());
            }
            return findNovel;
        default:
            System.out.println("default出错");
            return null;
        }
    }

    // 封装add的方法
    public boolean addOneBooks(Integer tName, JSONObject addOneForm) {
        String bookname = addOneForm.get("bookname").toString();
        String altertime = addOneForm.get("altertime").toString();
        String bookintro = addOneForm.get("bookintro").toString();
        String downloadIVN = addOneForm.get("downloadIVN").toString();
        Integer downlaodNUM = Integer.parseInt(addOneForm.getString("downlaodNUM"));
        String bookimg = addOneForm.get("bookimg").toString();
        String manage = addOneForm.get("manage").toString();
        boolean addOk;
        switch (tName) {
        case 1:
            addOk = new addBooks().addLiterature(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                    manage);
            return addOk;
        case 2:
            addOk = new addBooks().addBiography(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                    manage);
            return addOk;
        case 3:
            addOk = new addBooks().addCartoon(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                    manage);
            return addOk;
        case 4:
            addOk = new addBooks().addArt(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        case 5:
            addOk = new addBooks().addChildren(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                    manage);
            return addOk;
        case 6:
            addOk = new addBooks().addSocial(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        case 7:
            addOk = new addBooks().addHistory(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                    manage);
            return addOk;
        case 8:
            addOk = new addBooks().addSuccer(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        case 9:
            addOk = new addBooks().addFun(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        case 10:
            addOk = new addBooks().addTraval(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        case 11:
            addOk = new addBooks().addLife(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        case 12:
            addOk = new addBooks().addLanguage(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                    manage);
            return addOk;
        case 13:
            addOk = new addBooks().addNovel(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage);
            return addOk;
        default:
            System.out.println("default出错");
            return false;
        }

    }

    // 封装up的方法
    public boolean upOneBooks(Integer tName, JSONObject upOneForm) {
        String bookname = upOneForm.get("bookname").toString();
        String altertime = upOneForm.get("altertime").toString();
        String bookintro = upOneForm.get("bookintro").toString();
        String downloadIVN = upOneForm.get("downloadIVN").toString();
        Integer downlaodNUM = Integer.parseInt(upOneForm.getString("downlaodNUM"));
        String bookimg = upOneForm.get("bookimg").toString();
        String manage = upOneForm.get("manage").toString();
        Integer id = Integer.parseInt(upOneForm.getString("id"));
        boolean upOk;
        switch (tName) {
        case 1:
            upOk = new upBooks().upLiterature(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 2:
            upOk = new upBooks().upBiography(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 3:
            upOk = new upBooks().upCartoon(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 4:
            upOk = new upBooks().upArt(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return upOk;
        case 5:
            upOk = new upBooks().upChildren(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 6:
            upOk = new upBooks().upSocial(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 7:
            upOk = new upBooks().upHistory(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 8:
            upOk = new upBooks().upSuccer(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 9:
            upOk = new upBooks().upFun(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return upOk;
        case 10:
            upOk = new upBooks().upTraval(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 11:
            upOk = new upBooks().upLife(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return upOk;
        case 12:
            upOk = new upBooks().upLanguage(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage,
                    id);
            return upOk;
        case 13:
            upOk = new upBooks().upNovel(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return upOk;
        default:
            System.out.println("default出错");
            return false;
        }

    }

    // 封装Download以及单个查看的方法
    public JSONArray findOneBookDownload(Integer id, Integer i) {
        List<Record> ls;
        switch (i) {
        case 1:
            JSONArray findLiterature = new JSONArray();
            ls = new findBooks().findOneLiteratureDownload(id);
            for (Record record : ls) {
                findLiterature.add(record.getColumns());
            }
            return findLiterature;
        case 2:
            JSONArray findBiography = new JSONArray();
            ls = new findBooks().findOneBiographyDownload(id);
            for (Record record : ls) {
                findBiography.add(record.getColumns());
            }
            return findBiography;

        case 3:
            JSONArray findCartoon = new JSONArray();
            ls = new findBooks().findOneCartoonDownload(id);
            for (Record record : ls) {
                findCartoon.add(record.getColumns());
            }
            return findCartoon;

        case 4:
            JSONArray findArt = new JSONArray();
            ls = new findBooks().findOneArtDownload(id);
            for (Record record : ls) {
                findArt.add(record.getColumns());
            }
            return findArt;

        case 5:
            JSONArray findChildren = new JSONArray();
            ls = new findBooks().findOneChildrenDownload(id);
            for (Record record : ls) {
                findChildren.add(record.getColumns());
            }
            return findChildren;

        case 6:
            JSONArray findSocial = new JSONArray();
            ls = new findBooks().findOneSocialDownload(id);
            for (Record record : ls) {
                findSocial.add(record.getColumns());
            }
            return findSocial;

        case 7:
            JSONArray findHistory = new JSONArray();
            ls = new findBooks().findOneHistoryDownload(id);
            for (Record record : ls) {
                findHistory.add(record.getColumns());
            }
            return findHistory;

        case 8:
            JSONArray findSuccer = new JSONArray();
            ls = new findBooks().findOneSuccerDownload(id);
            for (Record record : ls) {
                findSuccer.add(record.getColumns());
            }
            return findSuccer;

        case 9:
            JSONArray findFun = new JSONArray();
            ls = new findBooks().findOneFunDownload(id);
            for (Record record : ls) {
                findFun.add(record.getColumns());
            }
            return findFun;

        case 10:
            JSONArray findTraval = new JSONArray();
            ls = new findBooks().findOneTravalDownload(id);
            for (Record record : ls) {
                findTraval.add(record.getColumns());
            }
            return findTraval;

        case 11:
            JSONArray findLife = new JSONArray();
            ls = new findBooks().findOneLifeDownload(id);
            for (Record record : ls) {
                findLife.add(record.getColumns());
            }
            return findLife;

        case 12:
            JSONArray findLanguage = new JSONArray();
            ls = new findBooks().findOneLanguageDownload(id);
            for (Record record : ls) {
                findLanguage.add(record.getColumns());
            }
            return findLanguage;

        case 13:
            JSONArray findNovel = new JSONArray();
            ls = new findBooks().findOneNovelDownload(id);
            for (Record record : ls) {
                findNovel.add(record.getColumns());
            }
            return findNovel;
        default:
            System.out.println("default出错");
            return null;
        }
    }

    /** 分页 */

    public JSONArray pageingData(Integer kindid, Integer pageNum) {
        List<Record> ls;
        switch (kindid) {
        case 1:
            JSONArray pageLiterature = new JSONArray();
            ls = new pageBooks().pageLiterature(pageNum);
            for (Record record : ls) {
                pageLiterature.add(record.getColumns());
            }
            return pageLiterature;
        case 2:
            JSONArray pageBiography = new JSONArray();
            ls = new pageBooks().pageBiography(pageNum);
            for (Record record : ls) {
                pageBiography.add(record.getColumns());
            }
            return pageBiography;

        case 3:
            JSONArray pageCartoon = new JSONArray();
            ls = new pageBooks().pageCartoon(pageNum);
            for (Record record : ls) {
                pageCartoon.add(record.getColumns());
            }
            return pageCartoon;

        case 4:
            JSONArray pageArt = new JSONArray();
            ls = new pageBooks().pageArt(pageNum);
            for (Record record : ls) {
                pageArt.add(record.getColumns());
            }
            return pageArt;

        case 5:
            JSONArray pageChildren = new JSONArray();
            ls = new pageBooks().pageChildren(pageNum);
            for (Record record : ls) {
                pageChildren.add(record.getColumns());
            }
            return pageChildren;

        case 6:
            JSONArray pageSocial = new JSONArray();
            ls = new pageBooks().pageSocial(pageNum);
            for (Record record : ls) {
                pageSocial.add(record.getColumns());
            }
            return pageSocial;

        case 7:
            JSONArray pageHistory = new JSONArray();
            ls = new pageBooks().pageHistory(pageNum);
            for (Record record : ls) {
                pageHistory.add(record.getColumns());
            }
            return pageHistory;

        case 8:
            JSONArray pageSuccer = new JSONArray();
            ls = new pageBooks().pageSuccer(pageNum);
            for (Record record : ls) {
                pageSuccer.add(record.getColumns());
            }
            return pageSuccer;

        case 9:
            JSONArray pageFun = new JSONArray();
            ls = new pageBooks().pageFun(pageNum);
            for (Record record : ls) {
                pageFun.add(record.getColumns());
            }
            return pageFun;

        case 10:
            JSONArray pageTraval = new JSONArray();
            ls = new pageBooks().pageTraval(pageNum);
            for (Record record : ls) {
                pageTraval.add(record.getColumns());
            }
            return pageTraval;

        case 11:
            JSONArray pageLife = new JSONArray();
            ls = new pageBooks().pageLife(pageNum);
            for (Record record : ls) {
                pageLife.add(record.getColumns());
            }
            return pageLife;

        case 12:
            JSONArray pageLanguage = new JSONArray();
            ls = new pageBooks().pageLanguage(pageNum);
            for (Record record : ls) {
                pageLanguage.add(record.getColumns());
            }
            return pageLanguage;

        case 13:
            JSONArray pageNovel = new JSONArray();
            ls = new pageBooks().pageNovel(pageNum);
            for (Record record : ls) {
                pageNovel.add(record.getColumns());
            }
            return pageNovel;
        default:
            System.out.println("default出错");
            return null;
        }

    }

    /** 用户分享书籍 */
    public static boolean addShareUser(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer kindid) {
        try {
            Db.update(
                    "insert into share_from_user (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage,kindid) values(?,?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, kindid);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    /** 用户分享的删除：代表挂起，不显示不给其他用户下载 其中100代表可查看以及下载，101代表已挂起，不提供下载和展示 */
    public static boolean delShareUser(Integer id, Integer statuRe) {
        try {
            Db.update("update share_from_user set remove = ?  where id=?", statuRe, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 展示所有用户分享的书籍的信息 */
    public static List<Record> selectShareUser() {
        List<Record> list = Db.find("select * from share_from_user order by id  desc ");
        return list;
    }

    /** 用户的修改 */
    public static boolean upShareUser(String bookname, String altertime, String bookintro, String downloadIVN,
            Integer downlaodNUM, String bookimg, String manage, Integer id) {
        try {
            Db.update(
                    "update share_from_user set bookname=? ,altertime=?,bookintro=?,downloadIVN=? ,downlaodNUM=?,bookimg=?,manage=? where id=?",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 用户分享的查找 */
    public static List<Record> findShareUserBooks(String findInput) {
        List<Record> list = Db.find("select * from share_from_user  where bookintro like ?", "%" + findInput + "%");
        return list;
    }

    /** 用户分享的查找状态为100 */
    public static List<Record> findShareTrue(Integer nubstatu) {
        List<Record> list = Db.find("select * from share_from_user  where remove like ?", nubstatu);
        return list;
    }

    /** 单个用户的的数据 */
    public static List<Record> findShareUserOne(String findName) {
        List<Record> list = Db.find("select * from share_from_user  where manage like ?", "%" + findName + "%");
        return list;
    }

    /** Share添加 */
    public boolean addShareBook(Integer kindid, JSONObject addShare) {
        String bookname = addShare.get("bookname").toString();
        String altertime = addShare.get("altertime").toString();
        String bookintro = addShare.get("bookintro").toString();
        String downloadIVN = addShare.get("downloadIVN").toString();
        Integer downlaodNUM = Integer.parseInt(addShare.getString("downlaodNUM"));
        String bookimg = addShare.get("bookimg").toString();
        String manage = addShare.get("manage").toString();
        boolean ifshare;
        ifshare = addShareUser(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, kindid);
        return ifshare;
    }

    /** Share 根据书名查找 */
    public JSONArray findShareUserData(String findInput) {
        List<Record> ls;
        JSONArray findShare = new JSONArray();
        ls = findShareUserBooks(findInput);
        for (Record record : ls) {
            findShare.add(record.getColumns());
        }
        return findShare;

    }

    /** Share 删除/挂起 or 重新上传 */
    public boolean delShareBook(Integer id, Integer statuRe) {
        boolean delshare = delShareUser(id, statuRe);
        return delshare;
    }

    /** Share 展示manager */
    public JSONArray showShareBook() {
        List<Record> ls;
        JSONArray showShare = new JSONArray();
        ls = selectShareUser();
        for (Record record : ls) {
            showShare.add(record.getColumns());
        }
        return showShare;
    }

    /** Share 展示个人 */
    public JSONArray showShareBookHtml() {
        List<Record> ls;
        JSONArray showShareTrue = new JSONArray();
        ls = findShareTrue(100);
        for (Record record : ls) {
            showShareTrue.add(record.getColumns());
        }
        return showShareTrue;
    }

    /** Share 修改 */
    public boolean upShareBook(Integer id, JSONObject upShares) {
        String bookname = upShares.get("bookname").toString();
        String altertime = upShares.get("altertime").toString();
        String bookintro = upShares.get("bookintro").toString();
        String downloadIVN = upShares.get("downloadIVN").toString();
        Integer downlaodNUM = Integer.parseInt(upShares.getString("downlaodNUM"));
        String bookimg = upShares.get("bookimg").toString();
        String manage = upShares.get("manage").toString();
        boolean upShare;

        upShare = upShareUser(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, id);
        return upShare;
    }

    /** Share 单个用户的信息 */
    public JSONArray shareUserOnebooks(String username) {
        JSONArray shareonebooks = new JSONArray();
        List<Record> ls;
        ls = findShareUserOne(username);
        for (Record record : ls) {
            shareonebooks.add(record.getColumns());
        }
        return shareonebooks;
    }

}