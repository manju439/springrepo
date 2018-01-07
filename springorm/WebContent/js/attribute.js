var Attribute= function () { };

var attribute= new Attribute();

$(function() {
	attribute.getAllAttributes();
});


Attribute.prototype.getAllAttributes = function(){
	var _self=this;
	  $.ajax({
		  url: "./api/service/attributes",
		  success: function(response){
			  _self.displayAllAttributes(response);
	    }
	  });
	  
	  this.displayAllAttributes = function(data){
		  
		  var htmlContent="<div class='row'><div class='checkboxCls'>Select</div><div class='colClsHdr'>Name</div><div class='colClsHdr'> Description</div><div style='clear:both'></div></div>";
		  for(var i=0;i<data.length;i++){
			  htmlContent+="<div class='row'><div class='checkboxCls'><input type='checkbox' id='"+data[i].id+"'></div><div class='colCls'>"+data[i].name+"</div><div class='colCls'>"+data[i].description+"</div></div>";
		  }
		  $(".divTable").html(htmlContent);
	  }
}

Attribute.prototype.CreateAttribute = function(){
	var data={};
	data.name=$("#attrName").val().trim();
	data.description=$("#attrDesc").val().trim();
	if(data.name=="" || data.description==""){
		alert("Name and description can't be empty")
	}else{
	  $.ajax({
		  url: "./api/service/attributes",
		  method:'POST',
		  data:JSON.stringify(data),
		  contentType :"application/json",
		  success: function(response){
			  attribute.getAllAttributes();
	    }
	  });
   }
}

Attribute.prototype.DeleteAttributes = function(){
	var data={};
	var list="";
	$.each($(".checkboxCls input:checked"),function(index,value){
		var id=this.id;
		list+=id;
		if(index!=$(".checkboxCls input:checked").length-1)list+=",";
	});
	
	 data.ids=list;
	
	if(list==""){
		alert("Nothing to delete");
	}else{
	  $.ajax({
		  url: "./api/service/attributes",
		  method:"DELETE",
		  contentType :"application/json",
		  data:JSON.stringify(data),
		  success: function(response){
			 // document.getAllDocuments();
			  $(".checkboxCls input:checked").closest('.row').remove();  // deleteing rows using jquery remove method
	    }
	  });
	}
}