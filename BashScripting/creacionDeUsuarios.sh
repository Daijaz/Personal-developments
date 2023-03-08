#!/bin/bash
#Este script crea 3 usuarios con permisos root:
#By: magghuz - Juan Calderón

#Se crea el usuario en el grupo root:

useradd -g root franciscoc -c "Francisco Cuero"
useradd -g root robinsonr  -c "Robinson Rios"
useradd -g root juliang    -c "Julian Gonzalez"
useradd -g root sysadmin   -c "Admin System"

#Se establece una contraseña por defecto:

echo -e "2Q*sd34x-1\n2Q*sd34x-1" | passwd franciscoc
echo -e "4x*5d4xc,e\n4x*5d4xc,e" | passwd robinsonr
echo -e "E3@dfE3sd*\nE3@dfE3sd*" | passwd juliang
echo -e "r4Tdserg*s\nr4Tdserg*s" | passwd sysadmin

#Las contraseñas tienen una caducidad de 90 dias
#El sistema se encargará de notificar al usuario
#el vencimiento 7 días antes #!/bin/sh

passwd -x 90 -w 7 franciscoc
passwd -x 90 -w 7 robinsonr
passwd -x 90 -w 7 juliang

#Se inscribe el usuario en este archivo para que
#pueda ejecutar los comandos de root

echo "franciscoc ALL=(ALL:ALL) ALL" >> /etc/sudoers
echo "robinsonr  ALL=(ALL:ALL) ALL" >> /etc/sudoers
echo "juliang    ALL=(ALL:ALL) ALL" >> /etc/sudoers


