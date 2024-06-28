let pwVal = "", pwReVal = "", isPwValid = false
const pwInputEl = document.querySelector('#userPwd')
const pwErrorMsgEl = document.querySelector('#userPwdMsg')
pwInputEl.addEventListener('change', () => {
  const pwRegExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/
  pwVal = pwInputEl.value
  if(pwRegExp.test(pwVal)) { // 정규식 조건 만족 O
    isPwValid = true
    pwErrorMsgEl.textContent = ""
  } 
  else { // 정규식 조건 만족 X
    isPwValid = false
    pwErrorMsgEl.textContent = "8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
  }
  checkPwValid()
  console.log(pwVal, pwReVal, isPwValid, account)
});

/*** SECTION - PASSWORD RECHECK ***/
const pwReInputEl = document.querySelector('#checkUserPwd')
const pwReErrorMsgEl = document.querySelector('#checkUserPwdMsg')
pwReInputEl.addEventListener('change', () => {
  pwReVal = pwReInputEl.value
  checkPwValid()
  console.log(pwVal, pwReVal, isPwValid, account)
});

// 비밀번호와 재입력 값 일치 여부
function checkPwValid() {
    
    if(pwReVal === "") { // 미입력
      pwReErrorMsgEl.textContent = ""
    }
    else if(pwVal === pwReVal) { // 비밀번호 재입력 일치
      if(isPwValid)
        account.pw = pwVal
      pwReErrorMsgEl.style.color = "green"
      pwReErrorMsgEl.textContent = "일치"
    }
    else { // 비밀번호 재입력 불일치
      pwReErrorMsgEl.style.color = "red"
      pwReErrorMsgEl.textContent = "불일치"
    }
  }