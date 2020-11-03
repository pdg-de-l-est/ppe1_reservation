// On s'assure que la page est chargée
	var macarte = L.map("carte").setView([48.852969,2.349903],13)
	L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
                attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/0DbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
                minZoom: 1,
                maxZoom: 20
			}).addTo(macarte);