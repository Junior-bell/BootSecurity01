package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/")
    public String showHomepage() {
		return "login";
	}
    
    @GetMapping("/home")
    public String showHomePage() {
		return "home";
	}

    @GetMapping("/offers")
    public String showOffers() {
        return "offers";
    }

    @GetMapping("/checkBalance")
    public String checkBalance() {
        return "balance";
    }

    @GetMapping("/loan")
    public String approveLoan() {
        return "loan";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
    @GetMapping("checkLoanStatus")
    public String checkLoanStatus() {
		return "loanStatus";
	}
    
}