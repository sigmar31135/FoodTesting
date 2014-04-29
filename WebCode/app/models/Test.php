<?php

class Test extends Eloquent {

	protected $table = 'test';
	protected $primaryKey = 'tid';
	public static $unguarded = true;
	public  $timestamps = false;
}