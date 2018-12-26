var SnippetLogin = function() {
    var e = $("#m_login"),
    i = function(e, i, a) {
        var l = $('<div class="m-alert m-alert--outline alert alert-' + i + ' alert-dismissible" role="alert">\t\t\t<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>\t\t\t<span></span>\t\t</div>');
        e.find(".alert").remove(),
        l.prependTo(e),
        mUtil.animateClass(l[0], "fadeIn animated"),
        l.find("span").html(a)
    },
    a = function() {
        e.removeClass("m-login--forget-password"),
        e.removeClass("m-login--signup"),
        e.addClass("m-login--signin"),
        mUtil.animateClass(e.find(".m-login__signin")[0], "flipInX animated")
    },
    l = function() {
        $("#m_login_forget_password").click(function(i) {
            i.preventDefault(),
            e.removeClass("m-login--signin"),
            e.removeClass("m-login--signup"),
            e.addClass("m-login--forget-password"),
            mUtil.animateClass(e.find(".m-login__forget-password")[0], "flipInX animated")
        }),
        $("#m_login_forget_password_cancel").click(function(e) {
            e.preventDefault(),
            a()
        }),
        $("#m_login_signup").click(function(i) {
            i.preventDefault(),
            e.removeClass("m-login--forget-password"),
            e.removeClass("m-login--signin"),
            e.addClass("m-login--signup"),
            mUtil.animateClass(e.find(".m-login__signup")[0], "flipInX animated")
        }),
        $("#m_login_signup_cancel").click(function(e) {
            e.preventDefault(),
            a()
        })
    };
    return {
        init: function() {
            l(),
            $("#m_login_signin_submit").click(function(e) {
                e.preventDefault();
                var a = $(this),
                l = $(this).closest("form");
                l.validate({
                    rules: {
                        mobile: {
                            required: !0,
                            tel: !0
                        },
                        password: {
                            required: !0
                        }
                    }
                }),
                l.valid() && (a.addClass("m-loader m-loader--right m-loader--light").attr("disabled", !0), l.ajaxSubmit({
                    url: '/login',
                    type: 'POST',
                    timeout: 5000,
                    success: function(e, t, r, s) {
                    	alert(1);
                    	a.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1);
                    	if(e == 'ACCOUNT_DOES_NOT_EXIST'){
                            i(l, "danger", "抱歉，账号不存在！")
                    	}else if(e == 'WRONG_PASSWORD'){
                            i(l, "danger", "抱歉，账号或者密码错误！")
                    	}else if(e == 'TRY_TOO_MANY_TIMES'){
                    		i(l, "danger", "抱歉，尝试登录次数过多，请5分钟后再试！")
                    	}else{
                    		i(l, "success", "恭喜，登录成功！");
                    	}
                    },
                    error: function(e,t,r,s){
                    	a.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1);
                    	i(l, "danger", "抱歉，服务器异常，请联系管理员");
                    }
                }))
            }),
            $("#m_login_signup_submit").click(function(l) {
                l.preventDefault();
                var t = $(this),
                r = $(this).closest("form");
                r.validate({
                    rules: {
                        mobile: {
                            required: !0,
                            tel: !0
                        },
                        password: {
                            required: !0
                        },
                        agree: {
                            required: !0
                        }
                    }
                }),
                r.valid() && (t.addClass("m-loader m-loader--right m-loader--light").attr("disabled", !0), r.ajaxSubmit({
                    url: "",
                    success: function(l, s, n, o) {
                        setTimeout(function() {
                            t.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1),
                            r.clearForm(),
                            r.validate().resetForm(),
                            a();
                            var l = e.find(".m-login__signin form");
                            l.clearForm(),
                            l.validate().resetForm(),
                            i(l, "success", "非常感谢！您已经成为我们的一员了")
                        },
                        2e3)
                    }
                }))
            }),
            $("#m_login_forget_password_submit").click(function(l) {
                l.preventDefault();
                var t = $(this),
                r = $(this).closest("form");
                r.validate({
                    rules: {
                        mobile: {
                            required: !0,
                            tel: !0
                        }
                    }
                }),
                r.valid() && (t.addClass("m-loader m-loader--right m-loader--light").attr("disabled", !0), r.ajaxSubmit({
                    url: "",
                    success: function(l, s, n, o) {
                        setTimeout(function() {
                            t.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1),
                            r.clearForm(),
                            r.validate().resetForm(),
                            a();
                            var l = e.find(".m-login__signin form");
                            l.clearForm(),
                            l.validate().resetForm(),
                            i(l, "success", "太棒了！新的密码已经发送你的手机上")
                        },
                        2e3)
                    }
                }))
            })
        }
    }
} ();
jQuery(document).ready(function() {
    SnippetLogin.init()
});

$.validator.messages.required = "不能为空";
jQuery.validator.addMethod("tel", function (value, element) {
	var tel = /^\d{3,4}-?\d{7,9}$/;  
	return this.optional(element) || (tel.test(value) );  
}, "请正确填写您的联系电话");  

