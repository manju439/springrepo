var Mapper= function () { };
var mappedArr=[];
var map= new Mapper();

$(function() {
	map.getAllDocuments();
});


Mapper.prototype.getAllDocuments = function(){
	var _self=this;
	  $.ajax({
		  url: "./api/service/docs",
		  success: function(response){
			  _self.displayAllDocuments(response);
	    }
	  });
	  
	  this.displayAllDocuments = function(data){
		  
		  var htmlContent=" <option>Please select</option>";
		  for(var i=0;i<data.length;i++){
			  htmlContent+=" <option id='"+data[i].id+"'>"+data[i].name+"</option>";
		  }
		  $("#dropdown").html(htmlContent);
		  
		  $("#dropdown").change(function() {
			    var id = $(this).find(':selected').attr('id');
			   if(id !=null) _self.displayMapper(id);
			});
	  }
	  
	  this.displayMapper = function (id){
		  $.ajax({
			  url: "./api/service/mapping/attributes/"+id,
			  success: function(response){
                  _self.createMapper(response);
			  }
		  });

	  }
	  
	  this.createMapper= function (data){
			 var htmlContent="";
			 var attrNames=[];
			 var attrIds=[];
			 mappedArr=[];
			  for(var i=0;i<data.ATTRIBUTES.length;i++){
				  var id=data.ATTRIBUTES[i].id;
				  if(data.MAPPEDATTRIBUTES.indexOf(id)!=-1){
					  mappedArr.push(id);
					  htmlContent+=" <option id='"+id+"' selected>"+data.ATTRIBUTES[i].name+"</option>";
				  }
				  else
				  htmlContent+=" <option id='"+id+"'>"+data.ATTRIBUTES[i].name+"</option>";
				  attrNames.push(data.ATTRIBUTES[i].name);
				  attrIds.push(id);
			  }
			  $('#pre-selected-options').multiSelect('destroy');
			  $("#pre-selected-options").html(htmlContent);
			  
			  $('#pre-selected-options').multiSelect({
			      afterSelect: function(values){
			    	  	var indx=attrNames.indexOf(values[0]);		
			    	  	mappedArr.push(attrIds[indx]);
			        },
			        afterDeselect: function(values){
			        	var indx=attrNames.indexOf(values[0]);	
			        	var val=mappedArr.indexOf(attrIds[indx]);
			        	mappedArr.splice(val,1);
			        }
			      });
			  $(".mapper").css('opacity','1');
		 }
}


Mapper.prototype.MapAttributestoDocument = function(){

	var docId=$("#dropdown").find(':selected').attr('id');
	var data={};
	data.ids=mappedArr.toString();
	$.ajax({
		  url: "./api/service/mapping/"+docId,
		  method:"PUT",
		  contentType :"application/json",
		  data:JSON.stringify(data),
		  success: function(response){
           console.log(response);
		  }
	  });
}

