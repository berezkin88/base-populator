package de.adorsys.basepopulator.service.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.adorsys.basepopulator.service.model.mbsmodel.LoginSettings;

import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"bankCode", "bic", "name", "loginSettings", "bankApi", "bankingUrl", "redirectPreferred", "bankApiBankCode", "searchIndex"})
public class AspspMbs {
    private String bankCode;
    private String bic;
    private String name;
    private LoginSettings loginSettings;
    private String bankApi;
    private String bankingUrl;
    private Boolean redirectPreferred;
    private String bankApiBankCode;
    private List<String> searchIndex;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginSettings getLoginSettings() {
        return loginSettings;
    }

    public void setLoginSettings(LoginSettings loginSettings) {
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
        AspspMbs aspspMbs = (AspspMbs) o;
        return bankCode.equals(aspspMbs.bankCode) &&
            bic.equals(aspspMbs.bic) &&
            name.equals(aspspMbs.name) &&
            Objects.equals(loginSettings, aspspMbs.loginSettings) &&
            Objects.equals(bankApi, aspspMbs.bankApi) &&
            Objects.equals(bankingUrl, aspspMbs.bankingUrl) &&
            Objects.equals(redirectPreferred, aspspMbs.redirectPreferred) &&
            Objects.equals(bankApiBankCode, aspspMbs.bankApiBankCode) &&
            Objects.equals(searchIndex, aspspMbs.searchIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankCode, bic, name, loginSettings, bankApi, bankingUrl, redirectPreferred, bankApiBankCode, searchIndex);
    }

    @Override
    public String toString() {
        return "AspspMbs{" +
            "bankCode='" + bankCode + '\'' +
            ", bic='" + bic + '\'' +
            ", name='" + name + '\'' +
            ", loginSettings=" + loginSettings +
            ", bankApi='" + bankApi + '\'' +
            ", bankingUrl='" + bankingUrl + '\'' +
            ", redirectPreferred=" + redirectPreferred +
            ", bankApiBankCode='" + bankApiBankCode + '\'' +
            ", searchIndex=" + searchIndex +
            '}';
    }
}
