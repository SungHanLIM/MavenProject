/**
 * @author 임승한(lim_designer@naver.com)
 * 파일명 : ReadFile.java
 * 작성일 : 2015. 7. 20.
 * 파일설명 : 카카오톡 대화 내용 파일의 내용을 읽어온다. 
 */
package com.cdg.ReadFile;

import java.io.*;

import com.cdg.MavenProject.AppTest;

public class ReadFile {
	public static void main(String[] args) {

		/*
		 * String path = AppTest.class.getResource("").getPath(); // 현재 클래스의 절대
		 * 경로를 가져온다. System.out.println(path); // 절대 경로가 출력됨 File
		 * fileInSamePackage = new File(path + "conversation.txt"); // path 폴더 내의
		 * conversation.txt 를 가리킨다.
		 */
		
		String fDir = "/C:/Dev/workspace/MavenProject/target/classes/com/cdg/ReadFile/";
		String fName1 = "conversation.txt";
		File f;

		try {
			// File 객체 생성(존재하는 파일)
			f = new File(fDir + fName1);

			// 파일 읽기
			FileReader fileReader = new FileReader(f);
			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
		}
	}
}