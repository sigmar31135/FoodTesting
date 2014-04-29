<?php

class Testinuser extends Eloquent {

	protected $table = 'testinuser';
	protected $primaryKey = 'id';
	public static $unguarded = true;
	public  $timestamps = false;
}