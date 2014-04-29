@extends('layout.logindefault')
@section('content')
	<div class="row">
		<div class="large-12 columns">
			<div class="panel login">
				<form action = "{{URL::to('checklogin')}}" method = "post">
					<h3 class="header">
						Sign In
					</h3>
					<div class="row">
						<div class="large-12 columns">
							<label>Username
								<input type="text" name = "username">
							</label>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label>Password
								<input type="password" name = "password">
							</label>
						</div>
					</div>
					<div style="text-align:right">
						<input type= "submit" class="button signin" value = "login">
					</div>
					 @if (Session::has('flash_error'))
				        <div id="flash_error">{{ Session::get('flash_error') }}</div>
				    @endif
				</form>
			</div>
		</div>
	</div>
@endsection