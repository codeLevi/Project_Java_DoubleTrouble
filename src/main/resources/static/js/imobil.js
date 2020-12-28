
function editImobil(...imobilAttributes){
    var form = document.getElementById("form_update_div");
    var formCreate = document.getElementById("form_create_div");

    formCreate.style.display ="none";
    const formElements = document.getElementById("form_update").elements;

    if(form.style.display === "none"){
        form.style.display = "block";
    }

    for(let i = 0; i < formElements.length; i++){
    console.log(imobilAttributes[i]);
        formElements[i].value = imobilAttributes[i];
    }

}