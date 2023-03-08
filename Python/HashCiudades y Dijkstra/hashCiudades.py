ciudades = {
    'Bogota': {
        'nombre': 'Bogota',
        'pais': 'Colombia',
        'poblacion': '9 millones',
        'hechos': 'El grito de independecia se llevo acabo en esta ciudad.',
    },
    'Valledupar': {
        'nombre': 'Valledupar',
        'pais': 'Colombia',
        'poblacion': '900000',
        'hechos': 'En esta ciudad se celebra el festival vallenato cada año.',
    },
    'Cali': {
        'nombre': 'Cali',
        'pais': 'Colombia',
        'poblacion': '4 millones',
        'hechos': 'Cali es la ciudad que representa la salsa en Colombia (Género Musical).',
    },
    'Ibague': {
        'nombre': 'Ibague',
        'pais': 'Colombia',
        'poblacion': '9 millones',
        'hechos': 'De esta ciudad es oriundo el Tamal, plato típico de Colombia.',
    },
    'Armenia': {
        'nombre': 'Armenia',
        'pais': 'Colombia',
        'poblacion': '400.000',
        'hechos': 'En 1999 ocurrió un grave terremoto.',
    },
    'Monteria': {
        'nombre': 'Monteria',
        'pais': 'Colombia',
        'poblacion': '1 millones',
        'hechos': 'En las veredas aledañas de esta ciudad queda el uberrimo, predio del asesino mas grande que tiene este país.',
    },
    'Pasto': {
        'nombre': 'Pasto',
        'pais': 'Colombia',
        'poblacion': '1 millon',
        'hechos': 'De esta ciudad es oriundo el cuy, plato típico de los Colombianos.',
    },
    'Zipaquira': {
        'nombre': 'Zipaquira',
        'pais': 'Colombia',
        'poblacion': '20.000',
        'hechos': 'Ciudad donde nació el campeón del tour de francia 2019; Egan Bernal.',
    },

    'Barranquilla': {
        'nombre': 'Barranquilla',
        'pais': 'Colombia',
        'poblacion': '3 millones',
        'hechos': 'Lugar de nacimiento de la cantante Shakira.',
    },
    'Medellin': {
        'nombre': 'Medellin',
        'pais': 'Colombia',
        'poblacion': '4 millones',
        'hechos': 'En esta ciudad se encuentra la comuna 13, epicentro del conflicto narco terrorista en los 80.',
    }
}
for clave, informacion in ciudades.items():
    print('\nEl nombre de la ciudad es: ', clave)
    Pais_población_hechos = 'El pais en que se encuentra es ' + informacion['pais'] + ', su poblacion es ' + informacion[
        'poblacion'] + ', Los hechos : ' + informacion['hechos']
    print('\tInformación : ' + Pais_población_hechos.title())