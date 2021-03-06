/**
 * 자동차 주행에 필요한 js
 */

var check = false;
var policeCnt = 0;

function SuperCar(){
	this.brand = "Ferrari";
	this.color = "red";
	this.price = 15000;
}

function activeEnter(){
	if(window.event.keyCode == 13){
		//시동 켜기
		SuperCar.engineStart();
	}
}

SuperCar.prototype.pw = prompt("자동차 초기 비밀번호 입력");

const result = document.getElementById("result");

SuperCar.showInput = function(){
	if(!check){
		//시동을 켤 수 있는 상태
		//input태그 visible
		const inputTag = document.getElementById("pw");
		inputTag.style.visibility = "visible";
	}else{
		//시동이 이미 켜져있는 상태
		result.innerHTML = "이미 시동이 켜져있습니다.";
	}
}

//프로토타입의 메소드 사용 방법
//SuperCar.engineStart()

SuperCar.engineStart = function(){
	const img = document.getElementById("stat");
	const inputTag = document.getElementById("pw");
	
	var pw = inputTag.value;
	
	//비밀번호 검사(SuperCar.prototype.pw : 초기비밀번호)
	if(SuperCar.prototype.pw == pw){
		policeCnt = 0;
		img.src = "시동켜기.gif";
		inputTag.value = "비밀번호 입력";
		inputTag.style.visibility = "hidden";
		result.innerHTML = "시동 켜짐";
		check = true;
	}else{
		//연속 3회 오류 시 경찰 출동
		policeCnt++;
		
		if(policeCnt == 3){
			img.src = "경찰.png";
			document.getElementById("on").style.display = "none";
			document.getElementById("off").style.display = "none";
			inputTag.style.display = "none";
			result.innerHTML = "경찰 출동";
		}else{
			result.innerHTML = "비밀번호 오류 : " + policeCnt + "회";
		}
	}
}

SuperCar.engineStop = function(){
	//시동을 끌 수 있는 상태
	if(check){
		const img = document.getElementById("stat");
		img.src = "시동끄기.gif";
		result.innerHTML = "시동 꺼짐";
		check = false;
	}else{
		//시동이 이미 꺼져있는 상태
		result.innerHTML = "이미 시동이 꺼져있습니다.";
	}
}

















