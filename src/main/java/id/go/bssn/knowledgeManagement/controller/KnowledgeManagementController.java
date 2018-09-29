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

import id.go.bssn.knowledgeManagement.domain.KnowledgeManagement;
import id.go.bssn.knowledgeManagement.repository.KnowledgeManagementRepository;

@Controller
@RequestMapping("/knowledgemanagement")
public class KnowledgeManagementController {
	
	//private final Logger log = LoggerFactory.getLogger(KnowledgeManagementController.class);

	@Autowired
	private KnowledgeManagementRepository knowledgeManagementRepository;

	// From Tabel Role
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('KNOWLEDGEMANAGEMENT_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorKnowledgeManagement"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		Page<KnowledgeManagement> listKnowledgeManagement = knowledgeManagementRepository.findAll(pr);
		mm.addAttribute("listKnowledgeManagement", listKnowledgeManagement.getContent());
	}
	
	// From Add dan Edit Role
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('KNOWLEDGEMANAGEMENT_ADD', 'KNOWLEDGEMANAGEMENT_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
		KnowledgeManagement knowledgeManagement;
        
        if(id != null) {
        	knowledgeManagement = knowledgeManagementRepository.findOne(id);
        } else {
        	knowledgeManagement = new KnowledgeManagement();
        }
        
        mm.addAttribute("knowledgeManagement", knowledgeManagement);
    }
	
	// Form Save dan Edit Role
    @PostMapping("/form")
//  @PreAuthorize("hasAnyAuthority('KNOWLEDGEMANAGEMENT_ADD', 'KNOWLEDGEMANAGEMENT_EDIT')")
    public String postForm(@ModelAttribute KnowledgeManagement knowledgeManagement) {
    	knowledgeManagementRepository.save(knowledgeManagement);
        return "redirect:/knowledgemanagement/list";
    }
    
    // Form Delete Role
    @GetMapping("/delete/")
//  @PreAuthorize("hasAuthority('KNOWLEDGEMANAGEMENT_DELETE')")
    public String delete(@RequestParam String id) {
    	knowledgeManagementRepository.delete(id);
        return "redirect:/knowledgemanagement/list";
    }
}
