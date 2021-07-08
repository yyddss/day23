package com.yds.service;

import com.yds.bean.User;
import com.yds.dao.StuDao;

import java.util.List;

public class StuService {
    public List<User> getAll() {
        StuDao sd = new StuDao();
        return sd.getAll();
    }
}
