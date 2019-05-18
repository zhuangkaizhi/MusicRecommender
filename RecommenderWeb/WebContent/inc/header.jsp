<div class="container-fluid">
        
	<div id="navbar-menuIcon">
		<button id="sidebarCollapse" class="btn btn-info" type="button">
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
	<div id="navbarSupportedContent" class="collapse navbar-collapse">
		<ul class="nav navbar-nav ml-auto">
			<li class="nav-item">
				<!-- a class="btn btn-primary" href="#">
                        <i class="material-icons md-36">account_circle</i>
                     </a -->
			</li>
			<li class="nav-item">
				<!-- a class="btn btn-primary" href="#"><i class="fa fa-user fa-fw"></i>User</a -->
			</li>
			
			<li class="nav-item" ng-show = "!loginStaus">
				<button type="button" class="btn btn-primary" ng-click="goToSignUp();">Sign Up</button>
			</li>
			<li class="nav-item" ng-show="!loginStaus">
				<button type="button" class="btn btn-primary" ng-click="goToSignIn();">Sign In</button>
			</li>
			
			<li class="nav-item" ng-show="loginStaus">
                {{userName}}
            </li>
			
			<li class="nav-item" ng-show ="loginStaus">
			 <div class="dropdown">
			    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
			         <i class="material-icons" style="font-size:32px;">account_circle</i>
			    </button>
			    <div class="dropdown-menu">
			      <a class="dropdown-item" href="#" ng-click="loginOut();">Sign Out</a>
			    </div>
			  </div>
			</li>
			
		</ul>
	</div>
</div>
