$('#loginForm').on("submit", e => {
    e.preventDefault();

    const email = document.getElementById("Email");
    const password = document.getElementById("Password");

    if(email.value === "account@atos.net" && password.value === "atos123") {
        localStorage.setItem("user", "David");
        window.location.href = "http://localhost:8081/dashboard";
    } else {
        alert("Email or password are incorrect");
    }
});