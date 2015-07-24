/**
 * 파일명 : AnalyzerPeople.java
 * 작성일 : 2015. 7. 23.
 * 파일설명 : 
 */
package com.cdg.Analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 임승한(lim_designer@naver.com) 누가 톡 많이 했나 구함
 */
public class AnalyzerPeople {

	private String people;
	private List<String> list = new ArrayList<String>();
	private ArrayList list1 = new ArrayList();

	public AnalyzerPeople(List<String> list) {
		this.list = list;
	}

	/*
	 * public String start() { people = "\\[임승한\\]";
	 * 
	 * Iterator iterator = list.iterator();
	 * 
	 * while (iterator.hasNext()) {
	 * 
	 * String peopleInfo = String.format(people); Pattern peoplePattern =
	 * Pattern.compile(peopleInfo); Matcher peoplePatternMatches =
	 * peoplePattern.matcher(iterator.next().toString());
	 * 
	 * if (peoplePatternMatches.find()) { // trim() : 공백 제거 String matchResult =
	 * peoplePatternMatches.group(0).trim(); System.out.println(matchResult);
	 * 
	 * // 참인경우 매칭된 값 반환 //return matchResult; } } return ""; }
	 */
	public ArrayList start() {
		people = "\\[임승한\\]";
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			String timeInfo = String.format(people);
			Pattern timePattern = Pattern.compile(timeInfo);
			Matcher timePatternMatches = timePattern.matcher(iterator.next()
					.toString());

			if (timePatternMatches.find()) {
				String matchResult = timePatternMatches.group(0).trim();
				list1.add(matchResult);
			}
		}
		// 수정중
		// int length = list1.add(MatchResult);
		return list1;
	}
}
