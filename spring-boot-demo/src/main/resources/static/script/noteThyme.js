$('document').ready(function() {
	});

	var showSideBar=true;
    function openNav() {
	  if(showSideBar==false){
		  showSideBar=true;
          document.getElementById("mySidenav").style.paddingLeft = "250px";
   
    }
	else{
		  showSideBar=false;
		  document.getElementById("mySidenav").style.paddingLeft = "0px";
	}
}
    
    function get_random_color() {
        var color = '#';
        var letters = ['000000','FF0000','00FF00','0000FF','FFFF00','00FFFF','FF00FF','C0C0C0'];
        color += letters[Math.floor(Math.random() * letters.length)];
        document.getElementById('posts:before').style.background = color;
        document.getElementByClassName('sidebar').style.background = color; 
    }
    
    /** **** Social Share ********** */
	  /*  var socialShare(note) {
	    	alert("after function @@@@@@@@@@@@@@@@@@")
		FB.init({
			appId : '383534318755042',
			status : true,
			cookie : true,
			xfbml : true,
			version : 'v2.4'
		});
		FB.ui({
			method : 'share_open_graph',
			action_type : 'og.likes',
			action_properties : JSON.stringify({
				object : {
					'og:title' : note.title,
					'og:description' : note.description	
				}
			})
		}, function(response) {
			alert('Posting completed.');
		}, function(error) {
			alert('Somthing Wrong.');
		});
	};*/

/*function update(){
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