package com.example.uniappdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UniPojo {


    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("web_pages")
    @Expose
    private List<String> webPages = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alpha_two_code")
    @Expose
    private String alphaTwoCode;
    @SerializedName("state-province")
    @Expose
    private Object stateProvince;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("country")
    @Expose
    private String country;

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<String> webPages) {
        this.webPages = webPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public Object getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(Object stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
