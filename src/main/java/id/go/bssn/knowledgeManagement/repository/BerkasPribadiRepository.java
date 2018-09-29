package id.go.bssn.knowledgeManagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import id.go.bssn.knowledgeManagement.domain.BerkasPribadi;

public interface BerkasPribadiRepository extends PagingAndSortingRepository<BerkasPribadi, String>  {
	
	//searchBox[0] = "nomorBerkasPribadi";
	//searchBox[1] = "namaBerkasPribadi";
	//searchBox[2] = "deskripsiBerkasPribadi";
	public Page<BerkasPribadi> findByNomorBerkasPribadiLikeOrNamaBerkasPribadiLikeOrDeskripsiBerkasPribadiLike(String nomorBerkasPribadi, String namaBerkasPribadi, String deskripsiBerkasPribadi, Pageable pageable);

	@Query("SELECT coalesce(max(bp.nomorBerkasPribadi), 0) FROM BerkasPribadi bp")
    public Integer findMaxNomorBerkasPribadi();
}
