package de.adorsys.basepopulator.db.model.mbs;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "loginsettings")
public class LoginSettingsPO {

    @Id
    @GeneratedValue
    private Long id;
    private String icon;
    private String additionalIcons;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MbsCredentialPO> credentials;
    @Column(length = 1024)
    private String advice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAdditionalIcons() {
        return additionalIcons;
    }

    public void setAdditionalIcons(String additionalIcons) {
        this.additionalIcons = additionalIcons;
    }

    public List<MbsCredentialPO> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<MbsCredentialPO> credentials) {
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
        LoginSettingsPO that = (LoginSettingsPO) o;
        return Objects.equals(icon, that.icon) &&
            Objects.equals(additionalIcons, that.additionalIcons) &&
            Objects.equals(credentials, that.credentials) &&
            Objects.equals(advice, that.advice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icon, additionalIcons, credentials, advice);
    }

    @Override
    public String
    toString() {
        return "LogginSettings{" +
            "icon='" + icon + '\'' +
            ", additionalIcons='" + additionalIcons + '\'' +
            ", credentials=" + credentials +
            ", advice='" + advice + '\'' +
            '}';
    }
}
