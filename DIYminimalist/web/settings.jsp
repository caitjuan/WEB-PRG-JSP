<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
    <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	<link rel="stylesheet" type="text/css" href="style.css" />
    <script src="js.js"></script>
    <title> Home | DIY minimalist </title>
    </head>

    <header>
        <ul id="header">
            <button onclick="openSidebar()" class="glyphicon glyphicon-th-list pull-left" id="sidebarbutton"></button>
            <a href="#" class="pull-right"><b>Log Out</b></a>
            <div class="search-container">
                <form action="/action_page.php">
                  <input type="text" placeholder="Search..." name="search">
                  <button type="submit" class="glyphicon glyphicon-search"></button>
                </form>
            </div>
        </ul>
    </header>
    
    <body background="IMAGE BANK\settingbg.jpg">
        <table class="sidebarcss" style="display:none;margin-top:0" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="profile.jsp">Username</a></th></tr>
            <tr><th><a href="member_home.jsp">Home</a></th></tr>
            <tr><th><a href="createpost.jsp">Create Post</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="member_tags.jsp">Tags</a></th><th></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="settings.jsp">Account Settings</a></th><th></th></tr>
            <tr><th><a href="member_about.html">About Us</a></th></tr>
        </table>
        <div class="entryform">
            <h1>Change Account Settings</h1>
            <form>
                <div class="inputBox">
                    <input type="text" required="">
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input type="text" required="">
                    <label>Description</label>
                </div>
                <div class="inputBox">
                    <input type="password" required="">
                    <label>New Password</label>
                </div>
                <div class="inputBox">
                    <input type="password" required="">
                    <label>Retype Password</label>
                </div>
                <div class="inputBox">
                    <input type="password" required="">
                    <label>Enter Old Password to Confirm</label>
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
            <a href="member_privacy.jsp" style="color:black;">Privacy Policy</a>&ensp;
            |&ensp;
            <a href="member_terms.jsp" style="color:black;">Terms of Use</a>
        </ul>
    </footer>
</html>