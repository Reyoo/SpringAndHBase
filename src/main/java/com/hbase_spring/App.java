package com.hbase_spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

import com.hbase_spring.service.IHBaseService;

/**
 * Hello world!
 *
 */
public class App {

	/**
	 * 代码没有应该试验 。 仅供参考
	 */
	@Test
	public void test01() {
		String configLocation = "classpath:core/application-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		BeanFactory factory = (BeanFactory) context;
		HbaseTemplate htemplate = (HbaseTemplate) factory.getBean("hbaseTemplate");
		htemplate.getConfiguration();
		System.out.println("==========");
		IHBaseService iHbase = (IHBaseService) factory.getBean("hbaseService");
		String tableName = "mytest";
		String[] family = { "baseinfo" };
		// iHbase.creatTable(tableName, family);
		// iHbase.deleteTable("test1","row1","cf");

	}

}
