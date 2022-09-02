//dom_5.js

const d2 = document.getElementById('d2');
const d1 = document.getElementById('d1');
const d3 = document.getElementById('d3');
const d5 = document.getElementById('d5');
const d4 = document.getElementById('d4');

d2.addEventListener('focus',function(){
    console.log('입력준비 상태')
})

d2.addEventListener('blur',function(){
    console.log('blur 실행')
})

d1.addEventListener('blur', check);

function check(){
    console.log(d1.value.length)
    if(d1.value.length <= 3){
        d1.focus();
    }
}

d3.addEventListener('change', function(){
    console.log('change Event 발생')
});

//d1 입력하고 나왔을 때 글자의 길이가 3글자 이하라면 d1에 강제로 다시 입력 대기 상태

d5.addEventListener('change',function(){
    console.log('change Event 발생')
})

let result = "";
d4.addEventListener('keyup',function(){
    console.log('keyup event 발생')
    result ++;
    console.log(result);
})
