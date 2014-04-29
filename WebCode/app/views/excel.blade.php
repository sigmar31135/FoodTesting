@extends('layout.default')
@section('content') 
    <div class="row">
        <div class="large-12 columns">
            <div class = "panel">
                <h4>Test id : {{$t->tid}}<input type="button" href ="#"  onclick="tableToExcel('xx', 'W3C Example Table')" class="button add" value = "Export"></h4><!-- <a href ="#" id ="export" class="button add">Export</a> -->
                <p>Detail : {{$t->detail}}</p>
            </div> 
        </div>
    </div>
    <div class="row">
        <div class="large-12 columns">
            <div class="panel">
                <table style="width:100%">
                    <thead>
                        <tr>
                            <th rowspan="2" style="text-align:center">User</th>
                            @foreach($alla as $a)
                                <?php
                                    $allc = Childinattribute::where('aid','=',$a->aid)->get();
                                ?>
                                <th colspan="{{count($allc)}}" style="text-align:center">{{$a->aname}}</th>
                            @endforeach
                        </tr>
                        <tr>
                            @foreach($alla as $a)
                                <?php
                                    $allc = Childinattribute::where('aid','=',$a->aid)->join('child','child.cid','=','childinattribute.cid')->get();
                                ?>
                                @foreach($allc as $c)
                                    <th  style="text-align:center">{{$c->cname}}</th>
                                @endforeach
                            @endforeach
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($allu as $u)
                            <tr>
                                <td>{{$u->uname}}</td>
                                @foreach($alla as $a)
                                    <?php
                                        $allc = Childinattribute::where('aid','=',$a->aid)->join('child','child.cid','=','childinattribute.cid')->get();
                                    ?>
                                    @foreach($allc as $c)
                                        <?php
                                            $x = Testinuser::where('tid','=',$t->tid)->where('aid','=',$a->aid)
                                                ->where('cid','=',$c->cid)->where('uid','=',$u->uid)->first();
                                        ?>
                                            <td  style="text-align:center">{{$x->point}}</td>
                                    @endforeach
                                @endforeach
                            </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div style="display:none">
        <div id="dvData">
            <table border="1" id = "xx">
                <caption><h2>Test id : {{$t->tid}}</h2></caption>
                <thead>
                    <tr>
                        <th rowspan="2" style="text-align:center">User</th>
                        @foreach($alla as $a)
                            <?php
                                $allc = Childinattribute::where('aid','=',$a->aid)->get();
                            ?>
                            <th colspan="{{count($allc)}}" style="text-align:center">{{$a->aname}}</th>
                        @endforeach
                    </tr>
                    <tr>
                        @foreach($alla as $a)
                            <?php
                                $allc = Childinattribute::where('aid','=',$a->aid)->join('child','child.cid','=','childinattribute.cid')->get();
                            ?>
                            @foreach($allc as $c)
                                <th  style="text-align:center">{{$c->cname}}</th>
                            @endforeach
                        @endforeach
                    </tr>
                </thead>
                <tbody>
                    @foreach($allu as $u)
                        <tr>
                            <td>{{$u->uname}}</td>
                            @foreach($alla as $a)
                                <?php
                                    $allc = Childinattribute::where('aid','=',$a->aid)->join('child','child.cid','=','childinattribute.cid')->get();
                                ?>
                                @foreach($allc as $c)
                                    <?php
                                        $x = Testinuser::where('tid','=',$t->tid)->where('aid','=',$a->aid)
                                            ->where('cid','=',$c->cid)->where('uid','=',$u->uid)->first();
                                    ?>
                                        <td  style="text-align:center">{{$x->point}}</td>
                                @endforeach
                            @endforeach
                        </tr>
                    @endforeach
                </tbody>
            </table>
        </div>
    </div>
    <script>
    $(document).ready(function() {
        $("#export").click(function(e) {
            //getting values of current time for generating the file name
            var dt = new Date();
            var i = "{{$t->tid}}";
            var day = dt.getDate();
            var month = dt.getMonth() + 1;
            var year = dt.getFullYear();
            var hour = dt.getHours();
            var mins = dt.getMinutes();
            var postfix = day + "." + month + "." + year + "_" + hour + "." + mins;
            //creating a temporary HTML link element (they support setting file names)
            var a = document.createElement('a');
            //getting data from our div that contains the HTML table
            var data_type = 'data:application/vnd.ms-excel';
            var table_div = document.getElementById('dvData');
            var table_html = table_div.outerHTML.replace(/ /g, '%20');
            a.href = data_type + ', ' + table_html;
            //setting the file name
            a.download = 'Test id:'+i+'_Report_' + postfix + '.xls';
            //triggering the function
            a.click();
            //just in case, prevent default behaviour
            e.preventDefault();
        });
    });
    var tableToExcel = (function() {
      var uri = 'data:application/vnd.ms-excel;base64,'
        , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
        , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
        , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
      return function(table, name) {
        if (!table.nodeType) table = document.getElementById(table)
        var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
        window.location.href = uri + base64(format(template, ctx))
      }
    })()
    </script>
@endsection