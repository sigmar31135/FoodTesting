
<!doctype html>
<!--[if IE 9]><html class="lt-ie10" lang="en" > <![endif]-->
<html class="no-js" lang="en" data-useragent="Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)">
  	<head>
    	<meta charset="utf-8" />
    	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    	<title>{{$title}}</title>
    	<link rel="icon" type="image/png" href="/image/fav.png" />

    
	    <meta name="description" content="Documentation and reference library for ZURB Foundation. JavaScript, CSS, components, grid and more." />
	    
	    <meta name="author" content="ZURB, inc. ZURB network also includes zurb.com" />
	    <meta name="copyright" content="ZURB, inc. Copyright (c) 2013" />

    	<link rel="stylesheet" href="/foundation/css/foundation.css" />
    	<script src="/foundation/js/vendor/jquery.js"></script>
    	<script src="/js/jquery.mambo.js"></script>
    	<link rel='stylesheet' id='webfonts-css'  href='http://fonts.googleapis.com/css?family=Arvo%7CTienne%3A400%2C700%7CPatua+One%7CDroid+Sans%7CCantarell%3A700%7COldenburg&#038;ver=3.8.1' type='text/css' media='all' />
    	<link rel="stylesheet" href="/css/style.css">
  	</head>
  	<body>
  		 <div class="wrap">
	  		<div class="content">
	    		 @yield('content')
	    	</div>
	    </div>
    	<!-- Footer -->
	    <script src="/foundation/js/foundation/foundation.js"></script>
	    <script src="/foundation/js/foundation/foundation.reveal.js"></script>
	    <script>
	     	 $(document).foundation();
	    </script>
  	</body>
</html>