<?php 

include("../database/config.php");

	$nama_lengkap = $_POST['nama_lengkap'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "UPDATE tbl_users SET nama_lengkap='$nama_lengkap', email='$email', passwords='$password' WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	//apakah query update berhasil?
	if ($query) {
		
	} else {
		// kalau gagal tampilkan pesan
		die("Gagal Menyimpan Perubahan...");
	}
	
 ?>