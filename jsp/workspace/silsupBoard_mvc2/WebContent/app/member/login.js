/**
 * 로그인
 */


function formSubmit(){
	var form = document.loginForm;
	
	if(form.memberId.value == "" || form.memberPw.value == ""){
		alert("아이디 혹은 비밀번호를 입력해주세요.");
		form.memberId.focus();
		return false;
	}
	
		
	form.submit();
}