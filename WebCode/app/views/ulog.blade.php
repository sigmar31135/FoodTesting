@extends('layout.default')
@section('content')
	<div class = "row">
        <div class= "large-12 columns">
	        <div class = "panel">
	            <div class = "row">
	            	<div class= "large-12 columns">
	                    <h2 class="header2">Test id {{$t->tid}}<h2>
	                    <h5>UserId {{$u->uid}}({{$u->uname}})</h5>
	                </div>
	            </div>
	            <hr>
	            <div class = "row">
	            	<div class ="large-12 columns">
						@foreach($ait as $a)
							<?php
								$count = 0;
								$allc = Testinuser::where('uid','=',$u->uid)->where('tid','=',$t->tid)->where('aid','=',$a->aid)
											->join('child','child.cid','=','testinuser.cid')->get();
							?>
							<div class="row">
								<div class="large-12 columns">
									<h3>{{$a->aname}}</h3>
									@foreach($allc as $c)
										@if($count%4==0)
											<div class="row">
										@endif
											<div class = "large-3 columns" style= "float:left">
					                			{{$c->cname}} {{$c->point}}/15
					      						<div class="progress large-12 success radius">
												  	<span class="meter" style="width: <?php echo $c->point/15*100; ?>%"></span>
												</div>
											</div>
								        @if($count==3)
								        	</div>
								        	<?php
								        		$count = 0;
								        	?>
								        @else
								        <?php
								        	$count++;
								        ?>
								    	@endif
									@endforeach
									@if(count($allc)%4!=0)
										</div>
									@endif
								</div>
							</div>
							<hr>
						@endforeach
  					</div>
	            </div>
            </div>
        </div>
    </div>

@endsection