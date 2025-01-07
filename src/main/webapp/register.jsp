<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/home.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <span class="navbar-brand">Revature Banking Application</span>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp">Register <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container" style="display: flex; justify-content: center; align-items: center; height: 100vh;">
        <div class="card" style="width: 40%; height: 80%;">
            <form action= "insert" method="post">
            <h5 class="card-header text-center">Register New User</h5>
            <div class="card-body text-center">
                <div class="col-10">
                    <div class="form-group text-center">
                        <label for="username-el">Username</label>
                        <input type="text" class="form-control" id="username-el" name="username" required>
                    </div>
                </div>
                <div class="col-10">
                    <div class="form-group text-center">
                        <label for="password-el">Password</label>
                        <input type="password" class="form-control" id="password-el" name="password" required>
                    </div>
                </div>

                <div class="col-10">
                    <div class="form-group text-center">
                        <label for="firstname-el">First name</label>
                        <input type="text" class="form-control" id="firstname-el" name="firstName" required>
                    </div>
                </div>
                <div class="col-10">
                    <div class="form-group text-center">
                        <label for="lastname-el">Last name</label>
                        <input type="text" class="form-control" id="lastname-el" name="lastName" required>
                    </div>
                </div>

                <div class="col-10">
                    <div class="form-group text-center">
                        <label for="email-el">Email address</label>
                        <input type="email" class="form-control" id="email-el" name="email" required>
                    </div>
                </div>
            </div>

            <div class="row text-center">
                <div class="col-12">
                    <button class="btn btn-primary" type="button" id="register-btn" onclick="window.location.href='registerconf.jsp';">Register</button>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <p class="card-text text-center"></p>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <p class="card-text text-center">Already have an account? <a href="login.jsp" class="card-link">Login</a></p>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <p class="card-text text-center"></p>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <p class="card-text text-center"></p>
                </div>
            </div>
        </form>
        </div>
    </div>

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>
