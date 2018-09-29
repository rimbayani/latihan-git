package id.go.bssn.knowledgeManagement.repository;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import id.go.bssn.knowledgeManagement.domain.JadwalKegiatan;

public interface JadwalKegiatanRepository extends PagingAndSortingRepository<JadwalKegiatan, String> {
	
	//input[0] = "personilKegiatan";
	//input[1] = "provinsiKegiatan";
	//input[2] = "tanggalKegiatan";
	//searchBox[0] = "nomorKegiatan";
	//searchBox[1] = "namaKegiatan";
	//searchBox[2] = "fileKegiatan";
	//searchBox[3] = "penyelengaraKegiatan";
	//searchBox[4] = "tempatKegiatan";
	//searchBox[5] = "kabupatenKotaKegiatan";
	//searchBox[6] = "jenisKegiatan";
	public Page<JadwalKegiatan> findByNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLike(String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLike(String personilKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLike(String personilKegiatan, String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByProvinsiKegiatanLike(String provinsiKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByProvinsiKegiatanLikeOrNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLike(String provinsiKegiatan, String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByTanggalKegiatanBetween(Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLikeOrTanggalKegiatanBetween(String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrProvinsiKegiatanLike(String personilKegiatan, String provinsiKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrProvinsiKegiatanLikeOrNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLike(String personilKegiatan, String provinsiKegiatan, String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrTanggalKegiatanBetween(String personilKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLikeOrTanggalKegiatanBetween(String personilKegiatan, String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByProvinsiKegiatanLikeOrTanggalKegiatanBetween(String provinsiKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByProvinsiKegiatanLikeOrNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLikeOrTanggalKegiatanBetween(String provinsiKegiatan, String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrProvinsiKegiatanLikeOrTanggalKegiatanBetween(String personilKegiatan, String provinsiKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<JadwalKegiatan> findByPersonilKegiatanLikeOrProvinsiKegiatanLikeOrNomorKegiatanLikeOrNamaKegiatanLikeOrFileKegiatanLikeOrPenyelengaraKegiatanLikeOrTempatKegiatanLikeOrKabupatenKotaKegiatanLikeOrJenisKegiatanLikeOrTanggalKegiatanBetween(String personilKegiatan, String provinsiKegiatan, String nomorKegiatan, String namaKegiatan, String fileKegiatan, String penyelengaraKegiatan, String tempatKegiatan, String kabupatenKotaKegiatan, String jenisKegiatan, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);

	@Query("SELECT coalesce(max(jk.nomorKegiatan), 0) FROM JadwalKegiatan jk")
    public Integer findMaxNomorKegiatan();
}