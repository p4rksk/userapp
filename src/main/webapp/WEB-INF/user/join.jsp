<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    response.setHeader("contentType","text/html;charset=UTF-8");

    //1. 파싱
    String username = request.getParameter("username"); // 윗 코드를 간편화 시킨거 즉 톰켓 문법으로 해결
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    System.out.println("username = " + username);
    System.out.println("password = " + password);
    System.out.println("email = " + email);

    //2. 유효성 검사(100줄 됨)
    if (username.length() < 3 || username.length() > 10) {
        response.getWriter().println("<h1>username 글자수가 3~10 사이여야 합니다.");
        return;
    }


    //3. DB 연결


    //4.DAO의 insert 메서드를 호출

    //5. 메인 페이지 그리기(비효율적)

    //6. 리다이렉트 (요청한 데이터를 다르게 준다.a를 요청한거를 b로 바꿔서 준다)
    response.setStatus(302);
    response.setHeader("Location","/board/main.jsp");
    response.setHeader("clock","12pm");
%>