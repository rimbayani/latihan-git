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

import id.go.bssn.knowledgeManagement.domain.DownloadableContent;
import id.go.bssn.knowledgeManagement.repository.DownloadableContentRepository;

@Controller
@RequestMapping("/downloadablecontent")
public class DownloadableContentController {
	
	//private final Logger log = LoggerFactory.getLogger(DownloadableContentController.class);

	@Autowired
	private DownloadableContentRepository downloadableContentRepository;

	// From Tabel Downloadable Content
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('DOWNLOADABLECONTENT_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorDownloadableContent"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		Page<DownloadableContent> listDownloadableContent = downloadableContentRepository.findAll(pr);
		mm.addAttribute("listDownloadableContent", listDownloadableContent.getContent());
	}
	
	// From Add dan Edit Downloadable Content
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('DOWNLOADABLECONTENT_ADD', 'DOWNLOADABLECONTENT_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
		DownloadableContent downloadableContent;
        
        if(id != null) {
        	downloadableContent = downloadableContentRepository.findOne(id);
        } else {
        	downloadableContent = new DownloadableContent();
        }
        
        mm.addAttribute("downloadableContent", downloadableContent);
    }
	
	// Form Save dan Edit Downloadable Content
    @PostMapping("/form")
//    @PreAuthorize("hasAnyAuthority('DOWNLOADABLECONTENT_ADD', 'DOWNLOADABLECONTENT_EDIT')")
    public String postForm(@ModelAttribute DownloadableContent downloadableContent) {
    	downloadableContentRepository.save(downloadableContent);
        return "redirect:/downloadablecontent/list";
    }
    
    // Form Delete Downloadable Content
    @GetMapping("/delete/")
//    @PreAuthorize("hasAuthority('DOWNLOADABLECONTENT_DELETE')")
    public String delete(@RequestParam String id) {
    	downloadableContentRepository.delete(id);
        return "redirect:/downloadablecontent/list";
    }
}
