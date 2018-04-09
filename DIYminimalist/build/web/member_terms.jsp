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
        <title> Terms of Use | DIY minimalist </title>
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
                <form action="/action_page.php">
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
                <form action="/action_page.php">
                    <input type="text" placeholder="Search..." name="search">
                    <button type="submit" class="glyphicon glyphicon-search"></button>
                </form>
            </div>
        </ul>
        <% } %>
    </header>

    <body background="IMAGE BANK\privacytermsbg.jpg">
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
            <tr><th><a href="profile.jsp">Username</a></th></tr>
            <tr><th><a href="member_home.jsp">Home</a></th></tr>
            <tr><th><a href="createpost.jsp">Create Post</a></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="member_tags.jsp">Tags</a></th><th></th></tr>
            <tr style="border-bottom:1px solid black"><th><a href="settings.jsp">Account Settings</a></th><th></th></tr>
            <tr><th><a href="member_about.jsp">About Us</a></th></tr>
        </table>
        <div class="main">
            <label style="font-size:30px">Terms of Use</label>
            <p>This agreement was written in English (US). To the extent any translated version of this agreement conflicts with the English version, the English version controls.</p>
            <p>Date of Last Revision: February 13, 2018</p>

            <label>Statement of Rights and Responsibilities</label>
            <p>This Statement of Rights and Responsibilities ("Statement," "Terms," or "SRR") derives from the DIY minimalist Principles, and is our terms of service that governs our relationship with users and others who interact with DIY minimalist, as well as DIY minimalist brands, products and services, which we call the ?DIY minimalist Services? or ?Services?. By using or accessing the DIY minimalist Services, you agree to this Statement, as updated from time to time in accordance with Section 13 below. Additionally, you will find resources at the end of this document that help you understand how DIY minimalist works.</p>
            <p>Because DIY minimalist provides a wide range of Services, we may ask you to review and accept supplemental terms that apply to your interaction with a specific app, product, or service. To the extent those supplemental terms conflict with this SRR, the supplemental terms associated with the app, product, or service govern with respect to your use of such app, product or service to the extent of the conflict.</p>

            <label>Privacy</label>
            <p>Your privacy is very important to us. We encourage you to read the Privacy Policy, and to use it to help you make informed decisions. </p>

            <label>Sharing Your Content and Informaton</label>

            <p>You own all of the content and information you post on DIY minimalist, and you can control how it is shared through your privacy and application settings. In addition:</p>
            <ol>
                <li><p>For content that is covered by intellectual property rights, like photos and videos (IP content), you specifically give us the following permission, subject to your privacy and application settings: you grant us a non-exclusive, transferable, sub-licensable, royalty-free, worldwide license to use any IP content that you post on or in connection with DIY minimalist (IP License). This IP License ends when you delete your IP content or your account unless your content has been shared with others, and they have not deleted it.</p></li>
                <li><p>When you delete IP content, it is deleted in a manner similar to emptying the recycle bin on a computer. However, you understand that removed content may persist in backup copies for a reasonable period of time (but will not be available to others).</p></li>
                <li><p>When you use an application, the application may ask for your permission to access your content and information as well as content and information that others have shared with you.  We require applications to respect your privacy, and your agreement with that application will control how the application can use, store, and transfer that content and information.  (To learn more about Platform, including how you can control what information other people may share with applications, read our Data Policy and Platform Page.)</p></li>
                <li><p>When you publish content or information using the Public setting, it means that you are allowing everyone, including people off of DIY minimalist, to access and use that information, and to associate it with you (i.e., your name and profile picture).</p></li>
                <li><p>We always appreciate your feedback or other suggestions about DIY minimalist, but you understand that we may use your feedback or suggestions without any obligation to compensate you for them (just as you have no obligation to offer them).</p></li>
            </ol>

            <label>Safety</label>

            <p>We do our best to keep DIY minimalist safe, but we cannot guarantee it. We need your help to keep DIY minimalist safe, which includes the following commitments by you:</p>
            <ol>
                <li><p>You will not post unauthorized commercial communications (such as spam) on DIY minimalist.</p></li>
                <li><p>You will not collect users' content or information, or otherwise access DIY minimalist, using automated means (such as harvesting bots, robots, spiders, or scrapers) without our prior permission.</p></li>
                <li><p>You will not engage in unlawful multi-level marketing, such as a pyramid scheme, on DIY minimalist.</p></li>
                <li><p>You will not upload viruses or other malicious code.</p></li>
                <li><p>You will not solicit login information or access an account belonging to someone else.</p></li>
                <li><p>You will not bully, intimidate, or harass any user.</p></li>
                <li><p>You will not post content that: is hate speech, threatening, or pornographic; incites violence; or contains nudity or graphic or gratuitous violence.</p></li>
                <li><p>You will not develop or operate a third-party application containing alcohol-related, dating or other mature content (including advertisements) without appropriate age-based restrictions.</p></li>
                <li><p>You will not use DIY minimalist to do anything unlawful, misleading, malicious, or discriminatory.</p></li>
                <li><p>You will not do anything that could disable, overburden, or impair the proper working or appearance of DIY minimalist, such as a denial of service attack or interference with page rendering or other DIY minimalist functionality.</p></li>
                <li><p>You will not facilitate or encourage any violations of this Statement or our policies.</p></li>
            </ol>

            <label>Registration and Account Security</label>

            <p>DIY minimalist users provide their real names and information, and we need your help to keep it that way. Here are some commitments you make to us relating to registering and maintaining the security of your account:</p>
            <ol>
                <li><p>You will not provide any false personal information on DIY minimalist, or create an account for anyone other than yourself without permission.</p></li>
                <li><p>You will not create more than one personal account.</p></li>
                <li><p>If we disable your account, you will not create another one without our permission.</p></li>
                <li><p>You will not use your personal timeline primarily for your own commercial gain, and will use a DIY minimalist Page for such purposes.</p></li>
                <li><p>You will not use DIY minimalist if you are under 13.</p></li>
                <li><p>You will not use DIY minimalist if you are a convicted sex offender.</p></li>
                <li><p>You will keep your contact information accurate and up-to-date.</p></li>
                <li><p>You will not share your password (or in the case of developers, your secret key), let anyone else access your account, or do anything else that might jeopardize the security of your account.</p></li>
                <li><p>You will not transfer your account (including any Page or application you administer) to anyone without first getting our written permission.</p></li>
                <li><p>If you select a username or similar identifier for your account or Page, we reserve the right to remove or reclaim it if we believe it is appropriate (such as when a trademark owner complains about a username that does not closely relate to a user's actual name).</p></li>
            </ol>

            <label>Protecting Other People's Rights</label>

            <p>We respect other people's rights, and expect you to do the same.</p>
            <ol>
                <li><p>You will not post content or take any action on DIY minimalist that infringes or violates someone else's rights or otherwise violates the law.</p></li>
                <li><p>We can remove any content or information you post on DIY minimalist if we believe that it violates this Statement or our policies.</p></li>
                <li><p>If we remove your content for infringing someone else's copyright, and you believe we removed it by mistake, we will provide you with an opportunity to appeal.</p></li>
                <li><p>If you repeatedly infringe other people's intellectual property rights, we will disable your account when appropriate.</p></li>
                <li><p>You will not use our copyrights or Trademarks or any confusingly similar marks, except as expressly permitted by our Brand Usage Guidelines or with our prior written permission.</p></li>
                <li><p>If you collect information from users, you will: obtain their consent, make it clear you (and not DIY minimalist) are the one collecting their information, and post a privacy policy explaining what information you collect and how you will use it.</p></li>
                <li><p>You will not post anyone's identification documents or sensitive financial information on DIY minimalist.</p></li>
            </ol>

            <label>Termination</label>

            <p>If you violate the letter or spirit of this Statement, or otherwise create risk or possible legal exposure for us, we can stop providing all or part of DIY minimalist to you. We will notify you by email or at the next time you attempt to access your account. You may also delete your account or disable your application at any time. In all such cases, this Statement shall terminate, but the following provisions will still apply: 2.2, 2.4, 3-5, 9.3, and 14-18.</p>

        </div>
        <% }%>
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