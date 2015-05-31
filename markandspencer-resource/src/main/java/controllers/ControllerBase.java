package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Ugo on 01/05/2015.
 */
public class ControllerBase {



    @ModelAttribute("c")
    public ControllerBase exposeController() {
        return this;
    }


}
