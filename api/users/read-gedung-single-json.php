<?php

include("../database/config.php");

$id = $_POST['id'];

$sql = "SELECT * FROM tbl_gedung where id = '$id'"; 
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('id' => $row['id'], 'nama_gedung' => $row['nama_gedung'],
    'luas_gedung' => $row['luas_gedung'], 'kapasitas' => $row['kapasitas'], 'parkir' => $row['parkir']
));
}
echo json_encode(array("result" => $result));
?>


