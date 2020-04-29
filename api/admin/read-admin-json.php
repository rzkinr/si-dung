<?php

include("../database/config.php");

$sql = "SELECT * FROM tbl_admin";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('username' => $row['username'], 'email' => $row['email'], 'password' => $row['password']
	));
}
echo json_encode(array("result" => $result));
?>
