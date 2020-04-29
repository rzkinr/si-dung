<?php

include("../database/config.php");

// $nama_lengkap= $_POST['nama_lengkap'];
$email= $_POST['email'];
$password= $_POST['password'];


$sql = "SELECT * FROM tbl_users WHERE email='$email' AND password='$password'";
$result = array();
$query = mysqli_query($db, $sql);
$stat=mysqli_num_rows ( $query ); 

array_push($result, array('status' => $stat));
echo json_encode(array("result" => $result));
?>