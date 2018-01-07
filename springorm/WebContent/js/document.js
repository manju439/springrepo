var document={};

$(function() {
	document.getAllDocuments();
});


Document.prototype.getAllDocuments = function(){
	var _self=this;
	  $.ajax({
		  url: "./api/service/docs",
		  success: function(response){
			  _self.displayAllDocuments(response);
	    }
	  });
	  
	  this.displayAllDocuments = function(data){
		  
		  var htmlContent="<div class='row'><div class='checkboxCls'>Select</div><div class='colClsHdr'>Name</div><div class='colClsHdr'> Description</div><div style='clear:both'></div></div>";
		  for(var i=0;i<data.length;i++){
			  htmlContent+="<div class='row'><div class='checkboxCls'><input type='checkbox' id='"+data[i].id+"'></div><div class='colCls'>"+data[i].name+"</div><div class='colCls'>"+data[i].description+"</div></div>";
		  }
		  $(".divTable").html(htmlContent);
	  }
}

Document.prototype.CreateDocument = function(){
	var data={};
	data.name=$("#docName").val().trim();
	data.description=$("#docDesc").val().trim();
	if(data.name=="" || data.description==""){
		alert("Name and description can't be empty")
	}else{
	  $.ajax({
		  url: "./api/service/docs",
		  method:'POST',
		  data:JSON.stringify(data),
		  contentType :"application/json",
		  success: function(response){
			  document.getAllDocuments();
	    }
	  });
   }
}

Document.prototype.DeleteDocuments = function(){
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
		  url: "./api/service/docs",
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