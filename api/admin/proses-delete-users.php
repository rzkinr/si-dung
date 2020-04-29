<?php

include("../database/config.php");

	$nama_lengkap = $_POST['nama_lengkap'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "DELETE FROM tbl_users (nama_lengkap, email, password) WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menghapus Data...");
	}
?>