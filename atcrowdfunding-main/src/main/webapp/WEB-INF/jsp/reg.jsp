<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="${ APP_PATH }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ APP_PATH }/css/font-awesome.min.css">
	<link rel="stylesheet" href="${ APP_PATH }/css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="${ APP_PATH }/index.htm" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="reuserpswd" name="reuserpswd" placeholder="再次输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址" style="margin-top:10px;">
			<span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<select class="form-control" id="usertype" name="usertype" >
                <option>企业</option>
                <option>个人</option>
            </select>
		  </div>
        <div class="checkbox">
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="${ APP_PATH }/login.htm">我有账号</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="doreg()" > 注册</a>
      </form>
    </div>
    <script src="${ APP_PATH }/jquery/jquery-2.1.1.min.js"></script>
    <script src="${ APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ APP_PATH }/jquery/layer/layer.js"></script>
    <script type="text/javascript">
    function doreg() {
    	
    	var loginacct = $("#loginacct").val().trim();
    	var userpswd = $("#userpswd").val().trim();
     	var reuserpswd = $("#reuserpswd").val().trim();
    	var email = $("#email").val().trim();
    	
    	var loginacctPatt = /^\w{5,13}$/;
    	var userpswdPatt = /^\w{5,13}$/;
    	var emailPatt = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/;
    	
    	if(!loginacctPatt.test(loginacct)){
    		layer.msg("用户名不合法!", { time:1500, icon:5, shift:6 });
    		return false;
    	}
    	
    	if(userpswd !== reuserpswd){
    		layer.msg("两次输入密码不一致!", { time:1500, icon:5, shift:6 });
    		return false;
    	}
    	
    	if(!userpswdPatt.test(userpswd)){
    		layer.msg("密码不合法!", { time:1500, icon:5, shift:6 });
    		return false;
    	}
    	
    	if(!emailPatt.test(email)){
    		layer.msg("邮箱不合法!", { time:1500, icon:5, shift:6 });
    		return false;
    	}
    	
    	$.ajax({
    		type:"POST",
			url:"${ APP_PATH }/doReg.do",
			data:{
				loginacct:loginacct,
				userpswd:userpswd,
				email:email,
				usertype:$("#usertype").val()
			},
			success:function(result){
				if( result.success ){
					window.location.href="${ APP_PATH }/main.htm";
				} else {
					layer.msg(result.message, {time:1500, icon:5, shift:6});
				}
			}
    	});

    	
    }
    	
    </script>
    
  </body>
</html>