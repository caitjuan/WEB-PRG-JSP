function closeSidebar() {
    document.getElementById("sidebarjs").style.display = "none";
}

function openSidebar() {
    document.getElementById("sidebarjs").style.display = "block";
}

function checkForm() {
    var usernameString = document.forms["loginform"]["username"].value;
    var passwordString = document.forms["loginform"]["password"].value;
    
    if(usernameString === "ugandancluckcluckcluck"){
        if(passwordString === "admin123"){
            window.location = "member_home.jsp";
            return false;
        }
    }
    
    else {
        alert("Incorrect username and/or password");
        return false;
    }
}