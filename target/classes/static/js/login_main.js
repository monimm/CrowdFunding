function log_regSwitch(SwitchID){
    if(SwitchID==0){
        document.getElementById("login").style.display="none";
        document.getElementById("register").style.display="block";
    }
    else if(SwitchID==1){
        document.getElementById("login").style.display="block";
        document.getElementById("register").style.display="none";
    }
}

$(function() {

    /*tab标签切换*/
    function tabs(tabTit, on, tabCon) {
        $(tabCon).each(function() {
            $(this).children().eq(0).show();

        });
        $(tabTit).each(function() {
            $(this).children().eq(0).addClass(on);
        });
        $(tabTit).children().click(function() {
            $(this).addClass(on).siblings().removeClass(on);
            var index = $(tabTit).children().index(this);
            $(tabCon).children().eq(index).show().siblings().hide();
        });
    }
    tabs(".form-header", "on", ".form-content");

})