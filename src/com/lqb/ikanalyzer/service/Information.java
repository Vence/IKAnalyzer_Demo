package com.lqb.ikanalyzer.service;

import com.lqb.ikanalyzer.Utils.FunctionUtil;

import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 * 和李其柄专家相关的基本信息
 * 我想知道李其柄的信息
 * 李其柄信息
 * 我想了解一下和糖尿病相关的信息
 */
public class Information {

    public String getPersonInfo(Vector<String> strs1) {
        String result = FunctionUtil.getDoctor(strs1);
        if (result == null) {
            result = FunctionUtil.getDisease(strs1);
        }
        else{
            //调用专家基本信息查询函数
            //result  =dao(result);
        }
        if (result == null) {
            result = "未找到相关信息";
        }
        else{
            //调用疾病基本信息查询函数
            //result  =dao(result);
        }
        System.out.println(result);
        return result;
    }
}
