<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メインページ</title>
    <link rel="stylesheet" href="css/style.css" />
</head>

<body>
    <div class="bgColor">
        <div class="loginSize">
            <div>
                <h2>WELCOME TO ○○○学校</h2>
            </div>
            <form action="/certificate/CheckServlet">
                <div>
                    <input type="text" placeholder="学籍番号or教師ID" name="id">
                </div>
                <div>
                    <input type="password" placeholder="PASSWORD" name="pw">
                </div>
                <div>
                    <p>学籍番号や教師IDがない場合は、担当の方に連絡してください。</p>
                </div>
                <div>
                    <input type="submit" value="LOGIN">
                </div>
            </form>
        </div>
    </div>
</body>
</html>