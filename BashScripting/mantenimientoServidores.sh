# !/bin/bash
# Este código realiza el mantenimiento a de los servidores de Audifarma
# Por: Infraestructura TIC.

# Declaramos la variable opción igual a 1, para que pueda entrar en el While.
OPCION=1

# Mientras opción sea diferente de cero, haga.
while [ $OPCION -ne 0 ]
do
  # Menú de mantenimiento desplegado en consola.
  echo "-----------------------BIENVENIDO AL MENU DE MANTENIMIENTO-------------------------"
  echo "-----------------------------------------------------------------------------------"
  echo "------PARA SELECCIONAR EL MANTENIMIENTO DE UN DETERMINADO SERVIDOR, DIGITE EL------"
  echo "------NUMERO QUE LO IDENTIFICA O 0 PARA FINALIZAR EL PROGRAMA.---------------------"
  echo "-----------------------------------------------------------------------------------"
  echo "--1.--TAREA DE MANTENIMIENTO SERVIDORES AUDITOR3 IP 10.1.1.146---------------------"
  echo "--2.--TAREA DE MANTENIMIENTO SERVIDORES AUDITOR PERU IP 10.1.244.52----------------"
  echo "--3.--TAREA DE MANTENIMIENTO SERVIDORES AUDITOR DEMPOS IP 10.1.1.134 y 10.1.1.43---"
  echo "--4.--TAREA DE MANTENIMIENTO SERVIDORES AUDITOR IPS IP 10.1.1.66-------------------"
  echo "--5.--TAREA DE MANTENIMIENTO SERVIDORES AUDITOR IPS IP 10.1.1.65-------------------"
  echo "--6.--TAREA DE MANTENIMIENTO SERVIDORES AUDITOR PRUEBAS IP 10.1.1.115--------------"
  echo "--7.--TAREA DE MANTENIMIENTO BODEGA  IP 10.1.1.185---------------------------------"
  echo "--8.--TAREA DE MANTENIMIENTO SERVIDORES  PORTOS IP 10.1.1.113----------------------"
  echo "--9.--TAREA DE MANTENIMIENTO SERVIDOR MOVGRAL IP 10.1.1.130------------------------"
  echo "-10.--TAREA DE MANTENIMIENTO SERVIDOR CORREO DOMINIO AUDIFARMA.COM.CO--------------"
  echo "-11.--TAREA DE MANTENIMIENTO SERVIDOR  IP 10.1.1.20--------------------------------"
  echo "-12.--TAREA DE MANTENIMIENTO SERVIDORES SITA IP / 10.1.244.175-176-----------------"
  echo "-13.--TAREA DE MANTENIMIENTO SERVIDORES EN CASA IP 10.1.244.46 / 10.1.244.61-------"
  echo "-14.--TAREA DE MANTENIMIENTO SERVIDOR REPLICA IP 10.1.1.159------------------------"
  echo "-15.--TAREA DE MANTENIMIENTO SERVIDOR COLCIENCIAS IP 10.1.1.173--------------------"
  echo "-16.--TAREA DE MANTENIMIENTO SERVIDOR SKYNET  IP 10.1.1.179------------------------"
  echo "-17.--TAREA DE MANTENIMIENTO SERVIDOR ATHOS IP 10.1.1.207--------------------------"
  echo "-18.--TAREA DE MANTENIMIENTO SERVIDOR IP 10.1.1.69---------------------------------"
  echo "-19.--TAREA DE MANTENIMIENTO SERVIDOR IP 10.1.1.205--------------------------------"
  echo "-20.--TAREA DE MANTENIMIENTO SERVIDOR ATLAS  IP 10.1.1.60--------------------------"
  echo "-21.--TAREA DE MANTENIMIENTO SERVIDOR SPARK   IP 10.1.1.24-------------------------"
  echo "-22.--TAREA DE MANTENIMIENTO SERVIDOR PAGINA AUDIFARMA IP 10.1.1.7-----------------"
  echo "-23.--TAREA DE MANTENIMIENTO SERVIDOR sensores IP 10.1.1.86------------------------"
  echo "-24.--TAREA DE MANTENIMIENTO SERVIDOR sensores IP 10.1.244.15----------------------"
  echo "-25.--TAREA DE MANTENIMIENTO SERVIDOR HYPER IP 10.1.1 215--------------------------"
  echo "-26.--TAREA DE MANTENIMIENTO SERVIDOR VULCANO  IP 10.1.1.23------------------------"
  echo "-27.--TAREA DE MANTENIMIENTO SERVIDOR quiron  IP 10.1.1.131------------------------"
  echo "-28.--TAREA DE MANTENIMIENTO SERVIDOR LDAP  IP 10.1.1.225--------------------------"
  echo "-29.--TAREA DE MANTENIMIENTO SERVIDOR AUDITOR3 PRUEBA IP 10.1.1.146----------------"
  #Leemos el número ingresado.
  read "-POR FAVOR DIGITE EL NÚMERO PARA HACER EL MANTENIMIENTO: " OPCION



  #Con el número digitado y almacenado, evaluamos la opcion(numero)), esta hace match con el bloque
  #de código que me reinicia el servidor seleccionado.

  case $OPCION in
  1)
    #Tarea de mantenimiento servidor auditor3 10.1.1.146
    #Ejectuamos el script stopserv para detener el webserver

    echo "###########################################################################################" >> /root/scripts/mantenimientoServidores.log
    echo "Comienza tarea de mantenimiento al servidor Auditor3 10.1.1.146 el día `date '+%d-%m-%Y'` a las `date '+%H:%M:%S'`. " >> /root/scripts/mantenimientoServidores.log
    echo "Ejecutando script stopserv para detener el webserver"
    echo " "
    echo " "
    /opt/webserver/https-auditor3.audifarma.com.co/bin/stopserv
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script stopserv para detener el webserver a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "
    echo "Por favor espere 60 segundos"
    echo " "
    echo " "
    sleep 10s

    #Bajamos el nodo
    echo "Ejecutando script stop-node-agent..."
    echo " "
    echo " "
    /opt/glassfish/bin/asadmin stop-node-agent
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script stop-node-agent para detener el nodo a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "
    echo "Por favor espere 60 segundos..."
    echo " "
    echo " "
    sleep 10s

    #Bajamos el dominio
    echo "Ejecutando script stop-domain..."
    echo " "
    echo " "
    /opt/glassfish/bin/asadmin stop-domain
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script stop-domain para detener el dominio a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "
    echo "Por favor espere 60 segundos..."
    echo " "
    echo " "
    sleep 60s

    #Miramos qué procesos están activos
    echo "A continuación todos los procesos activos de glassfish..."

    echo " "
    echo " "
    ps -ef |grep glassfish
    echo " "
    echo " "

# Definimos variable que ingresará en 
c=1

# Leemos el número de procesos digitados por el usuario
read -p "Digite el número de procesos activos de glassfish. (presione 0 si no tiene...)   Inserte aquí: " numeroProcesos

# Si el número de procesos es diferente de 0 métase por el else y valide
if [$numeroProcesos -eq 0]
then

    # Con el brake salimos de la estructura if.
    break


else

    # Mientras la opción sea diferente de 0, haga.
    while [ $c -ne 0 ]
    do
        echo " "
        echo " "
        echo "Se bajaran $numeroProcesos procesos, a continuación digite los PID de los procesos..."

        # Se repite el bucle según el número de procesos leidos, en cada iteración se ejecuta el PID del proceso y se killea
        for((i=1; i<=$numeroProcesos; i++)){

            echo " "
            echo " "
            read -p "Digite la ID del proceso número:$i ...   Inserte aquí: " idProceso
            echo " "
            echo " "
            kill -9 $idProceso

         }

        # Impresiones de pantalla
         echo " "
         echo " "
         echo "Verifique que todos los procesos se hayan cerrado..."
         echo " "
         echo " "
         ps -ef |grep glassfish
         echo " "
         echo " "
         read -p "Si los procesos se bajaron completamente digite 0, de lo contrario digite otro numero: " c
         echo " "

    done
    # Final del While
fi
# Final del if

    #Con esta estructura recorremos todas las instancias de auditor3 y les borramos los logs
    echo " "
    echo " "
    echo "Aquí recorremos todas las instancias y eliminamos los logs..."
    echo " "
    echo " "

    i=1
    while [ $i -lt 22 ]
    do
    #Nuevo requerimiento de Francisco
    #cp /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/imq/instances/cluster1slave$i/log/log$i.txt

    #Eliminamos los logs
    rm -rf /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/logs/server.log_20*
    rm -rf /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/imq/instances/cluster1slave$i/log/log$i.txt

    #Vaciamos los logs
    cat /dev/null > /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/imq/instances/cluster1slave$i/log/log.txt
    cat /dev/null > /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/generated/jsp/j2ee-modules/auditor/auditor_SESSIONS.ser
    ((i++))
    done

    echo " "
    echo " "
    echo "Por favor, espere 60 segundos..."
    echo " "
    echo " "
    sleep 60s

    #Subimos el dominio
    echo "Ejecutando comando start-domain..."
    echo " "
    echo " "
    /opt/glassfish/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script start-domain para subir el dominio a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "

    echo "Por favor, espere 60 segundos..."
    echo " "
    echo " "
    sleep 60s

    #Subimos el nodo
    echo "Ejecutando el comando start-node-agent..."
    echo " "
    echo " "
    /opt/glassfish/bin/asadmin start-node-agent --user admin --passwordfile /opt/glassfish/pass.txt
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script start-node-agent para subir el nodo a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log


    #Con este comando mostramos la lista de instancias

    echo " "
    echo " "
    echo "Aquí listamos todas las instancias"
    echo " "
    echo " "

    /opt/glassfish/bin/asadmin list-instances

    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Mantenimiento finalizado a las: `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo "###########################################################################################" >> /root/scripts/mantenimientoServidores.log


    ;;

  2)
    #TAREA DE MANTENIMIENTO SERVIDORES AUDITOR PERU IP 10.1.244.52
    echo "###########################################################################################" >> /root/scripts/mantenimientoServidores.log
    echo "Comienza tarea de mantenimiento al servidor Auditor Perú 10.1.244.52 el día `date '+%d-%m-%Y'` a las `date '+%H:%M:%S'`. " >> /root/scripts/mantenimientoServidores.log
    echo "Ejecutando script stopserv para detener el webserver"
    echo " "
    echo " "

    #PASO 1 Bajar los servicios de glassfish3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    durmiendo
    sleep 60s

    /opt/glassfish3/bin/asadmin stop-domain
    durmiendo
    sleep 60s
    clear

    #PASO 2 Verificamos los procesos activos del glassfish
    ps -ef |grep glassfish3

    #PASO 3 Subimos los servicios de glassfish3
    /opt/glassfish3/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt
    /opt/glassfish3/bin/asadmin start-cluster cluster1 --user admin --passwordfile /opt/glassfish/pass.txt

    #PASO 4 Listamos las instancias del glassfish3
    /opt/glassfish3/bin/asadmin list-instances
    realizado
    clear
    echo "En 10 segundos empezamos a bajar el glassfish4..."
    sleep 10s

    #PASO 5 Bajamos el glassfish4
    /opt/glassfish4/bin/asadmin stop-domain
    durmiendo
    sleep 60s
    clear

    #PASO 6, Subimos el glassfish4
    /opt/glassfish4/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt

    #PASO 5 Verificamos que todas las intancias estén funcionando
    /opt/glassfish4/bin/asadmin list-instances
    realizado

    ;;

  3)
    #TAREA DE MANTENIMIENTO SERVIDORES AUDITOR DEMPOS IP 10.1.1.134 y 10.1.1.43 (son 2 servidores)
     #PASO 1 Bajar el servidor web de Dempos
    /opt/webserver/https-demposapp1.audifarma.com.co/bin/stopserv

    #PASO 2 Bajar los servicios de glassfish
    /opt/glassfish/bin/asadmin stop-node-agent
    durmiendo
    sleep 60s

    /opt/glassfish/bin/asadmin stop-domain
    durmiendo
    sleep 60s

    /opt/glassfish3/bin/asadmin stop-domain
    durmiendo
    sleep 60s

    #PASO 3 Listamos los procesos activos de glassfish
    ps -ef |grep glassfish

    #PASO 4 Subir los servicios de glassfish
    /opt/glassfish/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt
    durmiendo
    sleep 60s

    /opt/glassfish3/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt
    durmiendo
    sleep 60s

    /opt/glassfish/bin/asadmin start-node-agent --user admin --passwordfile /opt/glassfish/pass.txt
    durmiendo
    sleep 60s

    #PASO 5 Subir los servicios de glassfish
    /opt/glassfish/bin/asadmin list-instances
    /opt/webserver/https-demposapp1.audifarma.com.co/bin/startserv

    #TAREA DE MANTENIMIENTO DE AUDITOR DEMPOS IP-- 10.1.1.43
    /opt/glassfish/bin/asadmin stop-node-agent
    /opt/glassfish/bin/asadmin stop-domain

    ps -ef |grep glassfish
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish/bin/asadmin start-node-agent
    usuario admin clave adminadmin maestra=enter
    /opt/glassfish/bin/asadmin list-instances

    ;;

  4)
    #TAREA DE MANTENIMIENTO SERVIDORES AUDITOR IPS IP 10.1.1.66
    /opt/webserver7/https-ips2.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances
    /opt/webserver7/https-ips2.audifarma.com.co/bin/startserv

    ;;


  5)
    #TAREA DE MANTENIMIENTO SERVIDORES AUDITOR IPS IP 10.1.1.65
    /opt/webserver7/https-ips.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd
    /opt/glassfish/bin/asadmin stop-node-agent
    /opt/glassfish/bin/asadmin stop-domain
    ps -ef |grep glassfish
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish/bin/asadmin start-node-agent
    admin adminadmin enter

    /opt/webserver7/https-ips.audifarma.com.co/bin/startserv

    #PTE: COMO SE VALIDA EL INGRESO

    ;;

  6)
    #TAREA DE MANTENIMIENTO SERVIDORES AUDITOR PRUEBAS IP 10.1.1.115

    #GLASFISH2
    /opt/glassfish/bin/asadmin stop-domain
    /opt/glassfish3/bin/asadmin stop-domain
    /opt/glassfish4/bin/asadmin stop-domain
    ps -ef |grep glassfish
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish4/bin/asadmin start-domain

    #TOMCAT:
    cd /opt/tomcat/apache-tomcat-8.0.27/bin/
    ./shutdown.sh
    ./startup.sh

    #PTE: COMO SE VALIDA EL INGRESO
    #pruebasbd.audifarma.com.co:7676
    ;;

  7)
    # BODEGA  IP 10.1.1.185

    service httpd stop

    /opt/glassfish/bin/asadmin stop-domain
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-domain
    service httpd start

    ;;

  8)

    #TAREA DE MANTENIMIENTO SERVIDORES  PORTOS IP 10.1.1.113

    #BAJAR WEB SERVER
    /opt/webserver/https-hyper.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd

    #BAJAR GLASFISH3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERVER
    /opt/webserver/https-hyper.audifarma.com.co/bin/startserv

    #PTE: (COMO VALIDO EL INGRESO)

    ;;

  9)
    #TAREA DE MANTENIMIENTO SERVIDOR MOVGRAL IP 10.1.1.130

    #BAJAR WEB SERVER
    /opt/webserver/https-movgral.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd

    #BAJAR GLASFISH3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3

    #SUBIR GLASSFISH3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERVER
    /opt/webserver/https-movgral.audifarma.com.co/bin/startserv
    #http://movgral.audifarma.com.co:80

    ;;

  10)
    #TAREA DE MANTENIMIENTO SERVIDOR CORREO DOMINIO AUDIFARMA.COM.CO

    Correo wind
    sudo service httpd restart
    sudo quotaoff /cxorion         -- apagar couotas
    sudo quotacheck -vgum /cxorion --manten a las cuotas de correo
    sudo quotaon /cxorion -- encender cuotas
    sudo service dovecot restart
    #mailq -- verificar si llegan y salen correos

    ;;

  11)
    #TAREA DE MANTENIMIENTO SERVIDOR  IP 10.1.1.20

   # service httpd stop
   # cd /cxorion/dotcms/dotcms2.5.4/dotserver/
   # ll
   # bin/./shutdown.sh
   # ps -ef |grep tomcat
   # ll /tmp   ( si aparece un archivo dotserver.pid  hay que eliminarlo)
   # ulimit -n 100000
   # bin/startup.sh&
   # service httpd start

   # cava.audifarma.com.co

    ;;

  12)
    #TAREA DE MANTENIMIENTO SERVIDORES SITA IP / 10.1.244.175-176

    #BAJAR GF3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3

    #SUBIR GF3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    ;;

  13)
    #TAREA DE MANTENIMIENTO SERVIDORES EN CASA IP 10.1.244.46 / 10.1.244.61

    #BAJAR WEB SERVER
    #Servidor 46
    /opt/webserver/https-localhost.localdomain/bin/stopserv

    #Servidor 61
    /opt/webserver/https-segdomicilio/bin/stopserv

    ps -ef |grep webservd
    BAJAR GLASFISH3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef | grep glassfish3

    #SUBIR GLASSFISH3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERVER
    #Servidor 46
    /opt/webserver/https-localhost.localdomain/bin/startserv

    #Servidor 61
    /opt/webserver/https-segdomicilio/bin/startserv


    #https://pacientesws.audifarma.com.co/pacienteswsalter/

    ;;

  14)
    #TAREA DE MANTENIMIENTO SERVIDOR REPLICA IP 10.1.1.159

    #BAJAR WEB SER
    /opt/webserver7/https-bdreplica.voxmark.net/bin/stopserv
    ps -ef |grep webservd

    #BAJAR GLASSFISH3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3

    #SUBIR GLASSFISH3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERVER
    /opt/webserver7/https-bdreplica.voxmark.net/bin/startserv

    #http://bdreplica.voxmark.net:80

    ;;

  15)
    #TAREA DE MANTENIMIENTO SERVIDOR COLCIENCIAS IP 10.1.1.173

    #BAJAR WEB SERV
    /opt/webserver7/https-colcienciasapp.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd

    #BAJAR GLASSFISH3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3

    #SUBIR GLF3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERV
    /opt/webserver7/https-colcienciasapp.audifarma.com.co/bin/startserv

    #http://colcienciasapp.audifarma.com.co:80

    #DASHBOARD
    cd /opt/dashBoardSeguimientoApp/
    ps -ef |grep jetty
    kill -9 proceso
    ./start-demo.sh&

    ;;

  16)
    #TAREA DE MANTENIMIENTO SERVIDOR SKYNET  IP 10.1.1.179

    #BAJAR WEB SERV
    /opt/webserver/https-hyper.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd

    #BAJAR GLASSFISH3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3


    #SUBIR GLASSFISH3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERV
    /opt/webserver/https-hyper.audifarma.com.co/bin/startserv

    #http://hyper.audifarma.com.co:80

    ;;

  17)
    #TAREA DE MANTENIMIENTO SERVIDOR ATHOS IP 10.1.1.207

    #BAJAR WEB SERV
    /opt/webserver7/https-athos.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd

    #BAJAR
    /opt/glassfish/bin/asadmin stop-node-agent
    /opt/glassfish/bin/asadmin stop-domain
    ps -ef |grep glassfish

    #SUBIR GLASSFISH
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish/bin/asadmin start-node-agent
    admin adminadmin enter
    /opt/glassfish/bin/asadmin list-instances

    #SUBIR WEB SER
    /opt/webserver7/https-athos.audifarma.com.co/bin/startserv

    #http://athos.audifarma.com.co:80

    ;;

  18)
    #TAREA DE MANTENIMIENTO SERVIDOR  IP 10.1.1.69

    #BAJAR WEB SERV
    /opt/webserver/https-repgral.audifarma.com.co/bin/stopserv
    ps -ef |grep webservd

    #BAJAR GLASSFISH
    /opt/glassfish/bin/asadmin stop-node-agent
    /opt/glassfish/bin/asadmin stop-domain
    ps -ef |grep glassfish

    #SUBIR GLASSFISH
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish/bin/asadmin start-node-agent
    enter
    /opt/glassfish/bin/asadmin list-instances

    #SUBIR WEB SERV
    /opt/webserver/https-repgral.audifarma.com.co/bin/startserv

    http://repgral.audifarma.com.co:80
    ;;

  19)
    #TAREA DE MANTENIMIENTO SERVIDOR  IP 10.1.1.205

    BAJAR WEB SERV
    /opt/webserver7/https-thunder.audifarma.com.co/bin/stopserv

    #BAJAR GLASSFISH
    /opt/glassfish/bin/asadmin stop-node-agent
    /opt/glassfish/bin/asadmin stop-domain
    ps -ef |grep glassfish

    #SUBIR GLASSFISH
    /opt/glassfish/bin/asadmin start-domain
    admin adminadmin 12345678
    /opt/glassfish/bin/asadmin start-node-agent
    admin adminadmin 12345678
    /opt/glassfish/bin/asadmin list-instances

    #SUBIR WEB SERV
    /opt/webserver7/https-thunder.audifarma.com.co/bin/startserv

    user name>admin
    admin password>adminadmin
    master password>12345678
    ;;

  20)
    #AREA DE MANTENIMIENTO SERVIDOR ATLAS  IP 10.1.1.60

    #BAJAR WEB SERVER
    /opt/webserver8/https-atlas/bin/stopserv
    /opt/webserver7/https-atlas/bin/stopserv

    #BAJAR GLASSFISH
    /opt/glassfish/bin/asadmin stop-node-agent
    /opt/glassfish/bin/asadmin stop-domain
    /opt/glassfish3/bin/asadmin stop-cluster cluster1 -p 5858
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish

    #SUBIR GLASSFISH
    /opt/glassfish/bin/asadmin start-domain
    /opt/glassfish/bin/asadmin start-node-agent
    #admin adminadmin enter

    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1 -p 5858
    /opt/glassfish/bin/asadmin list-instances
    /opt/glassfish3/bin/asadmin list-instances


    #SUBIR WEB SERVER
    /opt/webserver8/https-atlas/bin/startserv
    /opt/webserver7/https-atlas/bin/startserv
    ;;

  21)

    #TAREA DE MANTENIMIENTO SERVIDOR SPARK   IP 10.1.1.24

    #Reiniciar SPARK 10.1.1.24
    /opt/openfire_393/bin/openfire stop

    #bajar la bd
    /etc/init.d/mysqld2 stop
    ps -ef |grep openfire

    #subir
    mysqld_safe --defaults-file=/etc/my2.cnf &
    /opt/openfire_393/bin/openfire start
    /opt/openfire_393/bin/openfire status

    #ASI SE VALIDA:
    http://10.1.1.24:9090/login.jsp?url=%2Findex.jsp
    ;;

  22)
    #TAREA DE MANTENIMIENTO SERVIDOR PAGINA AUDIFARMA IP 10.1.1.7

    cd /opt/dotcms5.1.5/dotserver/tomcat-8.5.32/bin/primero

    ./shutdown.sh

    ps -ef |grep tomcat

    kill -9 proceso tomcat

    ll /tmp
    si hay un dotserver.pid
    ulimit -n 100000 --habilitar cien mil conexiones
    ./startup.sh &

    service httpd restart -- reincio apache
    ;;

  23)
    #TAREA DE MANTENIMIENTO SERVIDOR sensores IP 10.1.1.86

    #BAJAR WEB SERV
    /opt/webserver/https-yareth.audifarma.com.co/bin/stopserv

    #BAJAR GLF3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef | grep glassfish3

    #SUBIR GLF3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERV
    /opt/webserver/https-yareth.audifarma.com.co/bin/startserv
    #http://yareth.audifarma.com.co:80
    ;;

  24)
    #TAREA DE MANTENIMIENTO SERVIDOR sensores IP 10.1.244.15

    #BAJAR WEB
    /opt/webserver/https-wsescalamiento.audifarma.com.co/bin/stopserv

    #BAJAR GLF3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef | grep glassfish3


    #SUBIR GLF3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1

    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB
    /opt/webserver/https-wsescalamiento.audifarma.com.co/bin/startserv

    ;;

  25)
    TAREA DE MANTENIMIENTO SERVIDOR HYPER IP 10.1.1 215

    #Servicio: http://10.1.1.215:8095/paprs/
    #Aplicativo de APP Movil

    #BAJAR TOMCAT
    cd /opt/tomcat/apache-tomcat-8.0.27/bin
    ./shutdown.sh


    #BAJAR WEB SERV
    /opt/webserver/https-localhost.localdomain/bin/stopserv

    #BAJAR GLF3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef | grep glassfish3

    #SUBIR GLF3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1

    #VER LAS INSTANCIAS
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR TOMCAT
    ./startup.sh

    #SUBIR WEB SERV
    /opt/webserver/https-localhost.localdomain/bin/startserv

    #Servicio WEB SERV
    #http://10.1.1.215/TableroMonitoreoAmbiental/faces/principal.xhtml

    ;;

  26)
    #TAREA DE MANTENIMIENTO SERVIDOR VULCANO  IP 10.1.1.23

    service httpd restart

    ;;

  27)
    #TAREA DE MANTENIMIENTO SERVIDOR quiron  IP 10.1.1.131

    #BAJAR WEB SERVER
    /opt/webserver/https-quiron.audifarma.com.co/bin/stopserv

    #BAJAR GF3
    /opt/glassfish3/bin/asadmin stop-cluster cluster1
    /opt/glassfish3/bin/asadmin stop-domain
    ps -ef |grep glassfish3

    #SUBIR GLF3
    /opt/glassfish3/bin/asadmin start-domain
    /opt/glassfish3/bin/asadmin start-cluster cluster1

    #VER LAS INSTANCIAS
    /opt/glassfish3/bin/asadmin list-instances

    #SUBIR WEB SERVER
    /opt/webserver/https-quiron.audifarma.com.co/bin/startserv

    ;;

  28)

    #TAREA DE MANTENIMIENTO SERVIDOR LDAP  IP 10.1.1.225
    #Reiniciar el servicio de LDAP
    /etc/init.d/ldap restart

    ;;


  29)
    #TAREA DE MATENIMIENTO SERVIDOR DE PRUEBA DE AUDITOR 10.1.1.146
    #Ejectuamos el script stopserv para detener el webserver
    echo "#########################################################################################################" >> /root/scripts/mantenimientoServidores.log
    echo "Comienza tarea de mantenimiento al servidor pruebas Auditor3 10.1.1.146 el día $fecha a las $hora." >> /root/scripts/mantenimientoServidores.log
    echo "Ejecutando script stopserv para detener el webserver..."
    echo " "
    echo " "
    /opt/webserver/https-auditor3.audifarma.com.co/bin/stopserv
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script stopserv para detener el webserver a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "
    echo "Por favor espere 10 segundos..."
    echo " "
    echo " "
    sleep 10s

    #Bajamos el nodo
    echo "Ejecutando script stop-node-agent..."
    echo " "
    echo " "
    /opt/glassfish/bin/asadmin stop-node-agent
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script stop-node-agent para detener el nodo a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "
    echo "Por favor espere 10 segundos..."
    echo " "
    echo " "
    sleep 10s

    #Bajamos el dominio
    echo "Ejecutando script stop-domain..."
    echo " "
    echo " "
    /opt/glassfish/bin/asadmin stop-domain
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script stop-domain para detener el dominio a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo " "
    echo " "
    echo "Por favor espere 10 segundos..."
    echo " "
    echo " "
    sleep 10s

    #Miramos qué procesos están activos
    echo "A continuación todos los procesos activos de glassfish..."
    echo " "
    echo " "
    ps -ef |grep glassfish
    echo " "
    echo " "

    echo -p "Digite el número de procesos activos de glassfish. (presione 0 si no tiene...)" numeroProcesos 

    if [$numeroProcesos -eq 0]
    then
        break
    else
        c=1
        while [ $c -ne 0 ]
        do
          for((i=1; i<=$numeroProcesos; i++)){
            echo " "
            echo " "
            echo -p "Digite la ID del proceso número:$i ..." idProceso 
            echo " "
            echo " "

            kill -9 $idProceso
          }

          echo " "
          echo " "
          echo "Verifique que todos los procesos se hayan cerrado..."
          echo " "
          echo " "
          ps -ef |grep glassfish
          echo " "
          echo " "
          echo -p "Si los procesos se bajaron completamente digite 0, de lo contrario digite 1 u otro numero:" c
          echo " "
          echo " "
        done
    fi

    #Con esta estructura recorremos todas las instancias de auditor3 y les borramos los logs
    echo " "
    echo " "
    echo "Aquí recorremos todas las instancias y eliminamos los logs..."
    echo " "
    echo " "

    i=1
    while [ $i -lt 6 ]

    do
    rm -rf /opt/glassfish/nodeagents/pruebas.audifarma.com.co/instancia$i/logs/server.log
    rm -rf /opt/glassfish/nodeagents/pruebas.audifarma.com.co/instancia$i/imq/instances/cluster1instancia$i/log/log.txt
    #Nuevo requerimiento de Francisco
    #cp /opt/glassfish/nodeagents/auditor3.audifarma.com.co/instancia$i/imq/instances/cluster1slave$i/log/log.txt
    cat /dev/null > /opt/glassfish/nodeagents/pruebas.audifarma.com.co/instancia$i/imq/instances/cluster1instancia$i/log/log.txt
    cat /dev/null > /opt/glassfish/nodeagents/pruebas.audifarma.com.co/instancia$i/generated/jsp/j2ee-modules/__default-web-module-server/tldCache.ser
    ((i++))
    done


    echo " "
    echo " "
    echo "Por favor, espere 10 segundos..."
    echo " "
    echo " "
    sleep 10s

    #Subimos el dominio
    echo "Ejecutando comando start-domain..."
    /opt/glassfish/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script start-domain para subir el dominio a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log

    echo " "
    echo " "
    echo "Por favor, espere 10 segundos..."
    sleep 10s

    #Subimos el nodo
    echo "Ejecutando el comando start-node-agent..."
    /opt/glassfish/bin/asadmin start-node-agent --user admin --passwordfile /opt/glassfish/pass.txt
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Se ejecuta script start-node-agent para subir el nodo a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log


    #Con este comando mostramos la lista de instancias

    echo " "
    echo " "
    echo "Aquí listamos todas las instancias..."
    echo " "
    echo " "

    /opt/glassfish/bin/asadmin list-instances
    echo " "
    echo " "
    echo " " >> /root/scripts/mantenimientoServidores.log
    echo "Mantenimiento finalizado a las: `date '+%H:%M:%S'` " >> /root/scripts/mantenimientoServidores.log
    echo "#########################################################################################################" >> /root/scripts/mantenimientoServidores.log

    ;;



#Fin de la estructura Case
esac

#Fin del While
done

echo "Usted ha salido exitosamente del programa"
