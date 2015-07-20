package com.cdg.MavenProject;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        /*String path = AppTest.class.getResource("").getPath();  // 현재 클래스의 절대 경로를 가져온다.
        System.out.println(path); 								// 절대 경로가 출력됨
        File fileInSamePackage = new File(path + "book.txt");   // path 폴더 내의 book.txt 를 가리킨다.
         */
        
        String path = AppTest.class.getResource("").getPath();  // 현재 클래스의 절대 경로를 가져온다.
        System.out.println(path); 								// 절대 경로가 출력됨
        File fileInSamePackage = new File(path + "conversation.txt");   // path 폴더 내의 book.txt 를 가리킨다.
        }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        
    }
}
