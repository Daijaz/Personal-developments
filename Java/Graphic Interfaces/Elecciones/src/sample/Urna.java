package sample;
public class Urna
{
    // Atributos
    private Candidato candidato1;
    private Candidato candidato2;
    private Candidato candidato3;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    public Urna( )
    {
        candidato1 = new Candidato( "Andrea", "Combes", "Independiente", 27, 1 );
        candidato2 = new Candidato( "Felipe", "Pitti", "Revolucionario", 26, 2 );
        candidato3 = new Candidato( "Susanita", "Chirusi", "Tradicional", 26, 3 );
    }


    public Candidato darCandidato1( )
    {
        return candidato1;
    }

    public Candidato darCandidato2( )
    {
        return candidato2;
    }

    public Candidato darCandidato3( )
    {
        return candidato3;
    }

    public Candidato buscarCandidato( int pNumero )
    {
        Candidato buscado = null;

        if( candidato1.darNumero( ) == pNumero )
        {
            buscado = candidato1;
        }
        else if( candidato2.darNumero( ) == pNumero )
        {
            buscado = candidato2;
        }
        else if( candidato3.darNumero( ) == pNumero )
        {
            buscado = candidato3;
        }

        return buscado;
    }

    public int calcularTotalVotos( )
    {
        return candidato1.darCantidadTotalVotos( ) + candidato2.darCantidadTotalVotos( ) + candidato3.darCantidadTotalVotos( );
    }

    public int calcularTotalVotosGeneroFemenino( )
    {
        return candidato1.darTotalVotosGeneroFemenino( ) + candidato2.darTotalVotosGeneroFemenino( ) + candidato3.darTotalVotosGeneroFemenino( );
    }

    public int calcularTotalVotosGeneroMasculino( )
    {
        return candidato1.darTotalVotosGeneroMasculino( ) + candidato2.darTotalVotosGeneroMasculino( ) + candidato3.darTotalVotosGeneroMasculino( );
    }

    public int darTotalVotosRangoEdad( VotosRangoEdad.Edad pEdad )
    {
        int total = 0;
        switch( pEdad )
        {
            case EDAD_JOVEN:
            {
                total = candidato1.darVotosRango1( ).darCantidadTotalVotos( ) + candidato2.darVotosRango1( ).darCantidadTotalVotos( ) + candidato3.darVotosRango1( ).darCantidadTotalVotos( );
                break;
            }
            case EDAD_MEDIA:
            {
                total = candidato1.darVotosRango2( ).darCantidadTotalVotos( ) + candidato2.darVotosRango2( ).darCantidadTotalVotos( ) + candidato3.darVotosRango2( ).darCantidadTotalVotos( );
                break;
            }
            case EDAD_MAYOR:
            {
                total = candidato1.darVotosRango3( ).darCantidadTotalVotos( ) + candidato2.darVotosRango3( ).darCantidadTotalVotos( ) + candidato3.darVotosRango3( ).darCantidadTotalVotos( );
                break;
            }
        }

        return total;
    }

    public double calcularCostoPromedioCampanha( )
    {
        double total = candidato1.darCostoCampanha( ) + candidato2.darCostoCampanha( ) + candidato3.darCostoCampanha( );
        double promedio = total / 3;

        return promedio;
    }

    public double calcularPorcentajeVotosCandidato( int pNumero )
    {
        double numVotosCandidato = buscarCandidato( pNumero ).darCantidadTotalVotos( );
        double votosTotales = calcularTotalVotos( );

        double porcentaje = numVotosCandidato / votosTotales * 100;

        return porcentaje;
    }

    public void registrarVoto(int pNumero, VotosRangoEdad.Edad pEdad, VotosRangoEdad.Genero pGenero, Candidato.Medio pMedio )
    {
        Candidato buscado = buscarCandidato( pNumero );
        if( buscado != null )
        {
            buscado.registrarVoto( pEdad, pGenero, pMedio );
        }
    }

    public void reiniciar( )
    {
        candidato1.reiniciar( );
        candidato2.reiniciar( );
        candidato3.reiniciar( );
    }


}
