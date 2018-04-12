<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML>
<html lang="en">
    <head>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="style.css" />
        <script src="js.js"></script>
        <title> Sign Up | DIY minimalist </title>
    </head>

    <header>
        <ul id="header">
            <a href="/DIYminimalist/showPostsViewer" style="font-size:25px" class="glyphicon glyphicon-home pull-left"></a>
            <a href="login.jsp" class="pull-right"><b>Log In</b></a>
        </ul>
    </header>

    <body background="IMAGE BANK\logsignbg.jpg">                
        <div class="entryform" id="signup">
            <h1>Sign Up</h1>
            <form method="post" action="createMember">
                <div class="inputBox">
                    <label style="color:#03A9F4;">
                        <%
                            String error = (String) request.getAttribute("error");
                            if (error != null) {
                                out.print(error);
                        }%>
                    </label>
                </div>
                    <br/><br/>
                <div class="inputBox">
                    <input type="text" required="" name="name">
                    <label>Name</label>
                </div>
                <div class="inputBox">
                    <input type="text" required="" name="email">
                    <label>E-mail</label>
                </div>
                <div class="inputBox">
                    <input type="text" required="" name="username">
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input type="text" required="" name="gender">
                    <label>Gender</label>
                </div>
                <div class="inputBox">
                    <input type="password" required="" name="password1">
                    <label>Password</label>
                </div>
                <div class="inputBox">
                    <input type="password" required="" name="password2">
                    <label>Re-enter Password</label>
                </div>
                <input type='submit' value="Submit" class="center-block" />
            </form>
        </div>
    </body>

    <footer>
        <ul id="footer">
            getting stuff done - minimalist style&ensp;
            |&ensp;
            all rights reserved © 2018&ensp;
            |&ensp;
            <a href="viewer_privacy.jsp" style="color:black;">Privacy Policy</a>&ensp;
            |&ensp;
            <a href="viewer_terms.jsp" style="color:black;">Terms of Use</a>
        </ul>
    </footer>
</html>
