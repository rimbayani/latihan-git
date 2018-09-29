package id.go.bssn.knowledgeManagement.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "c_role")
public class Role extends BaseEntity {

	@Getter	@Setter
	@Column(name = "nomor_role", length = 5)
	private int nomorRole;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_role", length = 40, unique = true)
	private String namaRole;
	
	@Getter	@Setter
	@Column(name = "deskripsi_role", length = 100)
	private String deskripsiRole;
	
	@Getter @Setter
	@ManyToMany
	@JoinTable(
			name = "c_role_permission",
			joinColumns = @JoinColumn(name = "id_role", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "id_permission", nullable = false)
			)
	// Set Mirip Dengan List, Namun Set TIDAK Boleh ada Data yang Sama
	private Set<Permission> permissionSet = new HashSet<>();
	//private List<Permission> permissionList = new ArrayList();
	
}
