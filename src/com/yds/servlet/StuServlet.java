package com.yds.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yds.bean.Student;
import com.yds.bean.User;
import com.yds.service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/student")
public class StuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决请求 响应乱码问题
        req.setCharacterEncoding("utf8");
        resp.setContentType("text/html;charset=utf8");

        //创建业务逻辑层对象
        StuService ss = new StuService();

        //执行查询所有user的方法 返回user集合
        List<User> users =  ss.getAll();

        //创建Json的ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();

        //将users集合转成json字符串
        String msg = mapper.writeValueAsString(users);

        //输出到前端页面
        PrintWriter out = resp.getWriter();
        out.println(msg);

        //关流
        out.close();
    }
}
