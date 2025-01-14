<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Navigation bar styling */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #001f3f;
            color: white;
            padding: 10px 20px;
        }

        .navbar .logo {
            font-size: 1.5rem;
            font-weight: bold;
            color: #01FF70;
        }

        .navbar ul {
            list-style: none;
            display: flex;
            gap: 15px;
        }

        .navbar ul li {
            display: inline;
        }

        .navbar ul li a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            padding: 10px 15px;
            transition: all 0.3s ease;
        }

        .navbar ul li a:hover {
            background-color: #01FF70;
            color: black;
            border-radius: 5px;
        }

        /* Header section styling */
        .header {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 90vh;
            background: url('https://via.placeholder.com/1920x1080') no-repeat center center/cover;
            position: relative;
            color: white;
            text-align: center;
        }

        .header-content {
            max-width: 600px;
            background-color: rgba(0, 0, 0, 0.6);
            padding: 20px;
            border-radius: 10px;
        }

        .header h1 {
            font-size: 2.5rem;
            margin-bottom: 15px;
        }

        .header p {
            font-size: 1rem;
            margin-bottom: 20px;
        }

        /* Form container styling */
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            margin: auto;
        }

        .form-container h3 {
            margin-bottom: 20px;
            text-align: center;
        }

        .form-container input {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .form-container button {
            background-color: #2ecc71;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s ease;
            width: 100%;
        }

        .form-container button:hover {
            background-color: #27ae60;
        }

        /* Footer styling */
        footer {
            text-align: center;
            padding: 10px;
            background-color: #001f3f;
            color: white;
        }
    </style>
</head>
<body>
    <!-- Navigation bar -->
    <div class="navbar">
        <div class="logo">Bank Management System</div>
        <ul>
            <li><a href="login.html">Login</a></li>
            <li><a href="registration.html">Register new Users</a></li>
            <li><a href="profile.html">Update Password</a></li>
            <li><a href="user_list.html">Users</a></li>
        </ul>
    </div>

    <!-- Header section -->
    <div class="header">
        <div class="header-content">
            <h1>User Registration</h1>
            <p>Create a new account by entering your details below.</p>

            <!-- Registration Form -->
            <div class="form-container">
                <h3>Register New User</h3>
                <form action="submit_registration.php" method="post">
                    <!-- Username Field -->
                    <input type="text" name="username" placeholder="Enter Username" required>

                    <!-- Email Field -->
                    <input type="email" name="email" placeholder="Enter Email" required>

                    <!-- Password Field -->
                    <input type="password" name="password" placeholder="Enter Password" required>

                    <!-- Submit Button -->
                    <button type="submit">Register Now</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Bank Management System. All Rights Reserved.</p>
    </footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
