package infunction.demo;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.captcha.CaptchaRender;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;

import infunction.demo.common.FileService;
import infunction.demo.common.bookServer;
import infunction.demo.common.bookToken;
import infunction.demo.common.log;
import infunction.demo.common.peopleOrder;
import infunction.demo.common.qkNews;
import infunction.demo.common.bookStore.booksWare;
import infunction.demo.common.bookStore.userCSclick;

@Before(log.class)
public class bookscontroller extends Controller {

    static String SESSION_TOKEN;

    @Clear(log.class)
    public void index() {
        renderTemplate("/infornal/html/login.html");
    }

    /** 上传文件 */
    @Clear(log.class)
    public void upload() {
        UploadFile uploadFile = this.getFile();
        String filename = uploadFile.getFileName();
        File file = uploadFile.getFile();
        int kind = getParaToInt("kind");
        if (kind == 0) {
            String flname = filename.substring(0, filename.indexOf('.'));
            FileService fService = new FileService();
            long nowdate = new Date().getTime();
            File tFile = new File(PathKit.getWebRootPath().toString() + "/uploads/img/" + nowdate + flname
                    + filename.substring(filename.lastIndexOf(".")));
            if (!tFile.exists()) {
                tFile.getParentFile().mkdir();
            }
            try {
                tFile.createNewFile();
            } catch (IOException e1) {

                e1.printStackTrace();
            }
            try {
                tFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fService.copy(file, tFile);
            String llname = "http://120.78.75.213:8080" + tFile.toString().substring(24, tFile.toString().length());
            JSONArray imgJson = new JSONArray();
            boolean ifDownload = true;
            imgJson.add(llname);
            imgJson.add(ifDownload);
            renderJson(imgJson);
        }
        if (kind == 1) {
            String flname = filename.substring(0, filename.indexOf('.'));
            FileService fService = new FileService();
            long nowdate = new Date().getTime();
            File tFile = new File(PathKit.getWebRootPath().toString() + "/uploads/ebooks/" + nowdate + flname
                    + filename.substring(filename.lastIndexOf(".")));
            if (!tFile.exists()) {
                tFile.getParentFile().mkdir();
            }
            try {
                tFile.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                tFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fService.copy(file, tFile);
            String llname = "http://120.78.75.213:8080" + tFile.toString().substring(24, tFile.toString().length());
            JSONArray textJson = new JSONArray();
            boolean ifDownload = true;
            textJson.add(llname);
            textJson.add(ifDownload);
            renderJson(textJson);
        }

    }

    public void htmlUpload() {
        UploadFile uploadFile = this.getFile();
        String filename = uploadFile.getFileName();
        File file = uploadFile.getFile();
        String flname = filename.substring(0, filename.indexOf('.'));
        FileService fService = new FileService();
        long nowdate = new Date().getTime();
        File tFile = new File(PathKit.getWebRootPath().toString() + "/uploads/userbooks/" + nowdate + flname
                + filename.substring(filename.lastIndexOf(".")));
        if (!tFile.exists()) {
            tFile.getParentFile().mkdir();
        }
        try {
            tFile.createNewFile();
        } catch (IOException e1) {

            e1.printStackTrace();
        }
        try {
            tFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fService.copy(file, tFile);
        String llname = "http://120.78.75.213:8080" + tFile.toString().substring(24, tFile.toString().length());
        JSONArray textJson = new JSONArray();
        boolean ifDownload = true;
        textJson.add(llname);
        textJson.add(ifDownload);
        renderJson(textJson);
    }

    public void test() {
        renderTemplate("/infornal/html/test.html");
    }

    public void showUser() {
        renderTemplate("/infornal/html/index.html");
    }

    public void showManager() {
        renderTemplate("/infornal/html/dist/index.html");
    }

    public void exit() {
        redirect("/index");
    }

    // login 用户与管理员 登录判断
    public void login() {
        String username = getPara("username");
        String password = getPara("password");
        String Eximg = getPara("Eximg");
        // 随机生成token
        bookToken bookToken = new bookToken();
        String sessionString = new bookToken().getTonkeString(getSession());
        setSessionAttr("key", sessionString);
        List<Record> users = new bookServer().SNameAndPsw(username, password);
        setSessionAttr("users", users);
        List<Record> manager = new bookServer().GNameAndPsw(username, password);
        boolean succeslogin = CaptchaRender.validate(this, Eximg);
        if (users.size() > 0 && succeslogin) {
            String nowSession = (String) getSession().getAttribute("key");
            SESSION_TOKEN = nowSession;
            setSessionAttr("userPoer", users);
            getSession().setAttribute("username", username);
            setCookie("userID", users.get(0).get("id").toString(), 7200);
            setCookie("username", username, 7200);
            redirect("/showUser");
        } else if (manager.size() > 0 && succeslogin) {
            String nowSession = (String) getSession().getAttribute("key");
            SESSION_TOKEN = nowSession;
            getSession().setAttribute("username", username);
            setCookie("username", username, 7200);
            redirect("/showManager");
        } else {
            renderHtml("<script>alert('登录失败！');history.back()</script>");
        }
    }

    // 传给前端，判断时候为会员，以及已下载量
    public void memberIf() {
        JSONObject getMember = new JSONObject();
        getMember.put("userPor", getSessionAttr("userPoer"));
        renderJson(getMember);
    }

    // 用户注册
    public void S_register() {
        String username = getPara("username");
        String password = getPara("password");
        String remark = getPara("remark");
        String date = new bookServer().nowDate();
        boolean e = new bookServer().saveUser(date, username, password, remark);
        if (e) {
            renderHtml(
                    "<p>注册成功.......</p> <script>setInterval(function() { window.location.href = 'http://120.78.75.213:8080/books/index'; }, 500);</script>");
        } else {
            renderHtml("<script>alert('注册失败！');history.back()</script>");
        }
    }

    /********************************************************
     * 下载 **********2018.8.06
     */
    // 单个下载
    public void downloadBookOne() {
        /** 获取当前登录用户的id */
        List<Record> list = (List<Record>) getSession().getAttribute("users");
        Integer userId = list.get(0).get("id");
        JSONArray userOne = new bookServer().oneUserData(userId);
        Integer ifMember = (Integer) userOne.getJSONObject(0).get("ifMember");
        String username = (String) userOne.getJSONObject(0).get("username");
        JSONObject url = new JSONObject();
        if (ifMember == 0) {
            Integer downloadNul = (Integer) userOne.getJSONObject(0).get("downloadNul");
            if (downloadNul < 20) {
                Integer kindid = getParaToInt("kindid");
                Integer id = getParaToInt("id");
                JSONArray httpUrl = new booksWare().findOneBookDownload(id, kindid);
                downloadNul = downloadNul + 1;
                boolean ifOk = new bookServer().upDownloadUser(downloadNul, userId);
                if (ifOk) {
                    url.put("message", " 成功返回能下载的url地址");
                    url.put("url", httpUrl.getJSONObject(0).get("downloadIVN"));
                    url.put("message", "还能继续下载:" + (20 - downloadNul) + "次");
                    url.put("downKey", true);
                } else {
                    url.put("message", " 修改失败");
                }
            } else {
                url.put("message", "下载数已超出");
                url.put("downKey", false);
            }
            renderJson(url);
        } else if (ifMember == 1) {
            Integer downloadNul = (Integer) userOne.getJSONObject(0).get("downloadNul");
            Integer kindid = getParaToInt("kindid");
            Integer id = getParaToInt("id");
            JSONArray httpUrl = new booksWare().findOneBookDownload(id, kindid);
            downloadNul = downloadNul + 1;
            boolean ifOk = new bookServer().upDownloadUser(downloadNul, userId);
            if (ifOk) {
                url.put("message", " 成功返回能下载的url地址");
                url.put("url", httpUrl.getJSONObject(0).get("downloadIVN"));
                url.put("message", "已下载了:" + downloadNul + "次");
                url.put("downKey", true);
            } else {
                url.put("message", " 修改失败");
            }
            renderJson(url);
        } else {
            renderJson(url);
        }

    }

    @Clear(log.class)
    // 多个下载
    public void downloadBooks() throws IOException, RuntimeException {
        /**
         * 需要接受书籍种类 kindId ， 以及书籍的Id
         * 批量时，数组格式为datas:[{kindId:"",id:""},{kindId:"",id:""},{kindId:"",id:""}]
         */

        List<Record> list = (List<Record>) getSession().getAttribute("users");
        Integer userId = list.get(0).get("id");
        JSONArray userDou = new bookServer().oneUserData(userId);

        Integer downloadNul = (Integer) userDou.getJSONObject(0).get("downloadNul");
        Integer ifMember = (Integer) userDou.getJSONObject(0).get("ifMember");
        String username = (String) userDou.getJSONObject(0).get("username");

        JSONObject url = new JSONObject();
        String datas = getPara("datasql");
        JSONArray array = JSONArray.parseArray(datas);
        if (ifMember == 0) {
            int dNul = downloadNul + array.size();
            if (dNul <= 20) {
                List<URL> fileLinks = new ArrayList<URL>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Integer index = jsonObject.getInteger("kindid");
                    Integer id = jsonObject.getInteger("id");
                    JSONArray httpurl = new booksWare().findOneBookDownload(id, index);
                    fileLinks.add(new URL(httpurl.getJSONObject(0).getString("downloadIVN")));
                }
                long nowdate = new Date().getTime();
                FileOutputStream fos2 = new FileOutputStream(new File(
                        PathKit.getWebRootPath().toString() + "/uploads/urlZips/" + nowdate + "Mydownloads.zip"));
                String massage = new bookServer().UrltoZip(fileLinks, fos2);
                String hpurl = "http://120.78.75.213:8080/books/uploads/urlZips/" + nowdate + "Mydownloads.zip";
                boolean ifOk = new bookServer().upDownloadUser(dNul, userId);
                if (ifOk) {
                    url.put("key", massage);
                    url.put("massage", "成功压缩");
                    url.put("HttpURL", hpurl);
                    url.put("downloadNul", "已下载:" + dNul + "次");
                    url.put("shengXia", "还剩下" + (20 - dNul) + "次下载 ");
                    renderJson(url);
                } else {
                    url.put("massage", "压缩失败");
                    renderJson(url);
                }
                System.out.println("还能下载:" + (20 - dNul));
            } else if (dNul > 20) {
                url.put("message", "已超出下载量");
                url.put("doN", "超出：" + (dNul - 20) + "个");
                url.put("downloadNul", "现下载数为：" + downloadNul);
                url.put("shengxia", "还能下载:" + (20 - downloadNul));
                url.put("promtp", "请升级为会员");

                renderJson(url);
            } else {
                System.out.println("null");
            }
        } else if (ifMember == 1) {
            List<URL> fileLinks = new ArrayList<URL>();
            for (int i = 0; i < array.size(); i++) {
                Integer index = (Integer) array.getJSONObject(i).get("kindid");
                Integer id = (Integer) array.getJSONObject(i).get("id");
                JSONArray httpurl = new booksWare().findOneBookDownload(id, index);
                fileLinks.add(new URL(httpurl.getJSONObject(0).getString("downloadIVN")));
            }
            long nowdate = new Date().getTime();
            FileOutputStream fos2 = new FileOutputStream(
                    new File(PathKit.getWebRootPath().toString() + "/uploads/urlZips/" + nowdate + "Mydownloads.zip"));
            String massage = new bookServer().UrltoZip(fileLinks, fos2);
            String hpurl = "http://120.78.75.213:8080/books/uploads/urlZips/" + nowdate + "Mydownloads.zip";

            int dNuls = downloadNul + array.size();
            boolean ifOk = new bookServer().upDownloadUser(dNuls, userId);
            if (ifOk) {
                url.put("key", massage);
                url.put("massage", "成功压缩");
                url.put("HttpURL", hpurl);
                url.put("downloadNul", "已下载:" + dNuls + " ");
                renderJson(url);
            } else {
                url.put("massage", "压缩失败");
                renderJson(url);
            }

        }

    }

    /******************************************************************* */
    // 用户注册时，判断时候已存在用户
    public void ifSaveUser() {
        String username = getPara("username");
        boolean ifTrue = new bookServer().ifSave(username);
        boolean ifMan = new bookServer().ifManager(username);
        JSONObject message = new JSONObject();
        if (ifTrue && ifMan) {
            message.put("message", "用户不存在,可以使用");
            message.put("ifTrue", true);
            renderJson(message);
        } else {
            message.put("message", "用户已存在,不可以使用");
            message.put("ifTrue", false);
            renderJson(message);
        }
    }

    @Clear(log.class)
    // 验证码
    public void valiadateImg() {
        CaptchaRender Eximg = new CaptchaRender();
        render(Eximg);
    }

    /********************************************************************
     * 前端需要展示的大部分数据,均为最新数据 包括 5*新闻资讯(10+10*新闻榜) 8*13种书籍 10+10*新书榜 *，-------------
     * 2018.8.06 以及单个数据的跳转
     */
    /*** 5*新闻资讯 */
    public void newsLink() {
        /**
         * 我把需要打印的新闻数据全部写在这里， 0 代表轮播用到 1 新闻榜用到 2 新闻榜后10条
         */
        Integer newskid = getParaToInt(0);
        JSONArray nlinks = new qkNews().selNewsData();
        if (newskid == 0) {
            nlinks = JSON.parseArray(JSON.toJSONString(nlinks.subList(0, 5)));
            renderJson(nlinks);
        } else if (newskid == 1) {
            nlinks = JSON.parseArray(JSON.toJSONString(nlinks.subList(0, 10)));
            renderJson(nlinks);
        } else if (newskid == 2) {
            nlinks = JSON.parseArray(JSON.toJSONString(nlinks.subList(10, 20)));
            renderJson(nlinks);
        } else {
            renderText("null;");
        }
    }

    /** 单条新闻的跳转 */
    public void newsOne() {
        Integer newsid = getParaToInt(0);
        JSONArray oneNews = new qkNews().findOneNewsData(newsid);
        renderJson(oneNews);
    }

    /*** 新书榜数据 */
    public void newBooksLink() {
        Integer newbookskid = getParaToInt(0);
        JSONArray newJson = new bookServer().showNewBooks();
        if (newbookskid == 0) {
            newJson = JSON.parseArray(JSON.toJSONString(newJson.subList(0, 10)));
            renderJson(newJson);
        } else if (newbookskid == 1) {
            newJson = JSON.parseArray(JSON.toJSONString(newJson.subList(10, 20)));
            renderJson(newJson);
        } else {
            renderText("null");
        }
    }

    /***
     * 单个新书信息
     * ，本来考虑到修改书籍信息时，是不会添加到新书榜的，所以可能会出现新书榜和各类书籍的同名书籍里面数据不一样，但不想后台管理系统那里修改，所以暂时忽略这个坑
     */
    public void newOneBook() {
        Integer newbook = getParaToInt(0);
        JSONArray oneNews = new bookServer().findOneNewBook(newbook);
        renderJson(oneNews);
    }

    /**
     * 13种书籍数据
     */
    public void allBooksLink() {
        Integer kindId = getParaToInt(0);
        JSONArray showSome = new booksWare().showAllData(kindId);
        showSome = JSON.parseArray(JSON.toJSONString(showSome.subList(0, 6)));
        renderJson(showSome);
    }

    /** 13种书籍的分页 */

    public void booksLinkPaging() {
        Integer kindid = getParaToInt(0);
        Integer pageNum = getParaToInt(1);
        JSONArray allData = new booksWare().showAllData(kindid);
        System.out.println(allData.size() / 10);
        JSONArray pageData = new booksWare().pageingData(kindid, pageNum * 10);
        JSONObject pageDataJSONObject = new JSONObject();
        pageDataJSONObject.put("sql", pageData);
        pageDataJSONObject.put("pageCur", allData.size() / 10);
        pageDataJSONObject.put("message", "sql为当前页数的数据，pageCur为数据总有多少页，（/10）");
        renderJson(pageDataJSONObject);
    }

    /** 点击查看单个书籍的数据 */
    public void showOneBooksData() {
        Integer kindId = getParaToInt(0);
        Integer id = getParaToInt(1);
        JSONArray oneBook = new booksWare().findOneBookDownload(id, kindId);
        renderJson(oneBook);
    }

    /******************************************************************** 全部书库数据 */
    // 添加功能
    public void addData() {
        String bookname = getPara("bookname");
        String altertime = new bookServer().nowDate();
        String bookintro = getPara("bookintro");
        String downloadIVN = getPara("downloadIVN");
        String downlaodNUM = "1";
        String bookimg = getPara("bookimg");
        String manage = getPara("manage");
        String kindname = getPara("kindname");
        Integer tName = new bookServer().upkind(kindname);
        JSONObject addFrom = new JSONObject();
        addFrom.put("bookname", bookname);
        addFrom.put("altertime", altertime);
        addFrom.put("bookintro", bookintro);
        addFrom.put("downloadIVN", downloadIVN);
        addFrom.put("downlaodNUM", downlaodNUM);
        addFrom.put("bookimg", bookimg);
        addFrom.put("manage", manage);
        boolean ADDS = new booksWare().addOneBooks(tName, addFrom);
        boolean NEWB = new bookServer().addNewBooks(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                manage, tName);
        System.out.println(ADDS + "**");
        System.out.println(NEWB + "---");
        if (ADDS && NEWB) {
            JSONObject message = new JSONObject();
            message.put("message", "修改成功");
            renderJson(message);
        } else {
            JSONObject message = new JSONObject();
            message.put("message", "修改失败");
            renderJson(message);
        }

    }

    // 修改功能
    public void upData() {
        String bookimg = getPara("bookimg");
        String downloadIVN = getPara("downloadIVN");
        String bookintro = getPara("bookintro");
        String downlaodNUM = getPara("downlaodNUM");
        Integer id = (Integer) getParaToInt("id");
        String bookname = getPara("bookname");
        Integer kindid = (Integer) getParaToInt("kindid");
        String manage = getPara("manage");
        String altertime = new bookServer().nowDate();
        String kindname = getPara("kindname");

        Integer afterId = new bookServer().upkind(kindname);
        JSONObject upForm = new JSONObject();
        upForm.put("bookname", bookname);
        upForm.put("altertime", altertime);
        upForm.put("bookintro", bookintro);
        upForm.put("downloadIVN", downloadIVN);
        upForm.put("downlaodNUM", downlaodNUM);
        upForm.put("bookimg", bookimg);
        upForm.put("manage", manage);
        if (kindid == afterId) {
            upForm.put("id", id);
            boolean UPS = new booksWare().upOneBooks(kindid, upForm);
            if (UPS) {
                JSONObject message = new JSONObject();
                message.put("message", "修改成功");
                renderJson(message);
            } else {
                JSONObject message = new JSONObject();
                message.put("message", "修改失败");
                renderJson(message);
            }
        } else {
            boolean upAdd = new booksWare().addOneBooks(afterId, upForm);
            boolean upDel = new booksWare().delectAllData(kindid, id);
            if (upAdd && upDel) {
                JSONObject message = new JSONObject();
                message.put("message", "修改成功");
                renderJson(message);
            } else {
                JSONObject message = new JSONObject();
                message.put("message", "修改失败");
                renderJson(message);
            }
        }
    }

    /**** 新书榜 */
    public void newData() {
        JSONArray newJson = new bookServer().showNewBooks();
        newJson = JSON.parseArray(JSON.toJSONString(newJson.subList(0, 30)));
        renderJson(newJson);
    }

    // 删除功能
    public void delectData() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        Integer kindId = (Integer) getParaToInt("kindId");
        Integer id = (Integer) getParaToInt("id");
        int tName = kindId;
        Boolean ifdelect = new booksWare().delectAllData(tName, id);
        JSONObject sObject = new JSONObject();
        sObject.put("succice", "成功删除");
        if (ifdelect) {
            renderJson(sObject);
        } else {
            renderHtml("<script>alert('删除失败！');history.back()</script>");
        }
    }

    // 打印所有数据
    public void showData() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        String getToken = getHeader("Token");
        int tName = 0;
        // if (getToken == SESSION_TOKEN) {
        // Integer kindId = getParaToInt(0);
        // tName = kindId;
        // } else {
        // tName = 0;
        // renderHtml("<script>alert('进入失败！');history.back()</script>");
        // }
        Integer kindId = getParaToInt(0);
        tName = kindId;
        JSONArray showSome = new booksWare().showAllData(tName);

        renderJson(showSome);
    }

    // 查找功能
    public void findData() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        String input = getPara("inputFind");

        String findInput = input.replaceAll(" ", "");
        JSONObject objData = new JSONObject();
        if (findInput.equals(" ")) {
            redirect("/showManager");
        } else {
            for (int i = 1; i <= 13; i++) {
                JSONArray sql = new booksWare().findAllData(findInput, i);
                JSONArray allData = JSONArray.parseArray(JSON.toJSONString(sql));
                objData.put("" + i, allData);
            }
            renderJson(objData);
        }

    }

    public void getHeader() {
        String herader = getHeader("Token");
        System.out.println(herader);
        renderText("SS");
    }

    /****************************************** log */
    // 打印用户日志
    public void showUserLog() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        JSONArray showUserLog = new JSONArray();
        List<Record> ls = new bookServer().selectUserLog();
        for (Record record : ls) {
            showUserLog.add(record.getColumns());
        }
        renderJson(showUserLog);
    }

    // 打印管理员日志
    public void showManagerLog() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        JSONArray showManagerLog = new JSONArray();
        List<Record> ls = new bookServer().selectManageLog();
        for (Record record : ls) {
            showManagerLog.add(record.getColumns());
        }
        renderJson(showManagerLog);
    }

    /********************** 2018.7.06******************** 用户名单 */

    // 打印全部用户名单
    public void userPeople() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        JSONArray userspeople = new peopleOrder().selectPeopleData(0);
        renderJson(userspeople);
    }

    // 打印全部管理员名单
    public void managerPeople() {
        // 数据跨域
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        JSONArray managerspeople = new peopleOrder().selectPeopleData(1);
        renderJson(managerspeople);
    }

    // 删除用户
    public void delUserPeople() {
        Integer id = (Integer) getParaToInt("id");
        boolean ifDel = new peopleOrder().delectUser(id);
        if (ifDel) {
            redirect("/userPeople");
        } else {
            renderHtml("<script>alert('删除失败！');history.back()</script>");
        }
    }

    // 修改用户信息
    public void upDataUsers() {
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");
        String username = getPara("username");
        String password = getPara("password");
        String remark = getPara("remark");
        Integer id = (Integer) getParaToInt("id");
        String date = new bookServer().nowDate();
        boolean ifUpdata = new peopleOrder().updateUser(username, password, remark, date, id);
        if (ifUpdata) {

            // redirect("/userPeople");
        } else {
            renderHtml("<script>alert('修改失败！');history.back()</script>");
        }
    }

    // 修改用户信息--前端
    public void uphtmlUsers() {
        // getResponse().addHeader("Access-Control-Allow-Origin", "*");

        String username = getPara("usernameInput1");
        String password = getPara("passwordInput1");
        String remark = getPara("remarkInput1");

        System.out.println(username);

        List<Record> list = (List<Record>) getSession().getAttribute("users");
        Integer userId = list.get(0).get("id");
        String date = new bookServer().nowDate();
        boolean ifUpdata = new peopleOrder().updateUser(username, password, remark, date, userId);
        if (ifUpdata) {
            redirect("/index");
        } else {
            renderHtml("<script>alert('修改失败！');history.back()</script>");
        }
    }

    // 修改管理员信息
    public void upDataManagers() {
        String username = getPara("username");
        String password = getPara("password");
        String remark = getPara("remark");
        Integer id = (Integer) getParaToInt("id");
        String date = new bookServer().nowDate();
        boolean ifUpdata = new peopleOrder().updateManager(username, password, remark, date, id);
        if (ifUpdata) {
            redirect("/managerPeople");
        } else {
            renderHtml("<script>alert('修改失败！');history.back()</script>");
        }
    }

    // 查找用户

    public void findPeopleUser() {
        String fInputuser = getPara("fInputuser");
        JSONArray findpeopleUser = new peopleOrder().finduser(fInputuser);
        renderJson(findpeopleUser);
    }

    /*********************** 2018.7.12 ****************************** 快讯 */
    // 打印全部快讯数据
    public void allNews() {
        JSONArray allNews = new qkNews().selNewsData();
        renderJson(allNews);
    }

    // 删除快讯
    public void delNews() {
        Integer id = (Integer) getParaToInt("newsid");
        boolean iFdel = new qkNews().delectNews(id);
        if (iFdel) {
            redirect("/allNews");
        } else {
            renderHtml("<script>alert('删除失败！');history.back()</script>");
        }

    }

    // 添加快讯
    public void addNews() {
        String title = getPara("title");
        String context = getPara("context");
        String issuer = getPara("issuer");
        String titleimg = getPara("titleimg");
        String newstime = new bookServer().nowDate();
        boolean addIf = new qkNews().addNews(title, context, newstime, issuer, titleimg);
        if (addIf) {
            redirect("/allNews");
        } else {
            renderHtml("<script>alert('添加失败!');history.back()</script>");
        }
    }

    // 查找到的快讯数据
    public void findAllNewsData() {
        String findInputNews = getPara("findInputNews");
        JSONArray allNewsJson = new qkNews().findAllNewsData(findInputNews);
        renderJson(allNewsJson);
    }

    // 修改快讯

    public void updateNews() {
        String title = getPara("title");
        String context = getPara("context");
        String issuer = getPara("issuer");
        String titleimg = getPara("titleimg");
        String newstime = new bookServer().nowDate();

        Integer id = (Integer) getParaToInt("newsid");

        boolean iFup = new qkNews().updateNews(title, context, newstime, issuer, titleimg, id);
        if (iFup) {
            redirect("/allNews");
        } else {
            renderHtml("<script>alert('修改失败！');history.back()</script>");
        }
    }

    /******************************** 2018.9.6 ****************/

    /*** 关于用户个人的所有功能 ，包括增删查改等等 */
    // 添加功能
    public void addShareUserData() {
        String bookname = getPara("bookname");
        String altertime = new bookServer().nowDate();
        String bookintro = getPara("bookintro");
        String downloadIVN = getPara("downloadIVN");
        String downlaodNUM = "1";
        String bookimg = getPara("bookimg");
        String manage = getPara("manage");
        String kindname = getPara("kindname");
        Integer tName = new bookServer().upkind(kindname);
        JSONObject addShare = new JSONObject();
        addShare.put("bookname", bookname);
        addShare.put("altertime", altertime);
        addShare.put("bookintro", bookintro);
        addShare.put("downloadIVN", downloadIVN);
        addShare.put("downlaodNUM", downlaodNUM);
        addShare.put("bookimg", bookimg);
        addShare.put("manage", manage);
        boolean ADDS = new booksWare().addShareBook(tName, addShare);
        boolean NEWB = new bookServer().addNewBooks(bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg,
                manage, tName);
        if (ADDS && NEWB) {
            List<Record> list = (List<Record>) getSession().getAttribute("users");
            Integer id = list.get(0).get("id");
            List<Record> listOne = new bookServer().oneUser(id);

            Integer shareNul = listOne.get(0).get("shareNul");
            shareNul = shareNul + 1;
            new bookServer().shareUser(shareNul, id);
            JSONObject message = new JSONObject();
            message.put("message", "添加成功");
            message.put("shareNul", shareNul);
            if (shareNul > 5) {
                boolean ifM = new bookServer().ifMemberUser(id);
                if (ifM) {
                    message.put("status", true);
                }
            }
            renderJson(message);
        } else {
            JSONObject message = new JSONObject();
            message.put("message", "添加成功");
            message.put("status", false);
            renderJson(message);
        }

    }

    public void showShareUserData() {
        String findName = getPara("username");
        JSONArray shareUserone = new booksWare().shareUserOnebooks(findName);
        renderJson(shareUserone);
    }

    public void showShareUser() {
        List<Record> list = (List<Record>) getSession().getAttribute("users");
        Integer id = list.get(0).get("id");
        List<Record> listOne = new bookServer().oneUser(id);
        renderJson(listOne);
    }

    public void shareUserdownoreup() {
        Integer id = getParaToInt("id");
        Integer dp = getParaToInt("downup");
        boolean downorup = new booksWare().delShareBook(id, dp);
        JSONObject message = new JSONObject();
        if (downorup) {
            message.put("message", "操作成功");
        } else {
            message.put("message", "操作失败");
        }
        renderJson(message);
    }

    /********************************* 2018.9.11 */
    // 所有收藏的书籍
    public void collectionData() {
        List<Record> list = (List<Record>) getSession().getAttribute("users");
        String collocetion_username = list.get(0).get("username");
        JSONArray conllcectionFind = new userCSclick().findAllCollcetionData(collocetion_username);
        renderJson(conllcectionFind);
    }

    // 添加收藏
    public void collection_add() {
        List<Record> list = (List<Record>) getSession().getAttribute("users");
        String collocetion_username = list.get(0).get("username");
        Integer collcetion_userId = list.get(0).get("id");

        Integer collcetion_book_id = getParaToInt("collcetion_book_id");
        Integer collcetion_book_kindid = getParaToInt("collcetion_book_kindid");

        JSONObject addFrom = new JSONObject();
        JSONObject messageData = new JSONObject();
        addFrom.put("collocetion_username", collocetion_username);
        addFrom.put("collcetion_userId", collcetion_userId);
        addFrom.put("collcetion_book_id", collcetion_book_id);
        addFrom.put("collcetion_book_kindid", collcetion_book_kindid);
        boolean addup = new userCSclick().addCollerction(addFrom);
        if (addup) {
            messageData.put("message", "收藏成功");
        } else {
            messageData.put("message", "收藏失败");
        }
        renderJson(messageData);
    }

    // 删除收藏

    public void collection_del() {
        Integer collcetionId = getParaToInt("collcetionId");
        boolean delup = new userCSclick().delCollerction(collcetionId);
        JSONObject messageData = new JSONObject();
        if (delup) {
            messageData.put("message", "删除收藏成功");
        } else {
            messageData.put("message", "删除收藏失败");
        }
        renderJson(messageData);
    }

    /** 购物车 */

    // 所有购物车的书籍
    public void shoppingData() {
        List<Record> list = (List<Record>) getSession().getAttribute("users");
        String shopping_username = list.get(0).get("username");
        JSONArray shoppingFind = new userCSclick().findAllshoppingData(shopping_username);
        renderJson(shoppingFind);
    }

    // 添加购物车
    public void shopping_add() {
        List<Record> list = (List<Record>) getSession().getAttribute("users");
        String shopping_username = list.get(0).get("username");
        Integer shopping_userId = list.get(0).get("id");

        Integer shopping_book_id = getParaToInt("shopping_book_id");
        Integer shopping_book_kindid = getParaToInt("shopping_book_kindid");

        JSONObject addFrom = new JSONObject();
        JSONObject messageData = new JSONObject();
        addFrom.put("shopping_username", shopping_username);
        addFrom.put("shopping_userId", shopping_userId);
        addFrom.put("shopping_book_id", shopping_book_id);
        addFrom.put("shopping_book_kindid", shopping_book_kindid);

        boolean addup = new userCSclick().addShopping(addFrom);
        System.out.println(addup);
        if (addup) {
            messageData.put("message", "加入购物车成功");
        } else {
            messageData.put("message", "加入购物车失败");
        }
        renderJson(messageData);
    }

    // 删除购物车

    public void shopping_del() {
        Integer shoppingId = getParaToInt("shoppingId");
        boolean delup = new userCSclick().delShopping(shoppingId);
        JSONObject messageData = new JSONObject();
        if (delup) {
            messageData.put("message", "删除购物车");
        } else {
            messageData.put("message", "删除购物车失败");
        }
        renderJson(messageData);
    }

    // 用于前端搜索，将多表的数据拼接在一起
    public void findAllBooksData() {
        String input = getPara("findbook");
        JSONArray objData = new JSONArray();
        for (int i = 1; i <= 13; i++) {
            JSONArray sql = new booksWare().findNameAllData(input, i);
            objData.addAll(sql);
        }
        JSONArray sharesql = new booksWare().findShareUserData(input);
        objData.addAll(sharesql);
        renderJson(objData);

    }

    /************ 2018 9.19 用于manage的查看个人分享的信息 */
    public void managerLooksShare() {
        JSONArray mgLookShare = new booksWare().showShareBook();
        renderJson(mgLookShare);
    }

    public void managerFindShare() {
        String findinput = getPara("mgFindInput");
        JSONArray manageFindShare = new booksWare().findShareUserData(findinput);
        renderJson(manageFindShare);
    }

    public void managedelShare() {
        Integer id = getParaToInt("shareId");
        Integer statuRe = getParaToInt("shareRe");
        boolean mgDel = new booksWare().delShareBook(id, statuRe);
        JSONObject sql = new JSONObject();
        if (mgDel) {
            sql.put("message", "操作成功");
        } else {
            sql.put("message", "操作失败");

        }
    }

    /***************************************************************** 2 */

    /** 带钥匙 */
    public void TokenAndDate() {
        String nowToken = SESSION_TOKEN;
        // System.out.println(SESSION_TOKEN);
        // 数据库
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", nowToken);
        renderJson(jsonObject);

    }

}