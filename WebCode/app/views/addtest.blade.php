@extends('layout.default')
@section('content')
	<div class= "row">
        <div class="large-8 large-offset-2 columns">
            <div class = "panel">
                <div class = "row">
                    <div class="large-6 columns">
                        <img src="/image/step1-2.png" style="width:100%">
                    </div>
                    <div class="large-6 columns">
                        <img src="/image/step2-1.png" style="width:100%">
                    </div>
                </div>
                <hr>
                <h2 class="header2">New Test</h2>
                <div class="row">
                    <div class="large-3 columns">
                        <label>Test id
                            <input type="text" name = "tid" id = "tid"/>
                        </label>
                    </div>
                    <div class="large-9 columns">
                        <label>Detail
                            <input type="text" name = "detail" id = "detail"/>
                        </label>
                    </div>
                </div>
                <div class = "row">
                    <div class="large-5 columns">
                        <h2 class="header2">Attribute<a class = "button add" href ="#" data-reveal-id="myModal" data-reveal>new</a></h2>
                        <div id = "allatt">
                        </div>
                    </div>
                    <input type = "hidden" id = "a" name = "allattribute" value = "0">
                </div>
                <div class = "login-btn">
                    <input type= "submit" class = "button next" id = "next" value = "Next">
                </div>
            </div>
        </div>
    </div>
    <div id="myModal" class="reveal-modal small" data-reveal>
        <h2 class="header2">New Attribute</h2>
        <div class="row">
            <div class="large-12 columns">
                <label>Attribute Name
                    <input type="text" id = "aname" name = "aname"/>
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
                        var x = $('#aname').val();
                        var inside = new Object();
                        inside.aname = x;
                        $('#aname').val("");
                        $('<label>Attribute'+num+' name<input type="text" name = "attribute'+num+'" value = "'+x+'" disabled/></label>').appendTo('#allatt');
                        num++;
                        $('#myModal').foundation('reveal', 'close');
                        item.push(inside);
                    });
                    $('#next').click(function(){
                        //alert(JSON.stringify(data));
                        var form = document.createElement('form');
                        form.action = "{{URL::to('testtodb')}}";
                        form.method = "post";
                        // for each of your input variables:
                        var input = document.createElement('input');
                        input.name = "allatt";
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