

const d1 = document.querySelector('#d1'); //getElementByID와 결과 같음
const d1_2_1_2 = document.querySelector('#d1_2_1_2');
const btn = document.querySelector('#btn')

console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);



console.log('-------------------------------------')
btn.addEventListener('click', function(){
    console.log(d1_2_1_2.parentNode.parentNode);
    d1_2_1_2.parentNode.parentNode.remove();
})

//parent
console.log(d1_2_1_2.parentNode.parentNode.parentNode);

console.log('-------------------------------------')

//child

console.log(d1.childNodes);
console.log(d1.children);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);
console.log(d1.children[1].children[0].children[0].innerHTML)

d1.addEventListener('click', function(){
    //li 모두 삭제
    console.log(d1.children[1].children[0].children)
    //1.remove
   let li = d1.children[1].children[0].children
   console.log(li);
   for(let i = 0; i != li.length;){
    li[0].remove();
   }

   //2. removeChild()
});