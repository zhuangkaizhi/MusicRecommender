
<div class="card bg-dark">
    <article class="card-body mx-auto" style="min-width: 400px; max-width: 500px; height: 700px;">
        <h4 class="card-title mt-3 text-center">Sign In</h4>
        <p class="text-center">Sign in your free account</p>

        <form name="userForm" ng-submit="submitLoginForm();" ng-init="initLoginForm();" >
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
            
            <!-- form-group end.// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-lock"></i></span>
                </div>
                <input id="firstPassword" ng-model="myUser.firstPassword" class="form-control" placeholder="Input your password" type="password" required>
                <div class="invalid-feedback">The password is wrong</div>
            </div>
            
            <!-- form-group// -->
            <div class="form-group">
                <button type="submit" 
                        class="btn btn-primary btn-block"
                        ng-disabled="userForm.$invalid"
                        >
                        Sing In
                </button>
            </div>
            
            <!-- form-group end.// -->
            <div class="form-group" ng-show="loginFail">
                <span style="color: red; font-size: small;">Couldn't find your account or your password is not correct.</span>
            </div>
            
        </form>
    </article>
</div>
<!-- card.// -->

