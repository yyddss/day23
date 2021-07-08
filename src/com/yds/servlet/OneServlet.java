package com.yds.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("text/html;charset=utf8");

        StuService ss = new StuService();

        List<User> all = ss.getAll();

        ObjectMapper m = new ObjectMapper();

        String s = m.writeValueAsString(all);

        PrintWriter out = resp.getWriter();

        out.println(s);

        out.close();

    }
}
