package sample;
public class VotosRangoEdad
{
    // Enumeraciones
    public enum Edad
    {

        EDAD_JOVEN,
        EDAD_MEDIA,
        EDAD_MAYOR
    }


    public enum Genero
    {
        MASCULINO,
        FEMENINO
    }

    // Atributos

    private int cantidadMasculino;
    private int cantidadFemenino;
    private Edad edad;

    // Método constructor

    public VotosRangoEdad( Edad pEdad )
    {
        cantidadMasculino = 0;
        cantidadFemenino = 0;
        edad = pEdad;
    }

    // Métodos

    public int darCantidadMasculino( )
    {
        return cantidadMasculino;
    }

    public int darCantidadFemenino( )
    {
        return cantidadFemenino;
    }

    public Edad darEdad( )
    {
        return edad;
    }

    public int darCantidadTotalVotos( )
    {
        int total = cantidadMasculino + cantidadFemenino;
        return total;
    }

    public void registrarVoto( Genero pGenero )
    {
        switch( pGenero )
        {
            case MASCULINO:
            {
                cantidadMasculino++;
                break;
            }
            case FEMENINO:
            {
                cantidadFemenino++;
                break;
            }
        }
    }

    public void reiniciar( )
    {
        cantidadMasculino = 0;
        cantidadFemenino = 0;
    }

}











