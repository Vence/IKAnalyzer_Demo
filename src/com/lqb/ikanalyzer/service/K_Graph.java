package com.lqb.ikanalyzer.service;

import com.lqb.ikanalyzer.Utils.FunctionUtil;

import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 */
public class K_Graph {

    public String getKnowleageGraph(Vector<String> strs1) {

        String result = FunctionUtil.getDisease(strs1);
        if (result == null) {
            result = "未找到相关信息";
        }
        else{
            //调用某知识图谱函数
            //result  =dao(result);
        }
        System.out.println(result);
        return result;
    }
}
