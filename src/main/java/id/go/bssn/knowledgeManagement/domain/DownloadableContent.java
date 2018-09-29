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
@Table(name = "t_donwloadable_content")
public class DownloadableContent extends BaseEntity {
    
	@Getter	@Setter
	@Column(name = "nomor_donwloadable_content", length = 5)
	private int nomorDownloadableContent;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_donwloadable_content", length = 40, unique = true)
	private String namaDownloadableContent;
	
	@Getter	@Setter
	@Column(name = "deskripsi_donwloadable_content", length = 100)
	private String deskripsiDownloadableContent;
    
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_donwloadable_content", nullable = false)
    private Date tanggalDownloadableContent = new Date();

}
