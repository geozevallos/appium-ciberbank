# language: es

@perfil
Característica: Cierre de sesión

  Escenario: Cerrar sesión regresa a la pantalla de login
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando abre su perfil y pulsa cerrar sesión
    Entonces debería estar de vuelta en la pantalla de login

  Escenario: El botón atrás del sistema no reingresa al dashboard
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando abre su perfil y pulsa cerrar sesión
    Y presiona el botón atrás del sistema
    Entonces debería seguir en la pantalla de login
