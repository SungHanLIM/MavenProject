/**
 * 파일명 : PopularTime.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.Analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 임승한(lim_designer@naver.com) 가장 많이 대화하는 시간대를 구한다
 */
public class AnalyzerTime {

	private List<String> list = new ArrayList<String>();
	private ArrayList list1 = new ArrayList(10);
	private String time;
	private String pickTime;

	/*
	 * private String time; private String popularTime; private String fDir;
	 * private String fName;
	 */

	// PopularTime Class 생성자
	public AnalyzerTime(List<String> list) {
		this.list = list;
	}


	/*// 가장 톡 많이 한 시간 구하는 매서드 구현
	public String analyzerTime() {
		// 2015년 5월 31일 일요일
		time = "\\d{4}년"+" " + "\\d{1}월" + " " + "\\d{2}일";
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			String timeInfo = String.format(time);
			Pattern timePattern = Pattern.compile(timeInfo);
			Matcher timePatternMatches = timePattern.matcher(iterator.next().toString());
			if (timePatternMatches.find()) {
				String matchResult = timePatternMatches.group(0).trim();
				
				list1.add(matchResult);
				System.out.println(list1);
				//System.out.println(matchResult);
				// return matchResult;
			}
		}
		return "";
	}
*/	
	public ArrayList start() {
		time = "\\d{4}년"+" " + "\\d{1}월" + " " + "\\d{2}일";
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			String timeInfo = String.format(time);
			Pattern timePattern = Pattern.compile(timeInfo);
			Matcher timePatternMatches = timePattern.matcher(iterator.next().toString());
			
			if (timePatternMatches.find()) {
				String matchResult = timePatternMatches.group(0).trim();
				list1.add(matchResult);
			}
		}
		return list1;
	}
}
