package de.adorsys.basepopulator.service.model.mbsmodel;

import java.util.List;
import java.util.Objects;

public class LoginSettings {

    private String icon;
    private String additional_icons;
    private List<MbsCredential> credentials;
    private String advice;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAdditional_icons() {
        return additional_icons;
    }

    public void setAdditional_icons(String additional_icons) {
        this.additional_icons = additional_icons;
    }

    public List<MbsCredential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<MbsCredential> credentials) {
        this.credentials = credentials;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginSettings that = (LoginSettings) o;
        return Objects.equals(icon, that.icon) &&
            Objects.equals(additional_icons, that.additional_icons) &&
            Objects.equals(credentials, that.credentials) &&
            Objects.equals(advice, that.advice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icon, additional_icons, credentials, advice);
    }

    @Override
    public String
    toString() {
        return "LogginSettings{" +
            "icon='" + icon + '\'' +
            ", additionalIcons='" + additional_icons + '\'' +
            ", credentials=" + credentials +
            ", advice='" + advice + '\'' +
            '}';
    }
}
