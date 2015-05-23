package com.lqb.ikanalyzer.demo;


import com.lqb.ikanalyzer.service.*;
import com.lqb.ikanalyzer.Utils.FunctionUtil;
import com.lqb.ikanalyzer.Utils.IKAnalyzerUtil;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author: lqb
 * @Date: 2015-5-20
 * @version 1.0
 */

public class CheckTheSame {
	
/*
个性化检索：
（最好检索一下它的相关问答库，对满意情况排序，个性化推荐；或者对动态进行排序，根据专家讲座的频度排序
 －－－－》在这里新建数据库，加入专家满意度评价情况字段和专家讲座次数，然后自己适当加权定参数排序就可以了）

//我想知道/查询/了解xxx专家的信息      模式：查询/了解/知道信息,提取xxx，返回简介/擅长领域/地点/出诊时间/相关时间/博客/地点
//和xxx专家相关的文章                模式：文章，查询文章字段，返回文章名，文章摘要
//我想查找／查看中医xxx领域的相关文章   模式:文章   提取xxx，查询文章字段，返回作者、文章名和摘要（根据时间和引用次数排序）
//xxx专家近期动态                    模式：动态，提取xxx，查询返回动态字段
//擅长xxx领域的专家                  模式：领域，提取xxx与擅长领域字段比较相似度，返回专家列表和所在医院
//XX专家擅长的领域                   模式：领域，提取xxx与，返回专家擅长的领域
//能够治疗／诊断xxx的专家             模式：治疗／诊断，提取xxx，同上
//（福州xx）有哪些（糖尿病xxx）医院  模式:医院，提取地点和领域，返回该医院列表
// xxx医院详情   模式：医院，提取地xxx,获取医院详情
//如何预防糖尿病xxx/糖尿病xxx相关知识   模式:预防知识，提取xxx，查询问答数据结构，将xxx与问题进行相似度匹配排序，对相应问答进行生成摘要然后串接
//xxx专家的关联图谱/治疗xxx的相关图谱   模式:关联图谱   查看是否存在“专家”字眼，若有提取xxx，查询xxx专家图谱，若无，根据疾病xxx，筛选出专家在计算图谱
//xxx领域的知识图谱                   模式:知识图谱   提取xxx
*/

	//可以将此main函数改生servlet直接运用到系统中
	//接受参数为用户搜索内容,String str
	//返回参数为用户搜索结果,String result
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = null;
		String result = null;
		System.out.println("请输入您想查询的内容：");
		while(true) {
			str = scan.next();
			//去掉“的”,因分词能力有限
			str = str.replaceAll("[的]","" );
			//分词
			Vector<String> strs1 = IKAnalyzerUtil.participle(str) ;
			System.out.println(strs1);
			int type = getFunctionType(strs1);
			switch (type) {
				case FunctionUtil.Information:
					//专家或者疾病信息
					result = new Information().getPersonInfo(strs1);
					break;
				case FunctionUtil.Article:
					//相关文章
					result = new Article().getArticleDetail(strs1);
					break;
				case FunctionUtil.Statu:
					//最新动态
					result = new Statu().getStatus(strs1);
					break;
				case FunctionUtil.Field:
					//擅长领域
					result = new Field().getFieldDetail(strs1);
					break;
				case FunctionUtil.Consult:
					//治疗咨询
					result = new Consult().getConsults(strs1);
					break;
				case FunctionUtil.Hospital:
					//医院诊所
					result = new Hospital().getHospitalInfo(strs1);
					break;
				case FunctionUtil.Prevent:
					//预防知识
					result = new Prevent().getPreventKnowleage(strs1);
					break;
				case FunctionUtil.D_Graph:
					//专家图谱
					result = new D_Graph().getDoctorGraph(strs1);
					break;
				case FunctionUtil.K_Graph:
					//知识图谱
					result = new K_Graph().getKnowleageGraph(strs1);
					break;
				default:
					//匹配不成功，以日常对话形式返回答语
					break;
			}
		}
	}


	//计算相似类型
	public static int getFunctionType(Vector<String> strs1) {

		double max = 0;
		int type = -1;
		for(int i = 0;i<FunctionUtil.Function.length ;i++){
			for(int j = 0;j<FunctionUtil.Function[i].length;j++) {
				Vector<String> strs2 = IKAnalyzerUtil.participle(FunctionUtil.Function[i][j]);
				double same = 0;
				try {
					same = IKAnalyzerUtil.getSimilarity(strs1, strs2);
				} catch (Exception e) {
					//System.out.println(e.getMessage());
					same = 0;
				}
				//System.out.println("类型" + String.valueOf(i) + "_" +String.valueOf(j)+"的相似度：" + same);
				if (max < same) {
					max = same;
					type = i;
				}
			}
		}
		if( max < 0.5){
			return -1;
		}
		else{
			System.out.println( "\n最大关联类型为"+FunctionUtil.Function[type][0]+"\n最大关联度为"+String.valueOf(max)+"\n");
			return type;
		}
	}
}
