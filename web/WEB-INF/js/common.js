/**
 * Created by song on 16/7/22.
 */
//$ = require("jquery");

common_submit_binder = function(){
    $('.submit_button').on("click",function(){
        var submitForm = {};
        $.each($(this).closest(".submit_form").find(':text'),function(){
            submitForm[$(this).attr('name')] = $(this).val();
        });
        var callback = default_success_callback;
        if($(this).attr("callback")){
            callback = eval($(this).attr("callback"));
        }
        var submitType = $(this).attr('method')||"get";
        $.ajax({
            type: submitType,
            url: $(this).attr('url'),
            data: JSON.stringify(submitForm),
            dataType: 'json',
            contentType : 'application/json',
            success: callback,
            error: function(data){
                console.log("-------" + data);
                alert("操作失败");
            }
        });
    });
};

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

default_success_callback = function(data){
    var msg;
    if(data.status == 1)
        msg = data.message || "操作成功";
    else
        msg = data.message || "操作失败";
    console.log(data);
    alert(msg);
}
for(key in table_init ){
    $(".submit_form tbody").append("<tr><td>"+key+"</td><td><input type='text' name='"+key+"' value='"+table_init[key]+"'/></tr>")
}
common_submit_binder();
