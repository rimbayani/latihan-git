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

import id.go.bssn.knowledgeManagement.domain.JadwalKegiatan;
import id.go.bssn.knowledgeManagement.repository.JadwalKegiatanRepository;

@Controller
@RequestMapping("/jadwalkegiatan")
public class JadwalKegiatanController {
	
	//private final Logger log = LoggerFactory.getLogger(JadwalKegiatanController.class);

	@Autowired
	private JadwalKegiatanRepository jadwalKegiatanRepository;

	// From Tabel Role
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('JADWALKEGIATAN_LIST')")
	public void listUser(Pageable p, ModelMap mm){
		PageRequest pr;
		
		if (p.getSort() == null) {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), 
			     new Sort(Sort.Direction.ASC, "nomorJadwalKegiatan"));
		} else {
			pr = new PageRequest(p.getPageNumber(), p.getPageSize(), p.getSort());
		}
		
		Page<JadwalKegiatan> listJadwalKegiatan = jadwalKegiatanRepository.findAll(pr);
		mm.addAttribute("listJadwalKegiatan", listJadwalKegiatan.getContent());
	}
	
	// From Add dan Edit Role
	@GetMapping("/form")
//	@PreAuthorize("hasAnyAuthority('JADWALKEGIATAN_ADD', 'JADWALKEGIATAN_EDIT')")
    public void getForm(@RequestParam(required = false) String id, ModelMap mm) {
		JadwalKegiatan jadwalKegiatan;
        
        if(id != null) {
        	jadwalKegiatan = jadwalKegiatanRepository.findOne(id);
        } else {
        	jadwalKegiatan = new JadwalKegiatan();
        }
        
        mm.addAttribute("jadwalKegiatan", jadwalKegiatan);
    }
	
	// Form Save dan Edit Role
    @PostMapping("/form")
//  @PreAuthorize("hasAnyAuthority('JADWALKEGIATAN_ADD', 'JADWALKEGIATAN_EDIT')")
    public String postForm(@ModelAttribute JadwalKegiatan jadwalKegiatan) {
    	jadwalKegiatanRepository.save(jadwalKegiatan);
        return "redirect:/jadwalkegiatan/list";
    }
    
    // Form Delete Role
    @GetMapping("/delete/")
//  @PreAuthorize("hasAuthority('JADWALKEGIATAN_DELETE')")
    public String delete(@RequestParam String id) {
    	jadwalKegiatanRepository.delete(id);
        return "redirect:/jadwalkegiatan/list";
    }
}
