function event(){

    let form = document.getElementById('form');
let btn = document.getElementById('btn');
let id = document.getElementById('id');
let pw = document.getElementById('pw');

    btn.addEventListener('click', function(){
        let idValue = id.value;
        let pwValue = pw.value;
        console.log(idValue.length)
        console.log(pwValue.length)
        
        if(idValue.length != 0 && pwValue.length != 0){
            form.submit();
        } else if(idValue.length == 0 && pwValue.length == 0){
            alert('id와 pw가 입력되지 않았습니다')
        } else if(idValue.length == 0){
            alert('id가 입력되지 않았습니다')
        } else{
            alert('pw가 입력되지 않았습니다')
        }
        // if(idValue.length != 0 && pwValue.length)

    });
}


function joincheck(){
    // 1. ID 입력 조건
    //const id = document.getElementById('id');
    const id = document.querySelector('#id');
    const idm = document.getElementById('idm');

    id.addEventListener('blur', function(){
        if(id.value.length <= 2){
            idm.innerHTML = 'ID를 두 글자 이상 입력해주세요';
        }else{
            idm.innerHTML = "";
        }
    })

    //2. PW 입력 조건
    const pw = document.getElementById('pw');
    const pwn = document.getElementById('pwm');

    pw.addEventListener('keyup', function(){
        if(pw.value.length <= 6){
        pwm.innerHTML = 'PW를 6글자 이상 입력해주세요';
        }else{
            pwm.innerHTML = "";
        }
    })

    //3. PW 확인
    const pw2 = document.getElementById('pw2');
    const pwm2 = document.getElementById('pwm2');

    pw2.addEventListener('blur', function(){
        if(pw.value == pw2.value){
            pwm2.innerHTML = '비밀번호가 일치합니다';
        }else{
            pwm2.innerHTML = '비밀번호가 일치하지 않습니다';
        }
    })

    //4. name, email, phone 메세지 출력
    // const name = document.getElementById('name');
    // const email = document.getElementById('email');
    // const phone = document.getElementById('phone');
    // const cb = document.getElementsByClassName('cb');
    const cb = document.querySelectorAll('.cb');
    const ch = document.getElementsByClassName('ch');

    for(let i = 0; i < cb.length; i++){
        cb[i].addEventListener('blur', function(){
            console.log(ch[i])
            if(cb[i].value.length < 2){
                ch[i].innerHTML = "한 글자 이상 입력해주세요";
            }else{
                ch[i].innerHTML = "";
            }

        })
    }

    //5. submit 시에 조건이 충족하는지
    const btn = document.getElementById('btn');
    const form = document.getElementById('form');
    
    btn.addEventListener('click', function(){
        let check = true;
        for(let j=0; j<cb.length;j++){
        if(cb[j].value.length < 2){
            check = false;
            break;
        }
        }
        if((id.value.length > 2) && (pw.value.length > 6) && (pw.value == pw2.value) && check){
            form.submit();
        }else{
            alert("입력 조건을 확인해주세요")
        }
    })
}

