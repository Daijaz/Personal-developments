    # !/bin/bash
    # Tarea de mantenimiento servidor web AUDITOR9 10.1.1.21
    # Desarrollado por Infraestructura TIC Audifarma

    # Inicio mantenimiento
    echo "####################################################################################################################" >> /root/scripts/mantenimiento.log
    echo "Comienza tarea de mantenimiento al servidor Auditor9 IP: 10.1.1.21 el día `date '+%d-%m-%Y'` a las `date '+%H:%M:%S'`" >> /root/scripts/mantenimiento.log
    echo "Comienza tarea de mantenimiento al servidor Auditor9 IP: 10.1.1.21 el día `date '+%d-%m-%Y'` a las `date '+%H:%M:%S'`, por favor espere mientras termina..."

    # Bajamos el nodo
    echo "Ejecutando script stop-node-agent..." >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
        /opt/glassfish/bin/asadmin stop-node-agent >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo "Se ejecuta script stop-node-agent para detener el nodo agente a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    sleep 5s >> /root/scripts/mantenimiento.log

    # Bajamos el dominio
    echo "Ejecutando script stop-domain..." >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
        /opt/glassfish/bin/asadmin stop-domain >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo "Se ejecuta script stop-domain para detener el dominio a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    sleep 5s >> /root/scripts/mantenimiento.log

    # Matamos todas las intancias que quedaron pegadas
    touch /root/scripts/listadoProcesos.sh
    echo '#!/bin/bash' >> /root/scripts/listadoProcesos.sh
    ps -ef | grep glassfish | grep -v grep | tr -s ' ' | tr ' ' '\t' | cut -f 3 | sed "s/^/kill -9 /" >> /root/scripts/listadoProcesos.sh
    chmod 777 /root/scripts/listadoProcesos.sh
    sh /root/scripts/listadoProcesos.sh
    rm -rf /root/scripts/listadoProcesos.sh

    # Recorremos las instancias y borramos los logs
    i=1
    while [ $i -lt 20 ]
    do
    rm -rf /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/logs/server.log_20*
    rm -rf /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/imq/instances/cluster1slave$i/log/log$i.txt
    cat /dev/null > /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/imq/instances/cluster1slave$i/log/log.txt
    cat /dev/null > /opt/glassfish/nodeagents/auditor3.audifarma.com.co/slave$i/generated/jsp/j2ee-modules/auditor/auditor_SESSIONS.ser
    ((i++))
    done

    # Limpieza de Caches
    sync && echo 3 > /proc/sys/vm/drop_caches
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo "Se limpia la cache y los logs a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    sleep 5s >> /root/scripts/mantenimiento.log

    #Subimos el dominio
    echo "Ejecutando comando start-domain..." >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
        /opt/glassfish/bin/asadmin start-domain --user admin --passwordfile /opt/glassfish/pass.txt >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo "Se ejecuta script start-domain para subir el dominio a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    sleep 5s >> /root/scripts/mantenimiento.log

    #Subimos el nodo
    echo "Ejecutando el comando start-node-agent..." >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
        /opt/glassfish/bin/asadmin start-node-agent --user admin --passwordfile /opt/glassfish/pass.txt >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo "Se ejecuta script start-node-agent para subir el nodo a las `date '+%H:%M:%S'` " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    sleep 5s >> /root/scripts/mantenimiento.log

    #Con este comando mostramos la lista de instancias.
    echo "Aquí listamos todas las instancias..." >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
        /opt/glassfish/bin/asadmin list-instances --user admin --passwordfile /opt/glassfish/pass.txt >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo " " >> /root/scripts/mantenimiento.log
    echo "Mantenimiento finalizado a las: `date '+%H:%M:%S'` " >> /root/scripts/mantenimiento.log
    echo "Mantenimiento finalizado a las: `date '+%H:%M:%S'` "
    echo "#########################################################################################################" >> /root/scripts/mantenimiento.log
