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
    <script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
    <script>tinymce.init({ selector:'textarea' });</script>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <script src="js.js"></script>
    <title> Create Post | DIY minimalist </title>
    </head>

    <header>
        <%
            if ((session.getAttribute("userId") == null) || (session.getAttribute("userId") == "")) {
        %>
        <ul id="header">
            <button onclick="openSidebar()" class="glyphicon glyphicon-th-list pull-left" id="sidebarbutton"></button>
            <a href="login.jsp" class="pull-right"><b>Log In</b></a>
			<a href="signup.jsp" class="pull-right"><b>Sign Up</b></a>
            <div class="search-container">
                <form action="search" method="post">
                  <input type="text" placeholder="Search..." name="search">
                  <button type="submit" class="glyphicon glyphicon-search"></button>
                </form>
            </div>
        </ul>
        <% } else { %>
        <ul id="header">
            <button onclick="openSidebar()" class="glyphicon glyphicon-th-list pull-left" id="sidebarbutton"></button>
            <a href="/DIYminimalist/logOut" class="pull-right"><b>Log Out</b></a>
            <div class="search-container">
                <form action="search" method="post">
                  <input type="text" placeholder="Search..." name="search">
                  <button type="submit" class="glyphicon glyphicon-search"></button>
                </form>
            </div>
        </ul>
        <% } %>
    </header>
    
    <body background="IMAGE BANK\createbg.png">
        <%
            if ((session.getAttribute("userId") == null) || (session.getAttribute("userId") == "")) {
        %>
        <table class="sidebarcss" style="display:none" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="/DIYminimalist/showPostsViewer">Home</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="/DIYminimalist/showTagsViewer">Tags</a></th><th></th></tr>
            <tr><th><a href="viewer_about.jsp">About Us</a></th></tr>
        </table>
        
        <article class="main" id="viewhome">
            <label>You are not logged in</label>
        </article>
        <% } else { %>
        <table class="sidebarcss" style="display:none" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="profile.jsp"><%= (session.getAttribute("userId")) %></a></th></tr>
            <tr><th><a href="/DIYminimalist/showPostsMember">Home</a></th></tr>
            <tr><th><a href="createpost.jsp">Create Post</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="/DIYminimalist/showTagsMember">Tags</a></th><th></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="settings.jsp">Account Settings</a></th><th></th></tr>
            <tr><th><a href="member_about.jsp">About Us</a></th></tr>
        </table>
        
        <div class="main">
            <label style="font-size:30px">CREATE POST</label>
            <form action="createPost" class="createpostform" method="post">
                <label>Title:</label>
                <input type="text" name="postitle" id="title" placeholder="Title"><br><br>
                
                <label>Short description:</label>
                <textarea name="postdesc" id="desc" placeholder="Enter description..."></textarea><br><br>
                
                <label>Tags:</label>
                <input type="text" name="tag" id="tags" placeholder="Enter tags..."><br>
                <label style="font-size:14px;font-weight:lighter">Separate the tags with commas (,)</label>
                
                <input type="hidden" name="userId" value="<%= (session.getAttribute("userId")) %>">
                
                <input type='submit' value="Add Photos" class="center-block" id="create"/>
          </form>
        </div>
        <% } %>
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