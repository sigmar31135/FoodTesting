<?php

class Child extends Eloquent {

	protected $table = 'child';
	protected $primaryKey = 'cid';
	public static $unguarded = true;
	public  $timestamps = false;
}