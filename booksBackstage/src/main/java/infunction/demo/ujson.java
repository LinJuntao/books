package infunction.demo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class ujson {
    /**
     * 返回20个json数据
     */
    public JSONArray test() {
        List<Object> arrys = new ArrayList<Object>();

        for (int i = 0; i < 20; i++) {
            arrys.add("nihao" + i);
        }

        JSONArray json = JSONArray.parseArray(JSON.toJSONString(arrys));
        return json;
    }
}