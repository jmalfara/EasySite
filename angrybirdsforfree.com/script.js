function checkIfAdblock (block) {
	if( block === undefined ){
        document.getElementById('noBlock').style.display = 'none';
        document.getElementById('block').style.display = 'inline';
    } else {    	
    	document.getElementById('noBlock').style.display = 'inline';
        document.getElementById('block').style.display = 'none';
    }
}

function alertAdblock() {
	alert('Please Pause Adblocker and Refresh');
}