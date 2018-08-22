<%@page import="java.util.ArrayList"%>
<%@page import="dto.CertificateDTO"%>
<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
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
    	ArrayList<CertificateDTO> result = (ArrayList<CertificateDTO>) request.getAttribute("result");
    	int id = user.getId();
    %>
    <div class="wrappMain">
        <aside class="mainAside">
        <%if(100 < id && id < 130){ %>
            <ul class="sideMenu">
                <li>
                    <a href="/certificate/AddPageServlet">生徒登録</a>
                </li>
            </ul>
            <ul class="sideMenu">
                <li>
                    <a href="/certificate/CertificateAddPage">資格登録</a>
                </li>
            </ul>
            <ul class="sideMenu">
                <li>
                    <a href="/certificate/NewCertificateVal">合否登録</a>
                </li>
            </ul>
            <%} %>
            <ul class="sideMenu">
            	<li>
            		<a href="/certificate/ShowResult">一覧表示</a>
            	</li>
            </ul>
        </aside>
        <section>
            <div class="mainContent">
                <div class="contentVal1">
                   <h1 class="contentHeader">
                     資格取得状況一覧
                   </h1>
                   <table class="table">
                   		<tr>
                   			<th>
                   				学生名
                   			</th>
                   			<th>
								資格名
                   			</th>
                   			<th>
                   				受験日
                   			</th>
							<th>
								合否
							</th>
                   		</tr>
						<%for(CertificateDTO r : result){ %>
                   		<tr>
                   			<td>
								<%=r.getUserName() %>
                   			</td>
                   			<td>
								<%=r.getName() %>
                   			</td>
                   			<td>
								<%=r.getDate() %>
                   			</td>
                   			<td>
								<%if(r.isStats()){ %>
								合格
								<%}else{ %>
								不合格
								<%} %>
                   			</td>
                   		</tr>
                   		<%} %>
                   </table>

                </div>
            </div>
        </section>
        <footer class="footerMain">
            <p>Copyright&copy; 2018 Team6Morijyobi</p>
        </footer>
    </div>
</body>

</html>
