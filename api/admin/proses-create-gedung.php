<?php

include("../database/config.php");

	$nama_gedung = $_POST['nama_gedung'];
	$luas_gedung = $_POST['luas_gedung'];
	$kapasitas = $_POST['kapasitas'];
	$parkir = $_POST['parkir'];

	$sql = "INSERT INTO tbl_gedung (nama_gedung, luas_gedung, kapasitas, parkir) VALUES ('$nama_gedung', '$luas_gedung', '$kapasitas', '$parkir')";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menambah Data...");
	}
?>
