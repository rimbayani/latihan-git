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
@Table(name = "t_jadwal_kegiatan")
public class JadwalKegiatan extends BaseEntity {
	
	@Getter	@Setter
	@Column(name = "nomor_kegiatan", length = 5)
	private Integer nomorKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_kegiatan", length = 150, nullable = false)
	private String namaKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "file_kegiatan", length = 75, nullable = false)
	private String fileKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "penyelengara_kegiatan", length = 100, nullable = false)
	private String penyelengaraKegiatan;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_kegiatan", nullable = false)
    private Date tanggalKegiatan = new Date();
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "personil_kegiatan", length = 100, nullable = false)
	private String personilKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "tempat_kegiatan", length = 100, nullable = false)
	private String tempatKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "kabupaten_kota_kegiatan", length = 100, nullable = false)
	private String kabupatenKotaKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "provinsi_kegiatan", length = 100, nullable = false)
	private String provinsiKegiatan;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "jenis_kegiatan", length = 100, nullable = false)
	private String jenisKegiatan;

}
