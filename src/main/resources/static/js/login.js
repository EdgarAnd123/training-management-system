$('#loginForm').on("submit", e => {
    e.preventDefault();
    const emailValue = document.getElementById("Email").value;
    const passwordValue = document.getElementById("Password").value;
    const emailErrorMessageElement = document.getElementById('email-error-message');
    const passwordErrorMessageElement = document.getElementById('password-error-message');

    emailErrorMessageElement.innerHTML = validateEmail(emailValue);
    passwordErrorMessageElement.innerHTML = validatePassword(passwordValue);

    if(emailValue === "account@atos.net" && passwordValue === "atos123") {
        localStorage.setItem("user", "David");
        window.location.href = "http://localhost:8081/dashboard";
    }
});

function validateEmail(email) {
    if (!email) {
        return "Email is required";
    }

    const isValidEmail = /^\S+@\S+$/g
    if (!isValidEmail.test(email)) {
        return "Please enter a valid email";
    }

    return '';
}

function validatePassword(password) {
    if (!password) return "Password is required";

    const hasNumber = /\d/g;
    if (!hasNumber.test(password)) {
        return "Please use at least one number.";
    }

    return '';
}