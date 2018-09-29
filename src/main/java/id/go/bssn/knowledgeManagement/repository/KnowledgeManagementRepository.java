package id.go.bssn.knowledgeManagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.KnowledgeManagement;

public interface KnowledgeManagementRepository extends PagingAndSortingRepository<KnowledgeManagement, String>  {
	
	//searchBox[0] = "nomorKnowledgeManagement";
	//searchBox[1] = "namaKnowledgeManagement";
	//searchBox[2] = "deskripsiKnowledgeManagement";
	public Page<KnowledgeManagement> findByNomorKnowledgeManagementLikeOrNamaKnowledgeManagementLikeOrDeskripsiKnowledgeManagementLike(String nomorKnowledgeManagement, String namaKnowledgeManagement, String deskripsiKnowledgeManagement, Pageable pageable);

	@Query("SELECT coalesce(max(km.nomorKnowledgeManagement), 0) FROM KnowledgeManagement km")
    public Integer findMaxNomorKnowledgeManagement();
}
