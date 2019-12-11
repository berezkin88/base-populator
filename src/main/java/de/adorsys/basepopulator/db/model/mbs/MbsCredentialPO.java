package de.adorsys.basepopulator.db.model.mbs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "credentials")
public class MbsCredentialPO {

    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private boolean masked;
    private boolean optional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isMasked() {
        return masked;
    }

    public void setMasked(boolean masked) {
        this.masked = masked;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MbsCredentialPO that = (MbsCredentialPO) o;
        return masked == that.masked &&
            optional == that.optional &&
            Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, masked, optional);
    }

    @Override
    public String toString() {
        return "MbsCredential{" +
            "label='" + label + '\'' +
            ", masked=" + masked +
            ", optional=" + optional +
            '}';
    }
}
