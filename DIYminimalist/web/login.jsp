<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
    <head>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         
		<link rel="stylesheet" type="text/css" href="style.css" />
		<script src="js.js"></script>
        <title> Log In | DIY minimalist </title>
    </head>

    <header>
        <ul id="header">
            <a href="viewer_home.jsp" style="font-size:25px" class="glyphicon glyphicon-home pull-left"></a>
            <a href="signup.jsp" class="pull-right"><b>Sign Up</b></a>
        </ul>
    </header>
    
    <body background="IMAGE BANK\logsignbg.jpg">
        <div class="entryform">
            <h1>Login</h1>
            <form name="loginform" onsubmit="return checkForm()" method="post">
                <div class="inputBox">
                    <input type="text" id="username" required="">
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input type="password" id="password" required="">
                    <label>Password</label>
                </div>
                <input type="submit" value="Submit" class="center-block">
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