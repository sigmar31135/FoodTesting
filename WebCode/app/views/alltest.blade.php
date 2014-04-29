@extends('layout.default')
@section('content')
    <div class = "row">
        <div class= "large-12 columns">
            <div class = "panel">
                <div class = "row">
                    <div class= "large-12 columns">
                        <h2 class="header2">All Test<a class = "button add" href ="{{URL::to('addtest')}}" style = "margin-top: -5px;">New Test</a></h2>
                    </div>
                </div>
                <div class = "row">
                    <div class= "large-12 columns">
                        <table>
                            <thead>
                                <tr>
                                    <th width="150">Test id</th>
                                    <th width="450">Detail</th>
                                    <th width="200">created at</th>
                                    <th width="200">updated at</th>
                                </tr>
                                <tbody>
                                    @foreach($allt as $t)
                                        <tr>
                                            <td><a href="{{URL::to('tdetail',array('id'=>$t->tid))}}">{{$t->tid}}</a></td>
                                            <td>{{$t->detail}}</td>
                                            <td>{{$t->created_at}}</td>
                                            <td>{{$t->updated_at}}</td>
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
@endsection