package infunction.demo.common;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class bookToken {
    /*
     * @token介绍： token
     * 类似于手机令牌，前端开发，需要通过token进行确认用户，在抓取数据，这样保证了信息的安全性，另外token具有随机性，以及会保留7天
     */

    private static final String TOKEN_LIST_NAME = "tokenList";
    public static final String TOKEN_STRING_NAME = "token";

    /**
     * @token: 判断是否存在token，当不存在时，会重新生成，另外token只能保存7天，7天后重新生成；
     */
    private static ArrayList getTokenList(HttpSession session) {
        Object obj = session.getAttribute(TOKEN_LIST_NAME);
        if (obj != null) {
            return (ArrayList) obj;
        } else {
            ArrayList tokenList = new ArrayList();
            session.setAttribute(TOKEN_LIST_NAME, tokenList);
            return tokenList;
        }
    }
    /*
     * 保存token方法
     */

    private static void saveTokenString(String tokenStr, HttpSession session) {
        ArrayList tokenList = getTokenList(session);
        tokenList.add(tokenStr);
        session.setAttribute(TOKEN_LIST_NAME, tokenList);
    }

    /**
     * 生成一个令牌字符串，并在会话中保存字符串，然后返回令牌字符串。
     */
    private static String generateTokenSting() {
        return new Long(System.currentTimeMillis()).toString();
    }

    /**
     * get方法,调用generateTokenSting && saveTokenString
     * 
     * @param HttpSession session
     * @return 用于执行特定事务的单个请求的令牌字符串。
     */

    public static String getTonkeString(HttpSession session) {
        String tokenStr = generateTokenSting();
        saveTokenString(tokenStr, session);
        return tokenStr;
    }

    /**
     * 检查令牌字符串是否有效。如果会话包含令牌字符串，则返回true。 otherwise ,return false.
     * 
     * @param String      tokenStr
     * @param HttpSession session
     * @return true:会话包含tokenStr;false：会话为null或令牌str不在会话中
     */

    public static boolean isTokenStringValid(String tokenStr, HttpSession session) {
        boolean valid = false;
        if (session != null) {
            ArrayList tokenList = getTokenList(session);
            if (tokenList.contains(tokenStr)) {
                valid = true;
                tokenList.remove(tokenStr);
            }
        }
        return valid;
    }

}