<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prenotazione effettuata</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Prenotazione effettuata, di seguito i dati della prenotazione</h2>
        <p><strong>Nome e Cognome:</strong> <%= request.getParameter("nomeCognome") %></p>
        <p><strong>Recapito Telefonico:</strong> <%= request.getParameter("recapitoTelefonico") %></p>
        <p><strong>Numero di Persone:</strong> <%= request.getParameter("numeroPersone") %></p>
        <br><br><br>
        <a href="index.html">Torna alla home</a>
    </div>
    <img src="img/grazie.jpg" alt="Immagine grazie" width="1910" height="470">
</body>
</html>
