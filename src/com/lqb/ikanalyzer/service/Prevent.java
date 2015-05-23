package com.lqb.ikanalyzer.service;

import com.lqb.ikanalyzer.Utils.FunctionUtil;

import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 */
public class Prevent {

    public String getPreventKnowleage(Vector<String> strs1) {
        String result = FunctionUtil.getDisease(strs1);
        if (result == null) {
            result = "未找到相关知识";
        }
        else{
            //调用某疾病基本信息和治疗/预防方法查询函数
            //result  =dao(result);
        }
        System.out.println(result);
        return result;
    }
}