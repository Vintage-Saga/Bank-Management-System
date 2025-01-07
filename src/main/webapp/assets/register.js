const app = function () {
    const usernameEl = document.getElementById("username-el");
    const passwordEl = document.getElementById("password-el");
    const firstNameEl = document.getElementById("firstname-el");
    const lastNameEl = document.getElementById("lastname-el");
    const emailEl = document.getElementById("email-el");
    const roleEl = document.getElementById("role-el");
    const registerBtnEl = document.getElementById("register-btn");

    // Ensure all required elements are found in the DOM
    if (!usernameEl || !passwordEl || !firstNameEl || !lastNameEl || !emailEl || !roleEl || !registerBtnEl) {
        console.error("One or more required elements not found in the DOM.");
        return;
    }
		
    const populateRoles = async function () {
        try {
            const response = await axios.get("/roles");
            console.log("Roles response:", response.data); // Debug log

            const roles = response.data;

            // Check if roles array exists and has at least 3 items
            if (!roles || roles.length < 3) {
                throw new Error("Insufficient roles data");
            }

            for (let i = 0; i < 3; i++) {
                const roleOption = document.createElement("option");
                roleOption.setAttribute("value", roles[i].roleId);
                roleOption.innerText = roles[i].role;
                roleEl.append(roleOption);
            }
        } catch (error) {
            console.error("Error in populateRoles:", error.message);
            alert("Failed to load roles. Please try again later.");
        }
    };

    const handleSubmit = async function (event) {
        event.preventDefault();

        const user = {
            username: usernameEl.value,
            password: passwordEl.value,
            firstName: firstNameEl.value,
            lastName: lastNameEl.value,
            email: emailEl.value,
            roleId: roleEl.value,
        };

        try {
            const response = await axios.post("/register", user);

            if (response.data.message) {
                console.log(response.data.message);
                alert(response.data.message); // Optional: Notify the user
            } else {
                window.location.replace("http://localhost:8080/maven-banking-app/home.jsp");
            }
        } catch (error) {
            console.error("Error during registration:", error.message);
            alert("Registration failed. Please try again.");
        }
    };

    // Populate roles when the app starts
    populateRoles();

    // Add event listener to register button
    registerBtnEl.addEventListener("click", handleSubmit);
};

// Run the app
document.addEventListener("DOMContentLoaded", app);
