<?php

include("../database/config.php");

	$username = $_POST['username'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "DELETE FROM tbl_admin (username, email, password) WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menghapus Data...");
	}
?>