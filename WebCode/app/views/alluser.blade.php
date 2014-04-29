@extends('layout.default')
@section('content')
    <div class = "row">
        <div class= "large-12 columns">
            <div class = "panel">
                <div class = "row">
                    <div class= "large-12 columns">
                        <h2 class="header2">All User<a class = "button add" href ="#" data-reveal-id="myModal" data-reveal>New User</a></h2>
                    </div>
                </div>
                <div class = "row">
                    <div class= "large-12 columns">
                        <table>
                            <thead>
                                <tr>
                                    <th width="150">User ID</th>
                                    <th width="450">Username</th>
                                    <th width="200">Password</th>
                                    <th width="200">Role</th>
                                </tr>
                                <tbody>
                                    @foreach($allu as $u)
                                        <tr>
                                            <td>{{$u->uid}}</td>
                                            <td>{{$u->uname}}</td>
                                            <td>{{$u->passwordsee}}</td>
                                            <td>{{$u->role}}</td>
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
        <form action = "{{URL::to('newuser')}}" method = "post">
            <h2 class="header2">New User</h2>
            <div class="row">
                <div class="large-12 columns">
                    <label>Username
                        <input type="text" id = "uname" name = "uname"/>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns">
                    <label>Password
                        <input type="text" id = "password" name = "password"/>
                    </label>
                </div>
            </div>
            <div class = "login-btn">
                <input class = "button next" type="submit" value = "Done">
            </div>
        </form>
    </div>

@endsection