package id.go.bssn.knowledgeManagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, String>   {

	//searchBox[0] = "nomorRole";
	//searchBox[1] = "namaRole";
	//searchBox[2] = "deskripsiRole";
	public Page<Role> findByNomorRoleLikeOrNamaRoleLikeOrDeskripsiRoleLike(String nomorRole, String namaRole, String deskripsiRole, Pageable pageable);
	
	@Query("SELECT coalesce(max(r.nomorRole), 0) FROM Role r")
    public Integer findMaxNomorRole();
}
