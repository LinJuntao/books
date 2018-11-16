package infunction.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.Const;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        me.setMaxPostSize(100 * Const.DEFAULT_MAX_POST_SIZE);
        me.setBaseUploadPath("uploads");
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", bookscontroller.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        // 数据库连接操作
        DruidPlugin dp = new DruidPlugin(
                "jdbc:mysql://120.78.75.213/booksmanage?useUnicode=true&characterEncoding=utf8&useSSL=true", "root",
                "admin");
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }

}