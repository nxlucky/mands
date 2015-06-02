package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by uchegc01 on 02/06/2015.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Movie not found")
public class MovieNotFoundException extends RuntimeException{
}
