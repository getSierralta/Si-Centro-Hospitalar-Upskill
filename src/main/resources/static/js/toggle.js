//----------------------Toggle menu

let toggleNavStatus = true; 

let toggleNav = function(){
    let getSidebar = document.querySelector(".nav-sidebar");
    let getSidebarUl = document.querySelector(".nav-sidebar ul");
    let getSidebarTitle = document.querySelector(".nav-sidebar span");
    let getSidebarLinks = document.querySelectorAll(".nav-sidebar a");
    let getSidebarImgs = document.querySelectorAll(".nav-sidebar img");
    


    if(toggleNavStatus === false){
        getSidebarUl.style.visibility = "visible";
        getSidebar.style.width = "272px";
        getSidebarTitle.style.opacity = "0.5";
        getSidebarLinks.forEach(element => {
            element.style.opacity = "1";
        });
        getSidebarImgs.forEach(element => {
            element.style.opacity = "1";
        });

        toggleNavStatus = true;
    }else if(toggleNavStatus === true){
        getSidebar.style.width = "50px";
        getSidebarTitle.style.opacity = "0";
        getSidebarLinks.forEach(element => {
            element.style.opacity = "0";
        });
        getSidebarImgs.forEach(element => {
            element.style.opacity = "0";
        });
        
        getSidebarUl.style.visibility = "hidden";

        toggleNavStatus = false;
    }
}