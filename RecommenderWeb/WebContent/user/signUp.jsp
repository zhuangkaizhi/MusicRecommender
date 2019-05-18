
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<div class="card bg-dark">
	<article class="card-body mx-auto" style="min-width: 400px; max-width: 500px;">
		<h4 class="card-title mt-3 text-center">Create Account</h4>
		<p class="text-center">Get started with your free account</p>

		<form name="userForm" ng-submit="submitRegForm();" ng-init="initRegForm();" >
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-user"></i></span>
				</div>
				<input  id ="username" type="text"  class="form-control"
				        placeholder="Full name" 
				        ng-model="myUser.userName" 
				        ng-minlength="3" 
				        ng-maxlength="12"
				        required/>
				<div class="invalid-feedback">Please fill out this field.</div>
			
			</div>
			<!-- form-group// -->
			<div class="form-group input-group" >
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-envelope"></i></span>
				</div>
				<input  class="form-control" 
				        placeholder="Email address" 
				        type="email"
				        ng-model="myUser.userEmail" required/>
				        
		        <div class="invalid-feedback">Please input a valid email.</div>
        
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-user"></i>
					</span>
				</div>
				<select class="form-control" ng-model="myUser.userGender" required>
                    <option value="">--Gender--</option>
                    <option value="0">Male</option>
                    <option value="1">Female</option>
				</select>
			</div>
			
			<!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                </div>
                <select class="form-control" ng-model="myUser.userBirthDay" required>
                    <option ng-repeat="item in arrDays" value="{{item.value}}">{{item.label}}</option>
               </select>
               
               <select  class="form-control" ng-model="myUser.userBirthMonth" required>
                    <option ng-repeat="item in arrMonths" value="{{item.value}}">{{item.label}}</option>
               </select>
               <select  class="form-control"  ng-model="myUser.userBirthYear" required>
                    <option ng-repeat="item in arrYears" value="{{item.value}}">{{item.label}}</option>
               </select>
            </div>
			
			<!-- form-group end.// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-lock"></i></span>
				</div>
				<input id="firstPassword" ng-model="myUser.firstPassword" class="form-control" placeholder="Create password" type="password" required>
				<div class="invalid-feedback">The password is wrong</div>
			</div>
			
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-lock"></i></span>
				</div>
				<input id="secondPassword" ng-model="myUser.secondPassword" class="form-control" placeholder="Repeat password" type="password" required>
				<div class="invalid-feedback">The password is not same</div>
			</div>
			
			<div class="form-check">
				<input type="checkbox" id="accept-terms" class="form-check-input" required>
				<label for ="accept-terms" class="form-check-label">Accept Terms &amp; Conditions</label>
			</div>
			
			<!-- form-group// -->
			<div class="form-group">
				<button type="submit" 
				        class="btn btn-primary btn-block"
				        ng-disabled="userForm.$invalid"
				        >
				        Create Account
				</button>
			</div>
			
			<div class="form-group" ng-show="regFail">
                <span style="color: red; font-size: small;">Your email has been registered.</span>
            </div>
			<!-- form-group// -->
			<p class="text-center">	 
			     Have an account? <a href="">Log In</a>
			</p>
		</form>
	</article>
</div>
<!-- card.// -->

