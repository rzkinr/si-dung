<?php

include("../database/config.php");

	$username = $_POST['username'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "INSERT INTO tbl_admin (username, email, password) VALUES ('$username', '$email', '$password')";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menambah Data...");
	}
?>
