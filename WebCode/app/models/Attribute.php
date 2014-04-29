<?php

class Attribute extends Eloquent {

	protected $table = 'attribute';
	protected $primaryKey = 'aid';
	public static $unguarded = true;
	public  $timestamps = false;
}