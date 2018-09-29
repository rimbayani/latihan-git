package id.go.bssn.knowledgeManagement.repository;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.DownloadableContent;

public interface DownloadableContentRepository extends PagingAndSortingRepository<DownloadableContent, String>  {
	
	//input[0] = "lastUpdateDownloadableContent";
	//searchBox[0] = "nomorDownloadableContent";
	//searchBox[1] = "namaDownloadableContent";
	//searchBox[2] = "deskripsiDownloadableContent";
	public Page<DownloadableContent> findByNomorDownloadableContentLikeOrNamaDownloadableContentLikeOrDeskripsiDownloadableContentLike(String nomorDownloadableContent, String namaDownloadableContent, String deskripsiDownloadableContent, Pageable pageable);
	public Page<DownloadableContent> findByTanggalDownloadableContentBetween(Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<DownloadableContent> findByNomorDownloadableContentLikeOrNamaDownloadableContentLikeOrDeskripsiDownloadableContentLikeOrTanggalDownloadableContentBetween(String nomorDownloadableContent, String namaDownloadableContent, String deskripsiDownloadableContent, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);

	@Query("SELECT coalesce(max(dc.nomorDownloadableContent), 0) FROM DownloadableContent dc")
    public Integer findMaxNomorDownloadableContent();
}
