<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=utf-8" >
<?php

mysql_connect('localhost','tartecakec','KnQ-NHJ98X');
mysql_select_db('tartecakec_food');
$a = $_POST['array'];
$all = json_decode(stripslashes($a));
foreach($all as $x){
	mysql_query('update testinuser set point = "'.$x->point.'" where tid = "'.$x->tid.'" and  uid = "'.$x->uid.'" and  aid = "'.$x->aid.'" and  cid = "'.$x->cid.'"');
	mysql_query('update userintest set updated_at = "'.date('Y-m-d H:i:s').'" where uid = "'.$x->uid.'" and tid = "'.$x->tid.'"');
}

?>