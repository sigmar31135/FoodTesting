<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=utf-8" >
<?php

mysql_connect('localhost','tartecakec','KnQ-NHJ98X');
mysql_select_db('tartecakec_food');

$tid = $_POST['tid'];
$count = 0 ;
$alla = mysql_query('select * from attributeintest as at inner join attribute as a where at.aid = a.aid and at.tid = "'.$tid.'"');
echo '[';
while($a = mysql_fetch_array($alla)){
	if($count++!=0)
	{
		echo ',';
	}
	echo '{"aid":"'.$a['aid'].'",';
	echo '"aname":"'.$a['aname'].'"}';
}
echo ']';
?>