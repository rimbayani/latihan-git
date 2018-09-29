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

import id.go.bssn.knowledgeManagement.domain.BerkasPribadi;
import id.go.bssn.knowledgeManagement.repository.BerkasPribadiRepository;

@Controller
@RequestMapping("/berkaspribadi")
public class BerkasPribadiController {
	
	//private final Logger log = LoggerFactory.getLogger(BerkasPribadiController.class);

	@Autowired
	private BerkasPribadiRepository berkasPribadiRepository;

	// From Tabel Berkas Pribadi
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('BERKASPRIBADI_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorBerkasPribadi"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		Page<BerkasPribadi> listBerkasPribadi = berkasPribadiRepository.findAll(pr);
		mm.addAttribute("listBerkasPribadi", listBerkasPribadi.getContent());
	}
	
	// From Add dan Edit Berkas Pribadi
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('BERKASPRIBADI_ADD', 'BERKASPRIBADI_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
		BerkasPribadi berkasPribadi;
        
        if(id != null) {
        	berkasPribadi = berkasPribadiRepository.findOne(id);
        } else {
        	berkasPribadi = new BerkasPribadi();
        }
        
        mm.addAttribute("berkasPribadi", berkasPribadi);
    }
	
	// Form Save dan Edit Berkas Pribadi
    @PostMapping("/form")
//    @PreAuthorize("hasAnyAuthority('BERKASPRIBADI_ADD', 'BERKASPRIBADI_EDIT')")
    public String postForm(@ModelAttribute BerkasPribadi berkasPribadi) {
    	berkasPribadiRepository.save(berkasPribadi);
        return "redirect:/berkaspribadi/list";
    }
    
    // Form Delete Berkas Pribadi
    @GetMapping("/delete/")
//    @PreAuthorize("hasAuthority('BERKASPRIBADI_DELETE')")
    public String delete(@RequestParam String id) {
    	berkasPribadiRepository.delete(id);
        return "redirect:/berkaspribadi/list";
    }
}
