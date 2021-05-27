 const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});



$(document).ready(function () {

	$("#sidebar").mCustomScrollbar({
		theme: "minimal"
	});

	$('#sidebarCollapse').on('click', function () {
		$('#sidebar').toggleClass('active');
	});


	$("#sidebar").mCustomScrollbar({
		theme: "minimal"
	});

	$('#sidebarCollapse').on('click', function () {
		// open or close navbar
		$('#sidebar').toggleClass('active');
		// close dropdowns
		$('.collapse.in').toggleClass('in');
		// and also adjust aria-expanded attributes we use for the open/closed arrows
		// in our CSS
		$('a[aria-expanded=true]').attr('aria-expanded', 'false');
	});




		$('.deleteUser').on('click', function (){

			var data=$('#deleteModel').modal('show').val();

			console(data);

		});




});
/*
$(document).ready(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('modal-body');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
					form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	}

);*/
