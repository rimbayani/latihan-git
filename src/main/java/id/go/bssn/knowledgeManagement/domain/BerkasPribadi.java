package id.go.bssn.knowledgeManagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "t_berkas_pribadi")
public class BerkasPribadi extends BaseEntity {
	@Getter	@Setter
	@Column(name = "nomor_berkas_pribadi", length = 5)
	private int nomorBerkasPribadi;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_berkas_pribadi", length = 50, unique = true)
	private String namaBerkasPribadi;
	
	@Getter	@Setter
	@Column(name = "deskripsi_berkas_pribadi", length = 100)
	private String deskripsiBerkasPribadi;
}
