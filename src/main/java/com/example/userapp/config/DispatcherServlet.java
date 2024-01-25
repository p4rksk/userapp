package com.example.userapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// FromtController
@WebServlet("*.do") // ~.do 하면 여기로 다 오는 것
public class DispatcherServlet extends HttpServlet {

    // /join-form.do
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 공통로직
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        System.out.println("common logic~~~~~");

        // 2. 분기
        String uri = req.getRequestURI();

        if (uri.equals("/join-form.do")) {
            //resp.sendRedirect("/WEB-INF/user/join-form.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join-form.jsp").forward(req, resp); // 최초에 들고있는 req, resp를 들고 재요청을 한다. 강제성을 주기위해 하는 것이다. WEB-INF가 보안 폴더 이기 때문이다.
        } else if (uri.equals("/join.do")) {
            //resp.sendRedirect("/WEB-INF/user/join.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
        } else if (uri.equals("/main.do")) {
            //resp.sendRedirect("/WEB-INF/board/main.jsp");
            req.getRequestDispatcher("/WEB-INF/board/main.jsp").forward(req, resp);
        } else {
            resp.setStatus(404);
            resp.getWriter().println("잘못된 페이지를 요청하셨습니다.");
        }
    }
}