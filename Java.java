// Select form and table
let form = document.querySelector("form");
let table = document.querySelector("table");
let declaration = document.querySelector(".declaration input");

// Add success message element
let successMsg = document.createElement("p");
successMsg.style.color = "green";
successMsg.style.textAlign = "center";
form.appendChild(successMsg);

form.addEventListener("submit", function(e){
    e.preventDefault(); // Prevent page reload

    // Get input values
    let name = document.querySelector('input[type="text"]');
    let email = document.querySelector('input[type="email"]');
    let phone = document.querySelectorAll('input[type="text"]')[1];
    let gender = document.querySelector('input[name="gender"]:checked');
    let department = document.querySelectorAll("select")[0];
    let year = document.querySelectorAll("select")[1];
    let events = document.querySelectorAll('fieldset:nth-of-type(3) input[type="checkbox"]:checked');

    // Reset borders
    name.style.border = "";
    email.style.border = "";
    phone.style.border = "";

    // Validation
    if(name.value === ""){
        alert("Please enter your name");
        name.style.border = "2px solid red";
        return;
    } else {
        name.style.border = "2px solid green";
    }

    if(email.value === "" || !email.value.includes("@")){
        alert("Please enter valid email");
        email.style.border = "2px solid red";
        return;
    } else {
        email.style.border = "2px solid green";
    }

    if(phone.value === "" || phone.value.length < 10){
        alert("Enter valid phone number");
        phone.style.border = "2px solid red";
        return;
    } else {
        phone.style.border = "2px solid green";
    }

    if(!gender){
        alert("Please select gender");
        return;
    }

    if(events.length === 0){
        alert("Please select at least one event");
        return;
    }

    if(!declaration.checked){
        alert("Please accept declaration");
        return;
    }

    // Collect selected events
    let eventList = "";
    events.forEach(function(event){
        eventList += event.parentElement.textContent.trim() + ", ";
    });

    eventList = eventList.slice(0, -2); // Remove last comma

    // Add new row to table
    let newRow = table.insertRow();

    newRow.insertCell(0).innerText = name.value;
    newRow.insertCell(1).innerText = department.value;
    newRow.insertCell(2).innerText = year.value;
    newRow.insertCell(3).innerText = eventList;

    // Success Message
    successMsg.innerText = "Registration Successful!";
    
    setTimeout(function(){
        successMsg.innerText = "";
    }, 3000);

    // Reset form
    form.reset();
});
