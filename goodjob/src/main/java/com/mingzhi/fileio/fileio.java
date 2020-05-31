package com.mingzhi.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author mingzhi
 * 掌握读文件的读写操作。
 */
public class fileio {
//参考javaSE 10
	public static void main(String[] args) throws Exception {
//======低效率的不带bufferd的读取操作方式=========
//文件流写的读操作
//		 FileReader();

//从硬盘读取文件输出到控制台
//		 readfile();

//从硬盘读数据的两种方式1.一次读一个字符。		    
//		 readerchar();
//从硬盘一次读一个字符数组
//		readchararray();
		
//============高效率的带bufferd字符读取操作方式=============		
// Buffered way
		bufferReadAndWrite();
		
		
		
	}

	private static void bufferReadAndWrite() throws IOException {
			//1.读取该文件的内容，存储到一个字符串中。
			BufferedReader b = new BufferedReader(new FileReader("/Users/mingzhi/Desktop/a.txt"));
			String line=b.readLine();
			b.close();
			 // 2.把字符串转为字符数组。
			char [] chs=line.toCharArray();
			 //	3.对字符数组进行排序。或者不处理直接拷贝。
			Arrays.sort(chs);
			 // 4.把排序后的字符数组转为字符串。
			String s= new String(chs);
			 // 5.把字符串写入2.txt
			BufferedWriter br= new BufferedWriter(new FileWriter("/Users/mingzhi/Desktop/c.txt"));
			br.write(s);
			/*br.newLine();
			br.newLine();*/
			br.flush();
			br.close();
	
}

	@SuppressWarnings("unused")
	private static void readchararray() throws IOException {

		FileReader fr = new FileReader("/Users/mingzhi/Desktop/a.txt");
		// int read(char [] cbuf); 一次读取一个字符数组的数据，返回的是实际读取的字符个数。
		char[] chas = new char[1024]; // 这里可以是1024及其倍数
		int len;
		// 循环表达
		while ((len = fr.read(chas)) != -1) {
			System.out.print(new String(chas, 0, len));
		}
		fr.close();

	}

	@SuppressWarnings("unused")
	private static void readerchar() throws Exception {
//		边读边写。
		FileReader fr = new FileReader("/Users/mingzhi/Desktop/a.txt");
		FileWriter fw = new FileWriter("/Users/mingzhi/Desktop/b.txt");
		// 这里定义的是int型，因为要进行数值的对比。
		int ch;
		while ((ch = fr.read()) != -1) {
			fw.write(ch);
		}
		fr.close();
		fw.close();

	}

	@SuppressWarnings("unused")
	private static void FileReader() throws Exception {
		// 核心代码区域：创建文件输入流对象
		FileWriter fw = new FileWriter("/Users/mingzhi/Desktop/a.txt");
		// 写入数据 并刷新数据
		fw.write("hello ");
		// 在windos系统中\r\n代表的是换行
		fw.write("\r\n");
		fw.write("world");
//刷新流才能存储到文件内容。理解为内存刷到硬盘的操作。
		fw.flush(); // 刷新文件流缓冲区
		fw.close(); // 释放资源

	}

	@SuppressWarnings("unused")
	private static void readfile() throws IOException {
		// 指定文件的位置
		String filePath = "D:/test.txt";
		// String filePath = "..\\..\\test.txt";
		FileInputStream fin = new FileInputStream(filePath);
		InputStreamReader reader = new InputStreamReader(fin);
		BufferedReader buffReader = new BufferedReader(reader);
		String strTmp = "";
		while ((strTmp = buffReader.readLine()) != null) {
			System.out.println(strTmp);
		}

	}

}
