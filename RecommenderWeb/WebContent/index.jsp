<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Recommender</title>
    
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/main_style.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>

</head>

<body>
    <nav class="navbar navbar-expand-lg" role="navigation">
       <div class="container-fluid">
           <div id="navbarIcon">
                <button id="sidebarCollapse" class="btn btn-info" type="button"  >
                    <i class="fas fa-align-justify"></i>
                </button>
           </div>
        
           <div id="navbarSearchBox">
                <form class="navbar-form" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search music">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default">
                                <i class="fas fa-search"></i>
                            </button>
                        </span>
                    </div>
                </form>
           
           </div>
           <div id="navbarSupportedContent" class="collapse navbar-collapse" >
               <ul class="nav navbar-nav ml-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="#"><i class="fa fa-cog"></i>Icon 1</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="#"><i class="fa fa-cog"></i>Icon 2</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="#"><i class="fa fa-cog"></i>Icon 3</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="#"><i class="fa fa-cog"></i>Profile</a>
                   </li>
               </ul>
           </div>
       </div>
   </nav>

   <div class="wrapper">
       <!-- Sidebar  -->
       <nav id="sidebar">
           <div class="sidebar-header">
               <h3>Recommend System</h3>
           </div>

           <ul class="list-unstyled components">
               <p>Recommend System</p>
               <li>
                   <a href="#homeSubmenu" data-toggle="collapse" 
                        aria-expanded="false" 
                        class="dropdown-toggle">
                        <i class="fas fa-home"></i>
                        <span>Home</span>
                   </a>
                  
                   <ul class="collapse list-unstyled" id="homeSubmenu">
                       <li>
                           <a href="#">Home 1</a>
                       </li>
                       <li>
                           <a href="#">Home 2</a>
                       </li>
                       <li>
                           <a href="#">Home 3</a>
                       </li>
                   </ul>
               </li>
               <li>
                   <a href="#">
                        <i class="fas fa-eject"></i>
                        <span>About</span>
                   </a>
               </li>
               <li>
                   <a href="#pageSubmenu" 
                        data-toggle="collapse" 
                        aria-expanded="false" 
                        class="dropdown-toggle">
                        <i class="fas fa-file-audio"></i>
                        <span>Music</span>
                   </a>
                   <ul class="collapse list-unstyled" id="pageSubmenu">
                       <li>
                           <a href="#">Page 1</a>
                       </li>
                       <li>
                           <a href="#">Page 2</a>
                       </li>
                       <li>
                           <a href="#">Page 3</a>
                       </li>
                   </ul>
               </li>
               
               <li>
                   <a href="#">
                        <i class="fas fa-compact-disc"></i>
                        <span>Others</span>
                    </a>
                   
               </li>
               <li>
                   <a href="#">
                    <i class="fas fa-address-card"></i>
                        <span>Contact</span>
                   </a>
               </li>
           </ul>
       </nav>

       <!-- Page Content  -->
       <div id="content">
		    <jsp:include page="content/main_content.jsp"></jsp:include> 
       </div>
    
   </div>
    
    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
    

    <script type="text/javascript">
        /*
        $(function() {
            $("#content").load("content/main_content.jsp");
        }); 
        */
    </script>
   
     <script src="js/content.js"></script>
</body>

</html>