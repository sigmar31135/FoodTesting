<?php

mysql_connect('localhost','tartecakec','KnQ-NHJ98X');
mysql_select_db('tartecakec_food');
$u = $_GET['username'];
$p = $_GET['password'];
$x = mysql_query('select * from user where uname = "'.$u.'" and passwordsee = "'.$p.'"');
$num = mysql_num_rows($x);
if($num>0)
{
	echo '{';
	while($xx = mysql_fetch_array($x))
	{
		$uid = $xx['uid'];
		echo '"uid":"'.$xx['uid'].'",';
		echo '"test":[';
	}
	$y = mysql_query('select * from (userintest as ut inner join user as u) inner join test as t where t.tid = ut.tid and u.uid = ut.uid and ut.uid = "'.$uid.'"');
	$count = 0;
	while($yy = mysql_fetch_array($y))
	{
		$z = mysql_query('select max(point) as m from testinuser where tid="'.$yy['tid'].'" and uid = "'.$uid.'" group by tid');
		$work = 0;
		 while($zz = mysql_fetch_array($z))
		 {
			$max = $zz['m'];
			if($max == 0)
			{
				$work = 0;
			}
			else{
				$work = 1;
			}
		 }
		if($count++!=0)
		{
			echo ',';
		}
		$d = date("j/n/Y",strtotime($yy['created_at']));
		echo '{"tid":"'.$yy['tid'].'",';
		echo '"work":"'.$work.'",';
		echo '"attribute":"'.$yy['attribute_num'].'",';
		echo '"create":"'.$d.'"}';
	}
	echo ']';
	echo '}';
}
else{
	echo "no";
}
?>

<!-- {"uid":"1","test":[{"tid":"1","work":"0","attribute":"20","create":"31/3/2557"},{"tid":"2","work":"1","attribute":"19","create":"31/3/2557"}]} -->