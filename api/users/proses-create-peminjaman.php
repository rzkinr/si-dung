<?php

include("../database/config.php");

	$no_pinjam = $_POST['no_pinjam'];
	$nama = $_POST['nama'];
	$nim = $_POST['nim'];
	$fakultas = $_POST['fakultas'];
	$nama_organisasi = $_POST['nama_organisasi'];
	$nama_gedung = $_POST['nama_gedung'];
	$tanggal_pinjam = $_POST['tanggal_pinjam'];
	$waktu_pinjam = $_POST['waktu_pinjam'];
	$jenis_acara = $_POST['jenis_acara'];
	$deskripsi_acara = $_POST['deskripsi_acara'];
	$surat_permohonan = $_POST['surat_permohonan'];
	$ktm = $_POST['ktm'];
	$status = $_POST['status'];

	$sql = "INSERT INTO tbl_peminjaman_gedung (no_pinjam, nama, nim, fakultas, nama_organisasi, nama_gedung, tanggal_pinjam, waktu_pinjam, jenis_acara, deskripsi_acara, surat_permohonan, ktm, status) VALUES ('$no_pinjam', '$nama', '$nim', '$fakultas', '$nama_organisasi', '$nama_gedung', '$tanggal_pinjam', '$waktu_pinjam', '$jenis_acara', '$deskripsi_acara', '$surat_permohonan', '$ktm', '$status')";
	$query = mysqli_query($db, $sql);

	if ($query) {
		
	} else{
		die("Gagal Menambah Data...");
	}
?>