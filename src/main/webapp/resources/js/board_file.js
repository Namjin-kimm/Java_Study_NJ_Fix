/* <p>Image</p>
<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="files"></p> */
//<button type="button" class="del">삭제</button>

const addFiles = document.getElementById('addFiles');
const fileAdd = document.getElementById('fileAdd');

//파일 선택 추가
let count = 0;
let idx = 0;
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