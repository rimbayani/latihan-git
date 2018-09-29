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
@Table(name = "c_permission")
public class Permission extends BaseEntity{
	
	@Getter	@Setter
	@Column(name = "nomor_permission", length = 5)
	private int nomorPermission;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_permission", length = 100, unique = true, nullable = false)
	private String namaPermission;
	
	@Getter @Setter
	@Column(name = "deskripsi_permission", length = 100)
	private String deskripsiPermission;

}
