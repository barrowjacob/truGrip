package trugrip.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import trugrip.site.Models.SchoolClass;
import trugrip.site.Models.User;

@Controller
public class IndexController {

//    DAO's
    private User user;
    private SchoolClass schoolClass;





    @GetMapping("/index")
    public String homePage() {
        return "/pages/index";
    }
}
