# !/bin/bash
# Este Scriptsito mata procesos activos, sólo se necesita indicar el número de procesos y el PID del mismo
# By: Daijaz
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

# Fin del script
echo "El programa ha finalizado con éxito."
