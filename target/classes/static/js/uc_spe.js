/*************** Tab Switch ***************/
$(document).ready(function(){
    $("#uc-user").click(function(){
        $("#uc-content-user").show();
        $("#uc-content-account").hide();
        $("#uc-content-order").hide();
        $("#uc-content-project").hide();
        $("#uc-content-message").hide();
        $("#uc-content-set").hide();
    });
});
$(document).ready(function(){
    $("#uc-account").click(function(){
        $("#uc-content-user").hide();
        $("#uc-content-account").show();
        $("#uc-content-order").hide();
        $("#uc-content-project").hide();
        $("#uc-content-message").hide();
        $("#uc-content-set").hide();
    });
});
$(document).ready(function(){
    $("#uc-order").click(function(){
        $("#uc-content-user").hide();
        $("#uc-content-account").hide();
        $("#uc-content-order").show();
        $("#uc-content-project").hide();
        $("#uc-content-message").hide();
        $("#uc-content-set").hide();
    });
});
$(document).ready(function(){
    $("#uc-project").click(function(){
        $("#uc-content-user").hide();
        $("#uc-content-account").hide();
        $("#uc-content-order").hide();
        $("#uc-content-project").show();
        $("#uc-content-message").hide();
        $("#uc-content-set").hide();
    });
});
$(document).ready(function(){
    $("#uc-message").click(function(){
        $("#uc-content-user").hide();
        $("#uc-content-account").hide();
        $("#uc-content-order").hide();
        $("#uc-content-project").hide();
        $("#uc-content-message").show();
        $("#uc-content-set").hide();
    });
});
$(document).ready(function(){
    $("#uc-set").click(function(){
        $("#uc-content-user").hide();
        $("#uc-content-account").hide();
        $("#uc-content-order").hide();
        $("#uc-content-project").hide();
        $("#uc-content-message").hide();
        $("#uc-content-set").show();
    });
});
$(document).ready(function(){
    $("#uc-balance").click(function(){
        $("#uc-account-balance-content").show();
        $("#uc-account-transaction-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-transaction").click(function(){
        $("#uc-account-balance-content").hide();
        $("#uc-account-transaction-content").show();
    });
});
$(document).ready(function(){
    $("#uc-allorder").click(function(){
        $("#uc-order-all-content").show();
        $("#uc-order-unpaid-content").hide();
        $("#uc-order-paid-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-unpaidorder").click(function(){
        $("#uc-order-all-content").hide();
        $("#uc-order-unpaid-content").show();
        $("#uc-order-paid-content").hide();
    });
});$(document).ready(function(){
    $("#uc-paidorder").click(function(){
        $("#uc-order-all-content").hide();
        $("#uc-order-unpaid-content").hide();
        $("#uc-order-paid-content").show();
    });
});

$(document).ready(function(){
    $("#uc-allproject").click(function(){
        $("#uc-project-all-content").show();
        $("#uc-project-unfin-content").hide();
        $("#uc-project-fin-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-unfinproject").click(function(){
        $("#uc-project-all-content").hide();
        $("#uc-project-unfin-content").show();
        $("#uc-project-fin-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-finproject").click(function(){
        $("#uc-project-all-content").hide();
        $("#uc-project-unfin-content").hide();
        $("#uc-project-fin-content").show();
    });
});

$(document).ready(function(){
    $("#uc-allmessage").click(function(){
        $("#uc-message-all-content").show();
        $("#uc-message-unread-content").hide();
        $("#uc-message-read-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-unreadmessage").click(function(){
        $("#uc-message-all-content").hide();
        $("#uc-message-unread-content").show();
        $("#uc-message-read-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-readmessage").click(function(){
        $("#uc-message-all-content").hide();
        $("#uc-message-unread-content").hide();
        $("#uc-message-read-content").show();
    });
});

/***** Children Tab Switch *****/
$(document).ready(function(){
    $("#uc-account-balance").click(function(){
        $("#uc-account-balance-content").show();
        $("#uc-account-transaction-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-account-transaction").click(function(){
        $("#uc-account-balance-content").hide();
        $("#uc-account-transaction-content").show();
    });
});
$(document).ready(function(){
    $("#uc-order-all").click(function(){
        $("#uc-order-all-content").show();
        $("#uc-order-unpaid-content").hide();
        $("#uc-order-paid-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-order-unpaid").click(function(){
        $("#uc-order-all-content").hide();
        $("#uc-order-unpaid-content").show();
        $("#uc-order-paid-content").hide();
    });
});$(document).ready(function(){
    $("#uc-order-paid").click(function(){
        $("#uc-order-all-content").hide();
        $("#uc-order-unpaid-content").hide();
        $("#uc-order-paid-content").show();
    });
});
$(document).ready(function(){
    $("#uc-project-all").click(function(){
        $("#uc-project-all-content").show();
        $("#uc-project-unfin-content").hide();
        $("#uc-project-fin-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-project-unfin").click(function(){
        $("#uc-project-all-content").hide();
        $("#uc-project-unfin-content").show();
        $("#uc-project-fin-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-project-fin").click(function(){
        $("#uc-project-all-content").hide();
        $("#uc-project-unfin-content").hide();
        $("#uc-project-fin-content").show();
    });
});
$(document).ready(function(){
    $("#uc-message-all").click(function(){
        $("#uc-message-all-content").show();
        $("#uc-message-unread-content").hide();
        $("#uc-message-read-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-message-unread").click(function(){
        $("#uc-message-all-content").hide();
        $("#uc-message-unread-content").show();
        $("#uc-message-read-content").hide();
    });
});
$(document).ready(function(){
    $("#uc-message-read").click(function(){
        $("#uc-message-all-content").hide();
        $("#uc-message-unread-content").hide();
        $("#uc-message-read-content").show();
    });
});
$(document).ready(function(){
    $("#uc-myusername").click(function(){
        $("#uc-content-account").hide();
        $("#uc-content-project").hide();
        $("#uc-content-order").hide();
        $("#uc-content-message").hide();
        $("#uc-content-set").hide();
        $("#uc-content-user").show();
        $("li").removeClass("nav-active");
        $("#uc-user").addClass("nav-active");
    });
});
$(document).ready(function(){
    $("#uc-mybalance").click(function(){
        $("#uc-content-user").hide();
        $("#uc-content-project").hide();
        $("#uc-content-order").hide();
        $("#uc-content-message").hide();
        $("#uc-content-set").hide();
        $("#uc-content-account").show();
        $("li").removeClass("nav-active");
        $("#uc-account").addClass("nav-active");
        $("li").removeClass("child-nav-active");
        $("#uc-account-balance").addClass("child-nav-active");
    });
});
$(document).ready(function(){
    $("#uc-mymessage").click(function(){
        $("#uc-content-account").hide();
        $("#uc-content-project").hide();
        $("#uc-content-order").hide();
        $("#uc-content-user").hide();
        $("#uc-content-set").hide();
        $("#uc-content-message").show();
        $("li").removeClass("nav-active");
        $("#uc-message").addClass("nav-active");
        $("#uc-message-all-content").hide();
        $("#uc-message-unread-content").show();
        $("li").removeClass("child-nav-active");
        $("#uc-message-unread").addClass("child-nav-active");
    });
});




/**************** Dialog ****************/
/***** 充值弹窗 *****/
function uc_openDialogTopup(){
    document.getElementById('uc-dialog-topup').style.display='block';
    document.getElementById('uc_body').addClass("uc-exceptdialog");
}
function uc_closeDialogTopup(){
    document.getElementById('uc-dialog-topup').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 提现弹窗 *****/
function uc_openDialogWithdraw(){
    document.getElementById('uc-dialog-withdraw').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogWithdraw(){
    document.getElementById('uc-dialog-withdraw').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 绑定手机弹窗 *****/
function uc_openDialogBindphone(){
    document.getElementById('uc-dialog-bindphone').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogBindphone(){
    document.getElementById('uc-dialog-bindphone').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 解绑手机弹窗 *****/
function uc_openDialogUnbindphone(){
    document.getElementById('uc-dialog-unbindphone').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogUnbindphone(){
    document.getElementById('uc-dialog-unbindphone').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 绑定邮箱弹窗 *****/
function uc_openDialogBindemail(){
    document.getElementById('uc-dialog-bindemail').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogBindemail(){
    document.getElementById('uc-dialog-bindemail').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 解绑邮箱弹窗 *****/
function uc_openDialogUnbindemail(){
    document.getElementById('uc-dialog-unbindemail').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogUnbindemail(){
    document.getElementById('uc-dialog-unbindemail').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 修改用户名弹窗 *****/
function uc_openDialogResetname(){
    document.getElementById('uc-dialog-resetname').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogResetname(){
    document.getElementById('uc-dialog-resetname').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 修改密码弹窗 *****/
function uc_openDialogResetkey(){
    document.getElementById('uc-dialog-resetkey').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogResetkey(){
    document.getElementById('uc-dialog-resetkey').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 修改头像弹窗 *****/
function uc_openDialogResetprofile(){
    document.getElementById('uc-dialog-resetprofile').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogResetprofile(){
    document.getElementById('uc-dialog-resetprofile').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 去支付弹窗 *****/
function uc_openDialogGopay(){
    document.getElementById('uc-dialog-gopay').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogGopay(){
    document.getElementById('uc-dialog-gopay').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/***** 消息详情弹窗 *****/
function uc_openDialogAllmsgdetail(that){
    //document.getElementById('uc-dialog-allmsgdetail').style.display='block';
    //document.getElementById('uc_body').style.display='block';
	that.parentNode.children[1].style.display = 'block';
}
function uc_closeDialogAllmsgdetail(that){
    /*document.getElementById('uc-dialog-allmsgdetail').style.display='none';
    document.getElementById('uc_body').style.display='none';*/
	that.parentNode.parentNode.style.display = 'none';

}
function uc_openDialogUnreadmsgdetail(that){
 /*   document.getElementById('uc-dialog-unreadmsgdetail').style.display='block';
    document.getElementById('uc_body').style.display='block';*/
	that.parentNode.children[1].style.display = 'block';

}
function uc_closeDialogUnreadmsgdetail(that){
  /*  document.getElementById('uc-dialog-unreadmsgdetail').style.display='none';
    document.getElementById('uc_body').style.display='none';*/
	that.parentNode.parentNode.style.display = 'none';

}
function uc_openDialogReadmsgdetail(that){
    /*document.getElementById('uc-dialog-readmsgdetail').style.display='block';
    document.getElementById('uc_body').style.display='block';*/
	that.parentNode.children[1].style.display = 'block';

}
function uc_closeDialogReadmsgdetail(that){
   /* document.getElementById('uc-dialog-readmsgdetail').style.display='none';
    document.getElementById('uc_body').style.display='none';*/
	that.parentNode.parentNode.style.display = 'none';

}
/******************* Special *******************/
$("#uc-user").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-user").addClass("nav-active");
});
$("#uc-account").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-account").addClass("nav-active");
    $("#uc-account-balance").addClass("child-nav-active");
});
$("#uc-balance").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-account").addClass("nav-active");
    $("#uc-balance").addClass("nav-active");
    $("#uc-account-balance").addClass("child-nav-active");
});
$("#uc-account-balance").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-account").addClass("nav-active");
    $("#uc-balance").addClass("nav-active");
    $("#uc-account-balance").addClass("child-nav-active");
});
$("#uc-account-transaction").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-account").addClass("nav-active");
    $("#uc-transaction").addClass("nav-active");
    $("#uc-account-transaction").addClass("child-nav-active");
});
$("#uc-order").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-order").addClass("nav-active");
    $("#uc-allorder").addClass("nav-active");
    $("#uc-order-all").addClass("child-nav-active");
});
$("#uc-order-all").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-order").addClass("nav-active");
    $("#uc-allorder").addClass("nav-active");
    $("#uc-order-all").addClass("child-nav-active");
});
$("#uc-order-unpaid").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-order").addClass("nav-active");
    $("#uc-unpaidorder").addClass("nav-active");
    $("#uc-order-unpaid").addClass("child-nav-active");
});
$("#uc-order-paid").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-order").addClass("nav-active");
    $("#uc-paidorder").addClass("nav-active");
    $("#uc-order-paid").addClass("child-nav-active");
});
$("#uc-project").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-project").addClass("nav-active");
    $("#uc-allproject").addClass("nav-active");
    $("#uc-project-all").addClass("child-nav-active");
});
$("#uc-project-all").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-project").addClass("nav-active");
    $("#uc-allproject").addClass("nav-active");
    $("#uc-project-all").addClass("child-nav-active");
});
$("#uc-project-unfin").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-project").addClass("nav-active");
    $("#uc-unfinproject").addClass("nav-active");
    $("#uc-project-unfin").addClass("child-nav-active");
});
$("#uc-project-fin").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-project").addClass("nav-active");
    $("#uc-finproject").addClass("nav-active");
    $("#uc-project-fin").addClass("child-nav-active");
});
$("#uc-message").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-message").addClass("nav-active");
    $("#uc-allmessage").addClass("nav-active");
    $("#uc-message-all").addClass("child-nav-active");
});
$("#uc-allmessage").on("click",function(){
    $("li").removeClass("nav-active");
    $("#uc-message").addClass("nav-active");
    $("#uc-allmessage").addClass("nav-active");
    $("#uc-message-all").addClass("child-nav-active");
    $("li").removeClass("child-nav-active");
});
$("#uc-message-all").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-message").addClass("nav-active");
    $("#uc-allmessage").addClass("nav-active");
    $("#uc-message-all").addClass("child-nav-active");
});
$("#uc-message-unread").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-message").addClass("nav-active");
    $("#uc-unreadmessage").addClass("nav-active");
    $("#uc-message-unread").addClass("child-nav-active");
});
$("#uc-message-read").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-message").addClass("nav-active");
    $("#uc-readmessage").addClass("nav-active");
    $("#uc-message-read").addClass("child-nav-active");
});
$("#uc-set").on("click",function(){
    $("li").removeClass("nav-active");
    $("li").removeClass("child-nav-active");
    $("#uc-set").addClass("nav-active");
});

$(".uc-dialog-item .input").on("click",function(){
    $(".input").removeClass("input-active");
    $(this).addClass("input-active");
});
$(".uc-dialog-item .child").on("click",function(){
    $(".child").removeClass("child-active");
    $(this).addClass("child-active");
});