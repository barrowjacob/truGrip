package trugrip.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trugrip.site.Repositories.ClassRepository;
import trugrip.site.Repositories.UserRepository;
import trugrip.site.Services.StripeService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class checkoutClassController {
    private final UserRepository userDao;
    private final ClassRepository schoolClassDao;

    public checkoutClassController(UserRepository userDao, ClassRepository schoolClassDao) {
        this.userDao = userDao;
        this.schoolClassDao = schoolClassDao;
    }

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("/bookNow/{id}/checkout")
    public String checkout(Model model, @PathVariable Integer id) {
        model.addAttribute(schoolClassDao.getOne(id));
        model.addAttribute("amount", schoolClassDao.getOne(id).getPrice() * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "/pages/checkout";
    }
    @Autowired
    private StripeService stripeService;

    @RequestMapping(value = "/charge/{id}", method = RequestMethod.POST)
    public String chargeCard(@PathVariable Integer id, Model model, HttpServletRequest request) throws Exception {
        model.addAttribute("class", schoolClassDao.getOne(id));
        String token = request.getParameter("stripeToken");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        model.addAttribute("amount", amount);
        stripeService.chargeNewCard(token, amount);
        return "/pages/result";
    }

    @GetMapping("/result")
    @ResponseBody
    public String yes() {
        return "thats right";
    }

}





