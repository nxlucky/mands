package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ugo on 01/05/2015.
 */
@RestController

public class LoginController extends ControllerBase {

    @RequestMapping(value = {"/login"},produces ="application/json" )
    public Object showLoginPage(HttpServletRequest request){

        return "login";
    }

    @RequestMapping(value = {"/welcome"})
    public Object welcomePage(){
        return "welcome";
    }


}
