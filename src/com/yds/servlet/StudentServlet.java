package com.yds.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yds.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stu")
public class StudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf8");
        Student stu1 = new Student("1", "一号", 18);
        Student stu2 = new Student("2", "二号", 17);
        Student stu3 = new Student("3", "三号", 19);


        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);

        ObjectMapper mapper = new ObjectMapper();
        String msg = mapper.writeValueAsString(stus);
        PrintWriter out = resp.getWriter();
        out.println(msg);
        System.out.println(msg);
        out.close();

    }
}
