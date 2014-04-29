<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

/*========================= get =================================*/
Route::get('/',array('as'=>'home','uses'=>'HomeController@home'))
	->before('checkadmin');
Route::get('login',array('as'=>'login','uses'=>'HomeController@login'))
	->before('guest');
Route::get('logout',array('as'=>'logout','uses'=>'HomeController@logout'));
Route::get('alluser',array('as'=>'alluser','uses'=>'HomeController@alluser'))
	->before('checkadmin');
Route::get('alltest',array('as'=>'alltest','uses'=>'HomeController@alltest'))
	->before('checkadmin');
Route::get('addtest',array('as'=>'addtest','uses'=>'HomeController@addtest'))
	->before('checkadmin');
Route::get('addtest2',array('as'=>'addtest2','uses'=>'HomeController@addtest2'))
	->before('checkadmin');
Route::get('tdetail/{id}',array('as'=>'tdetail','uses'=>'HomeController@tdetail'))
	->before('checkadmin');
Route::get('ulog/{tid}/{uid}',array('as'=>'ulog','uses'=>'HomeController@ulog'))
	->before('checkadmin');
Route::get('excel/{tid}',array('as'=>'excel','uses'=>'HomeController@excel'))
	->before('checkadmin');


/*========================= post =================================*/
Route::post('checklogin',array('uses'=>'HomeController@checklogin'));
Route::post('newuser',array('uses'=>'HomeController@newuser'));
Route::post('testtodb',array('uses'=>'HomeController@testtodb'));
Route::post('testtodb2',array('uses'=>'HomeController@testtodb2'));
Route::post('addusertotest',array('uses'=>'HomeController@addusertotest'));