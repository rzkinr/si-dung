<?php

include("../database/config.php");

$sql = "SELECT * FROM tbl_peminjaman_gedung";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('no_pinjam' => $row['no_pinjam'],
    'nama' => $row['nama'], 'nim' => $row['nim'], 'fakultas' => $row['fakultas'],
    'nama_organisasi' => $row['nama_organisasi'], 'nama_gedung' => $row['nama_gedung'],
    'tanggal_pinjam' => $row['tanggal_pinjam'], 'waktu_pinjam' => $row['waktu_pinjam'],
    'jenis_acara' => $row['jenis_acara'], 'deskripsi_acara' => $row['deskripsi_acara'], 
    'surat_permohonan' => $row['surat_permohonan'], 'ktm' => $row['ktm'], 'status' => $row['status']
));
}
echo json_encode(array("result" => $result));
?>