$('document').ready(function() {
	});

	var showSideBar=true;
    function openNav() {
	  if(showSideBar==false){
		  showSideBar=false;
          document.getElementById("mySidenav").style.paddingLeft = "250px";
   
    }
	else{
		  showSideBar=false;
		  document.getElementById("mySidenav").style.paddingLeft = "250px";
		 
	  
	}
	
}
/*
function deleteNote(id) {
    $.ajax({
    	 type : 'DELETE',  
         url : 'delete/1',
	}); 
}
function addNote(){
	var note={};
	note.title= $('#title').val();
	note.description = $('#description').val();
	
	$.ajax({
		type:'POST',
		url:'addNote',
		data: {
			'title' : note.title,
			'description' : note.description
		},
	     success:function(result){
		 $('#myModal').modal('hide'),
	     }
	});
} 

function update(){
	var note={};
	note.title = $('#title').val();
	alert("##title-->"+note.title);
	
	note.description = $('#description').val();
	
	$.ajax({
		type:'POST',
		url:'update',
		data: {
			'title' : note.title,
			'description' : note.description
		},
	success:function(result){
		$('#editModal').modal('hide'),
		console.log(result);
	}
	});
}
}*/