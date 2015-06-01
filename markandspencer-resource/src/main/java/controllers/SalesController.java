package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.MovieStoreService;

/**
 * Created by Ugo on 01/06/2015.
 */

@RestController
@RequestMapping(value = "/purchase")
public class SalesController {

    @Autowired private MovieStoreService movieStoreService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public  Object  buyMovie(@RequestBody String payload)throws Exception{
        Object movieBuyerObject = movieStoreService.processSale(payload);



        return new  ResponseEntity<String>(HttpStatus.CREATED);
    }
}
