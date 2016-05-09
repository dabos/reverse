package com.example.reverse;

import com.example.reverse.model.Reverse;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * @author Alex Bostan (alex.bostan@hostelworld.com)
 * @version $Id$
 * @since 1.0
 */
@Controller
@EnableAutoConfiguration
public class ReverseController {
    @RequestMapping(value = "/reverse", method = RequestMethod.GET)
    public String reverseForm(Model model) {
        model.addAttribute(new Reverse());
        return "reverse";
    }

    @RequestMapping(value = "/reverse", method = RequestMethod.POST)
    public String reverse(@ModelAttribute Reverse reverse, Model model) {
        Reverse res = new Reverse();
        res.setIt(new StringBuilder(reverse.getIt()).reverse().toString());
        model.addAttribute("reverse", res);
        return "result";
    }
}
