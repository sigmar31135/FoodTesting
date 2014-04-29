@extends('layout.default')
@section('content') 
    <div class="row">
        <div class="large-12 columns">
             <div class = "panel">
                <h2 class="header2">Analysis<a href ="{{URL::to('excel',array('id'=>$tid))}}" class="button add">View in Excel</a></h2>
                <div id="jqChart" style="width: 100%; height: 500px;"></div>
             </div>
        </div>
    </div>
    <div class="row">
        <div class="large-4 columns">
            <div class = "panel">
                <h4>Test id : {{$t->tid}}</h4>
                <p>Detail : {{$t->detail}}</p>
            </div> 
            <div class="panel">
                <div class= "row" style="margin:0 auto">
                    <a class = "button add" href ="#" data-reveal-id="myModal" data-reveal style="width:100%">Add user to this test</a>
                </div>
            </div>
        </div>

        <div class="large-8 columns">
            <div class="panel">
                <div class = "row">
                    <div class="large-12 columns">
                        <h3>Test Log</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="large-12 columns">
                        <table>
                            <thead>
                                <tr>
                                    <th width="150">user id</th>
                                    <th width="400">username</th>
                                    <th width="250">updated at</th>
                                </tr>
                                <tbody>
                                    @foreach($uit as $u)
                                        <tr>
                                            <td><a href= "{{URL::to('ulog',array('tid'=>$tid,'uid'=>$u->uid))}}">{{$u->uid}}</td>
                                            <td>{{$u->uname}}</td>
                                            <td>{{$u->updated_at}}</td>
                                        </tr>
                                    @endforeach
                                </tbody>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="myModal" class="reveal-modal small" data-reveal>
        <form method = "post" action = "{{URL::to('addusertotest')}}">
            <h2 class="header2">User</h2>
            <div class="row">
                <div class="large-12 columns">
                    <label>Username
                        <select name = "uid">
                            @foreach($allu as $u)
                                <?php 
                                    $x = Userintest::where('uid','=',$u->uid)->where('tid','=',$tid)->first();
                                ?>
                                @if(!isset($x))
                                    <option value = "{{$u->uid}}">{{$u->uname}}</option>   
                                @endif    
                            @endforeach
                        </select>                                 
                    </label>
                </div>
            </div>
            <input type= "hidden" name = "tid" value = "{{$tid}}">
            <div class = "login-btn">
                <input type= "submit" class = "button next" value = "Done">
            </div>
            <a class="close-reveal-modal">&#215;</a>
        </form>
    </div>
    <!--$randomcolor = '#' . strtoupper(dechex(rand(0,10000000)));-->
    <script type="text/javascript">
         $(document).ready(function () {
            $('#jqChart').jqChart({
                title: { text: 'Line Chart' },
                animation: { duration: 1.5 },
                axes: [
                    {
                        type: 'category',
                        location: 'bottom',
                        categories: [
                            <?php
                                $count = 0;
                                if($allc != "")
                                {
                                    foreach($allc as $c)
                                    {
                                        echo '"'.$c->cname.'"';
                                        $count++;
                                        if($count!=count($allc))
                                        {
                                            echo ",";
                                        }
                                    }
                                }
                            ?>
                        ]
                    }
                ],
                series: [
                    <?php
                        $ccc = 0;
                        foreach($uit as $u)
                        {
                            $ccc++;
                            $randomcolor = '#' . strtoupper(dechex(rand(0,10000000)));
                            $allc = Testinuser::where('tid','=',$tid)->where('uid','=',$u->uid)->get();
                    ?>
                        {
                            type: 'line',
                            title: <?php echo '"'.$u->uname.'"'; ?>,
                            strokeStyle: "{{$randomcolor}}",
                            lineWidth: 2,
                            data: [
                                <?php
                                    $count = 0;
                                    foreach($allc as $c)
                                    {
                                        echo $c->point;
                                        $count++;
                                        if($count!=count($allc))
                                        {
                                            echo ",";
                                        }
                                    }
                                ?>
                            ],
                            labels: {
                                stringFormat: '%.1f',
                                font: '12px sans-serif'
                            }
                        }
                    <?php
                            if(count($uit)!=$ccc)
                            {
                                echo ",";
                            }
                        }
                    ?>
                ]
            });
        });
    </script>
@endsection