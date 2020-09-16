import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email1",
        "email2",
        "address1",
        "address2",
        "address3",
        "city",
        "stateName",
        "county",
        "country",
        "zip",
        "phone",
        "phoneExt",
        "pagerNumber",
        "fax1",
        "fax2",
        "isPrimary",
        "mobile",
        "emailFormat",
        "emergency",
        "twitterURL",
        "linkedInURL",
        "facebookURL",
        "googlePlusURL"
})
public class HomeAddress implements Serializable {

    @JsonProperty("email1")
    private Object email1;
    @JsonProperty("email2")
    private Object email2;
    @JsonProperty("address1")
    private Object address1;
    @JsonProperty("address2")
    private Object address2;
    @JsonProperty("address3")
    private Object address3;
    @JsonProperty("city")
    private Object city;
    @JsonProperty("stateName")
    private Object stateName;
    @JsonProperty("county")
    private Object county;
    @JsonProperty("country")
    private Object country;
    @JsonProperty("zip")
    private Object zip;
    @JsonProperty("phone")
    private Object phone;
    @JsonProperty("phoneExt")
    private Object phoneExt;
    @JsonProperty("pagerNumber")
    private Object pagerNumber;
    @JsonProperty("fax1")
    private Object fax1;
    @JsonProperty("fax2")
    private Object fax2;
    @JsonProperty("isPrimary")
    private Boolean isPrimary;
    @JsonProperty("mobile")
    private Object mobile;
    @JsonProperty("emailFormat")
    private Boolean emailFormat;
    @JsonProperty("emergency")
    private Object emergency;
    @JsonProperty("twitterURL")
    private Object twitterURL;
    @JsonProperty("linkedInURL")
    private Object linkedInURL;
    @JsonProperty("facebookURL")
    private Object facebookURL;
    @JsonProperty("googlePlusURL")
    private Object googlePlusURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8624147596258455778L;

    /**
     * No args constructor for use in serialization
     */
    public HomeAddress() {
    }

    /**
     * @param zip
     * @param country
     * @param phoneExt
     * @param linkedInURL
     * @param address3
     * @param address2
     * @param city
     * @param address1
     * @param twitterURL
     * @param county
     * @param mobile
     * @param pagerNumber
     * @param emergency
     * @param email2
     * @param email1
     * @param facebookURL
     * @param googlePlusURL
     * @param stateName
     * @param phone
     * @param isPrimary
     * @param fax2
     * @param fax1
     * @param emailFormat
     */
    public HomeAddress(Object email1, Object email2, Object address1, Object address2, Object address3, Object city, Object stateName, Object county, Object country, Object zip, Object phone, Object phoneExt, Object pagerNumber, Object fax1, Object fax2, Boolean isPrimary, Object mobile, Boolean emailFormat, Object emergency, Object twitterURL, Object linkedInURL, Object facebookURL, Object googlePlusURL) {
        super();
        this.email1 = email1;
        this.email2 = email2;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.stateName = stateName;
        this.county = county;
        this.country = country;
        this.zip = zip;
        this.phone = phone;
        this.phoneExt = phoneExt;
        this.pagerNumber = pagerNumber;
        this.fax1 = fax1;
        this.fax2 = fax2;
        this.isPrimary = isPrimary;
        this.mobile = mobile;
        this.emailFormat = emailFormat;
        this.emergency = emergency;
        this.twitterURL = twitterURL;
        this.linkedInURL = linkedInURL;
        this.facebookURL = facebookURL;
        this.googlePlusURL = googlePlusURL;
    }

    @JsonProperty("email1")
    public Object getEmail1() {
        return email1;
    }

    @JsonProperty("email1")
    public void setEmail1(Object email1) {
        this.email1 = email1;
    }

    @JsonProperty("email2")
    public Object getEmail2() {
        return email2;
    }

    @JsonProperty("email2")
    public void setEmail2(Object email2) {
        this.email2 = email2;
    }

    @JsonProperty("address1")
    public Object getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(Object address1) {
        this.address1 = address1;
    }

    @JsonProperty("address2")
    public Object getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    @JsonProperty("address3")
    public Object getAddress3() {
        return address3;
    }

    @JsonProperty("address3")
    public void setAddress3(Object address3) {
        this.address3 = address3;
    }

    @JsonProperty("city")
    public Object getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(Object city) {
        this.city = city;
    }

    @JsonProperty("stateName")
    public Object getStateName() {
        return stateName;
    }

    @JsonProperty("stateName")
    public void setStateName(Object stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("county")
    public Object getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(Object county) {
        this.county = county;
    }

    @JsonProperty("country")
    public Object getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(Object country) {
        this.country = country;
    }

    @JsonProperty("zip")
    public Object getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(Object zip) {
        this.zip = zip;
    }

    @JsonProperty("phone")
    public Object getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    @JsonProperty("phoneExt")
    public Object getPhoneExt() {
        return phoneExt;
    }

    @JsonProperty("phoneExt")
    public void setPhoneExt(Object phoneExt) {
        this.phoneExt = phoneExt;
    }

    @JsonProperty("pagerNumber")
    public Object getPagerNumber() {
        return pagerNumber;
    }

    @JsonProperty("pagerNumber")
    public void setPagerNumber(Object pagerNumber) {
        this.pagerNumber = pagerNumber;
    }

    @JsonProperty("fax1")
    public Object getFax1() {
        return fax1;
    }

    @JsonProperty("fax1")
    public void setFax1(Object fax1) {
        this.fax1 = fax1;
    }

    @JsonProperty("fax2")
    public Object getFax2() {
        return fax2;
    }

    @JsonProperty("fax2")
    public void setFax2(Object fax2) {
        this.fax2 = fax2;
    }

    @JsonProperty("isPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("isPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    @JsonProperty("mobile")
    public Object getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("emailFormat")
    public Boolean getEmailFormat() {
        return emailFormat;
    }

    @JsonProperty("emailFormat")
    public void setEmailFormat(Boolean emailFormat) {
        this.emailFormat = emailFormat;
    }

    @JsonProperty("emergency")
    public Object getEmergency() {
        return emergency;
    }

    @JsonProperty("emergency")
    public void setEmergency(Object emergency) {
        this.emergency = emergency;
    }

    @JsonProperty("twitterURL")
    public Object getTwitterURL() {
        return twitterURL;
    }

    @JsonProperty("twitterURL")
    public void setTwitterURL(Object twitterURL) {
        this.twitterURL = twitterURL;
    }

    @JsonProperty("linkedInURL")
    public Object getLinkedInURL() {
        return linkedInURL;
    }

    @JsonProperty("linkedInURL")
    public void setLinkedInURL(Object linkedInURL) {
        this.linkedInURL = linkedInURL;
    }

    @JsonProperty("facebookURL")
    public Object getFacebookURL() {
        return facebookURL;
    }

    @JsonProperty("facebookURL")
    public void setFacebookURL(Object facebookURL) {
        this.facebookURL = facebookURL;
    }

    @JsonProperty("googlePlusURL")
    public Object getGooglePlusURL() {
        return googlePlusURL;
    }

    @JsonProperty("googlePlusURL")
    public void setGooglePlusURL(Object googlePlusURL) {
        this.googlePlusURL = googlePlusURL;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
