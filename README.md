# IataaaJavaIA
Greffon pour les IA java

## Structures de données

Des structures de données sont prévues pour les échanges entre la plateforme
et l'IA.  

Elles suivent les conventions suivantes :

    PLAYER {
      J1, // PLAYER 1, blanc
      J2, // PLAYER 2, noir
      DRAW // Aucun des joueurs
    }

    BOARD_SQUARE_TYPE {
      EMPTY, // '0'
      BLACK_PAWN, // '1'
      BLACK_DRAUGHT, // '2'
      WHITE_PAWN, // '3'
      WHITE_DRAUGHT // '4'
    }

    DIFFICULTY {
      EASY, // Facile
      MEDIUM, // Moyen
      HARD // Difficile
    }

    CODE_ENDGAME {
      TIMEOUT, // Timeout
      SURRENDER, // Rédition
      CLASSICAL // Classique
    }

    STATUS {
      BUSY, // Occupé
      AVAILABLE // Disponible
    }

    BOARD {
      50 characters array // Plateau de jeu
    }

## Services REST proposés

Le greffon permet de proposer un certain nombre de services REST.

### POST /ai/status  
Permet d'accéder à l'état de l'IA.

    Input : {"token": token}
    Output : {"token": token, "status": STATUS }
    Error :
        200 -> OK
        401 -> "Invalid token."
        400 -> "Invalid arguments."

### POST /ai/games/start/
Indique à l'IA le début d'une partie, récupère un ID de partie.

    Input : {"token":token, "difficulty": DIFFICULTY, "player": PLAYER}
    Output : {"token": token, "status": STATUS, "game_id": token de partie}
    Error :
        200 -> OK
        401 -> "Invalid token."
        400 -> "Invalid arguments."

### POST /ai/games/play/:game_id
Demande à l'IA de jouer un coup et le récupère (dans "board").

    Input : {"token":token, "difficulty": DIFFICULTY, "player": PLAYER, "board": BOARD}
    Output : {"token":token, "difficulty": DIFFICULTY, "player": PLAYER, "board": BOARD}
    Error :
        200 -> OK
        401 -> "Invalid token."
        400 -> "Invalid arguments."

### POST /ai/games/end/:game_id
Indique à l'IA la fin d'une partie.

    Input : {"token": token, "winner": PLAYER, "code": CODE_ENDGAME}
    Output : {"token": token, "status": STATUS }
    Error :
        200 -> OK
        401 -> "Invalid token."
        400 -> "Invalid arguments."

## Installation et personnalisation

### Apache Maven

Apache Maven est un outil pour la gestion et l'automatisation de production des projets logiciels Java en général et Java EE en particulier. L'objectif recherché est comparable au système make sous Unix : produire un logiciel à partir de ses sources, en optimisant les tâches réalisées à cette fin et en garantissant le bon ordre de fabrication.

Sources : https://maven.apache.org/source-repository.html

Maven installera le nécessaire pour faire tourner Spring et Jackson qui sont présentés ci-dessous.


### Spring

Spring est un socle pour le développement d'applications, principalement d'entreprises mais pas obligatoirement. Il fournit de nombreuses fonctionnalités parfois redondantes ou qui peuvent être configurées ou utilisées de plusieurs manières : ceci laisse le choix au développeur d'utiliser la solution qui lui convient le mieux et/ou qui répond aux besoins.

Il sert ici à dévellopper simplement des services web RESTfull

### Jackson

est un parser JSON pour JAVA



### Personnalisation du code

La grande majorité du code doit rester telle quelle.

Vous devez compléter au minimum ```gamePlay``` (de ```GestionGame.java```) et les
méthodes de la classe ```Converter``` pour que tout soit fonctionnel.

Vous trouverez ci-dessous la liste de toutes les méthodes paramétrables.

Dans ```service.CheckersAIService.java``` :
* La méthode ```newGameStarted``` peut être paramétrée à votre guise. Elle est appelée automatiquement au démarrage d'une nouvelle partie.  
Elle reçoit en paramètre la difficulté de la nouvelle partie ainsi que le joueur que votre IA incarnera.
* La méthode ```gamePlay``` doit contenir l'appel à votre IA pour décider du prochain coup.  
Elle est décomposée en 3 étapes :
    * Conversion du format d'entrée vers votre format interne (```Converter.convertToInternalFormat(board)```)
    * Calcul du prochain coup
    * Conversion du coup calculé de votre format interne vers le format de sortie (```Converter.convertToExternalFormat(calculatedMove)```)  
Elle reçoit en paramètre l'ID de la partie sur laquelle jouer, la difficulté demandée, le joueur qui doit jouer et l'état du plateau de jeu.
* La méthode ```gameEnded``` est appelée automatiquement lorsqu'une partie se termine.  
Elle reçoit en paramètre l'ID de la partie terminée, le joueur qui a gagné et le code de fin de partie.

Dans ```Converter.java``` :
* La méthode ```convertToInternalFormat``` est utilisée pour convertir un plateau de jeu depuis le format externe (un tableau de 50 cases de ```char```) vers votre format interne, compréhensible pour l'IA.  
Pensez à changer le type de retour de ```void``` vers votre type interne.
* La méthode ```convertToExternalFormat``` permet l'inverse : elle convertit un plateau de jeu depuis votre format interne vers le format externe.  
Pensez donc à prendre en paramètre une référence constante vers votre format interne, pour ensuite la convertir vers un tableau de 50 cases de ```char```.

Note : Le code JAVA est très largement inspiré du code C++
