const d1 = document.getElementById('d1');
const d2 = document.getElementById('d2');
const d3 = document.getElementById('d3');
const btn = document.getElementById('btn');
const btn2 = document.getElementById('btn2');
const btn3 = document.getElementById('btn3');

// let one = prompt('1번째 칸 숫자 입력')
// let two = prompt('2번째 칸 숫자 입력')

// d1.setAttribute('value', one);
// d2.setAttribute('value', two);

// let result = "";

// btn.addEventListener('click', function(){
//     console.log(one, two);
//     result = one * two;
//     console.log(result);
//     d3.setAttribute('value', result);
// });


//Event 등록
btn.addEventListener("click", function(){
    console.log("work");
    console.log(d1.value);
    console.log(d2.value);

    d3.value=d1.value * 1 +d2.value * 1;
    console.log(d3.value);
});

btn2.addEventListener('click', function(){
    alert("haha")
})

btn3.addEventListener('click', function(){
    btn2.click();
})
