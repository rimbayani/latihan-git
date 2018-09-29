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
@Table(name = "t_suratmasuk")
public class SuratMasuk extends BaseEntity {
	
	@Getter	@Setter
	@Column(name = "nomor_surat_masuk", length = 5)
	private int nomorSuratMasuk;

	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "dari_surat_masuk", length = 50, unique = true)
	private String dariSuratMasuk;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "kepada_surat_masuk", length = 50, unique = true)
	private String kepadaSuratMasuk;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_surat_masuk", nullable = false)
    private Date tanggalSuratMasuk = new Date();

	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "perihal_surat_masuk", length = 255, unique = true)
	private String perihalSuratMasuk;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "jenis_surat_masuk", length = 100, nullable = false)
	private String jenisSuratMasuk;

}
