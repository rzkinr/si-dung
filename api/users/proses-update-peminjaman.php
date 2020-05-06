<?php

include("../database/config.php");

$konfirmasi = $_POST['konfirmasi'];

$sql = "UPDATE tbl_peminjaman_gedung SET konfirmasi='$konfirmasi' ";
$query = mysqli_query($db, $sql);

if ($query) {
} else {
    die("Gagal Menyimpan Perubahan Data...");
}
