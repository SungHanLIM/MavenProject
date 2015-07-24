/**
 * 파일명 : ReadFile.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.Main;
/*
 * getter & setter Alt + Shift + S - R 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import com.cdg.Analyzer.AnalyzerPeople;
import com.cdg.Analyzer.AnalyzerTime;
import com.cdg.ReadFile.ReadFile;

/**
 * @author 임승한(lim_designer@naver.com)
 *
 */
public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		// ReadFile Class
		ReadFile readfile = new ReadFile("/C:/Dev/workspace/MavenProject/target/classes/", "conversation.txt");
		
		// 카카오톡 파일 내용을 읽어온다.
		/*System.out.println(readfile.start());*/
		list = readfile.start();
		AnalyzerTime hotTime = new AnalyzerTime(list);
		System.out.println(hotTime.start());
		
	
		AnalyzerPeople hotPeople = new AnalyzerPeople(list);
		System.out.println(hotPeople.start());
		
	}


}
