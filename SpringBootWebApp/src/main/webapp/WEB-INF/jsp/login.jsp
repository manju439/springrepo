<html><head><title>Login Page</title></head><body onload="document.f.username.focus();">
<h3>Login with Username and Password</h3><form name="f" action="/login" method="POST">
<table>
	<tbody><tr><td>User:</td><td><input type="text" name="username" value=""></td></tr>
	<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
	<tr><td colspan="2"><input name="submit" type="submit" value="Login"></td></tr>
	<input name="_csrf" type="hidden" value="ffbf7f8a-7d31-44fb-900f-206ef9c93811">
</tbody></table>
</form></body></html>