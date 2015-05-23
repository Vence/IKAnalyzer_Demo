package com.lqb.ikanalyzer.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by icyli on 15/5/21.
 */
public class FunctionUtil {

    //文章需要分为专家文章和领域文章,索引,同时添加疾病和专家到词库
    //擅长领域同样分为某专家擅长领域和擅长某领域的专家查询
    //信息也分为专家信息和疾病信息
    //.....

    public static final String[][] Function={{"查看信息","了解信息","知道信息","基本信息"},{"文章","相关文章"},{"最新动态","近期动态","动态"}, {"擅长领域","方面"},
        {"诊断","医治","咨询","治疗"}, {"医院","诊所"},{"预防","护理","调养"},{"关联图谱","相关图谱","专家图谱","相关"},{"知识图谱"}};


    // 个人信息
    public static final int Information = 0;
    // 相关文章
    public static final int Article = 1;
    // 专家动态
    public static final int Statu = 2;
    // 擅长领域
    public static final int Field = 3;
    // 医治疾病
    public static final int Consult = 4;
    // 医院诊所
    public static final int Hospital = 5;
    // 预防知识
    public static final int Prevent = 6;
    // 专家图谱
    public static final int D_Graph = 7;
    // 知识图谱
    public static final int K_Graph = 8;


    public static String getDoctor(Vector<String> strs1){
        String result = null;
        try {

            for(int i =0;i < strs1.size();i++){

                String element = strs1.elementAt(i);
                //专家数据量小,文件IO耗时小，若大的话，则需要用树结构预取存储
                FileReader fr=new FileReader("src/com/lqb/ikanalyzer/dict/doctor.dic");
                BufferedReader br = null;
                br = new BufferedReader(fr);
                String line = null;
                while((line=br.readLine())!=null){
                    if (line.equals(element)) {
                        result = element;
                        break;
                    }
                }
                if(result != null){
                    break;
                }
            }
        }catch (IOException e) {
            result = null;
        }
        return result;
    }


    public static String getDisease(Vector<String> strs1){
        String result = null;
        try {

            for (int i = 0; i < strs1.size(); i++) {

                String element = strs1.elementAt(i);
                //疾病类型数据量小,文件IO耗时小
                FileReader fr = new FileReader("src/com/lqb/ikanalyzer/dict/disease.dic");
                BufferedReader br = null;
                br = new BufferedReader(fr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.equals(element)) {
                        result = element;
                        break;
                    }
                }
            }
        }catch (IOException e) {
            result = null;
        }
        return result;
    }

    public static String getField(Vector<String> strs1){
        String result = null;
        try {

            for (int i = 0; i < strs1.size(); i++) {

                String element = strs1.elementAt(i);
                //疾病类型数据量小,文件IO耗时小
                FileReader fr = new FileReader("src/com/lqb/ikanalyzer/dict/field.dic");
                BufferedReader br = null;
                br = new BufferedReader(fr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.equals(element)) {
                        result = element;
                        break;
                    }
                }
            }
        }catch (IOException e) {
            result = null;
        }
        return result;
    }

    public static String getPlace(Vector<String> strs1){
        String result = null;
        try {

            for (int i = 0; i < strs1.size(); i++) {

                String element = strs1.elementAt(i);
                //疾病类型数据量小,文件IO耗时小
                FileReader fr = new FileReader("src/com/lqb/ikanalyzer/dict/place.dic");
                BufferedReader br = null;
                br = new BufferedReader(fr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.equals(element)) {
                        result = element;
                        break;
                    }
                }
            }
        }catch (IOException e) {
            result = null;
        }
        return result;

    }

    public static String getHospital(Vector<String> strs1){
        String result = null;
        try {

            for (int i = 0; i < strs1.size(); i++) {

                String element = strs1.elementAt(i);
                //疾病类型数据量小,文件IO耗时小
                FileReader fr = new FileReader("src/com/lqb/ikanalyzer/dict/hospital.dic");
                BufferedReader br = null;
                br = new BufferedReader(fr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.equals(element)) {
                        result = element;
                        break;
                    }
                }
            }
        }catch (IOException e) {
            result = null;
        }
        return result;

    }
}
