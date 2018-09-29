package id.go.bssn.knowledgeManagement.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import id.go.bssn.knowledgeManagement.domain.SuratKeluar;

public interface SuratKeluarRepository extends PagingAndSortingRepository<SuratKeluar, String> {
	
	public Page<SuratKeluar> findByNomorSuratKeluarLikeOrDariSuratKeluarLikeOrKepadaSuratKeluarLikeOrPerihalSuratKeluarLikeOrJenisSuratKeluarLike(String nomorSuratKeluar, String dariSuratKeluar, String kepadaSuratKeluar, String perihalSuratKeluar, String jenisSuratKeluar, Pageable pageable);
	public Page<SuratKeluar> findByTanggalSuratKeluarBetween(Date tanggalAwal, Date tanggalAkhir, Pageable pageable);
	public Page<SuratKeluar> findByNomorSuratKeluarLikeOrDariSuratKeluarLikeOrKepadaSuratKeluarLikeOrPerihalSuratKeluarLikeOrJenisSuratKeluarLikeOrTanggalSuratKeluarBetween(String nomorSuratKeluar, String dariSuratKeluar, String kepadaSuratKeluar, String perihalSuratKeluar, String jenisSuratKeluar, Date tanggalAwal, Date tanggalAkhir, Pageable pageable);

	@Query("SELECT coalesce(max(sklr.nomorSuratKeluar), 0) FROM SuratKeluar sklr")
    public Integer findMaxNomorSuratKeluar();
}
