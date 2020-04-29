<?php

include("../database/config.php");

$email = $_POST['email'];

$sql = "SELECT * FROM tbl_users WHERE email='$email'";
$result = array();
$query = mysqli_query($db, $sql);

while ($row = mysqli_fetch_array($query)) {
    array_push($result, array(
        'id' => $row['id'], 'nama_lengkap' => $row['nama_lengkap'], 'email' => $row['email'], 'password' => $row['password']
    ));
}
echo json_encode(array("result" => $result));
