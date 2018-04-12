package com.hbase_spring.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hbase_spring.service.IHBaseService;

//@Component("hbaseService")

@Service("hbaseService")
public class HBaseServiceImpl implements IHBaseService {

	@Resource(name = "hbaseTemplate")
	private HbaseTemplate hbaseTemplate;

	Connection connection = null;
	public void init(HbaseTemplate htemplate) throws Exception {
		if (connection == null) {
			connection = ConnectionFactory.createConnection(hbaseTemplate.getConfiguration());
		}
		if (this.hbaseTemplate == null) {
			this.hbaseTemplate = htemplate;
		}
	}


	@Override
	public void creatTable(String tableName, String[] family) {
		try {
			init(hbaseTemplate);
			Admin admin;
			admin = connection.getAdmin();

			HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(tableName));
			for (int i = 0; i < family.length; i++) {
				desc.addFamily(new HColumnDescriptor(family[i]));
			}
			if (admin.tableExists(TableName.valueOf(tableName))) {
				System.out.println("table Exists!");
				System.exit(0);
			} else {
				admin.createTable(desc);
				System.out.println("create table Success!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addData(String rowKey, String tableName, String[] column1, String[] value1, String[] column2,
			String[] value2) {
		try {
			Put put = new Put(Bytes.toBytes(rowKey));// 设置rowkey
			Table table;
			table = connection.getTable(TableName.valueOf(tableName));
			// HTabel负责跟记录相关的操作如增删改查等//
			// 获取表
			HColumnDescriptor[] columnFamilies = table.getTableDescriptor() // 获取所有的列族
					.getColumnFamilies();

			for (int i = 0; i < columnFamilies.length; i++) {
				String familyName = columnFamilies[i].getNameAsString(); // 获取列族名
				if (familyName.equals("article")) { // article列族put数据
					for (int j = 0; j < column1.length; j++) {
						put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(column1[j]), Bytes.toBytes(value1[j]));
					}
				}
				if (familyName.equals("author")) { // author列族put数据
					for (int j = 0; j < column2.length; j++) {
						put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(column2[j]), Bytes.toBytes(value2[j]));
					}
				}
			}
			table.put(put);
			System.out.println("add data Success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public void deleteTable(String tableName,String rowName,String familyName) {
		hbaseTemplate.delete(tableName, rowName, familyName);
	}


	@Override
	public Result getResult(String tableName, String rowKey) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void getResultScann(String tableName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getResultScann(String tableName, String start_rowkey, String stop_rowkey) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getResultByColumn(String tableName, String rowKey, String familyName, String columnName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateTable(String tableName, String rowKey, String familyName, String columnName, String value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getResultByVersion(String tableName, String rowKey, String familyName, String columnName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteColumn(String tableName, String rowKey, String falilyName, String columnName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllColumn(String tableName, String rowKey) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteTable(String tableName) {
		// TODO Auto-generated method stub
		
	}

}
