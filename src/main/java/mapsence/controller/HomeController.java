package mapsence.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class HomeController {
    @GetMapping("/{jwtToken}")
    public String home(Model model, @PathVariable String jwtToken, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.isEmpty()) {
            authHeader = "Bearer " + jwtToken;
            ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().setAttribute("Authorization", authHeader);
        }
        return "home";
    }
}
