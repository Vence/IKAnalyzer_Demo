package com.lqb.ikanalyzer.service;

import com.lqb.ikanalyzer.Utils.FunctionUtil;
import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 */
public class Statu {

    public String getStatus(Vector<String> strs1) {
        String result = FunctionUtil.getDoctor(strs1);
        if (result == null) {
            result = "未找到相关信息";
        }
        else{
            //调用专家动态查询函数
            //result  =dao(result);
        }
        System.out.println(result);
        return result;
    }
}
