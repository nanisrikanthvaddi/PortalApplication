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

});

$(document).ready(function () {

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

});