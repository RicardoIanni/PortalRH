function mascaraCpf(campoTexto) {
	if (campoTexto.value.length > 0) {
		campoTexto.value = campoTexto.value.padStart(11, "0").replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g,"\$1.\$2.\$3\-\$4");
	}
}

function onloadUsuario() {
	var cpf = document.getElementById('cpf');
	
	if (cpf != null) {
		mascaraCpf(cpf);
	}
}

function enableRecibo(recibos) {
    recibos = recibos.split(",");
    tipoRecibos = ["FP", "AD", "D1", "D2"]
    
    for (i = 0; i < tipoRecibos.length; i++) {
    	document.getElementById(tipoRecibos[i]).disabled = true;
    	document.getElementById(tipoRecibos[i]).selected = false;
    }
    
    for (i = 0; i < recibos.length; i++) {
    	document.getElementById(recibos[i]).disabled = false;
    }
    
}