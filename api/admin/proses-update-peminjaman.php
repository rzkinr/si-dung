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

	$sql = "UPDATE tbl_peminjaman_gedung SET no_pinjam ='$no_pinjam', nama ='$nama', nim ='$nim', fakultas ='$fakultas', nama_organisasi ='$nama_organisasi', nama_gedung ='$nama_gedung', tanggal_pinjam ='$tanggal_pinjam', waktu_pinjam ='$waktu_pinjam', jenis_acara ='$jenis_acara', deskripsi_acara ='$deskripsi_acara', surat_permohonan ='$surat_permohonan', ktm ='$ktm', status ='$status' WHERE id = '$id'";
	$query = mysqli_query($db, $sql);

	//apakah query update berhasil?
	if ($query) {
		
	} else {
		// kalau gagal tampilkan pesan
		die("Gagal Menyimpan Perubahan...");
	}
	
 ?>