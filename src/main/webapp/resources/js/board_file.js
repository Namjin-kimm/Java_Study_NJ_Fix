/* <p>Image</p>
<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="files"></p> */
//<button type="button" class="del">삭제</button>

const addFiles = document.getElementById('addFiles');
const fileAdd = document.getElementById('fileAdd');
const fileDelete = document.querySelectorAll('.fileDelete'); //foreach 사용 가능
//const fileDelete = document.getElementClassName('fileDelete'); 이건 foreach 사용 불가능

//------------------------- Update시 file Delete ----------------------------------
try{
fileDelete.forEach(function(f){
    f.addEventListener('click', function(){


        //console.log('file Delete');

        let check = window.confirm("삭제하시겠습니까 이 자쉭아?");

        if(!check){
            return;
        }

       let fileNum = f.getAttribute('data-file-num');
       //ajax
       const xhttp = new XMLHttpRequest();

       xhttp.open("POST", "./fileDelete");

       xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

       xhttp.send("fileNum=" + fileNum);

       xhttp.onreadystatechange=function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
            let result = xhttp.responseText.trim();
            if(result == 1){
                console.log(result);
                f.parentNode.remove();
                count--;
            }else{
                console.log(result);
            }
        }
       }

    })
});
}catch(e){
    console.log(e);
}



// for(fi of fileDelete){
//     console.log(fi);
// }

//파일 선택 추가
let count = 0;
let idx = 0;

//기존에 추가되있던 파일까지 고려
function setCount(c){
    if(c >= 0){
        count = c;
    }
}

try{

    fileAdd.addEventListener('click', function(){

        //count ++;
        // if(count > 5){
        //     alert('최대 5개만 가능')
        //     return;
        // }

        if(count < 5){
            //  부모 div 생성
            let div = document.createElement('div');
            let cla = document.createAttribute('class');
            cla.value = 'mb-3'
            div.setAttributeNode(cla);
            cla = document.createAttribute('id');
            cla.value = 'file' + idx;
            console.log(idx);
            div.setAttributeNode(cla);
            addFiles.append(div);
            
            
            //자식 input 생성
            let c = document.createAttribute('class');
            let p = document.createElement('p');
            let p2 = document.createElement('p');
            let Image = document.createTextNode('Image');
            let input = document.createElement('input');
            c.value = "form-control form-control-lg"
            let t = document.createAttribute('type');
            t.value = "file";
            let l = document.createAttribute('aria-label')
            l.value = ".form-control-lg example"
            let n = document.createAttribute('name');
            n.value = "files";
            
            p.appendChild(Image);
            div.append(p);
            
            div.append(p2);
            p2.appendChild(input);
            input.setAttributeNode(c);
            input.setAttributeNode(t);
            input.setAttributeNode(l);
            input.setAttributeNode(n);
            
            //삭제 버튼
            let button = document.createElement('button');
            let type = document.createAttribute('type');
            type.value = "button";
            let cl = document.createAttribute('class');
            cl.value = "btn btn-danger del";
            let text = document.createTextNode("삭제");
            let title = document.createAttribute('title');
            title.value = idx;
            button.appendChild(text);
            button.setAttributeNode(type);
            button.setAttributeNode(cl);
            button.setAttributeNode(title);
            div.append(button);
            
            count ++;
            idx++;

            
        }else{
            alert('파일첨부는 5개까지만 가능합니다')
        }

    })

    addFiles.addEventListener('click', function(event){
        if(event.target.classList[2] == "del"){
            console.log(event.target.title);
            let div = document.getElementById('file' + event.target.title);
            div.remove();
            count--;

        }
    })

}catch(e){

}