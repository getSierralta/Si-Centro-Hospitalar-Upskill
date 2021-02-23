const img = document.querySelector(".index");
//this most be better

document.querySelector(".left-arrow").addEventListener('click', () =>{

    /*we get all the style of the element so we can
            disect it*/

    let getElementCss = window.getComputedStyle(img);
    let getFullImgUrl = getElementCss.getPropertyValue("background-image");
    let getImageUrlPos = getFullImgUrl.split("/img/img");
    let setNewImgUrl = getImageUrlPos[1].replace('img', '');
    setNewImgUrl = setNewImgUrl.replace('.jpg")', '');

    newImg = parseInt(setNewImgUrl) - 1;

    img.style.animationName = "none";
    if(newImg < 1){
        img.style.backgroundImage = "url('../img/img"+3+".jpg')";
    }else{
        img.style.backgroundImage = "url('../img/img"+newImg+".jpg')";
    }

});

document.querySelector(".right-arrow").addEventListener('click', () =>{
    /*we get all the style of the element so we can
            disect it*/

    let getElementCss = window.getComputedStyle(img);
    let getFullImgUrl = getElementCss.getPropertyValue("background-image");
    let getImageUrlPos = getFullImgUrl.split("/img/img");
    let setNewImgUrl = getImageUrlPos[1].replace('img', '');
    setNewImgUrl = setNewImgUrl.replace('.jpg")', '');

    newImg = parseInt(setNewImgUrl) + 1;

    img.style.animationName = "none";
    if(newImg > 3){
        img.style.backgroundImage = "url('../img/img"+1+".jpg')";
    }else{
        img.style.backgroundImage = "url('../img/img"+newImg+".jpg')";
    }

});