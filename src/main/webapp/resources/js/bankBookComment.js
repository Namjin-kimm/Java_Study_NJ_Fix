const btn = document.querySelector('#btn');
const writer = document.querySelector('#writer');
const contents = document.querySelector('#contents');

btn.addEventListener('click', function(){
    // console.log(btn.getAttribute("data-booknum"));
    let booknum = btn.getAttribute("data-booknum");
    let wv = writer.value;
    let cv = contents.value;

    //-----------------------ajax-------------------------
    //1. XMLHTTPRequest 객체 생성
    const xhttp = new XMLHttpRequest();
    
    //2. Method, url 준비
    xhttp.open("POST", "./commentAdd");
    
    //3. Enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    //4. 요청 발생 (post일 경우 파라미터 추가)
    xhttp.send("bookNum=" + booknum + "&writer=" + wv + "&contents=" + cv);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);

            if(result.result == 1){
                alert("댓글이 등록되었습니다");
                getCommentList();
            }
        }
    }

}); // click event

const commentList = document.querySelector('#commentList');

function getCommentList(){
    //1. xmlHttpRequest
   const xhttp = new XMLHttpRequest();

   //2. 메서드, url
   xhttp.open('get', "./commentList?page=1&bookNum=" + btn.getAttribute('data-booknum'));

   //3. 요청 전송
   xhttp.send();

   //4.응답 처리
   xhttp.addEventListener("readystatechange", function(){
    if(xhttp.readyState == 4 && xhttp.status == 200){
        console.log(this.responseText);
        //1. jsp 사용한 결과물
        //commentList.innerHTML = this.responseText;

        //2. JSON 결과물
        let ar = JSON.parse(xhttp.responseText.trim());
        let table = document.createElement('table');
        let thead = document.createElement('thead');
        let tbody = document.createElement('tbody');
        
        for(let i = 0;i<ar.length;i++){

            // console.log(ar[i]);
            // console.log(ar[i].contents);
            // console.log(ar[i].writer);
            let tr = document.createElement('tr');
            let td = document.createElement('td');
            //let tdText = document.createTextNode(ar[i].contents);
            //td.appendChild(tdText);
            td.innerHTML = ar[i].contents;
            tr.appendChild(td);

            td = document.createElement('td');
            td.innerHTML = ar[i].writer;
            tr.appendChild(td);

            td = document.createElement('td');
            td.innerHTML = ar[i].regDate;
            tr.appendChild(td);

            tbody.appendChild(tr);
        }
        table.appendChild(tbody);
        let cla = document.createAttribute('class');
        cla.value = "table table-success table-striped-columns";
        table.setAttributeNode(cla);
        commentList.innerHTML = "";
        commentList.append(table);
    }
   })
}

getCommentList();


