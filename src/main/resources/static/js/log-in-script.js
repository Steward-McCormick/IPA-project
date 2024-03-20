function show_hide_password(target){
	var input = document.getElementById('pass');
	if (input.getAttribute('type') == 'password') {
		target.classList.add('view');
		input.setAttribute('type', 'text');
	} else {
		target.classList.remove('view');
		input.setAttribute('type', 'password');
	}
	return false;
}

function show_hide_second_password(target) {
	var input = document.getElementById('second-pass');
	if (input.getAttribute('type') == 'password') {
		target.classList.add('view');
		input.setAttribute('type', 'text');
	} else {
		target.classList.remove('view');
		input.setAttribute('type', 'password');
	}
	return false;
}

function forget_login_password() {
	var text = document.getElementById("forget-login-password")
	text.style.display = "flex"
}

function hide_forget_text() {
	var text = document.getElementById("forget-login-password")
	text.style.display = "none"
}