//agree.js
function check(){

    const all = document.getElementById('all');
    const ch = document.getElementsByClassName('ch');
    const join = document.getElementById('join');
    const form = document.getElementById('form');
    const req = document.getElementsByClassName('req');
    
    all.addEventListener("click", function(){
        console.log(all.checked);
        for(let i=0; i<ch.length; i++){
            ch[i].checked=all.checked;
        }
    });
    
    for(let i=0; i<ch.length; i++){
        ch[i].addEventListener("click", check);
    }
    
    function check(){
        let result = true;
        for(let i=0; i<ch.length; i++){
            if(!ch[i].checked){
                result=false;
                break;
            }
        } 
        all.checked=result; 
    }
    
    join.addEventListener('click', function(){
        // if(all.checked){
            //     form.submit();
            // }else{
                //     alert('필수약관에 동의하십시오')
                // }
                let result = true;
                for(let i = 0; i < req.length;i++){
                    if(!req[i].checked){
                        result = false;
                        break;
                    }
                }
                if(result){
                    form.submit();
                }else{
                    alert('필수약관에 동의하십시오')
                }
            });
            
            
}