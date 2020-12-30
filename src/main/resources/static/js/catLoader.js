function catLoader() {
    window.addEventListener("load", function () {
        const loader = document.querySelector(".loader");
        loader.className += " hidden";
    })
    window.addEventListener("load", function () {
        const loader = document.querySelector(".mobileLoader");
        loader.className += " mobileHidden";
    })
}

