package id.go.bssn.knowledgeManagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	
	//searchBox[0] = "nomorUser";
	//searchBox[1] = "usernameUser";
	//searchBox[2] = "namaUser";
	//searchBox[3] = "nipUser";
	//searchBox[4] = "pangkatGolonganUser";
	//searchBox[5] = "jabatanUser";
	//searchBox[6] = "unitKerjaUser";
	//searchBox[7] = "instansiUser";
	//searchBox[8] = "emailUser";
	public Page<User> findByNomorUserLikeOrUsernameUserLikeOrNamaUserLikeOrNipUserLikeOrPangkatGolonganUserLikeOrJabatanUserLikeOrUnitKerjaUserLikeOrInstansiUserLikeOrEmailUserLike(String nomorUser, String usernameUser, String namaUser, String nipUser, String pangkatGolonganUser, String jabatanUser, String unitKerjaUser, String instansiUser, String emailUser, Pageable pageable);

	@Query("SELECT coalesce(max(u.nomorUser), 0) FROM User u")
    public Integer findMaxNomorUser();
}