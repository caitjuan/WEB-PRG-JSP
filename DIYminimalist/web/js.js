function closeSidebar() {
    document.getElementById("sidebarjs").style.display = "none";
}

function openSidebar() {
    document.getElementById("sidebarjs").style.display = "block";
}

function getTags() {
    var xhttp;
    if (window.XMLHttpRequest) {
        // code for modern browsers
        xhttp = new XMLHttpRequest();
    } else {
        // code for old IE browsers
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //param 1 - method: GET or POST
    //param 2 - servlet to talk to
    //param 3 - asynchronus: for now always true
    xhttp.open("POST", "createTag", true);

    //indicates the header used
    xhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");

    var tags = document.forms["tagform"]["tag"].value;
    
    xhttp.send( "tags=" + tags);
}
