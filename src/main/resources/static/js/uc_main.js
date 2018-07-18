/********************* Tab切换 ************************/
/* 左右Big Tab切换 */
function uc_tabSwitch(uc_tabID){
    for(i=0;i<6;i++){
        document.getElementById("uc_tabCon_"+i).style.display="none";    
    }
    document.getElementById("uc_tabCon_"+uc_tabID).style.display="block";
}
/* 右侧主体Child Tab-Account Tab切换 */
function uc_acntTabSwitch(uc_acntTabID){
    for(i=0;i<2;i++){
        document.getElementById("uc_acntTabCon_"+i).style.display="none";    
    }
    document.getElementById("uc_acntTabCon_"+uc_acntTabID).style.display="block";
}
/* 右侧主体Child Tab-Message Tab切换 */
function uc_msgTabSwitch(uc_msgTabID){
    for(i=0;i<3;i++){
        document.getElementById("uc_msgTabCon_"+i).style.display="none";    
    }
    document.getElementById("uc_msgTabCon_"+uc_msgTabID).style.display="block";
}
/* 右侧主体Child Tab-Order Tab切换 */
function uc_odrTabSwitch(uc_odrTabID){
    for(i=0;i<3;i++){
        document.getElementById("uc_odrTabCon_"+i).style.display="none";    
    }
 
    document.getElementById("uc_odrTabCon_"+uc_odrTabID).style.display="block";
    //updateOrder();
   
}
/* 右侧主体Child Tab-Project Tab切换 */
function uc_pjtTabSwitch(uc_pjtTabID){
    for(i=0;i<3;i++){
        document.getElementById("uc_pjtTabCon_"+i).style.display="none";    
    }
    //updateProject();
    document.getElementById("uc_pjtTabCon_"+uc_pjtTabID).style.display="block";
}

/********************** 弹窗 ***************************/
/* 绑定手机弹窗 */
function uc_openDialogBindPhone(){
    document.getElementById('uc_bindPhoneNumCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogBindPhone(){
    document.getElementById('uc_bindPhoneNumCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 解绑手机弹窗 */
function uc_openDialogUnbindPhone(){
    document.getElementById('uc_unbindPhoneNumCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogUnbindPhone(){
    document.getElementById('uc_unbindPhoneNumCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 绑定邮箱弹窗 */
function uc_openDialogBindEmail(){
    document.getElementById('uc_bindEmailCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogBindEmail(){
    document.getElementById('uc_bindEmailCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 解绑邮箱弹窗 */
function uc_openDialogUnbindEmail(){
    document.getElementById('uc_unbindEmailCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogUnbindEmail(){
    document.getElementById('uc_unbindEmailCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 充值弹窗 */
function uc_openDialogTopUp(){
    document.getElementById('uc_topUpCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogTopUp(){
    document.getElementById('uc_topUpCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 提现弹窗 */
function uc_openDialogWithdraw(){
    document.getElementById('uc_withdrawCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogWithdraw(){
    document.getElementById('uc_withdrawCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 选择支付方式弹窗 */
function uc_openDialogPayChoice(){
    document.getElementById('uc_odrInfoTrCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogPayChoice(){
    document.getElementById('uc_odrInfoTrCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/* 消息详情弹窗 */
function uc_openDialogMsgDetail(){
    document.getElementById('uc_msgInfoTrCon').style.display='block';
    document.getElementById('uc_body').style.display='block';
}
function uc_closeDialogMsgDetail(){
    document.getElementById('uc_msgInfoTrCon').style.display='none';
    document.getElementById('uc_body').style.display='none';
}
/*************** 我的订单删除订单 ****************/
function uc_getRow(odr_element){
    var odr_rowID=odr_element.parentNode.parentNode.rowIndex;
    return odr_rowID;
}
function uc_delUnpaidOdr(odr_element){
    document.getElementById("uc_UnpaidOdrTable").deleteRow(uc_getRow(odr_element));
    document.getElementById("uc_UnpaidOdrTable").deleteRow(uc_getRow(odr_element+1));
}

