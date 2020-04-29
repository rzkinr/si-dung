<?php

include("../database/config.php");

	$nama_gedung = $_POST['nama_gedung'];
	$tanggal_pinjam = $_POST['tanggal_pinjam'];
	$waktu_pinjam = $_POST['waktu_pinjam'];

	$sql = "DELETE FROM tbl_jadwal (nama_gedung, tanggal_pinjam, waktu_pinjam) WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menghapus Data...");
	}
?>
