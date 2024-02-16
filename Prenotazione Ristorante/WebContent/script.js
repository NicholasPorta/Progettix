document.addEventListener("DOMContentLoaded", function() {
    // Ottieni riferimenti agli elementi del DOM
    var nomeCognomeElement = document.getElementById("nomeCognome");
    var recapitoTelefonicoElement = document.getElementById("recapitoTelefonico");
    var numeroPersoneElement = document.getElementById("numeroPersone");
    var confirmButton = document.getElementById("confirmButton");

    // Ascolta l'evento di clic sul pulsante di conferma
    confirmButton.addEventListener("click", function() {
        // Recupera i dati della prenotazione dall'HTML
        var nomeCognome = nomeCognomeElement.textContent;
        var recapitoTelefonico = recapitoTelefonicoElement.textContent;
        var numeroPersone = numeroPersoneElement.textContent;

        // Crea un oggetto con i dati della prenotazione
        var prenotazione = {
            nomeCognome: nomeCognome,
            recapitoTelefonico: recapitoTelefonico,
            numeroPersone: numeroPersone
        };

        // Effettua una richiesta HTTP POST al backend per confermare la prenotazione
        fetch("/CreaPrenotazione.do", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(prenotazione)
        })
        .then(response => {
            // Gestisci la risposta del backend
            if (response.ok) {
                alert("Prenotazione confermata con successo!");
            } else {
                alert("Si è verificato un errore durante la conferma della prenotazione.");
            }
        })
        .catch(error => {
            console.error("Si è verificato un errore durante la richiesta:", error);
            alert("Si è verificato un errore durante la richiesta al backend.");
        });
    });
});
