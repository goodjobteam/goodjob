package com.mingzhi.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileio {
//参考javaSE 10
	public static void main(String[] args) throws IOException {
			// 核心代码区域：创建文件输入流对象
		   FileWriter  fw = new FileWriter("a.txt");
		    //写入数据 并刷新数据   
		    fw.write("hello ");
		    //在windos系统中\r\n代表的是换行
		    fw.write("\r\n");
		    fw.write("world");
		    //fw.flush(); 刷新文件流缓冲区
		     //fw.close();  释放资源
		
		
		    //读取文件输出到控制台
//		    readfile();
		

	        
	
	}

	private static void readfile() throws IOException {
			//指定文件的位置
			String filePath = "D:/test.txt";
			//String filePath = "..\\..\\test.txt";
	        FileInputStream fin = new FileInputStream(filePath);
	        InputStreamReader reader = new InputStreamReader(fin);
	        BufferedReader buffReader = new BufferedReader(reader);
	        String strTmp = "";
	        while((strTmp = buffReader.readLine())!=null){
	            System.out.println(strTmp);
	        }
	       
		
	}
	
	
}
