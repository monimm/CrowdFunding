function closeTabSwitch(){
    document.getElementById("close-tab-before").style.display="none";
    document.getElementById("close-tab-after").style.display="block";
}

function openTabSwitch(){
 
    document.getElementById("open-tab-before").style.display="none";
    document.getElementById("open-tab-after").style.display="block";
    $("close-detail-user").slideToggle(10)

}

/******************* Tab Switch ********************/
$(document).ready(function(){
    $("#close-tab-before").click(function(){
        $("#close-detail-user").slideToggle(10);
    });
});

$(document).ready(function(){
    $("#close-tab-user").click(function(){
        $("#close-detail-pjt").hide();
        $("#close-detail-user").show();
    });
});

$(document).ready(function(){
    $("#close-tab-pjt").click(function(){
        $("#close-detail-pjt").show();
        $("#close-detail-user").hide();
    });
});

$(document).ready(function(){
    $("#open-tab-before").click(function(){
        $("#open-detail-user").slideToggle(10);
    });
});

$(document).ready(function(){
    $("#open-tab-user").click(function(){
        $("#open-detail-pjt").hide();
        $("#open-detail-user").show();
        $("#open-detail-reward").hide();
    });
});

$(document).ready(function(){
    $("#open-tab-pjt").click(function(){
        $("#open-detail-pjt").show();
        $("#open-detail-user").hide();
        $("#open-detail-reward").hide();
    });
});

$(document).ready(function(){
    $("#open-tab-reward").click(function(){
        $("#open-detail-pjt").hide();
        $("#open-detail-user").hide();
        $("#open-detail-reward").show();
    });
});

/******************** Li Style Change ********************/

/******************** 输入框字数检查 ********************/
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


var maxstrlen4=20;
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


var maxstrlen5=200;
function QFive(s5){return document.getElementById(s5);}
function checkWordFive(c5){
    len5=maxstrlen5;
    var str5 = c5.value;
    myLen5=getStrlengFive(str5);
    var wck5=QFive("wordCheckFive");
    if(myLen5>len5*2){
        c5.value=str5.substring(0,i5+1);
    }
    else{
        wck5.innerHTML = Math.floor((len5*2-myLen5)/2);
    }
}   
function getStrlengFive(str5){
    myLen5 =0;
    i5=0;
    for(;(i5<str5.length)&&(myLen5<=maxstrlen5*2);i5++){
        if(str5.charCodeAt(i5)>0&&str5.charCodeAt(i5)<128)
            myLen5++;
        else
            myLen5+=2;
    }
    return myLen5;
}


var maxstrlen6=500;
function QSix(s6){return document.getElementById(s6);}
function checkWordSix(c6){
    len6=maxstrlen6;
    var str6 = c6.value;
    myLen6=getStrlengSix(str6);
    var wck6=QSix("wordCheckSix");
    if(myLen6>len6*2){
        c6.value=str6.substring(0,i6+1);
    }
    else{
        wck6.innerHTML = Math.floor((len6*2-myLen6)/2);
    }
}   
function getStrlengSix(str6){
    myLen6 =0;
    i6=0;
    for(;(i6<str6.length)&&(myLen6<=maxstrlen6*2);i6++){
        if(str6.charCodeAt(i6)>0&&str6.charCodeAt(i6)<128)
            myLen6++;
        else
            myLen6+=2;
    }
    return myLen6;
}

/****** update ******/
$(document).ready(function(){
    $("#close-tab-close").click(function(){
        $("a").removeClass("li-active");
        $("#close-tab-user a").addClass("li-active");
    });
});

$(document).ready(function(){
    $("#close-tab-user").click(function(){
        $("a").removeClass("li-active");
        $("#close-tab-user a").addClass("li-active");
    });
});
$(document).ready(function(){
    $("#close-tab-pjt").click(function(){
        $("a").removeClass("li-active");
        $("#close-tab-pjt a").addClass("li-active");
    });
});

$(document).ready(function(){
    $("#open-tab-open").click(function(){
        $("a").removeClass("li-active");
        $("#open-tab-user a").addClass("li-active");
    });
});

$(document).ready(function(){
    $("#open-tab-user").click(function(){
        $("a").removeClass("li-active");
        $("#open-tab-user a").addClass("li-active");
    });
});

$(document).ready(function(){
    $("#open-tab-pjt").click(function(){
        $("a").removeClass("li-active");
        $("#open-tab-pjt a").addClass("li-active");
    });
});

$(document).ready(function(){
    $("#open-tab-reward").click(function(){
        $("a").removeClass("li-active");
        $("#open-tab-reward a").addClass("li-active");
    });
});

$(".detail-content-item-content .input").on("click",function(){
    $(".input").removeClass("input-active");
    $(this).addClass("input-active");
});