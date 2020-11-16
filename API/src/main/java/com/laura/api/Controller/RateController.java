package com.laura.api.Controller;

import com.laura.api.Service.RateService;
import com.laura.api.Service.UserService;
import com.laura.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/rate")
@CrossOrigin(origins = "*")
public class RateController {
    
    @Autowired
    RateService RateService;

    @Autowired
    UserService userService;

    @PostMapping("/participant")
    public ResponseEntity<?> rateParticipant(@RequestParam long idParticipant, @RequestParam long idEvent, @RequestParam float score){
        try{
            RateService.insertVote(idParticipant, getUser(), idEvent, score, 2);
            return ResponseEntity.ok().build();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/organizer")
    public ResponseEntity<?> rateOrganizer(@RequestParam long idOrganizer, @RequestParam long idEvent, @RequestParam float score){
        try{
            RateService.insertVote(idOrganizer, getUser(), idEvent, score, 1);
            return ResponseEntity.ok().build();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    private User getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getUser(auth.getName());
	}
}
