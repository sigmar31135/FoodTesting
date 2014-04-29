<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=utf-8" >
<?php

mysql_connect('localhost','tartecakec','KnQ-NHJ98X');
mysql_select_db('tartecakec_food');

$aid = $_GET['aid'];
$tid = $_GET['tid'];
$uid = $_GET['uid'];
$count = 0 ;
$alla = mysql_query('select * from testinuser as tu inner join child as c where tu.cid = c.cid and tu.aid = "'.$aid.'" and tu.uid = "'.$uid.'" and tu.tid = "'.$tid.'"');
echo '[';
while($a = mysql_fetch_array($alla)){
	if($count++!=0)
	{
		echo ',';
	}
	echo '{"cid":"'.$a['cid'].'",';
	echo '"cname":"'.$a['cname'].'",';
	echo '"min":"'.$a['min_av'].'",';
	echo '"max":"'.$a['max_av'].'",';
	echo '"point":"'.$a['point'].'"}';
}
echo ']';
?>