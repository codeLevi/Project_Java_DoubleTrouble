function showOrHideDiv() {
    var v = document.getElementById("form_create_div");
    var but = document.getElementById("butadd");
    if (v.style.display === "none") {
        v.style.display = "block";
        but.textContent = "-";
    } else {
        v.style.display = "none";
        but.textContent = "+";
    }
}

function editImobil(...imobilAttributes){
    var form = document.getElementById("form_update_div");
    const formElements = document.getElementById("form_update").elements;

    if(form.style.display === "none"){
        form.style.display = "block";
    }

    for(let i = 0; i < formElements.length; i++){
    console.log(imobilAttributes[i]);
        formElements[i].value = imobilAttributes[i];
    }

}