# Devco_Prueba

### Pre-requisitos
NodeJS https://nodejs.org/es/download/

Java 1.8 https://www.java.com/es/download/help/windows_manual_download.html

Oracle Database 11g 

Interfaz de usuario para manejo de oracle, en mi caso usé sqldeveloper https://www.oracle.com/co/tools/technologies/whatis-sql-developer.html


### Configuración de ambiente
1.Crear base de datos y ejecutar script "devco.sql"

2.Los datos usados para la conexión a la base de datos deben ser modificados en el archivo "apiRest.properties". 
Una vez se actualice el archivo, se debe establecer en el disco local C, para el correcto funcioanmietno de la aplicación.

3. Para correr el API client que se consume desde el aplicativo, se debe instalar un paquete de NodeJS, el 
cual permite crear un API Rest con la persistencia en un archivo json
npm install -g json-server

4. Una vez finalice la instalación se debe arrancar el servidor del API REST con los datos del json del archivo "dispositivos.json" ejecutando el siguinte comando
npx json-server --watch dispositivos.json

5. Una vez arranque el API client, se puede ejecutar el aplicativo de Devco el cual correrá por el puerto 9000 como se configuró en el archivo apiRest.properties.
El back se encuentra en el directorio "dotaciones"

6. Para ejecutar el front "apidevcoFront" use el comando 'npm install' para instalarlos paquetes usados

7. Al terminar la instalación, corra la aplicación con 'npm start' o 'ng serve --open'.
'ng serve --open' reconstruye y abre la aplicación 
'npm start' corre comandos definidos en la propiedad "start" del "script" o por defecto ejecuta 'node server.js', si la propiedad start no está definida
