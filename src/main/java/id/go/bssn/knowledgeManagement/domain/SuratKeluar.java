package id.go.bssn.knowledgeManagement.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "t_suratkeluar")
public class SuratKeluar extends BaseEntity {
	
	@Getter	@Setter
	@Column(name = "nomor_surat_keluar", length = 5)
	private int nomorSuratKeluar;

	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "dari_surat_keluar", length = 50, unique = true)
	private String dariSuratKeluar;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "kepada_surat_keluar", length = 50, unique = true)
	private String kepadaSuratKeluar;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_surat_keluar", nullable = false)
    private Date tanggalSuratKeluar = new Date();

	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "perihal_surat_keluar", length = 255, unique = true)
	private String perihalSuratKeluar;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "jenis_surat_keluar", length = 100, nullable = false)
	private String jenisSuratKeluar;
	
}
