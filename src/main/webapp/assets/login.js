const app = function () {
    const usernameEl = document.getElementById("username-el");
    const passwordEl = document.getElementById("password-el");
    const loginBtnEl = document.getElementById("login-btn");

    if (!usernameEl || !passwordEl || !loginBtnEl) {
        console.error("Required elements not found in the DOM.");
        return;
    } 
    const handleSubmit = async function (event) {
        event.preventDefault();
        try {
            const response = await axios.post("/login", {
                username: usernameEl.value,
                password: passwordEl.value,
            });
            if (response.data.message) {
                console.log(response.data.message);
            } else {
                window.location.replace("http://localhost:8080/maven-banking-app/home.jsp");
            }
        } catch (error) {
            console.error("Error during login:", error);
            alert("Login failed. Please try again.");
        }
    };

    loginBtnEl.addEventListener("click", handleSubmit);
};

document.addEventListener("DOMContentLoaded", app);
