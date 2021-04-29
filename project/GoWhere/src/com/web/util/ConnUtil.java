package com.web.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/****
 * �������ݿ����Ӷ���Ĺ�����
 * @author lyf
 */

public class ConnUtil {
	private static DataSource ds;
	//����һ��ÿ���û����е�һ������Connection���������
	private static ThreadLocal<Connection> local = new ThreadLocal<>();	
	static {//��̬����飬�ص㣺ֻ����һ�Ρ�
		try {
			// ������Դ�ļ���Ϣ���ļ�����
			Properties prop = new Properties();
			// ��mysql5.properties�ļ��м�����Ϣ
			prop.load(ConnUtil.class.getResourceAsStream("/mysql5.properties"));
			// ʹ�ü��ص���Ϣ��������Դ����
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * ���һ�����ݿ����Ӷ���ķ���
	 * @return ���Ӷ���
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException {
		Connection conn = local.get();	//��������ȡ�����Ӷ���
		if(conn == null || conn.isClosed()) {
			conn = ds.getConnection();
			local.set(conn);
		}
		return conn;
	}
	
	/***
	 * �ر�����	�����Ӷ���ķ���
	 */
	public static void closeConn() {
		Connection conn = local.get();
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();	//�ͷ�����
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
			local.set(null);
		}
	}
}
