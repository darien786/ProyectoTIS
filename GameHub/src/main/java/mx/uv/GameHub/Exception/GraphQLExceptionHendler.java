package mx.uv.GameHub.Exception;

import java.util.List;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;

//Extiende la clase DataFetcherExceptionResolverAdapter para manejar excepciones en la resolucion de datos durante las operaciones de GraphQL
public class GraphQLExceptionHendler extends DataFetcherExceptionResolverAdapter{

    //Se encarga de resolver una excepcion en un solo error de GraphQL que se pueda devolver en la respuesta    
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        
        //Se crea una instancia 
        return new GraphQLError() {

            //Se encarga de definir la clase de error
            @Override
            public List<SourceLocation> getLocations() {
                // TODO Auto-generated method stub
                return null;
            }

            //Se encarga de definir el tipo de error
            @Override
            public String getMessage() {
                // TODO Auto-generated method stub
                return ex.getMessage();
            }

            //Se encarga de definir el tipo de error
            @Override
            public ErrorClassification getErrorType() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }
}
