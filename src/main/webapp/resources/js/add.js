let userId = document.querySelector("#userId");
let id = document.querySelector("#idCheck")

userId.onchange = checkId

function checkId(){
   if(userId.value.length < 4 || userId.value.length > 15){
    alert("4~15자리의 영문과 숫자를 가져야 합니다.");
   	userId.value = null;
   	id.innerText = "";
   	userId.focus();
   }
    
  let userIdVal = userId.value;
  if(userId.value != ""){
  $.ajax({
    url : "/kopo/checkId",
    type: "post",
    data: {userId:userIdVal},
    success: function(result){
      if(result == 1){
        id.innerText = "이미 사용중인 아이디입니다."
        id.style.color = "#dc3545"
      }
      else if(result == 0){
        id.innerText = "사용할 수 있는 아이디입니다."
        id.style.color = "#2fb380"    
      }
    },
    error: function(){
      alert("서버요청실패")
    }
  });
  }
}

let pwVal = "", pwReVal = ""
const pwInputEl = document.querySelector('#userPwd')
const pwErrorMsgEl = document.querySelector('#userPwdMsg')
pwInputEl.addEventListener('change', () => {
  const pwRegExp = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/
  pwVal = pwInputEl.value
  if(pwRegExp.test(pwVal)) { // 정규식 조건 만족 O
    isPwValid = true
    pwErrorMsgEl.textContent = "조건만족"
  } 
  else { // 정규식 조건 만족 X
    pwErrorMsgEl.textContent = "8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
    pwInputEl.focus();
  }
  
});

/*** SECTION - PASSWORD RECHECK ***/
const pwReInputEl = document.querySelector('#checkUserPwd')
const pwReErrorMsgEl = document.querySelector('#checkUserPwdMsg')
pwReInputEl.addEventListener('change', () => {
  pwReVal = pwReInputEl.value
  checkPwValid()
});

// 비밀번호와 재입력 값 일치 여부
function checkPwValid() {
    
    if(pwReVal === "") { // 미입력
      pwReErrorMsgEl.textContent = ""
    }
    else if(pwVal === pwReVal) { // 비밀번호 재입력 일치      
      pwReErrorMsgEl.style.color = "green"
      pwReErrorMsgEl.textContent = "일치"
    }
    else { // 비밀번호 재입력 불일치
      pwReErrorMsgEl.style.color = "red"
      pwReErrorMsgEl.textContent = "불일치"
      pwReInputEl.value = null;
      pwReInputEl.focus();
    }
}

function autoEmail(a,b){
  
  const mailId = b.split('@'); // 메일계정의 ID만 받아와서 처리하기 위함
  const mailList = ['naver.com','gmail.com','daum.net','hanmail.net','yahoo.com','outlook.com','nate.com','kakao.com']; // 메일목록
  let availableCity = new Array; // 자동완성 키워드 리스트
  
  if(b.includes("@")){  

    for(let i=0; i < mailList.length; i++ ){
      availableCity.push( mailId[0] +'@'+ mailList[i] ); // 입력되는 텍스트와 메일목록을 조합
    }
    $("#"+a).autocomplete({
      source: availableCity // jQuery 자동완성에 목록을 넣어줌
      
    });
  }
  else{
    availableCity = null;
    $("#"+a).autocomplete({    
      source: availableCity
      
    });
  }
}

