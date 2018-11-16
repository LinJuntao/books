package infunction.demo.common;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.plugin.activerecord.Record;

public class log implements Interceptor {

    public void intercept(Invocation inv) {
        inv.invoke();
        HttpSession httpSession = inv.getController().getSession();
        String username = (String) httpSession.getAttribute("username");
        List<Record> userLog = new bookServer().ifUser(username);
        List<Record> managerLog = new bookServer().ifManage(username);

        if (userLog.size() > 0) {
            String nowDate = new bookServer().nowDate();
            String userLogs = "[普通用户: " + username + "]" + "在" + nowDate + ",操作了:" + inv.getActionKey() + "方法.";
            boolean e = new bookServer().addUserDateLog(username, nowDate, userLogs);
            if (e) {
                System.out.println("添加log用户日志成功");
            } else {
                System.out.println("添加log用户日志失败");
            }
        } else if (managerLog.size() > 0) {
            String nowDate = new bookServer().nowDate();
            String userLogs = "[管理员: " + username + "]" + "在 " + nowDate + ",操作了: " + inv.getActionKey() + "方法 .";
            boolean e = new bookServer().addManagerDateLog(username, nowDate, userLogs);
            if (e) {
                System.out.println("添加log管理员日志成功");
            } else {
                System.out.println("添加log管理员日志失败");
            }
        } else {
            System.out.println("未登陆");
        }
    }
}