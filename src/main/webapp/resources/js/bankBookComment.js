const btn = document.querySelector('#btn');
const writer = document.querySelector('#writer');
const contents = document.querySelector('#contents');
//페이지 번호 담는 변수
let page = 1;
//bookNum을 담는 변수
const bookNum = btn.getAttribute('data-bookNum');

getCommentList(page, bookNum);

btn.addEventListener('click', function(){
    // console.log(btn.getAttribute("data-booknum"));
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
    xhttp.send("bookNum=" + bookNum + "&writer=" + wv + "&contents=" + cv);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);

            if(result.result == 1){
                alert("댓글이 등록되었습니다");

                if(commentList.children.length != 0){
                    for(let i = 0; i<commentList.children.length;){
                        commentList.children[i].remove();
                    }
                }

                page = 1;
                getCommentList(page, bookNum);
                //댓글 등록 후에는 무조건 첫번째 페이지가 와야 되기 때문에
            }
        }
    }

}); // click event

const commentList = document.querySelector('#commentList');
let idx = 0;

function getCommentList(p, bn){
    //1. xmlHttpRequest
   const xhttp = new XMLHttpRequest();

   //2. 메서드, url
   xhttp.open('get', "./commentList?page=" + p + "&bookNum=" + bn/*btn.getAttribute('data-booknum')*/);

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

        let pager = ar.pager;
        let list = ar.list;
        // let table = document.createElement('table');
        // let thead = document.createElement('thead');
        let tbody = document.createElement('tbody');
        // let tbodyAttr = document.createAttribute('id');
        

        //table css 주기
        let cla = document.createAttribute('class');
        cla.value = "table table-success table-striped-columns";
        commentList.setAttributeNode(cla);
        //table css 주기
        
        for(let i = 0;i<list.length;i++){
            
            // console.log(ar[i]);
            // console.log(ar[i].contents);
            // console.log(ar[i].writer);
            let tr = document.createElement('tr');
            
            //. 삭제할 행의 ID
            let trId = document.createAttribute('id');
            trId.value = 'tr' + idx;
            tr.setAttributeNode(trId);

            let td = document.createElement('td');
            //let tdText = document.createTextNode(ar[i].contents);
            //td.appendChild(tdText);
            td.innerHTML = list[i].contents;
            tr.appendChild(td);

            td = document.createElement('td');
            td.innerHTML = list[i].writer;
            tr.appendChild(td);

            td = document.createElement('td');
            //날짜 format 변경
            // let date = new Date(list[i].regDate);
            // console.log(date);
            // let year = date.getFullYear();
            // let month = date.getMonth();
            // let d = date.getDate();
            // console.log(year);
            // console.log(month);
            // console.log(d);
            // tdText = document.createTextNode(year + month + d);
            // td.appendChild(tdText);
            
            td.innerHTML = list[i].regDate;
            tr.appendChild(td);

            td = document.createElement('td');
            tdText = document.createTextNode("수정");
            let tdAttr = document.createAttribute('class');
            tdAttr.value = 'update';
            td.setAttributeNode(tdAttr);

            //num 집어넣기
            tdAttr = document.createAttribute('data-num')
            tdAttr.value = list[i].num;
            td.setAttributeNode(tdAttr);

            td.appendChild(tdText);
            tr.appendChild(td);

            td = document.createElement('td');
            tdText = document.createTextNode("삭제");
            tdAttr = document.createAttribute('class');
            tdAttr.value = 'delete';
            td.setAttributeNode(tdAttr);

            //. 삭제 버튼 title
            let title = document.createAttribute('title');
            title.value = idx;
            td.setAttributeNode(title);

            tdAttr = document.createAttribute('data-num')
            tdAttr.value = list[i].num;
            td.setAttributeNode(tdAttr);
            td.appendChild(tdText);
            tr.appendChild(td);
            
            tbody.appendChild(tr);
            idx++;
        }
        commentList.append(tbody);

        if(page >= pager.totalPage){
            more.classList.add('disabled');
        }else{
            more.classList.remove('disabled');
        }
        
        
        //commentList.innerHTML = "";
        console.log(commentList.children);

        // let t = commentList.children;
        // if(t.length != 0){
        //     commentList.children[0].remove();
        // }
        
        // try{
            //     console.log(commentList.children());
            //     throw new Error("에러 메세지 ");
            // }catch(exception){ 
                
                // }finally{            
                    
                    // }
        // commentList.append(table);
                    
    }
   })

}

//-------------------------더보기-------------------
const more = document.querySelector('#more');

more.addEventListener('click', function(){
    page++;
    getCommentList(page, bookNum);
});

//--------------------댓글 수정 삭제-------------------------

commentList.addEventListener('click', function(event){
    //1. 댓글 수정
    if(event.target.className == 'update'){

        // console.log('update');
        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML = "<textarea>" + v + "</textarea>";

        // Modal 창 이용
        
        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        document.querySelector("#updateContents").value=contents;
        
        let writer = event.target.previousSibling.previousSibling.value;
        document.querySelector("#updateWriter").value = writer;
        
        let num = event.target.getAttribute("data-num");
        document.querySelector("#num").value = num;
        
        document.querySelector('#up').click();

        
        //2. 댓글 삭제
    }else if(event.target.className == 'delete'){
        console.log('delete');
        let check = window.confirm('삭제할거야?');
        if(check == true){
            console.log(event.target.getAttribute('data-num'));
            
            //1. xmlHTTPRequest 객체 생성
            const xhttp = new XMLHttpRequest();
            
            //2. 메서드, url 정보
            xhttp.open('POST', "./commentDelete");
            
            //3. enctype(Defalut 값)
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            
            //4. 요청 발생
            xhttp.send("num=" + event.target.getAttribute('data-num'));
            
            //5. 응답 처리
            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){
                    let get = xhttp.responseText.trim();
                    get = JSON.parse(get);
                    console.log(get.result);
                    
                    if(get.result == 1){
                        alert("삭제 성공")
                        
                        // 1. 리스트를 다시 불러오는 것
                        // if(commentList.children.length != 0){
                            //     for(let i = 0; i<commentList.children.length;){
                                //         commentList.children[i].remove();
                                //     }
                                // }
                                // page = 1;
                                // getCommentList(page, bookNum);
                                
                                //2. 해당 행만 삭제
                                let t = event.target.getAttribute('title');
                                let trId = 'tr' + t;
                                console.log()
                                document.getElementById(trId).remove();
                                
                            }else{
                                alert("삭제 실패");
                            }
                        }
                    }
                }
            }
        });
        
        const sendUpdateBtn = document.querySelector('#sendUpdateBtn');
        sendUpdateBtn.addEventListener('click', function(){
            console.log('click sendUpdateBtn');

            let contents = document.querySelector("#updateContents").value;
            let num = document.querySelector('#num').value;

            //1. Xhttp Request 객체 선언
            const xHttp = new XMLHttpRequest();
        
            //2. 요청에 대한 정보 쓰기(Method, Url)
            xHttp.open('POST', './commentUpdate');
        
            //3. Header 정보(Enctype)
            xHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        
            //4. 요청 실행
            xHttp.send("num=" + num + "&contents=" + contents);
        
            //5. 응답 처리
            xHttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){
                    let result = xHttp.responseText.trim();
                    if(result > 0){
                        alert("수정 완료");
                        if(commentList.children.length != 0){
                            for(let i = 0; i<commentList.children.length;){
                                commentList.children[i].remove();
                            }
                        }
                        page = 1;
                        getCommentList(page, bookNum);
                    }else{
                        alert("수정 실패");
                    }
                }
            }
});





