/*$('document').ready(function() {
	
	var colors = [ 
		{
			'color' : '#FFFFFF',
			'tooltip' : 'White'
		}, 
		{
			'color' : '#F8BBD0',
			'tooltip' : 'Pink'
		}, 
		{
			'color' : '#DC94F7',
			'tooltip' : 'purple'
		}, 
		{
			'color' : '#82B1FF',
			'tooltip' : 'Dark blue'
		}, 
		{
			'color' : '#80D8FF',
			'tooltip' : 'Blue'
		},
		{
			'color' : '#CCFF90',
			'tooltip' : 'Green'
		}, 
		{
			'color' : '#FF8A80',
			'tooltip' : 'Red'
		}, 
		{
			'color' : '#D5DBDB',
			'tooltip' : 'Grey'
		}, 
		{
			'color' : '#FFD180',
			'tooltip' : 'Orange'
		}, 
		{
			'color' : '#F5F518',
			'tooltip' : 'Yellow'
		},
		{
			'color' : '#D7C9C8',
			'tooltip' : 'Brown'
		}, 
		{
			'color' : '#A7FFEB',
			'tooltip' : 'Teal'
		} ];
		$scope.colors = colors;
		$.ajax({
			type:'POST',
			url:'update',
			data: {
				'color' : note.color,
				
			},
			}, function(response) {

				$scope.error = response.data.message;
			});
		}
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