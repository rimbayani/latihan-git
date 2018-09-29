package id.go.bssn.knowledgeManagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.KnowledgeManagementDocument;

public interface KnowledgeManagementDocumentRepository extends PagingAndSortingRepository<KnowledgeManagementDocument, String>  {
	
	//searchBox[0] = "nomorKnowledgeManagementDocument";
	//searchBox[1] = "namaKnowledgeManagementDocument";
	//searchBox[2] = "jenisKnowledgeManagementDocument";
	//searchBox[3] = "deskripsiKnowledgeManagementDocument";
	public Page<KnowledgeManagementDocument> findByNomorKnowledgeManagementDocumentLikeOrNamaKnowledgeManagementDocumentLikeOrJenisKnowledgeManagementDocumentLikeOrDeskripsiKnowledgeManagementDocumentLike(String nomorKnowledgeManagementDocument, String namaKnowledgeManagementDocument, String jenisKnowledgeManagementDocument, String deskripsiKnowledgeManagementDocument, Pageable pageable);

	@Query("SELECT coalesce(max(kmd.nomorKnowledgeManagementDocument), 0) FROM KnowledgeManagementDocument kmd")
    public Integer findMaxNomorKnowledgeManagementDocument();
}
