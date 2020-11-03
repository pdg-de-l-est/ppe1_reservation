let ville = distance = ""

window.onload=function(){
	var carte=L.map("map").setView([48.852969,2.349903],13)
	
	L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
                attribution: 'Données © <a href="//osm.org/copyright">OpenStreetMap</a> - Rendu <a href="//openstreetmap.fr">OSM France</a>',
                minZoom: 1,
                maxZoom: 20,
				name:'tiles' // Permettra de ne pas supprimer cette couche
            }).addTo(carte)

	// On active la gestion d'itinéraire
	
	let champVille = document.getElementById('champ-ville')
	let champDistance = document.getElementById('champ-distance')
	let valeurDistance = document.getElementById('valeur-distance')
	
	champVille.addEventListener("change", function(){
		// On envoie la requête ajax vers Nominatim
		ajaxGet(`https://nominatim.openstreetmap.org/search?q=${this.value}&format=json&addressdetails=1&limit=1&polygon_svg=1`)
	})
	
	champDistance.addEventListener("change", function(){
		distance = this.value
		valeurDistance.innerText = distance+" km"
	})
}

/** 
 * Cette fonction effectue un appel Ajax vers une URL et retourne une promesse
 * @param {string} url
 */
function ajaxGet(url){
	return new Promise(function(resolve,reject){
		// Nous allons gérer la promesse
		let xmlhttp = new XMLHttpRequest()
		
		xmlhttp.onreadystatechange = function(){
			if(xmlhttp.readyState ==4){
				if(xmlhttp.status==200){
					resolve(xmlhttp.response)
				}
				else{
					reject(xmlhttp)
				}
			}
		}
		
		xmlhttp.onerror=function(error){
			xmlhttp.reject(error)
		}
		
		xmlhttp.open('get',url,true)
		xmlhttp.send()
	})
}

