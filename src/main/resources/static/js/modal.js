// Get the modal
var modal = document.getElementById("myModal");
var createForm = document.getElementById("form-create");
var updateForm = document.getElementById("form-update");

// Get the button that opens the modal
var btn = document.getElementsByClassName("myBtn")[2];
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
      updateForm.style.display = "none";
      createForm.style.display = "block";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {

  if (event.target == modal) {
      updateForm.style.display = "none";
      createForm.style.display = "block";
    modal.style.display = "none";

  }
}

function editImobil(...imobilAttributes){
    var formUpdate = document.getElementById("form-update");
    var formCreate = document.getElementById("form-create");

    formCreate.style.display ="none";
    const formElements = formUpdate.elements;

    modal.style.display = "block";
    if(formUpdate.style.display === "none"){
        formCreate.style.display = "none";
        formUpdate.style.display = "block";
    }

    for(let i = 0; i < formElements.length; i++){
    console.log(imobilAttributes[i]);
        formElements[i].value = imobilAttributes[i];
    }

}