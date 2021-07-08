package com.yds.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils{

    private static DruidDataSource dataSource;

    public static DataSource getDataSource() {

        try {

            Properties ps = new Properties();

            //��ȡjdbc.properties���������ļ�
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            //�����м�������
            ps.load(is);

            //�������ݿ����ӳ�
            return dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    /**
     * ��ȡ���ݿ����ӳ��е�����
     * @return
     */
    public static Connection getConnection() {

        //�������Ӷ��� ��ֵΪnull (���try��δ��ȡ������ ���Է���null)
        Connection conn = null;

        try {
            //��ȡ���ӳ��е�����
            conn = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //��������
        return conn;

    }


    /**
     * �ر�����  �Ż����ݿ����ӳ�
     * @param conn
     */
    public static void close(Connection conn) {
        //�ж������Ƿ�Ϊ��, ��Ϊ�ղŹر�
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
