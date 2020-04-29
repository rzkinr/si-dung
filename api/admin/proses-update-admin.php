<?php 

include("../database/config.php");

	$username = $_POST['username'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "UPDATE tbl_admin SET username='$username', email='$email', passwords='$password' WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	//apakah query update berhasil?
	if ($query) {
		
	} else {
		// kalau gagal tampilkan pesan
		die("Gagal Menyimpan Perubahan...");
	}
	
 ?>