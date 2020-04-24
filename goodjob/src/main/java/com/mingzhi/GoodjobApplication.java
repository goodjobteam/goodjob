package com.mingzhi;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  
 * @author mingzhi
 * @date 2020年4月2日
 * @target：goodJob
 *
 */
//@RestController
@SpringBootApplication
public class GoodjobApplication {
	
    private static final Logger LOG = LoggerFactory.getLogger(GoodjobApplication.class);
  
// static String name ="明智"; 理解final修饰的变量-默认String是被final修饰的。所以如果初始定义final后再次修改实际上只是新生成了一个String
// 原来的name被垃圾回收。 如果加上final 修饰，则在类中修饰时被提示不能修改。
    static String name ="明智";
  
    
    static {
// 静态方法和变量相当于类变量，可以通过对象或者类名点调用。而普通方法只能对象调用。
    	System.out.println(GoodjobApplication.name+"这是对静态方法区的尝试");
    }
    
    //通过类反射获取其他类实现调用
//   @Autowired
//   private static  WiserMain wiserMain;
  
  /**运行当前包就执行当前包的启动类。保障该类下的方法好用。
            一个项目只需要一个启动类。且该启动类的位置层级要大于所有包的层级即可保障所有包服务可访问。
	由于本环境有很多配置文件。IDE环境启动会自动适用yml配置，但打包部署时候需要手动指定适用哪个配置文件。
	命令： java -jar -Dspring.profiles.active=line 打包文件  或者实际打包中按照application.yml文件设定的为准
	**/
	public static void main(String[] args) {
		SpringApplication.run(GoodjobApplication.class, args);
		LOG.info("==============this is info级别日志=============");
		LOG.debug("==============我是 debug级别日志============");
		System.out.println("hello world 项目已经启动完成咯");
		
		TestMethod();
		
	}
	
	public static void TestMethod() {
		int [] arr= {1,3,5,15,33};
		System.out.println(arr.length);
		
//		TreeSet和TreeMap的底层基于平衡二叉树实现
		TreeSet tset=new TreeSet();
		tset.add(1);
		System.out.println(tset);
		TreeMap<Integer,String> tmap= new TreeMap<Integer,String>();
		tmap.put(1, "one");
		tmap.put(2,"two");
		System.out.println(tmap.get(1));
		
		
	}
	
//	run方法也是继承自ApplicationContext的,通过其getBean的方法获取Person的实例
//	public static void main(String[] args) {
//		ApplicationContext ctx=SpringApplication.run(GoodjobApplication.class, args);
////		getBean方法的代码逻辑： 转换beanName  - 从缓存（工厂）中加载实例-实例化Bean -检测parentBeanFactory- 初始化依赖的Bean - 创建Bean 并返回。
//		Person person =ctx.getBean(Person.class);
//		 System.out.println("Name is "+person.getName());
//		 person.call(); 
//	}
//	
	
//  调用配置文件的配置或者使用@value注解方式	
//	 public static void main(String[] args) {
//	        ConfigurableApplicationContext ctx =  SpringApplication.run(SpringcloudApplication.class, args);
//
//	        System.out.println(ctx.getEnvironment().getProperty("test.port"));
//	    }
//	
	
	
	
	
	
	
// TODO:Springboot与easyUI或者layUI界面实现简单的后台系统
// TODO：SpringCloud
	
//	TODO:调用配置文件
	
//  TODO:Mybatis使用
	
//	TODO:调用其他类文件分别实现 数组，链表  ，等操作。

//	TODO：jedis 与redis的练习
	
}
