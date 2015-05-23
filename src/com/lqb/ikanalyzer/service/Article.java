package com.lqb.ikanalyzer.service;

import com.lqb.ikanalyzer.Utils.FunctionUtil;

import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 * 和糖尿病相关的文章
 * 和李其柄专家相关的文章
 * 李其柄近期发表的文章
 * 我想知道中医领域的文章
 */
public class Article {

    public String getArticleDetail(Vector<String> strs1) {
        String result = FunctionUtil.getDoctor(strs1);
        if (result == null) {
            result = FunctionUtil.getDisease(strs1);
        }
        else{
            //调用专家文章查询函数
            //result  =dao(result);
        }
        if (result == null) {
            result = FunctionUtil.getField(strs1);
        }
        else{
            //调用某疾病文章查询函数
            //result  =dao(result);
        }
        if (result == null) {
            result = "未找到相关信息";
        }
        else{
            //调用某领域文章查询函数
            //result  =dao(result);
        }
        System.out.println(result);
        return result;
    }
}
