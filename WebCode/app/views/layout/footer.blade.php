<footer class="row">
    <div class="large-12 columns">
        <hr />
        <div class="row">
            <div class="large-6 columns">
                <div class="pie">
                    <img src = "/image/pieee.png">
                </div>
                <p style = "vertical-align: middle;line-height: 40px;">&copy; Copyright to Pie Studio.</p>
            </div>
            <div class="large-6 columns">
                <ul class="inline-list right">
                    <li><a href="{{URL::route('home')}}">Home</a></li>
                    <li><a href="{{URL::to('alluser')}}">View User</a></li>
                    <li><a href="{{URL::to('alltest')}}">View Test</a></li>
                    <li><a href="{{URL::to('logout')}}">Sign Out</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>