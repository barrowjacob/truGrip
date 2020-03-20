package trugrip.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import trugrip.site.Repositories.ClassRepository;
import trugrip.site.Repositories.UserRepository;

@Controller
public class allClassesController {
    private final UserRepository userDao;
    private final ClassRepository schoolClassDao;

    public allClassesController(UserRepository userDao, ClassRepository schoolClassDao) {
        this.userDao = userDao;
        this.schoolClassDao = schoolClassDao;
    }

    @GetMapping("/bookNow")
    public String showBookPage(Model model) {
        model.addAttribute("bookNow", true);
        model.addAttribute("schools", schoolClassDao.findAll());
        return "/pages/bookNow";
    }



}
