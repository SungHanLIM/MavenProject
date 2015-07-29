/**
 * 파일명 : ReadFile.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.Main;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cdg.Analyzer.AnalyzerTime;
import com.cdg.ReadFile.ReadFile;

/**
 * @author 임승한(lim_designer@naver.com)
 *
 */
public class Main {
	public static void main(String[] args) {

		ReadFile readFile = new ReadFile();

		List<String> line = new ArrayList<String>();

		File file = new File("/C:/Dev/workspace/FileReadTest/src/conversation.txt");
		
		// Class ReadFile의 readFile의 매서드를 통해 읽은 파일 내용을 return 받는다.
		readFile.readFile(file);

		// 읽어온 카카오톡 내용을(List) Class AnalyserTime 에 넘긴다.
		AnalyzerTime hotTime = new AnalyzerTime(readFile.readFile(file));
		
		System.out.println("가장많이 대화하는 시간대 : " + hotTime.start());

	}

}
