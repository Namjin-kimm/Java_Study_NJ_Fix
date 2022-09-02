console.log('dom_1');

let result = window.confirm("확인?????");
console.log('result :' + result);

result = window.prompt("이름을 입력하세요");
console.log('result :' + result);

let d1 = window.document.getElementById("d1");
window.alert(d1);
console.log(d1);
d1.innerHTML = '<h1>' + result + '</h1>';
d1.innerText = '<h1>' + result + '</h1>';

let d2 = document.getElementById("d2");
console.log(d2.innerHTML);
console.log(d2.innerText);

let d3 = document.getElementById("d3");
d4.innerHTML = d3.innerHTML;