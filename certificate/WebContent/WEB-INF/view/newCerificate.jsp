<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Shrikhand" rel="stylesheet">
</head>
<body class="nonmargin">
    <div class="wrappNavi">
        <header class="head">
            <a href="/certificate/HomeServlet"></a>
            <nav class="navi">
            </nav>
        </header>
    </div>
    <!--ヘッダーのした-->
    <%
    	request.setCharacterEncoding("UTF-8");
    	UserDTO user = (UserDTO) session.getAttribute("user");
    	int id = user.getId();
    %>
    <div class="wrappMain">
        <aside class="mainAside">
            <ul class="sideMenu">
                <li>
                    <a href="/certificate/AddPageServlet">生徒登録</a>
                </li>
            </ul>
            <%if(100 < id && id < 130){ %>
            <ul class="sideMenu">
                <li>
                    <a href="#">bbb</a>
                </li>
            </ul>
            <ul class="sideMenu">
                <li>
                    <a href="#">ccc</a>
                </li>
            </ul>
            <%} %>
        </aside>
        <section>
            <div class="mainContent">
                <div class="contentVal1">
                   <h1 class="contentHeader">
                      資格登録
                   </h1>
                   <form action="#">
                   		<input type="text" name="certificate" />
                   		<input type="submit">
                   </form>
                </div>
            </div>
        </section>
        <footer class="footerMain">
            <p>Copyright&copy; 2018 Team6Morijyobi</p>
        </footer>
    </div>
</body>

</html>
