#!/bin/sh
# Lorena Sandoval - Infraestructura TIC 

#Se le asgina la cadena de texto de los log_usuarios_creado.txt
log=/var/log/log_usuarios_creados.txt

#Se asgina a la varibale date el día de hoy
date=`date '+%d-%m-%Y %H:%M:%S'`
clear
echo "Ingrese el nombre: "
read nombrecompleto
echo " "
echo " "
echo " Digite el login para el correo "
echo " Ejemplo: carlosep (nombre+primerapellido+segundoapellido)"
read login
echo " "
echo "Esta seguro de crear el correo (si (1) no (cualquier tecla))"
read opcion
if [ $opcion = 1 ]; then
sudo /usr/sbin/useradd -g mail -s /sbin/nologin -c "$nombrecompleto" $login
echo " "
echo " " 
#read clave | tee pass
echo " "
sudo /usr/bin/passwd $login
echo " "
echo " Se creo el usuario $nombrecompleto con el login: $login "
echo " "
echo "Asignación de la cuota (100 Megas en /dev/emcpowera1): "
sudo /usr/bin/clear
sudo /usr/sbin/edquota $login
clear
echo " "
echo " "
echo " Usuario Creado Satisfactoriamente........................shell by yeisonh "
echo "Fecha: $date - Info(M): Se creo el usuario de correo $login" >> $log
else
echo " No se creo el usuario "
echo " "
fi






