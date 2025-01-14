<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/home.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <span class="navbar-brand"> Banking Application</span>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <p class="card-text"><a href="login.jsp" class="card-link">Logout</a></p>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="row mb-5">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-12">
                                <h5 class="card-title text-center" id="name-el"></h5>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-2 text-center">
                                <p class="card-text" id="userid-el"></p>
                            </div>
                            <div class="col-2 text-center">
                                <p class="card-text" id="username-el"></p>
                            </div>
                            <div class="col-2 text-center">
                                <p class="card-text" id="email-el"></p>
                            </div>
                            <div class="col-2 text-center">
                                <p class="card-text" id="role-el"></p>
                            </div>
                            <div class="col-2 text-center">
                                <button class="btn btn-success" id="edit-btn">Edit info</button>
                            </div>
                            <div class="col-2 text-center">
                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#more-options-form" id="more-options-btn">More options</button>
                            </div>
                        </div>
                        <div class="row mt-1">
                            <div class="col-12">
                                <form class="collapse" id="more-options-form">
                                    <div class="row">
                                        <div class="col-2">
                                            <button class="btn btn-success" id="all-accounts-btn">Get all accounts</button>
                                        </div>
                                        <div class="col-3">
                                            <div class="form-group">
                                                <label for="accounts-by-status" class="d-none">Accounts by status</label>
                                                <select class="form-control" id="accounts-by-status">
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <button class="btn btn-success" id="accounts-by-status-btn">Get accounts by status</button>
                                        </div>
                                        <div class="col-3">
                                            <div class="form-group">
                                                <label for="pass-time-el" class="d-none">Pass time</label>
                                                <input type="text" class="form-control" id="pass-time-el" placeholder="Number of months">
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <button class="btn btn-success" id="pass-time-btn">Pass time</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row d-none" id="admin-content">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        Users
                    </div>
                    <ul class="list-group list-group-flush" id="admin-user-container">

                    </ul>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        Accounts
                    </div>
                    <ul class="list-group list-group-flush" id="admin-account-container">
                    </ul>
                </div>
            </div>
        </div>
        <div class="row d-none" id="user-info">
            <div class="col-6">
                <div class="card">
                    <div class="card-header" id="user-info-header">

                    </div>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-12 d-flex" id="user-info-backbtn-container">
                                    <!-- <button class="btn btn-success ml-auto" id="user-info-backbtn">Back home</button> -->
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user-info-username">Username</label>
                                        <input type="text" class="form-control" id="user-info-username">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user-info-password">Password</label>
                                        <input type="text" class="form-control" id="user-info-password">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user-info-firstname">First name</label>
                                        <input type="text" class="form-control" id="user-info-firstname">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user-info-lastname">Last name</label>
                                        <input type="text" class="form-control" id="user-info-lastname">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user-info-email">Email</label>
                                        <input type="email" class="form-control" id="user-info-email">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user-info-role">Role</label>
                                        <input type="text" class="form-control" id="user-info-role" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="upgrade-container">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="upgrade-premium">Account ID to pay for upgrade</label>
                                        <input type="text" class="form-control" id="upgrade-premium">
                                        <small class="form-text text-muted">Upgrading to Premium costs $100</small>
                                    </div>
                                </div>
                                <div class="col-6" id="upgrade-btn-container">
                                </div>
                            </div>
                            <div class="row" id="user-info-btn-container">
                                <div class="col-4" id="user-info-editbtn-container">
                                </div>
                                <div class="col-4" id="user-info-savebtn-container">
                                </div>
                                <div class="col-4" id="user-info-deletebtn-container">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card mb-3">
                    <div class="card-header" id = "user-info-account-header">
                    </div>
                    <ul class="list-group list-group-flush" id="user-info-account-container">
                    </ul>
                </div>

                <div class="card" id="new-account-card">
                    <h5 class="card-header text-center">Open new account</h5>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="new-account-balance">Initial balance</label>
                                        <input type="text" class="form-control" id="new-account-balance">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="account-status">Select account status</label>
                                        <select class="form-control" id="new-account-status">
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="account-type">Select account type</label>
                                        <select class="form-control" id="new-account-type">
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12" id="add-account-btn-container">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row d-none" id="account-info">
            <div class="col-6">
                <div class="card">
                    <div class="card-header" id="account-info-user-header">
                    </div>
                    <ul class="list-group list-group-flush" id="account-info-user-container">

                    </ul>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header" id="account-info-account-header">
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-12 d-flex">
                                    <button class="btn btn-success ml-auto" id="account-info-backbtn">Back home</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="account-info-balance">Balance</label>
                                        <input type="text" class="form-control-plaintext" id="account-info-balance" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="account-info-status">Account Status</label>
                                        <select class="form-control" id="account-info-status">
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="account-info-type">Account Type</label>
                                        <input type="text" class="form-control-plaintext" id="account-info-type" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3" id="modify-account-btn-container">
                                <div class="col-4" id="account-info-editbtn-container">
                                </div>
                                <div class="col-4" id="account-info-savebtn-container">
                                </div>
                                <div class="col-4" id="account-info-deletebtn-container">
                                </div>
                            </div>
                            <div class="row mb-3" id="act-on-account-btn-container">
                                <div class="col-3">
                                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#deposit-form">Deposit</button>
                                </div>
                                <div class="col-3">
                                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#withdraw-form">Withdraw</button>
                                </div>
                                <div class="col-3">
                                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#transfer-form">Transfer</button>
                                </div>
                                <div class="col-3">
                                    <button class="btn btn-primary" id="add-user-toggle" type="button" data-toggle="collapse" data-target="#add-user-form">Add user to account</button>
                                </div>
                            </div>
                        </form>
                        <form class="collapse" id="deposit-form">
                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="deposit-amount">Deposit Amount</label>
                                        <input type="text" class="form-control" id="deposit-amount">
                                    </div>
                                </div>
                                <div class="col-6 d-flex" id="deposit-submitbtn-container">
                                </div>
                            </div>
                        </form>
                        <form class="collapse" id="withdraw-form">
                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="withdraw-amount">Withdraw Amount</label>
                                        <input type="text" class="form-control" id="withdraw-amount">
                                    </div>
                                </div>
                                <div class="col-6 d-flex" id="withdraw-submitbtn-container">
                                </div>
                            </div>
                        </form>
                        <form class="collapse" id="transfer-form">
                            <div class="row">
                                <div class="col-4">
                                    <div class="form-group">
                                        <label for="transfer-amount">Transfer Amount</label>
                                        <input type="text" class="form-control" id="transfer-amount">
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="form-group">
                                        <label for="transfer-target">Transfer Target Account ID</label>
                                        <input type="text" class="form-control" id="transfer-target">
                                    </div>
                                </div>
                                <div class="col-4 d-flex" id="transfer-submitbtn-container">
                                </div>
                            </div>
                        </form>
                        <form class="collapse" id="add-user-form">
                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="added-user">User ID to add to account</label>
                                        <input type="text" class="form-control" id="added-user">
                                    </div>
                                </div>
                                <div class="col-6 d-flex" id="add-user-submitbtn-container">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="assets/Home.js"></script>
</body>
</html>