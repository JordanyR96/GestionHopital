const continents = {
    africa: {
        name: "Afrique",
        description: "Un continent riche en cultures, en paysages et en biodiversité."
    },
    northAmerica: {
        name: "Amérique du Nord",
        description: "Découvrez ses grands espaces, ses métropoles et ses paysages variés."
    },
    southAmerica: {
        name: "Amérique du Sud",
        description: "Explorez sa diversité culturelle, ses forêts et la cordillère des Andes."
    },
    asia: {
        name: "Asie",
        description: "Un continent aux traditions anciennes, aux cultures multiples et aux paysages contrastés."
    },
    caribbean: {
        name: "Caraïbes",
        description: "Profitez de ses îles, de ses plages et de sa richesse culturelle."
    },
    europe: {
        name: "Europe",
        description: "Parcourez son histoire, son patrimoine et la diversité de ses pays."
    },
    oceania: {
        name: "Océanie",
        description: "Découvrez ses archipels, ses paysages marins et sa faune unique."
    },
    australia: {
        name: "Australie",
        description: "Explorez ses grands espaces, ses plages et sa faune emblématique."
    },
    antarctica: {
        name: "Antarctique",
        description: "Un continent glacé consacré à la recherche et à la préservation de la nature."
    }
};

function createMessageElement() {
    const message = document.createElement("p");
    message.id = "discoveryMessage";
    message.setAttribute("role", "status");
    document.querySelector("main").appendChild(message);
    return message;
}

function showMessage(text) {
    const message = document.getElementById("discoveryMessage") || createMessageElement();
    message.textContent = text;
}

function displayContinent(continentId) {
    const continent = continents[continentId];

    if (!continent) {
        showMessage("Cette zone ne correspond à aucun continent connu.");
        return;
    }

    showMessage(`${continent.name} : ${continent.description}`);
}

function displayLocation(position) {
    const { latitude, longitude } = position.coords;
    showMessage(
        `Votre localisation est approximativement : latitude ${latitude.toFixed(4)}, longitude ${longitude.toFixed(4)}.`
    );
}

function displayLocationError(error) {
    const messages = {
        1: "L’accès à votre localisation a été refusé.",
        2: "Votre localisation n’est pas disponible.",
        3: "La demande de localisation a expiré."
    };

    showMessage(messages[error.code] || "Une erreur est survenue lors de la récupération de votre localisation.");
}

function discoverLocation() {
    if (!navigator.geolocation) {
        showMessage("La géolocalisation n’est pas prise en charge par votre navigateur.");
        return;
    }

    showMessage("Recherche de votre localisation...");
    navigator.geolocation.getCurrentPosition(displayLocation, displayLocationError);
}

function resizeMapAreas() {
    const image = document.querySelector('img[usemap="#worldmap"]');
    const areas = document.querySelectorAll('map[name="worldmap"] area');

    if (!image || !image.naturalWidth || !areas.length) {
        return;
    }

    const scaleX = image.clientWidth / image.naturalWidth;
    const scaleY = image.clientHeight / image.naturalHeight;

    areas.forEach((area) => {
        const originalCoordinates = area.dataset.originalCoordinates
            || area.coords.split(",").map(Number);

        area.dataset.originalCoordinates = originalCoordinates.join(",");
        const scaledCoordinates = originalCoordinates.map((coordinate, index) =>
            Math.round(coordinate * (index % 2 === 0 ? scaleX : scaleY))
        );

        area.coords = scaledCoordinates.join(",");
    });
}

document.addEventListener("DOMContentLoaded", () => {
    const image = document.querySelector('img[usemap="#worldmap"]');
    if (image) {
        image.addEventListener("load", resizeMapAreas);
        window.addEventListener("resize", resizeMapAreas);
        resizeMapAreas();
    }

    Object.keys(continents).forEach((continentId) => {
        const area = document.getElementById(continentId);

        if (area) {
            area.addEventListener("click", (event) => {
                event.preventDefault();
                displayContinent(continentId);
            });
        }
    });

    const locationButton = document.getElementById("discoverLocation");
    if (locationButton) {
        locationButton.addEventListener("click", discoverLocation);
    }
});