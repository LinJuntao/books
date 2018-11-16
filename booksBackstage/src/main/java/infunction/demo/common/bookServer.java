package infunction.demo.common;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.alibaba.fastjson.JSONArray;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class bookServer {

    /* 查询用户，用于登录 */
    public List<Record> SNameAndPsw(String username, String password) {
        List<Record> list = Db.find("select * from s_user where username= ? AND password= ? ", username, password);
        return list;
    }

    /* 注册用户-- 实现保存数据到数据库的功能 */
    public boolean saveUser(String date, String username, String password, String remark) {
        List<Record> list = Db.find("select * from s_user where username= ? ", username);
        if (list.size() == 0) {
            Db.update("insert into s_user(date,username,password,remark) values(?,?,?,?)", date, username, password,
                    remark);
            return true;
        }
        return false;
    }

    /*** 用于判断是否已存在用户名,用户名不得重复 */
    public boolean ifSave(String username) {
        List<Record> list = Db.find("select * from s_user where username= ? ", username);
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    /*** 同时判断是否存在与管理员的同名 */
    public boolean ifManager(String username) {
        List<Record> list = Db.find("select * from g_user where username= ? ", username);
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    /* 查询管理员，用于登录 */
    public List<Record> GNameAndPsw(String username, String password) {
        List<Record> list = Db.find("select * from g_user where username= ? AND password= ? ", username, password);
        return list;
    }

    // 获取当前本地系统时间
    public String nowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
        String nowdate = df.format(new Date()); // new Date()为获取当前系统时间
        return nowdate;
    }

    /* 查询用户，用于写Log用户日志 */
    public List<Record> ifUser(String username) {
        List<Record> list = Db.find("select * from s_user where username= ? ", username);
        return list;
    }

    /* 查询管理员，用于写Log管理员日志 */
    public List<Record> ifManage(String username) {
        List<Record> list = Db.find("select * from g_user where username= ? ", username);
        return list;
    }

    /* 打印Log用户表数据 */
    public List<Record> selectUserLog() {
        List<Record> list = Db.find("select * from ulog order by logid  desc ");
        return list;
    }

    /* 打印Log管理员表数据 */
    public List<Record> selectManageLog() {
        List<Record> list = Db.find("select * from mlog order by logid  desc ");
        return list;
    }

    /** 增加用户日记记录 */
    public boolean addUserDateLog(String loguser, String logtime, String logcontent) {
        try {
            Db.update("insert into ulog(loguser,logtime,logcontent) values(?,?,?)", loguser, logtime, logcontent);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /** 增加管理员日记记录 */
    public boolean addManagerDateLog(String loguser, String logtime, String logcontent) {
        try {
            Db.update("insert into mlog(loguser,logtime,logcontent) values(?,?,?)", loguser, logtime, logcontent);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /*** 判断是否修改了书本的种类 */
    public Integer upkind(String afterupkind) {
        Integer upkindID;
        if (afterupkind.equals("文学")) {
            upkindID = 1;
            return upkindID;
        } else if (afterupkind.equals("传记")) {
            upkindID = 2;
            return upkindID;
        } else if (afterupkind.equals("传记")) {
            upkindID = 2;
            return upkindID;
        } else if (afterupkind.equals("青春动漫")) {
            upkindID = 3;
            return upkindID;
        } else if (afterupkind.equals("艺术与摄影")) {
            upkindID = 4;
            return upkindID;
        } else if (afterupkind.equals("少儿")) {
            upkindID = 5;
            return upkindID;
        } else if (afterupkind.equals("社会科学")) {
            upkindID = 6;
            return upkindID;
        } else if (afterupkind.equals("历史")) {
            upkindID = 7;
            return upkindID;
        } else if (afterupkind.equals("励志与成功")) {
            upkindID = 8;
            return upkindID;
        } else if (afterupkind.equals("娱乐与体育")) {
            upkindID = 9;
            return upkindID;
        } else if (afterupkind.equals("旅游")) {
            upkindID = 10;
            return upkindID;
        } else if (afterupkind.equals("科技与生活")) {
            upkindID = 11;
            return upkindID;
        } else if (afterupkind.equals("外语学习")) {
            upkindID = 12;
            return upkindID;
        } else if (afterupkind.equals("小说")) {
            upkindID = 13;
            return upkindID;
        } else {
            return upkindID = 0;
        }

    }

    /**
     * 当新建一本书时 也会在newbooks表添加数据
     */
    public boolean addNewBooks(String bookname, String altertime, String bookintro, String downloadIVN,
            String downlaodNUM, String bookimg, String manage, Integer kindid) {
        try {
            Db.update(
                    "insert into newbooks (bookname, altertime , bookintro, downloadIVN,downlaodNUM, bookimg,manage,kindid) values(?,?,?,?,?,?,?,?)",
                    bookname, altertime, bookintro, downloadIVN, downlaodNUM, bookimg, manage, kindid);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    /** 打印newbooks的数据 */
    public static List<Record> selectNewBooks() {
        List<Record> list = Db
                .find("select * from newbooks as a ,kindid as b  where a.kindid = b.kindid order by  a.id   desc");
        return list;
    }

    /** 封装newbooks 数据 */
    public JSONArray showNewBooks() {
        List<Record> list = selectNewBooks();
        JSONArray showNewbooks = new JSONArray();
        for (Record record : list) {
            showNewbooks.add(record.getColumns());
        }
        return showNewbooks;
    }

    /** 单个新书榜书籍展示 */
    public JSONArray findOneNewBook(Integer newbookid) {
        List<Record> list = Db.find("select * from newbooks where id= ? ", newbookid);
        JSONArray findOneBook = new JSONArray();
        for (Record record : list) {
            findOneBook.add(record.getColumns());
        }
        return findOneBook;
    }

    /** 根据ID查找用户的信息 */
    public static List<Record> oneUser(Integer id) {
        List<Record> list = Db.find("select * from s_user  where id= ?  ", id);
        return list;
    }

    public JSONArray oneUserData(Integer id) {
        List<Record> ls = oneUser(id);
        JSONArray oneuser = new JSONArray();
        for (Record record : ls) {
            oneuser.add(record.getColumns());
        }
        return oneuser;
    }

    /** 下载时改变下载数 */

    public boolean upDownloadUser(Integer downloadNul, Integer id) {
        try {
            Db.update("update s_user set downloadNul =? where id=?", downloadNul, id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /** 分享时改变分享数量 */

    public boolean shareUser(Integer shareNul, Integer id) {
        try {
            Db.update("update s_user set shareNul =? where id=?", shareNul, id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
            return false;
        }
    }

    /** 当分享超过5本时，把该用户改为会员 */
    public boolean ifMemberUser(Integer id) {
        try {
            Db.update("update s_user set ifMember =? where id=?", 1, id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
            return false;
        }
    }

    private static final int BUFFER_SIZE = 2 * 1024;

    /**
     * 压缩成ZIP 方法2 57
     * 
     * @param srcFiles 需要压缩的文件列表
     * @param out      压缩文件输出流
     * @return
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static String UrltoZip(List<URL> srcFiles, OutputStream out) throws RuntimeException {
        long start = System.currentTimeMillis();
        // System.out.println(srcFiles);
        // srcFiles = UrlEncoded(srcFiles.)
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            for (URL srcFile : srcFiles) {
                zos.putNextEntry(new ZipEntry(srcFile.getFile()));
                String[] strs = srcFile.getFile().split("/");
                String jiafeng = strs[strs.length - 1];
                jiafeng = URLEncoder.encode(jiafeng, "UTF-8");
                // System.out.println(jiafeng);
                strs[strs.length - 1] = jiafeng;
                StringBuffer stringBuffer = new StringBuffer("http://120.78.75.213:8080");
                for (int i = 0; i < strs.length; i++) {
                    stringBuffer.append("/" + strs[i]);
                }
                URL url = new URL(stringBuffer.toString());
                srcFile = url;
                int len;
                srcFile.openConnection();
                InputStream in = srcFile.openStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    zos.write(line.getBytes());
                }
                zos.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            String massage = "压缩完成，耗时：" + (end - start) + " ms";
            return massage;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}