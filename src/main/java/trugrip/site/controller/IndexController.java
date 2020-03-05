package trugrip.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import trugrip.site.Repositories.ClassRepository;
import trugrip.site.Repositories.UserRepository;

@Controller
public class IndexController {

//    DAO's
    private final UserRepository userDao;
    private final ClassRepository schoolClassDao;

    public IndexController(UserRepository userDao, ClassRepository schoolClassDao) {
        this.userDao = userDao;
        this.schoolClassDao = schoolClassDao;
    }

    @GetMapping("/index")
    public String homePage(Model model) {
        model.addAttribute("schools", schoolClassDao.findAll());
        return "/pages/index";
    }


}
