package id.go.bssn.knowledgeManagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.Permission;

public interface PermissionRepository extends PagingAndSortingRepository<Permission, String>  {
	
	//searchBox[0] = "nomorPermission";
	//searchBox[1] = "namaPermission";
	//searchBox[2] = "deskripsiPermission";
	public Page<Permission> findByNomorPermissionLikeOrNamaPermissionLikeOrDeskripsiPermissionLike(String nomorPermission, String namaPermission, String deskripsiPermission, Pageable pageable);

	@Query("SELECT coalesce(max(p.nomorPermission), 0) FROM Permission p")
    public Integer findMaxNomorPermission();
}
