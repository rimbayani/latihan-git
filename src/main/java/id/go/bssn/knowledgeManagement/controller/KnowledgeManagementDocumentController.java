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

import id.go.bssn.knowledgeManagement.domain.KnowledgeManagementDocument;
import id.go.bssn.knowledgeManagement.repository.KnowledgeManagementDocumentRepository;

@Controller
@RequestMapping("/knowledgemanagementdocument")
public class KnowledgeManagementDocumentController {
	
	//private final Logger log = LoggerFactory.getLogger(KnowledgeManagementDocumentController.class);

	@Autowired
	private KnowledgeManagementDocumentRepository knowledgeManagementDocumentRepository;

	// From Tabel Role
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('KNOWLEDGEMANAGEMENTDOCUMENT_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorKnowledgeManagementDocument"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		Page<KnowledgeManagementDocument> listKnowledgeManagementDocument = knowledgeManagementDocumentRepository.findAll(pr);
		mm.addAttribute("listKnowledgeManagementDocument", listKnowledgeManagementDocument.getContent());
	}
	
	// From Add dan Edit Role
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('KNOWLEDGEMANAGEMENTDOCUMENT_ADD', 'KNOWLEDGEMANAGEMENTDOCUMENT_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
		KnowledgeManagementDocument knowledgeManagementDocument;
        
        if(id != null) {
        	knowledgeManagementDocument = knowledgeManagementDocumentRepository.findOne(id);
        } else {
        	knowledgeManagementDocument = new KnowledgeManagementDocument();
        }
        
        mm.addAttribute("knowledgeManagementDocument", knowledgeManagementDocument);
    }
	
	// Form Save dan Edit Role
    @PostMapping("/form")
//  @PreAuthorize("hasAnyAuthority('KNOWLEDGEMANAGEMENTDOCUMENT_ADD', 'KNOWLEDGEMANAGEMENTDOCUMENT_EDIT')")
    public String postForm(@ModelAttribute KnowledgeManagementDocument knowledgeManagementDocument) {
    	knowledgeManagementDocumentRepository.save(knowledgeManagementDocument);
        return "redirect:/knowledgemanagementdocument/list";
    }
    
    // Form Delete Role
    @GetMapping("/delete/")
//  @PreAuthorize("hasAuthority('KNOWLEDGEMANAGEMENTDOCUMENT_DELETE')")
    public String delete(@RequestParam String id) {
    	knowledgeManagementDocumentRepository.delete(id);
        return "redirect:/knowledgemanagementdocument/list";
    }
}
