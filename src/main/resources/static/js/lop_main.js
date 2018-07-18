/* Tab切换 */
function lop_tabSwitch(lop_tabID){
    if(lop_tabID==0){
        for(i=0;i<4;i++){
            document.getElementById("lop_tabCon_"+i).style.display="none";    
        }
        document.getElementById("lop_tabCon_"+lop_tabID).style.display="block";
        document.getElementById("lop_lastStep").style.display="none";
        document.getElementById("lop_nextStep").style.display="block";
        document.getElementById("lop_submit").style.display="none";
    }
    else if(lop_tabID==1){
        for(i=0;i<4;i++){
            document.getElementById("lop_tabCon_"+i).style.display="none";    
        }
        document.getElementById("lop_tabCon_"+lop_tabID).style.display="block";
        document.getElementById("lop_lastStep").style.display="block";
        document.getElementById("lop_nextStep").style.display="block";
        document.getElementById("lop_submit").style.display="none";
    }
    else if(lop_tabID==2){
        for(i=0;i<4;i++){
            document.getElementById("lop_tabCon_"+i).style.display="none";    
        }
        document.getElementById("lop_tabCon_"+lop_tabID).style.display="block";
        document.getElementById("lop_lastStep").style.display="block";
        document.getElementById("lop_nextStep").style.display="block";
        document.getElementById("lop_submit").style.display="none";
    }
    else if(lop_tabID==3){
        for(i=0;i<4;i++){
            document.getElementById("lop_tabCon_"+i).style.display="none";    
        }
        document.getElementById("lop_tabCon_"+lop_tabID).style.display="block";
        document.getElementById("lop_lastStep").style.display="none";
        document.getElementById("lop_nextStep").style.display="none";
        document.getElementById("lop_submit").style.display="block";
    }
}
/* Tab切换的button */
function lop_tabNext(){
    if(document.getElementById("lop_tabCon_1").style.display=="block"){
        document.getElementById("lop_tabCon_1").style.display="none";
        document.getElementById("lop_tabCon_2").style.display="block";
        document.getElementById("lop_lastStep").style.display="block";
    }
    else if(document.getElementById("lop_tabCon_2").style.display=="block"){
        document.getElementById("lop_tabCon_2").style.display="none";
        document.getElementById("lop_tabCon_3").style.display="block";
        document.getElementById("lop_nextStep").style.display="none";
        document.getElementById("lop_submit").style.display="block";
    }
    else if(document.getElementById("lop_tabCon_3").style.display=="block"){
        document.getElementById("lop_nextStep").style.display="none";

    }
    else{
        document.getElementById("lop_tabCon_0").style.display="none";
        document.getElementById("lop_tabCon_1").style.display="block";
        document.getElementById("lop_lastStep").style.display="block";
    }
    return false; /* 点击按钮时会刷新页面，根据网上经验改为onclick="return function()" function(){return false} */
}
function lop_tabLast(){
    if(document.getElementById("lop_tabCon_1").style.display=="block"){
        document.getElementById("lop_tabCon_1").style.display="none";
        document.getElementById("lop_tabCon_0").style.display="block";
        document.getElementById("lop_lastStep").style.display="none";
    }
    else if(document.getElementById("lop_tabCon_2").style.display=="block"){
        document.getElementById("lop_tabCon_2").style.display="none";
        document.getElementById("lop_tabCon_1").style.display="block";
    }
    else if(document.getElementById("lop_tabCon_3").style.display=="block"){
        document.getElementById("lop_tabCon_3").style.display="none";
        document.getElementById("lop_tabCon_2").style.display="block";
        document.getElementById("lop_submit").style.display="none";
        document.getElementById("lop_nextStep").style.display="block";
    }
    return false;
}


/* 输入框字数检查 */
var maxstrlen1=20;
function QOne(s1){return document.getElementById(s1);}
function checkWordOne(c1){
    len1=maxstrlen1;
    var str1 = c1.value;
    myLen1=getStrlengOne(str1);
    var wck1=QOne("wordCheckOne");
    if(myLen1>len1*2){
        c1.value=str1.substring(0,i1+1);
    }
    else{
        wck1.innerHTML = Math.floor((len1*2-myLen1)/2);
    }
}   
function getStrlengOne(str1){
    myLen1 =0;
    i1=0;
    for(;(i1<str1.length)&&(myLen1<=maxstrlen1*2);i1++){
        if(str1.charCodeAt(i1)>0&&str1.charCodeAt(i1)<128)
            myLen1++;
        else
            myLen1+=2;
    }
    return myLen1;
}


var maxstrlen2=200;
function QTwo(s2){return document.getElementById(s2);}
function checkWordTwo(c2){
    len2=maxstrlen2;
    var str2 = c2.value;
    myLen2=getStrlengTwo(str2);
    var wck2=QTwo("wordCheckTwo");
    if(myLen2>len2*2){
        c2.value=str2.substring(0,i2+1);
    }
    else{
        wck2.innerHTML = Math.floor((len2*2-myLen2)/2);
    }
}   
function getStrlengTwo(str2){
    myLen2 =0;
    i2=0;
    for(;(i2<str2.length)&&(myLen2<=maxstrlen2*2);i2++){
        if(str2.charCodeAt(i2)>0&&str2.charCodeAt(i2)<128)
            myLen2++;
        else
            myLen2+=2;
    }
    return myLen2;
}

var maxstrlen3=500;
function QThree(s3){return document.getElementById(s3);}
function checkWordThree(c3){
    len3=maxstrlen3;
    var str3 = c3.value;
    myLen3=getStrlengThree(str3);
    var wck3=QThree("wordCheckThree");
    if(myLen3>len3*2){
        c3.value=str3.substring(0,i3+1);
    }
    else{
        wck3.innerHTML = Math.floor((len3*2-myLen3)/2);
    }
}   
function getStrlengThree(str3){
    myLen3 =0;
    i3=0;
    for(;(i3<str3.length)&&(myLen3<=maxstrlen3*2);i3++){
        if(str3.charCodeAt(i3)>0&&str3.charCodeAt(i3)<128)
            myLen3++;
        else
            myLen3+=2;
    }
    return myLen3;
}

var maxstrlen4=100;
function QFour(s4){return document.getElementById(s4);}
function checkWordFour(c4){
    len4=maxstrlen4;
    var str4 = c4.value;
    myLen4=getStrlengFour(str4);
    var wck4=QFour("wordCheckFour");
    if(myLen4>len4*2){
        c4.value=str4.substring(0,i4+1);
    }
    else{
        wck4.innerHTML = Math.floor((len4*2-myLen4)/2);
    }
}   
function getStrlengFour(str4){
    myLen4 =0;
    i4=0;
    for(;(i4<str4.length)&&(myLen4<=maxstrlen4*2);i4++){
        if(str4.charCodeAt(i4)>0&&str4.charCodeAt(i4)<128)
            myLen4++;
        else
            myLen4+=2;
    }
    return myLen4;
}
