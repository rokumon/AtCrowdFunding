<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 角色维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i> ${ sessionScope.loginUser.username } <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${APP_PATH}/doLogout.do"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<ul style="padding-left:0px;" class="list-group">
					<li class="list-group-item tree-closed" >
						<a href="${APP_PATH}/main.htm"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a> 
					</li>
					<li class="list-group-item">
						<span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span> 
						<ul style="margin-top:10px;">
							<li style="height:30px;">
								<a href="${APP_PATH}/user/index.htm"><i class="glyphicon glyphicon-user"></i> 用户维护</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/role/index.htm" style="color:red;"><i class="glyphicon glyphicon-king"></i> 角色维护</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/permission/index.htm"><i class="glyphicon glyphicon-lock"></i> 许可维护</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="${APP_PATH}/auth_cert/index.htm"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/auth_adv/index.htm"><i class="glyphicon glyphicon-check"></i> 广告审核</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/auth_project/index.htm"><i class="glyphicon glyphicon-check"></i> 项目审核</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="${APP_PATH}/cert/index.htm"><i class="glyphicon glyphicon-picture"></i> 资质维护</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/certtype/index.htm"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/process/index.htm"><i class="glyphicon glyphicon-random"></i> 流程管理</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/advert/index.htm"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/message/index.htm"><i class="glyphicon glyphicon-comment"></i> 消息模板</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/projectType/index.htm"><i class="glyphicon glyphicon-list"></i> 项目分类</a> 
							</li>
							<li style="height:30px;">
								<a href="${APP_PATH}/tag/index.htm"><i class="glyphicon glyphicon-tags"></i> 项目标签</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed" >
						<a href="${APP_PATH}/param/index.htm"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a> 
					</li>
				</ul>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input class="form-control has-success" id="queryText" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button type="button" id="queryBtn" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" id="deleteSelectBtn" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/role/toAdd.htm'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox"></th>
                  <th>名称</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>
              
              </tbody>
			  <tfoot >
 				<tr >
				    <td colspan="6" align="center">
						<ul class="pagination">

						</ul>
					 </td>
				 </tr>
			  </tfoot>
            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${ APP_PATH }/jquery/layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
				var pageno = "${param.pageno}";
			    
			    if(pageno == ""){
			    	queryPage(1);
			    } else {
			    	queryPage(pageno);
			    }
            });
            
            var jsonObj = {
    	            pageno:1,
    	            pagesize:10
    	        };
                
                function queryPage(pageno){
                	
                	jsonObj.pageno = pageno;
                	
                	var index = -1;
                	
                	$.ajax({
    					type:"POST",            		
                		url:"${APP_PATH}/role/queryRoleByPage.do",
                		data:jsonObj,
                		beforeSend:function(){
                			index = layer.load(2 , {time:10*1000});
                			return true;
                		},
                		success:function(result){
                			
                			layer.close(index);
                			
                			if(result.success){
                				var page = result.data;
                				var list = page.datas;
                				
                				var content = "";
                				
                				//i 当前元素索引， e 当前元素
                				$.each(list,function(i, e){
                					content+='<tr>';
                					content+='	<td>'+(i+1)+'</td>';
                					content+='	<td><input type="checkbox" rid="'+e.id+'" rname="'+e.name+'"></td>';
                					content+='	<td>'+e.name+'</td>';
                					content+='   <td>';
                					content+='	<button type="button" class="btn btn-success btn-xs selectuser" rid="'+e.id+'"><i class=" glyphicon glyphicon-check"></i></button>';
                					content+='	<button type="button" class="btn btn-primary btn-xs edituser" rid="'+e.id+'" pageno="'+page.pageno+'"><i class=" glyphicon glyphicon-pencil"></i></button>';
                					content+='	<button type="button" class="btn btn-danger btn-xs deleteuser" pageno="'+page.pageno+'" rid="'+e.id+'" rname="'+e.name+'" ><i class=" glyphicon glyphicon-remove"></i></button>';
                					content+='  </td>';
                					content+=' </tr>';
                				});
                				
                				$("tbody").html(content);
                				
                				//分页条显示
                				var navicontent = '';
                				if(page.pageno==1){
                					navicontent+='<li class="disabled"><a href="#">上一页</a></li>';
                				}else{
                					navicontent+='<li><a onclick="queryPage('+(page.pageno-1)+')">上一页</a></li>';
                				}
                				
                				for(var i=1; i<=page.totalno; i++){
                					if(i==page.pageno){
                						navicontent+='<li class="active"><a onclick="queryPage('+i+')">'+i+'</a></li>';
                					}else{
                						navicontent+='<li><a onclick="queryPage('+i+')">'+i+'</a></li>';
                					}
                				}
                				
                				if(page.pageno==page.totalno){
                					navicontent+='<li class="disabled"><a href="#">下一页</a></li>';
                				}else{
                					navicontent+='<li><a onclick="queryPage('+(page.pageno+1)+')">下一页</a></li>';
                				}
                				
                				$(".pagination").html(navicontent);
                			} else {
                				layer.msg("服务器出现异常", {time: 1500, icon:5, shift:6});
                			}
                		}
                	});
                };
            
            
                function deleteRole(id, pageno){
                	
                	index = -1;
                	
                	 $.ajax({
    					type:"POST",            		
    	            	url:"${APP_PATH}/role/delete.do",
    	            	data:{
    	            		id:id
    	            	},
    	            	beforeSend:function(){
                			index = layer.load(2 , {time:10*1000});
                			return true;
                		},
    	            	success:function(result){
    	            		
    	            		layer.close(index);
    	            		if(result.success){
    	            			alert("请求成功");
    	            			queryPage(pageno);
    	            		} else {
    	            			layer.msg(success.message, {time:1500, icon:5, shift:6});
    	            		}
    	            	}
             		});
                	 
                	return false;
                }
                
                //条件查询按钮
                $('#queryBtn').click(function(){
                	jsonObj.queryText = $('#queryText').val().trim();
                	queryPage(1);
                });
                
                //修改角色按钮
                $('tbody').delegate(".edituser",'click',function(){  
    				var id = $(this).attr("rid");
    				var pageno = $(this).attr("pageno");
    				window.location.href="${APP_PATH}/role/edit.do?id="+id+"&pageno="+pageno;
                });
                
                //删除角色按钮
                $('tbody').delegate(".deleteuser",'click',function(){  
    				var id = $(this).attr("rid");
    				var name = $(this).attr("rname");
    				var pageno =  $(this).attr("pageno");
    				alert(id);
    				layer.confirm("确认删除角色 "+name+" 吗",  {icon: 3, title:'确认信息'}, function(cindex){
    				    layer.close(cindex);
    					deleteRole(id, pageno);
    				}, function(cindex){
    				    layer.close(cindex);
    				});
                });
                
                //选择按钮
                $('tbody').delegate(".selectrole",'click',function(){  
                	var box = $(this).parent().parent().find("td:eq(1) input")[0];
                	$(box).prop("checked",!box.checked);
                });
                
                $('#deleteSelectBtn').click(function(){
                	
                	var checkboxArray = $("tbody :checked");
                	
                	var pageno = $(this).attr("pageno");
                	
                	if(checkboxArray.length == 0){
                		layer.msg("请至少选择一个角色，才能删除", {time:1500, icon:5, shift:6});
                		return false;
                	}
                	
                	var id = "";
                	
                	$.each(checkboxArray,function(i,e){
                		if(i==0){
                			id += "id="+$(e).attr("rid");
                		} else {
                			id += "&id="+$(e).attr("rid");
                		}
                	});
                	
                	layer.confirm("确认删除 "+checkboxArray.length+" 个角色吗",  {icon: 3, title:'确认信息'}, function(cindex){
    				    layer.close(cindex);
    					
    				    var index = -1;
    				    
    				    $.ajax({
    						type:"POST",            		
    	            		url:"${APP_PATH}/role/delete.do",
    	            		data:id,
    	            		beforeSend:function(){
    	            			index = layer.load(2 , {time:10*1000});
    	            			return true;
    	            		},
    	            		success:function(result){
    	            			layer.close(index);
    	            			if(result.success){
    	            				queryPage(pageno);
    	            			} else {
    	            				layer.msg(result.message, {time:1500, icon:5, shift:6});
    	            			}
    	            		}
                		});
    				}, function(cindex){
    				    layer.close(cindex);
    				    return false;
    				});
                });
                
                $('#selectAllCheckBox').click(function(){
                	
                	var status = this.checked;
                	
                	var checkboxArray = $('tbody :checkbox');
                	
                	$.each(checkboxArray,function(i,e){
                		e.checked = status;
                	});
                	
                });
            
//             $("tbody .btn-success").click(function(){
//                 window.location.href = "assignPermission.html";
//             });
        </script>
  </body>
</html>
