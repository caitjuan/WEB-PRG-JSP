<!DOCTYPE HTML>
<html lang="en">
    <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <script src="js.js"></script>
    <title> About Us | DIY minimalist </title>
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
    
    <body background="IMAGE BANK\privacytermsbg.jpg">
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
        
       <div class="main">
           <label style="font-size:30px">About Us</label> 
           
           <p>DIY minimalist is a merge website dedicated to the creation of simple but useful objects. DIY minimalist aims to give users the experience of sharing to ease the lives of many.</p>
           
           <label>Founders of DIY minimalist</label>
           <p>Jaira Bat-og and Caitlienne Juan founded the website on February 6, 2018. This website was created as a partial fulfilment of their course WEB-PRG (Web Application Programming). They never intended to make such a website but, unfortunately, they are forced to. They started this website only a week before the deadline because other courses' deadlines also coincided with it.</p>
           
           <label>Contact Us</label>
           <p>Please don't.</p>
           
        </div>
    </body>
    
    <footer>
        <ul id="footer">
            getting stuff done - minimalist style&ensp;
            |&ensp;
            all rights reserved � 2018&ensp;
            |&ensp;
            <a href="member_privacy.html" style="color:black;">Privacy Policy</a>&ensp;
            |&ensp;
            <a href="member_terms.html" style="color:black;">Terms of Use</a>
        </ul>
    </footer>
</html>  