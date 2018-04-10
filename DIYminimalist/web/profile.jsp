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
    <title> Ugandan Knuckles | DIY minimalist </title>
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
                  <input type="submit" class="glyphicon glyphicon-search" />
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
                  <input type="submit" class="glyphicon glyphicon-search" />
                </form>
            </div>
        </ul>
        <% } %>
    </header>
    
    <body background="IMAGE BANK\homebg.png">
        <%
            if ((session.getAttribute("userId") == null) || (session.getAttribute("userId") == "")) {
        %>
        <table class="sidebarcss" style="display:none" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="viewer_home.jsp">Home</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="viewer_tags.jsp">Tags</a></th><th></th></tr>
            <tr><th><a href="viewer_about.jsp">About Us</a></th></tr>
        </table>
        
        <article class="main" id="viewhome">
            <label>You are not logged in</label>
        </article>
        <% } else { %>
        <table class="sidebarcss" style="display:none;margin-top:-1" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="profile.jsp"><%= (session.getAttribute("userId")) %></a></th></tr>
            <tr><th><a href="member_home.jsp">Home</a></th></tr>
            <tr><th><a href="createpost.jsp">Create Post</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="member_tags.jsp">Tags</a></th><th></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="settings.jsp">Account Settings</a></th><th></th></tr>
            <tr><th><a href="member_about.jsp">About Us</a></th></tr>
        </table>
        
        <form class="profileform">
            <input type="text" name="name" id="name" value="Ugandan Knuckles" readonly><br>
            <input type="text" name="username" id="uname" value="@ugandancluckcluckcluck" readonly><br>
            <input type="text" name="description" id="desc" value="I am de wae. It's ice ice water, baby." readonly>
        </form>
        
        <article class="main" id="viewhome">
            <div id="post">
                <a href="editpost.jsp"><button class="glyphicon glyphicon-edit pull-right" id="editbutton"></button></a>
                <button class="glyphicon glyphicon-trash pull-right" id="deletebutton" data-toggle="modal" data-target="#myModal"></button>
                <p class="posttitle">Felt Toys</p>
                <table>
                    <tr>
                        <th><img src="POSTS\felt cloth.jpg"></th>
                        <th><img src="IMAGE BANK\plus.png" class="design"></th>
                        <th><img src="POSTS\thread.jpg"></th>
                        <th><img src="IMAGE BANK\equals.png" class="design"></th>
                        <th><img src="POSTS\felt toys.jpg"></th>
                    </tr>
                </table>
                <div class="postinfo">
                    <div> 
                        <a>@ugandancluckcluckcluck</a>
                    </div>
                    <div> 
                        Give love and make felt toys ?
                    </div>
                    <div> TAGS:
                        <a>crafts</a>
                        <a>felt</a>
                        <a>thread</a>
                        <a>toys</a>
                        <a>cloth</a>
                    </div>  
                </div>
            </div>
            <input type="submit" value="View More" class="center-block">
        </article>   
        
        <div class="modal fade" id="myModal" role="dialog" tabindex="-1">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class ="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">DELETE POST</h4>
                    </div>
                    <div class="modal-body">
                        <p>WARNING! This post will be deleted permanently. Proceed?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Yes</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <% } %>
    
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