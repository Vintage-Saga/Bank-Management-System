<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Management System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome -->
    <style>
        /* General styling */
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

        .header .buttons a {
            text-decoration: none;
            padding: 10px 20px;
            margin: 5px;
            font-size: 1rem;
            font-weight: bold;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        .header .buttons a.start {
            background-color: #2ecc71;
            color: white;
        }

        .header .buttons a.start:hover {
            background-color: #27ae60;
        }

        .header .buttons a.how-it-works {
            background-color: #3498db;
            color: white;
        }

        .header .buttons a.how-it-works:hover {
            background-color: #2980b9;
        }

        /* Form styling */
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
    <div class="header" id="home">
        <div class="header-content">
            <h1>Welcome to Bank Management System</h1>
            <h3>Admin Portal </h3>
            <div class="form-container">
                <p style="color: grey;"><b><i>The Bank Management System is a comprehensive web-based application tailored for administrative control and management of bank operations. Designed from the perspective of an administrator, the system facilitates seamless management of user accounts, secure authentication, and operational efficiency. Key features include user registration, password updates, user list management, and transactional oversight, all encapsulated in an intuitive and user-friendly interface. With role-based access control, the admin can monitor customer profiles, update critical information, and ensure the system's overall security. The platform also integrates visually appealing elements, making navigation straightforward and enabling efficient management of day-to-day banking operations.</p>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Bank Management System. All Rights Reserved.</p>
    </footer>
</body>
</html>
