package de.adorsys.basepopulator.db.model;

import de.adorsys.basepopulator.db.model.mbs.LoginSettingsPO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mbs")
public class AspspMbsEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String bankCode;
    private String bic;
    private String aspspName;

    @OneToOne(cascade = CascadeType.ALL)
    private LoginSettingsPO loginSettings;
    private String bankApi;
    private Boolean redirectPreferred;
    private String bankingUrl;
    private String bankApiBankCode;

    @ElementCollection
    private List<String> searchIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBankingUrl() {
        return bankingUrl;
    }

    public void setBankingUrl(String bankingUrl) {
        this.bankingUrl = bankingUrl;
    }

    public String getAspspName() {
        return aspspName;
    }

    public void setAspspName(String aspspName) {
        this.aspspName = aspspName;
    }

    public LoginSettingsPO getLoginSettings() {
        return loginSettings;
    }

    public void setLoginSettings(LoginSettingsPO loginSettings) {
        this.loginSettings = loginSettings;
    }

    public String getBankApi() {
        return bankApi;
    }

    public void setBankApi(String bankApi) {
        this.bankApi = bankApi;
    }

    public Boolean getRedirectPreferred() {
        return redirectPreferred;
    }

    public void setRedirectPreferred(Boolean redirectPreferred) {
        this.redirectPreferred = redirectPreferred;
    }

    public String getBankApiBankCode() {
        return bankApiBankCode;
    }

    public void setBankApiBankCode(String bankApiBankCode) {
        this.bankApiBankCode = bankApiBankCode;
    }

    public List<String> getSearchIndex() {
        return searchIndex;
    }

    public void setSearchIndex(List<String> searchIndex) {
        this.searchIndex = searchIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AspspMbsEntity that = (AspspMbsEntity) o;
        return Objects.equals(id, that.id) &&
            bankCode.equals(that.bankCode) &&
            bic.equals(that.bic) &&
            aspspName.equals(that.aspspName) &&
            Objects.equals(loginSettings, that.loginSettings) &&
            Objects.equals(bankApi, that.bankApi) &&
            Objects.equals(redirectPreferred, that.redirectPreferred) &&
            Objects.equals(bankingUrl, that.bankingUrl) &&
            Objects.equals(bankApiBankCode, that.bankApiBankCode) &&
            Objects.equals(searchIndex, that.searchIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankCode, bic, aspspName, loginSettings, bankApi, redirectPreferred, bankingUrl, bankApiBankCode, searchIndex);
    }

    @Override
    public String toString() {
        return "AspspMbsEntity{" +
            "id=" + id +
            ", bankCode='" + bankCode + '\'' +
            ", bic='" + bic + '\'' +
            ", aspspName='" + aspspName + '\'' +
            ", loginSettings=" + loginSettings +
            ", bankApi='" + bankApi + '\'' +
            ", redirectPreferred=" + redirectPreferred +
            ", bankingUrl='" + bankingUrl + '\'' +
            ", bankApiBankCode='" + bankApiBankCode + '\'' +
            ", searchIndex=" + searchIndex +
            '}';
    }
}
