$('document').ready(function() {
}
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
		url:'addNote/1',
		data: {
			'title' : note.title,
			'description' : note.description
		},
	     success:function(result){
		 $('#myModal').modal('hide'),
	     }
	});
} 