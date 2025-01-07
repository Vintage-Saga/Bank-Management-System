<?php
// Database configuration
$host = 'localhost'; // Database host
$dbname = 'BankMan'; // Database name
$username = 'root'; // Database username
$password = 'Kaari@2006'; // Database password

// Create a connection to the database
$conn = new mysqli($host, $username, $password, $dbname);

// Check the connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get the form data
    $username = trim($_POST['username']);
    $email = trim($_POST['email']);
    $password = trim($_POST['password']);

    // Validate the input
    if (empty($username) || empty($email) || empty($password)) {
        echo "All fields are required.";
        exit;
    }

    // Hash the password for security
    $hashedPassword = password_hash($password, PASSWORD_DEFAULT);

    // Prepare the SQL statement to prevent SQL injection
    $stmt = $conn->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
    $stmt->bind_param("sss", $username, $email, $hashedPassword);

    // Execute the statement
    if ($stmt->execute()) {
        echo "Registration successful! Welcome, $username.";
    } else {
        echo "Error saving data: " . $stmt->error;
    }

    // Close the statement
    $stmt->close();
} else {
    // Redirect to registration page if accessed directly
    header("Location: registration.html");
    exit;
}

// Close the database connection
$conn->close();
?>