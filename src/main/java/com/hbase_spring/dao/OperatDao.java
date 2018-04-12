package com.hbase_spring.dao;

import java.util.List;

import org.apache.hadoop.hbase.client.Scan;
import org.springframework.data.hadoop.hbase.ResultsExtractor;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;

/**
 * 原版HbaseTemplate封装 对 hbase 的操作。这里暂时不用了
 * 
 * @author qisun
 */

public interface OperatDao {
	// 删除给定表中的单个单元格。
	// Deletes a single cell in the given table.
	void delete(String tableName, String rowName, String familyName, String qualifier);

	// Deletes a single qualifier in the given table and family.
	// 刪除指定表的列簇中列
	void delete(String tableName, String rowName, String familyName);

	// 对指定的表处理资源管理执行给定的操作
	<T> T execute(String tableName, TableCallback<T> action);

	// Scans the target table, using the given family. The content is processed by
	// the given action typically returning a domain object or collection of domain
	// objects.
	<T> T find(String tableName, String family, ResultsExtractor<T> action);

	// Scans the target table using the given Scan object.
	// 使用给定的扫描对象扫描目标表。
	<T> T find(String tableName, Scan scan, ResultsExtractor<T> action);

	// <T> T find(String tableName, Scan scan, ResultsExtractor<T> action);
	// Scans the target table using the given Scan object.
	// 使用给定的扫描对象扫描目标表。
	<T> List<T> find(String tableName, String family, RowMapper<T> action);
	// Scans the target table using the given Scan object. Suitable for maximum
	// control over the scanning process. The content is processed row by row by the
	// given action, returning a list of domain objects.

	<T> List<T> find(String tableName, Scan scan, RowMapper<T> action);

	// Scans the target table, using the given column family and qualifier.
	// 扫描表,用指定的列簇和限定符
	<T> T find(String tableName, String family, String qualifier, ResultsExtractor<T> action);

	// Scans the target table, using the given column family.
	// 使用给定的列簇扫描表
	<T> List<T> find(String tableName, String family, String qualifier, RowMapper<T> action);

	// Gets an individual row from the given table.
	// 从给定的表中获取一行
	<T> T get(String tableName, String rowName, RowMapper<T> mapper);

	// Gets an individual row from the given table.
	// 从给定的表中获取一行
	<T> T get(String tableName, String rowName, String familyName, RowMapper<T> mapper);

	// Gets an individual row from the given table.
	// 从给定的表中获取一行
	<T> T get(String tableName, String rowName, String familyName, String qualifier, RowMapper<T> mapper);

	// Puts a single value in to the given table.
	// 将单个值存入指定表
	void put(String tableName, String rowName, String familyName, String qualifier, byte[] value);

	// Sets the auto flush.
	// 自动刷新
	void setAutoFlush(boolean autoFlush);
}
