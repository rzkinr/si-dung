<?php 

include("../database/config.php");

	$nama_gedung = $_POST['nama_gedung'];
	$luas_gedung = $_POST['luas_gedung'];
	$kapasitas = $_POST['kapasitas'];
	$parkir = $_POST['parkir'];

	$sql = "UPDATE tbl_gedung SET nama_gedung='$nama_gedung', luas_gedung='$luas_gedung', kapasitas='$kapasitas', parkir='$parkir' WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	//apakah query update berhasil?
	if ($query) {
		
	} else {
		// kalau gagal tampilkan pesan
		die("Gagal Menyimpan Perubahan...");
	}
	
 ?>