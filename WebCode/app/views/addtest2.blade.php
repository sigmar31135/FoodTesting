@extends('layout.default')
@section('content')
	<div class= "row">
        <div class="large-8 large-offset-2 columns">
            <div class = "panel">
                <div class = "row">
                    <div class="large-6 columns">
                        <img src="/image/step1-1.png" style="width:100%">
                    </div>
                    <div class="large-6 columns">
                        <img src="/image/step2-2.png" style="width:100%">
                    </div>
                </div>
                <hr>
                <h2 class="header2">New Test</h2>
                <div class="row">
                    <div class="large-3 columns">
                        <label>Test id
                            <input type="text" name = "tid" id = "tid" value="{{$tid}}" disabled />
                        </label>
                    </div>
                    <div class="large-9 columns">
                        <label>Detail
                            <input type="text" name = "detail" id = "detail" value = "{{$detail}}" disabled/>
                        </label>
                    </div>
                </div>
                <div class = "row">
                    <div class="large-5 columns">
                        <h2 class="header2">Child<a class = "button add" href ="#" data-reveal-id="myModal" data-reveal>new</a></h2>
                    </div>
                    <input type = "hidden" id = "a" name = "allattribute" value = "0">
                </div>
                <div class="row">
                    <div class="large-12 columns">
                        <div id = "allatt">
                        </div>
                    </div>
                </div>
                <div class = "login-btn">
                    <input type= "submit" class = "button next" id = "next" value = "Next">
                </div>
            </div>
        </div>
    </div>
    <div id="myModal" class="reveal-modal small" data-reveal>
        <h2 class="header2">New Child</h2>
        <div class="row">
            <div class="large-6 columns">
                <label>Attribute Name
                    <select name = "aid" id = "aid">
                        @foreach($alla as $a)
                            <option value="{{$a->aid}}">{{$a->aname}}</option>
                        @endforeach
                    </select>
                </label>
            </div>
            <div class="large-6 columns">
                <label>Childname Name
                    <input type="text" id = "cname" name = "cname"/>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="large-6 columns">
                <label>Min Average
                    <input type="text" id = "min" name = "min"/>
                </label>
            </div>
            <div class="large-6 columns">
                <label>Max Average
                    <input type="text" id = "max" name = "max"/>
                </label>
            </div>
        </div>
        <div class = "login-btn">
            <a class = "button next" id = "addattr">Done</a>
        </div>
    </div>

    <script>
                $(document).ready(function(){
                    var item = new Array();
                    var num = 1;
                    $('#addattr').click(function(){
                        $('#a').val(num);
                        var x = $('#aid').val();
                        var y = $('#cname').val();
                        var min = $('#min').val();
                        var max = $('#max').val();
                        var z = $( "#aid option:selected" ).text();
                        var inside = new Object();
                        inside.aid = x;
                        inside.cname = y;
                        inside.min = min;
                        inside.max = max;
                        $('#aname').val("");
                        $('#cname').val("");
                        $('#min').val("");
                        $('#max').val("");
                        $('<div class="row"><div class="large-3 columns"><label>Attribute<input type="text"  value = "'+z+'" disabled/></label></div><div class="large-3 columns"><label>Child'+num+' name<input type="text" value = "'+y+'" disabled/></label></div><div class="large-3 columns"><label>Min Average<input type="text" value = "'+min+'" disabled/></label></div><div class="large-3 columns"><label>Max Average<input type="text" value = "'+max+'" disabled/></label></div></div>').appendTo('#allatt');
                        num++;
                        $('#myModal').foundation('reveal', 'close');
                        item.push(inside);
                    });
                    $('#next').click(function(){
                        //alert(JSON.stringify(data));
                        var form = document.createElement('form');
                        form.action = "{{URL::to('testtodb2')}}";
                        form.method = "post";
                        // for each of your input variables:
                        var input = document.createElement('input');
                        input.name = "allc";
                        input.type = "hidden";
                        input.value = ""+JSON.stringify(item);
                        form.appendChild(input);
    
                        var input = document.createElement('input');
                        input.name = "tid";
                        input.type = "hidden";
                        input.value = $('#tid').val();
                        form.appendChild(input);
    
                        var input = document.createElement('input');
                        input.name = "detail";
                        input.type = "hidden";
                        input.value = $('#detail').val();
                        form.appendChild(input);
    
                        var input = document.createElement('input');
                        input.name = "num";
                        input.type = "hidden";
                        input.value = $('#a').val();
                        form.appendChild(input);
    
                        // After the last input:
                        document.body.appendChild(form);
                        form.submit();
                    });
                });
            </script>

@endsection