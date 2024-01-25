package com.example.userapp.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/join")
public class JoinServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=utf-8");//바디, 헤더 순서
        // username=ssar&password=1234&email=ssar@nate.com

//        BufferedReader br = req.getReader();
//
//        String requestBody = "";
//
//        while(true){
//            String line = br.readLine();
//
//            if(line == null) break;
//
//            requestBody = requestBody + line;
//        }
//        System.out.println(requestBody);

        //1. 파싱
        String username = req.getParameter("username"); // 윗 코드를 간편화 시킨거 즉 톰켓 문법으로 해결
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("email = " + email);

        //2. 유효성 검사(100줄 됨)
        if (username.length() < 3 || username.length() > 10) {
            resp.getWriter().println("<h1>username 글자수가 3~10 사이여야 합니다.");
            return;
        }


        //3. DB 연결


        //4.DAO의 insert 메서드를 호출

        //5. 메인 페이지 그리기(비효율적)

        //6. 리다이렉트 (요청한 데이터를 다르게 준다.a를 요청한거를 b로 바꿔서 준다)
        resp.setStatus(302);
        resp.setHeader("Location","/main");
        resp.setHeader("clock","12pm");
    }
}