function onClickMainCheckBox(mainCheckBox) {
    let checkBox = document.getElementsByName("list");
    if(mainCheckBox.checked===true){
        for(let i = 0; i < checkBox.length; i++){
            checkBox[i].checked=true;
        }
    }else{
        for(let i = 0; i < checkBox.length; i++){
            checkBox[i].checked=false;
        }
    }
}