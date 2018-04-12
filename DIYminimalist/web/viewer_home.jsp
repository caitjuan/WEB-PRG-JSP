<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
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
        <title> Home | DIY minimalist </title>
    </head>

    <header>
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
    </header>
    
    <body background="IMAGE BANK\homebg.png">
        <table class="sidebarcss" style="display:none" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="/DIYminimalist/showPostsViewer">Home</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="viewer_tags.jsp">Tags</a></th><th></th></tr>
            <tr><th><a href="viewer_about.jsp">About Us</a></th></tr>
        </table>
        <article class="main" id="viewhome">
            <%
                ArrayList<String> username = (ArrayList<String>) request.getAttribute("username");
                ArrayList<String> title = (ArrayList<String>) request.getAttribute("title");
                ArrayList<String> desc = (ArrayList<String>) request.getAttribute("desc");
                ArrayList<String> fileName = (ArrayList<String>) request.getAttribute("fileName");
                ArrayList<String> tags = (ArrayList<String>) request.getAttribute("tags");
                
                String tempUser, tempTitle, tempDesc, tempImgSrc1, tempImgSrc2, tempImgSrc3, tempTag;
                int j = 1;
                for (int i = 0; i < username.size(); i+=3) {
                    tempUser = username.get(i);
                    tempTitle = title.get(i);
                    tempDesc = desc.get(i);
                    
                    tempImgSrc1 = "POSTS\\" + fileName.get(i);
                    tempImgSrc2 = "POSTS\\" + fileName.get(i + 1);
                    tempImgSrc3 = "POSTS\\" + fileName.get(i + 2);
            %>

            <div id="post">
                <p class="posttitle"><%= tempTitle %></p>
                <table>
                    <tr>
                        <th><img src="<%= tempImgSrc1 %>"></th>
                        <th><img src="IMAGE BANK\plus.png" class="design"></th>
                        <th><img src="<%= tempImgSrc2 %>"></th>
                        <th><img src="IMAGE BANK\equals.png" class="design"></th>
                        <th><img src="<%= tempImgSrc3 %>"></th>
                    </tr>
                </table>   
                <div class="postinfo">
                    <div> 
                        <a><%= tempUser %></a>
                    </div>
                    <div> 
                        <%= tempDesc %>
                    </div>
                    <div> TAGS:
                        <% 
                            for(int k = 0; k < tags.size(); k++) {
                                tempTag = tags.get(k);
                                if(tempTag.startsWith(Integer.toString(j))) {
                                    tempTag = tempTag.substring(1);
                        %>
                        <a><%= tempTag %></a>
                        <%
                                }
                            }   
                            j++;
                        %>
                    </div>  
                </div>
            </div>
            <% } %>
        </article>
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