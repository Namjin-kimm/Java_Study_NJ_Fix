/* <p>Image</p>
<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="files"></p> */

const addFiles = document.getElementById('addFiles');
const fileAdd = document.getElementById('fileAdd');

let count = 0;
fileAdd.addEventListener('click', function(){

    //count ++;
    // if(count > 5){
    //     alert('최대 5개만 가능')
    //     return;
    // }

    count ++;
    if(count < 6){
    let p = document.createElement('p');
    let p2 = document.createElement('p');
    let Image = document.createTextNode('Image');
    let input = document.createElement('input');
    let c = document.createAttribute('class');
    c.value = "form-control form-control-lg"
    let t = document.createAttribute('type');
    t.value = "file";
    let l = document.createAttribute('aria-label')
    l.value = ".form-control-lg example"
    let n = document.createAttribute('name');
    n.value = "files";
    
    p.appendChild(Image);
    addFiles.append(p);

    addFiles.append(p2);
    p2.appendChild(input);
    input.setAttributeNode(c);
    input.setAttributeNode(t);
    input.setAttributeNode(l);
    input.setAttributeNode(n);

    }else{
        alert('파일첨부는 5개까지만 가능합니다')
    }




})