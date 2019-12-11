package de.adorsys.basepopulator.service.model.mbsmodel;

import java.util.Objects;

public class MbsCredential {

    private String label;
    private boolean masked;
    private boolean optional;

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
        MbsCredential that = (MbsCredential) o;
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
