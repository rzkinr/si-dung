<?php

include("../database/config.php");

	$nama_lengkap = $_POST['nama_lengkap'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "INSERT INTO tbl_users (nama_lengkap, email, password) VALUES ('$nama_lengkap', '$email', '$password')";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menambah Data...");
	}
?>
