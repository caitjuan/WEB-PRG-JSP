<!DOCTYPE HTML>
<html lang="en">
    <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <script src="js.js"></script>
    <title> Tags | DIY minimalist </title>
    </head>
    
    <header>
        <ul id="header">
            <button onclick="openSidebar()" class="glyphicon glyphicon-th-list pull-left" id="sidebarbutton"></button>
            <a href="login.html" class="pull-right"><b>Log Out</b></a>
            <div class="search-container">
                <form action="/action_page.php">
                  <input type="text" placeholder="Search..." name="search">
                  <button type="submit" class="glyphicon glyphicon-search"></button>
                </form>
            </div>
        </ul>
    </header>
    
    <body background="IMAGE BANK\tagsbg.jpg">
        <table class="sidebarcss" style="display:none" id="sidebarjs">
            <tr style="border-bottom:1px solid black">
                <th style="width:80%"><p>MENU</p></th>
                <th><button onclick="closeSidebar()" class="glyphicon glyphicon-remove" id="menubutton"></button></th>
            </tr>
            <tr><th><a href="profile.html">Username</a></th></tr>
            <tr><th><a href="member_home.html">Home</a></th></tr>
            <tr><th><a href="createpost.html">Create Post</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="member_tags.html">Tags</a></th><th></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="settings.html">Account Settings</a></th><th></th></tr>
            <tr><th><a href="member_about.html">About Us</a></th></tr>
        </table>
        
        <div class="main" id="tags">
            <label style="font-size:30px;">Tags</label>
            <button class="pull-right" id="createtag" data-toggle="modal" data-target="#myModal" style="font-size: 14px;">+ Create Tag</button>
            <br><br>
            <ul>
                <li>crafts</li>
                <li>sticks</li>
                <li>glue</li>
                <li>felt</li>
                <li>cloth</li>
                <li>toys</li>
                <li>thread</li>
                <li>button</li>
                <li>shoes</li>
            </ul>
        </div>
    </body>
    
    <div class="modal fade" id="myModal" role="dialog" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class ="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">CREATE TAG</h4>
                </div>
                <div class="modal-body">
                    <form>
                        Tag name: <input type="text" name="tag">
                    </form>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" data-dismiss="modal" value="Add">
                </div>
            </div>
        </div>
    </div>
    <footer>
        <ul id="footer">
            getting stuff done - minimalist style&ensp;
            |&ensp;
            all rights reserved © 2018&ensp;
            |&ensp;
            <a href="member_privacy.html" style="color:black;">Privacy Policy</a>&ensp;
            |&ensp;
            <a href="member_terms.html" style="color:black;">Terms of Use</a>
        </ul>
    </footer>
</html>  