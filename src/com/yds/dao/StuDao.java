package com.yds.dao;

import com.yds.bean.User;
import com.yds.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StuDao {
    public List<User> getAll() {

        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from user";

        List<User> users = null;
        try {
            users = qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }
}
