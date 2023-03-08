package sample;
public class Candidato
{

    // Enumeraciones

    public enum Medio
    {
        INTERNET,
        RADIO,
        TELEVISION
    }

    //Constantes

    public final static double COSTO_INTERNET = 100;
    public final static double COSTO_RADIO = 500;
    public final static double COSTO_TELEVISION = 1000;

    // Atributos

    private String nombre;
    private String apellido;
    private String partidoPolitico;
    private int edad;
    private double costoCampanha;
    private int numero;

    //Relaciones entre clases

    private VotosRangoEdad votosRango1;
    private VotosRangoEdad votosRango2;
    private VotosRangoEdad votosRango3;

    // Método constructor

    public Candidato( String pNombre, String pApellido, String pPartidoPolitico, int pEdad, int pNumero )
    {
        nombre = pNombre;
        apellido = pApellido;
        partidoPolitico = pPartidoPolitico;
        edad = pEdad;
        costoCampanha = 0;
        numero = pNumero;

        votosRango1 = new VotosRangoEdad( VotosRangoEdad.Edad.EDAD_JOVEN );
        votosRango2 = new VotosRangoEdad( VotosRangoEdad.Edad.EDAD_MEDIA );
        votosRango3 = new VotosRangoEdad( VotosRangoEdad.Edad.EDAD_MAYOR );
    }

    //Métodos

    public String darNombre( )
    {
        return nombre;
    }

    public String darApellido( )
    {
        return apellido;
    }

    public String darPartidoPolitico( )
    {
        return partidoPolitico;
    }

    public int darEdad( )
    {
        return edad;
    }

    public double darCostoCampanha( )
    {
        return costoCampanha;
    }

    public int darNumero( )
    {
        return numero;
    }

    public int darCantidadTotalVotos( )
    {
        return votosRango1.darCantidadTotalVotos( ) + votosRango2.darCantidadTotalVotos( ) + votosRango3.darCantidadTotalVotos( );
    }

    public int darTotalVotosGeneroFemenino( )
    {
        return votosRango1.darCantidadFemenino( ) + votosRango2.darCantidadFemenino( ) + votosRango3.darCantidadFemenino( );
    }

    public int darTotalVotosGeneroMasculino( )
    {
        return votosRango1.darCantidadMasculino( ) + votosRango2.darCantidadMasculino( ) + votosRango3.darCantidadMasculino( );
    }

    public VotosRangoEdad darVotosRango1( )
    {
        return votosRango1;
    }


    public VotosRangoEdad darVotosRango2( )
    {
        return votosRango2;
    }


    public VotosRangoEdad darVotosRango3( )
    {
        return votosRango3;
    }


    public void registrarVoto(VotosRangoEdad.Edad pEdad, VotosRangoEdad.Genero pGenero, Medio pMedio )
    {
        switch( pEdad )
        {
            case EDAD_JOVEN:
            {
                votosRango1.registrarVoto( pGenero );
                break;
            }
            case EDAD_MEDIA:
            {
                votosRango2.registrarVoto( pGenero );
                break;
            }
            case EDAD_MAYOR:
            {
                votosRango3.registrarVoto( pGenero );
                break;
            }
        }

        switch( pMedio )
        {
            case INTERNET:
            {
                costoCampanha += COSTO_INTERNET;
                break;
            }
            case RADIO:
            {
                costoCampanha += COSTO_RADIO;
                break;
            }
            case TELEVISION:
            {
                costoCampanha += COSTO_TELEVISION;
                break;
            }
        }
    }

    public void reiniciar( )
    {
        votosRango1.reiniciar( );
        votosRango2.reiniciar( );
        votosRango3.reiniciar( );
        costoCampanha = 0;
    }
}
