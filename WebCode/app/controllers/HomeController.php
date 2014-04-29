<?php

class HomeController extends BaseController {

	/*
	|--------------------------------------------------------------------------
	| Default Home Controller
	|--------------------------------------------------------------------------
	|
	| You may wish to use controllers instead of, or in addition to, Closure
	| based routes. That's great! Here is an example controller method to
	| get you started. To route to this controller, just add the route:
	|
	|	Route::get('/', 'HomeController@showWelcome');
	|
	*/

	public function home()
	{
		return View::make('home')
			->with('title','Home');
	}

	public function login(){
		return View::make('login')
			->with('title','Sign in');
	}

	public function checklogin(){
		$u = array(
			'uname' => Input::get('username'),
			'password' =>Input::get('password')
		);
		$ux = User::where('uname','=',Input::get('username'))->where('passwordsee','=',Input::get('password'))->where('role','=','admin')->first();
		if(isset($ux))
		{
			if(Auth::attempt($u))
			{
				return Redirect::route('home');
			}
		}
		return Redirect::route('login')
			->with('flash_error','Error');
	}

	public function logout(){
		Auth::logout();
		return Redirect::route('login');
	}

	public function alluser(){
		$allu = User::all();
		return View::make('alluser',array('allu'=>$allu))
			->with('title','All User');

	}

	public function alltest(){
		$allt = Test::all();
		return View::make('alltest',array('allt'=>$allt))
			->with('title','All Test');
	}

	public function newuser(){
		$u = new User;
		$u->uname = Input::get('uname');
		$u->password = Hash::make(Input::get('password'));
		$u->role = "user";
		$u->passwordsee = Input::get('password');
		$u->save();
	return Redirect::route('alluser');
	}

	public function addtest(){
		return View::make('addtest')
			->with('title','Add Test');
	}

	public function testtodb(){
		$allatt = json_decode(stripslashes(Input::get('allatt')));
		$tid = Input::get('tid');
		$detail = Input::get('detail');
		$num = Input::get('num');
		$t = new Test;
		$t->tid = $tid;
		$t->detail = $detail;
		$t->attribute_num = $num;
		$t->save();
		foreach($allatt as $att)
		{
			$a = new Attribute;
			$a->aname = $att->aname;
			$a->save();
			$ait = new Attributeintest;
			$ait->tid = $tid;
			$ait->aid = $a->aid;
			$ait->save();
		}
		$alla = Attributeintest::where('tid','=',$tid)->join('attribute','attribute.aid','=','attributeintest.aid')->get();
		return View::make('addtest2',array('tid'=>$tid,'detail'=>Input::get('detail')
											,'alla'=>$alla))
			->with('title','Add test');
	}

	public function testtodb2(){
		$allc = json_decode(stripslashes(Input::get('allc')));
		$tid = Input::get('tid');
		$detail = Input::get('detail');
		$num = Input::get('num');
		foreach($allc as $c)
		{
			$cc = new Child;
			$cc->cname = $c->cname;
			$cc->min_av = $c->min;
			$cc->max_av = $c->max;
			$cc->save();
			$cia = new Childinattribute;
			$cia->cid = $cc->cid;
			$cia->aid = $c->aid;
			$cia->save();
		}
		return Redirect::route('alltest');
	}

	public function tdetail($id){
		$t = Test::find($id);
		$allu = User::all();
		$uit = Userintest::where('tid','=',$id)->join('user','user.uid','=','userintest.uid')->get();
		$ee = Userintest::where('tid','=',$id)->join('user','user.uid','=','userintest.uid')->first();
		if(isset($ee))
		{
			$allc = Testinuser::where('tid','=',$id)->where('uid','=',$ee->uid)->join('child','child.cid','=','testinuser.cid')->get();
		}else
		{
			$allc = "";
		}
		return View::make('tdetail',array('tid'=>$id,'t'=>$t,'allu'=>$allu
										,'uit'=>$uit,'allc'=>$allc))
			->with('title','Test Detail');
	}

	public function addusertotest(){
		$u = new Userintest;
		$u->uid = Input::get('uid');
		$u->tid = Input::get('tid');
		$u->save();
		$all = Attributeintest::where('tid','=',Input::get('tid'))->join('childinattribute','childinattribute.aid','=','attributeintest.aid')->get();
		foreach($all as $ea)
		{
			$t = new Testinuser;
			$t->uid = Input::get('uid');
			$t->tid = Input::get('tid');
			$t->aid = $ea->aid;
			$t->cid = $ea->cid;
			$t->point = 0;
			$t->save();
		}
		return Redirect::route('tdetail',array('id'=>Input::get('tid')));
	}

	public function ulog($tid,$uid){
		$ait = Attributeintest::where('tid','=',$tid)->join('attribute','attribute.aid','=','attributeintest.aid')->get();
		$u = User::find($uid);
		$t = Test::find($tid);
		return View::make('ulog',array('ait'=>$ait,'u'=>$u,'t'=>$t))
			->with('title','User log');
	}

	public function excel($id){
		$t = Test::find($id);
		$allu = Userintest::where('tid','=',$id)->join('user','user.uid','=','userintest.uid')->get();
		$alla = Attributeintest::where('tid','=',$id)->join('attribute','attribute.aid','=','attributeintest.aid')->get();
		return View::make('excel',array('alla'=>$alla,'t'=>$t,'allu'=>$allu))
			->with('title','Excel');
	}

}