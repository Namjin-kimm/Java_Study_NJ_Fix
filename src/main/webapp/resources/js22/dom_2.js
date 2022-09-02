
//1. 선택자
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
let d3 = document.getElementById("d3");

alert(d1.getAttribute("value"));
alert(d1.id);

d2.type = 'button';
// d2.setAttribute("type", "button");

let count = prompt("숫자를 입력하세요")
let t="";

for(let i = 0; i < count; i++){
    t=t+'<input type="text">';
}
d3.innerHTML = t;

let year = document.getElementById('year');
let y = "";
for(let i = 2022; i >= 1900; i--){
    y = y + '<option value="1">' + i + '</option>'
 }
 year.innerHTML = y;

let month = document.getElementById('month');
let m = "";
for(let i = 1; i <= 12; i++){
   m = m + '<option value="1">' + i + '</option>'
}
month.innerHTML = m;

let date = document.getElementById('date');
let d = "";
for(let i = 1; i <= 31; i++){
   d = d + '<option value="1">' + i + '</option>'
}
date.innerHTML = d;


let r = prompt("ROW의 갯수 입력"); //3
let c = prompt("column의 갯수 입력"); //2

const d4 = document.getElementById('d4');

let table = "";

for(let i = 0; i < r; i++){
    table = table + '<tr>';
    for(let j = 0; j < c; j++){
        table = table + '<td>' + i + j + '</td>'
    }
    table = table + '</tr>';
}

d4.innerHTML = table;