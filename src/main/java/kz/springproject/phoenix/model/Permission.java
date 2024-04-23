package kz.springproject.phoenix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_permissions")
@Data
public class Permission extends AbstractEntity implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
