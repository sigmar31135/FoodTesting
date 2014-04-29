<header>
    <div class="row">
        <div class="large-3 columns">
            <h1><img src="/image/logo.png" style=  "height:100px"></h1>
        </div>
        <div class="large-9 columns">
            <ul class="button-group right">
                <li style="margin-left: 15px;"><a href="{{URL::route('home')}}" class="button menu">Home</a></li>
                <li style="margin-left: 15px;"><a href="{{URL::to('alluser')}}" class="button menu">View User</a></li>
                <li style="margin-left: 15px;"><a href="{{URL::to('alltest')}}" class="button menu">View Test</a></li>
                <li style="margin-left: 15px;"><a href="{{URL::to('logout')}}" class="button menu signout">Sign Out</a></li>
            </ul>
        </div>
    </div>
</header> 