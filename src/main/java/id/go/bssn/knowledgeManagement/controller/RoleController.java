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

import id.go.bssn.knowledgeManagement.domain.Role;
import id.go.bssn.knowledgeManagement.repository.RoleRepository;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	//private final Logger log = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleRepository roleRepository;

	// From Tabel Role
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('ROLE_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorRole"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		Page<Role> listRole = roleRepository.findAll(pr);
		mm.addAttribute("listRole", listRole.getContent());
	}
	
	// From Add dan Edit Role
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADD', 'ROLE_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
		Role role;
        
        if(id != null) {
            role = roleRepository.findOne(id);
        } else {
            role = new Role();
        }
        
        mm.addAttribute("role", role);
    }
	
	// Form Save dan Edit Role
    @PostMapping("/form")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADD', 'ROLE_EDIT')")
    public String postForm(@ModelAttribute Role role) {
    	roleRepository.save(role);
        return "redirect:/role/list";
    }
    
    // Form Delete Role
    @GetMapping("/delete/")
//    @PreAuthorize("hasAuthority('ROLE_DELETE')")
    public String delete(@RequestParam String id) {
    	roleRepository.delete(id);
        return "redirect:/role/list";
    }
}
