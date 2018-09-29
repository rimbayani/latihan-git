package id.go.bssn.knowledgeManagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.go.bssn.knowledgeManagement.domain.User;
import id.go.bssn.knowledgeManagement.domain.UserPassword;
import id.go.bssn.knowledgeManagement.domain.Role;

import id.go.bssn.knowledgeManagement.repository.UserRepository;
import id.go.bssn.knowledgeManagement.repository.RoleRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	// From Tabel User
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('USER_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorUser"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		// "listUser" = Object dari Database yang Dilempar ke HTML
		Page<User> listUser = userRepository.findAll(pr);
		mm.addAttribute("listUser", listUser.getContent());
	}
	
	// From Add dan Edit User
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('USER_ADD', 'USER_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
        User user;
        
        if(id != null) {
            user = userRepository.findOne(id);
            user.setPasswordUser(user.getIdUsernamePassword().getPasswordUser());
        } else {
            user = new User();
        }
        
        Iterable<Role> listRole = roleRepository.findAll();
        mm.addAttribute("user", user);
        mm.addAttribute("listRole", listRole); 
    }
	
	// @ModelAttribute User user = Disamakan Dengan *.HTML yaitu th:object="${user}"
	// Form Save dan Edit User
    @PostMapping("/form")
//  @PreAuthorize("hasAnyAuthority('USER_ADD', 'USER_EDIT')")
    public String postForm(@ModelAttribute User user) {
        UserPassword userPassword = new UserPassword();
        
        userPassword.setIdUsernamePassword(user);
        userPassword.setPasswordUser(user.getPasswordUser());
        userPassword.setPasswordFileUser(user.getPasswordFileUser());
        userPassword.setDongleUser(user.getDongleUser());
        user.setIdUsernamePassword(userPassword);
        
        userRepository.save(user); 
        return "redirect:/user/list";
    }
    
    // Form Delete User
    @GetMapping("/delete/")
//  @PreAuthorize("hasAuthority('USER_DELETE')")
    public String delete(@RequestParam String id) {
        userRepository.delete(id);
        return "redirect:/user/list";
    }
}
