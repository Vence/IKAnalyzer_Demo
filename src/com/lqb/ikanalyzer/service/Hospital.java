package com.lqb.ikanalyzer.service;

import com.lqb.ikanalyzer.Utils.FunctionUtil;

import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 * 福州哪些医院看糖尿病好
 * 福州附属医院详情
 */
public class Hospital {

    public String getHospitalInfo(Vector<String> strs1) {
        String result = FunctionUtil.getHospital(strs1);
        if (result == null) {
            String place = FunctionUtil.getPlace(strs1);
            String field = FunctionUtil.getDisease(strs1);
            if(place!=null&&field!=null){
                //调用某地某领域医院检索函数
                //result  =dao(place,field);
                System.out.println(place+field);
            }
            else if(place!=null){
                //调用某地医院检索函数
                //result  =dao(place);
            }
            else if(field!=null){
                //调用某领域医院检索函数
                //result  =dao(field);
            }
            else{

            }
        }
        else{
            //调用xx医院详情检索函数
            //result  =dao(result+"医院");
        }
        System.out.println(result);
        return result;
    }
}