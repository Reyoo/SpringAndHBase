package com.hbase_spring.service;

import org.apache.hadoop.hbase.client.Result;

/**
 * *********************************************************
 * 
 * @Package:
 * @Date: 2018年4月10日16:51:32
 * @Version: default 1.0.0
 * @Class description：
 *        <p/>
 *        *********************************************************
 */
public interface IHBaseService {

	/*
	 * 创建表
	 * 
	 * @tableName 表名
	 * 
	 * @family 列族列表
	 */
	void creatTable(String tableName, String[] family);

	/*
	 * 为表添加数据（适合知道有多少列族的固定表）
	 * 
	 * @rowKey rowKey
	 * 
	 * @tableName 表名
	 * 
	 * @column1 第一个列族列表
	 * 
	 * @value1 第一个列的值的列表
	 * 
	 * @column2 第二个列族列表
	 * 
	 * @value2 第二个列的值的列表
	 */
	void addData(String rowKey, String tableName, String[] column1, String[] value1, String[] column2, String[] value2);

	/*
	 * 根据rowkey查询
	 * 
	 * @rowKey rowKey
	 * 
	 * @tableName 表名
	 */
	Result getResult(String tableName, String rowKey);

	/*
	 * 遍历查询hbase表
	 * 
	 * @tableName 表名
	 */
	void getResultScann(String tableName);

	/*
	 * 遍历查询hbase表
	 * 
	 * @tableName 表名
	 */
	void getResultScann(String tableName, String start_rowkey, String stop_rowkey);

	/*
	 * 查询表中的某一列
	 * 
	 * @tableName 表名
	 * 
	 * @rowKey rowKey
	 */
	void getResultByColumn(String tableName, String rowKey, String familyName, String columnName);

	/*
	 * 更新表中的某一列
	 * 
	 * @tableName 表名
	 * 
	 * @rowKey rowKey
	 * 
	 * @familyName 列族名
	 * 
	 * @columnName 列名
	 * 
	 * @value 更新后的值
	 */
	void updateTable(String tableName, String rowKey, String familyName, String columnName, String value);

	/*
	 * 查询某列数据的多个版本
	 * 
	 * @tableName 表名
	 * 
	 * @rowKey rowKey
	 * 
	 * @familyName 列族名
	 * 
	 * @columnName 列名
	 */
	void getResultByVersion(String tableName, String rowKey, String familyName, String columnName);

	/*
	 * 删除指定的列
	 * 
	 * @tableName 表名
	 * 
	 * @rowKey rowKey
	 * 
	 * @familyName 列族名
	 * 
	 * @columnName 列名
	 */
	void deleteColumn(String tableName, String rowKey, String falilyName, String columnName);

	/*
	 * 删除指定的列
	 * 
	 * @tableName 表名
	 * 
	 * @rowKey rowKey
	 */
	void deleteAllColumn(String tableName, String rowKey);

	/*
	 * 删除表
	 * 
	 * @tableName 表名
	 */
	void deleteTable(String tableName);
	
	//等待删除
	void deleteTable(String string, String string2, String string3);

}
