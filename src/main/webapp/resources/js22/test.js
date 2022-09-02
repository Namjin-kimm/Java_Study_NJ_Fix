alert("Welcome");

//1
// int  num = 1; java
var num = 1;

let num2 = '1';

console.log(num == num2);
console.log(num === num2);

for(let i = 0; i < 10; i++){
    console.log(i);
    var count = 2;
}
console.log('--------------')
console.log('--------------')

let ar = ['4', 1, 3, '2'];
console.log(ar[0]);
console.log(ar[1]);

ar.push(5);
console.log(ar);
ar.unshift('9');
console.log(ar);
ar.sort();
console.log(ar);
ar.reverse();
console.log(ar);

ar.forEach(function(v, i, ar){
    console.log("v", v); // "v :" + v
    console.log("i : ", i);
    console.log("--------------")
});