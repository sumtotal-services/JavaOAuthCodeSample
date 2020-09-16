import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "personId",
        "active",
        "firstName",
        "middleName",
        "lastName",
        "fullName",
        "firstNameNative",
        "lastNameNative",
        "friendlyName",
        "timezoneId",
        "languageId",
        "currencyId",
        "ethnicityCode",
        "genderCode",
        "startDate",
        "endDate",
        "lastReviewDate",
        "companyCode",
        "companyName",
        "statusCode",
        "typeCode",
        "birthDate",
        "prefixCode",
        "prefixText",
        "suffixCode",
        "suffixText",
        "noteText",
        "imagePath",
        "govtId",
        "personDescription",
        "url",
        "publishCalendar",
        "internalInd",
        "deleted",
        "welcomeEmailEnabled",
        "homeAddress",
        "businessAddress",
        "personDomain",
        "personOrganization",
        "personJob",
        "personRelation",
        "personELM",
        "personOptional",
        "personMobileUser",
        "userLogin",
        "userLoginProfile",
        "personTM"
})
public class UserGetObject implements Serializable
{

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("personId")
    private Integer personId;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private Object middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("firstNameNative")
    private Object firstNameNative;
    @JsonProperty("lastNameNative")
    private Object lastNameNative;
    @JsonProperty("friendlyName")
    private Object friendlyName;
    @JsonProperty("timezoneId")
    private Integer timezoneId;
    @JsonProperty("languageId")
    private Integer languageId;
    @JsonProperty("currencyId")
    private Integer currencyId;
    @JsonProperty("ethnicityCode")
    private Object ethnicityCode;
    @JsonProperty("genderCode")
    private Object genderCode;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private Object endDate;
    @JsonProperty("lastReviewDate")
    private Object lastReviewDate;
    @JsonProperty("companyCode")
    private Object companyCode;
    @JsonProperty("companyName")
    private Object companyName;
    @JsonProperty("statusCode")
    private Object statusCode;
    @JsonProperty("typeCode")
    private Object typeCode;
    @JsonProperty("birthDate")
    private Object birthDate;
    @JsonProperty("prefixCode")
    private Object prefixCode;
    @JsonProperty("prefixText")
    private Object prefixText;
    @JsonProperty("suffixCode")
    private Object suffixCode;
    @JsonProperty("suffixText")
    private Object suffixText;
    @JsonProperty("noteText")
    private Object noteText;
    @JsonProperty("imagePath")
    private Object imagePath;
    @JsonProperty("govtId")
    private Object govtId;
    @JsonProperty("personDescription")
    private Object personDescription;
    @JsonProperty("url")
    private Object url;
    @JsonProperty("publishCalendar")
    private Boolean publishCalendar;
    @JsonProperty("internalInd")
    private Boolean internalInd;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("welcomeEmailEnabled")
    private Object welcomeEmailEnabled;
    @JsonProperty("homeAddress")
    private HomeAddress homeAddress;
    @JsonProperty("businessAddress")
    private BusinessAddress businessAddress;
    @JsonProperty("personDomain")
    private List<PersonDomain> personDomain = null;
    @JsonProperty("personOrganization")
    private List<Object> personOrganization = null;
    @JsonProperty("personJob")
    private List<Object> personJob = null;
    @JsonProperty("personRelation")
    private PersonRelation personRelation;
    @JsonProperty("personELM")
    private PersonELM personELM;
    @JsonProperty("personOptional")
    private PersonOptional personOptional;
    @JsonProperty("personMobileUser")
    private PersonMobileUser personMobileUser;
    @JsonProperty("userLogin")
    private UserLogin userLogin;
    @JsonProperty("userLoginProfile")
    private List<Object> userLoginProfile = null;
    @JsonProperty("personTM")
    private PersonTM personTM;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -230477272536782670L;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserGetObject() {
    }

    /**
     *
     * @param lastName
     * @param noteText
     * @param welcomeEmailEnabled
     * @param prefixText
     * @param firstNameNative
     * @param endDate
     * @param imagePath
     * @param companyName
     * @param prefixCode
     * @param userLoginProfile
     * @param personELM
     * @param personOrganization
     * @param internalInd
     * @param currencyId
     * @param businessAddress
     * @param friendlyName
     * @param personDescription
     * @param homeAddress
     * @param companyCode
     * @param personOptional
     * @param personTM
     * @param lastNameNative
     * @param languageId
     * @param active
     * @param fullName
     * @param publishCalendar
     * @param userId
     * @param birthDate
     * @param url
     * @param personRelation
     * @param typeCode
     * @param userLogin
     * @param firstName
     * @param genderCode
     * @param personJob
     * @param deleted
     * @param personDomain
     * @param lastReviewDate
     * @param personMobileUser
     * @param govtId
     * @param timezoneId
     * @param suffixText
     * @param personId
     * @param middleName
     * @param ethnicityCode
     * @param startDate
     * @param suffixCode
     * @param statusCode
     */
    public UserGetObject(String userId, Integer personId, Boolean active, String firstName, Object middleName, String lastName, String fullName, Object firstNameNative, Object lastNameNative, Object friendlyName, Integer timezoneId, Integer languageId, Integer currencyId, Object ethnicityCode, Object genderCode, String startDate, Object endDate, Object lastReviewDate, Object companyCode, Object companyName, Object statusCode, Object typeCode, Object birthDate, Object prefixCode, Object prefixText, Object suffixCode, Object suffixText, Object noteText, Object imagePath, Object govtId, Object personDescription, Object url, Boolean publishCalendar, Boolean internalInd, Boolean deleted, Object welcomeEmailEnabled, HomeAddress homeAddress, BusinessAddress businessAddress, List<PersonDomain> personDomain, List<Object> personOrganization, List<Object> personJob, PersonRelation personRelation, PersonELM personELM, PersonOptional personOptional, PersonMobileUser personMobileUser, UserLogin userLogin, List<Object> userLoginProfile, PersonTM personTM) {
        super();
        this.userId = userId;
        this.personId = personId;
        this.active = active;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.firstNameNative = firstNameNative;
        this.lastNameNative = lastNameNative;
        this.friendlyName = friendlyName;
        this.timezoneId = timezoneId;
        this.languageId = languageId;
        this.currencyId = currencyId;
        this.ethnicityCode = ethnicityCode;
        this.genderCode = genderCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastReviewDate = lastReviewDate;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.statusCode = statusCode;
        this.typeCode = typeCode;
        this.birthDate = birthDate;
        this.prefixCode = prefixCode;
        this.prefixText = prefixText;
        this.suffixCode = suffixCode;
        this.suffixText = suffixText;
        this.noteText = noteText;
        this.imagePath = imagePath;
        this.govtId = govtId;
        this.personDescription = personDescription;
        this.url = url;
        this.publishCalendar = publishCalendar;
        this.internalInd = internalInd;
        this.deleted = deleted;
        this.welcomeEmailEnabled = welcomeEmailEnabled;
        this.homeAddress = homeAddress;
        this.businessAddress = businessAddress;
        this.personDomain = personDomain;
        this.personOrganization = personOrganization;
        this.personJob = personJob;
        this.personRelation = personRelation;
        this.personELM = personELM;
        this.personOptional = personOptional;
        this.personMobileUser = personMobileUser;
        this.userLogin = userLogin;
        this.userLoginProfile = userLoginProfile;
        this.personTM = personTM;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("personId")
    public Integer getPersonId() {
        return personId;
    }

    @JsonProperty("personId")
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public Object getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("firstNameNative")
    public Object getFirstNameNative() {
        return firstNameNative;
    }

    @JsonProperty("firstNameNative")
    public void setFirstNameNative(Object firstNameNative) {
        this.firstNameNative = firstNameNative;
    }

    @JsonProperty("lastNameNative")
    public Object getLastNameNative() {
        return lastNameNative;
    }

    @JsonProperty("lastNameNative")
    public void setLastNameNative(Object lastNameNative) {
        this.lastNameNative = lastNameNative;
    }

    @JsonProperty("friendlyName")
    public Object getFriendlyName() {
        return friendlyName;
    }

    @JsonProperty("friendlyName")
    public void setFriendlyName(Object friendlyName) {
        this.friendlyName = friendlyName;
    }

    @JsonProperty("timezoneId")
    public Integer getTimezoneId() {
        return timezoneId;
    }

    @JsonProperty("timezoneId")
    public void setTimezoneId(Integer timezoneId) {
        this.timezoneId = timezoneId;
    }

    @JsonProperty("languageId")
    public Integer getLanguageId() {
        return languageId;
    }

    @JsonProperty("languageId")
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    @JsonProperty("currencyId")
    public Integer getCurrencyId() {
        return currencyId;
    }

    @JsonProperty("currencyId")
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @JsonProperty("ethnicityCode")
    public Object getEthnicityCode() {
        return ethnicityCode;
    }

    @JsonProperty("ethnicityCode")
    public void setEthnicityCode(Object ethnicityCode) {
        this.ethnicityCode = ethnicityCode;
    }

    @JsonProperty("genderCode")
    public Object getGenderCode() {
        return genderCode;
    }

    @JsonProperty("genderCode")
    public void setGenderCode(Object genderCode) {
        this.genderCode = genderCode;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public Object getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("lastReviewDate")
    public Object getLastReviewDate() {
        return lastReviewDate;
    }

    @JsonProperty("lastReviewDate")
    public void setLastReviewDate(Object lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    @JsonProperty("companyCode")
    public Object getCompanyCode() {
        return companyCode;
    }

    @JsonProperty("companyCode")
    public void setCompanyCode(Object companyCode) {
        this.companyCode = companyCode;
    }

    @JsonProperty("companyName")
    public Object getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("statusCode")
    public Object getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(Object statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("typeCode")
    public Object getTypeCode() {
        return typeCode;
    }

    @JsonProperty("typeCode")
    public void setTypeCode(Object typeCode) {
        this.typeCode = typeCode;
    }

    @JsonProperty("birthDate")
    public Object getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("prefixCode")
    public Object getPrefixCode() {
        return prefixCode;
    }

    @JsonProperty("prefixCode")
    public void setPrefixCode(Object prefixCode) {
        this.prefixCode = prefixCode;
    }

    @JsonProperty("prefixText")
    public Object getPrefixText() {
        return prefixText;
    }

    @JsonProperty("prefixText")
    public void setPrefixText(Object prefixText) {
        this.prefixText = prefixText;
    }

    @JsonProperty("suffixCode")
    public Object getSuffixCode() {
        return suffixCode;
    }

    @JsonProperty("suffixCode")
    public void setSuffixCode(Object suffixCode) {
        this.suffixCode = suffixCode;
    }

    @JsonProperty("suffixText")
    public Object getSuffixText() {
        return suffixText;
    }

    @JsonProperty("suffixText")
    public void setSuffixText(Object suffixText) {
        this.suffixText = suffixText;
    }

    @JsonProperty("noteText")
    public Object getNoteText() {
        return noteText;
    }

    @JsonProperty("noteText")
    public void setNoteText(Object noteText) {
        this.noteText = noteText;
    }

    @JsonProperty("imagePath")
    public Object getImagePath() {
        return imagePath;
    }

    @JsonProperty("imagePath")
    public void setImagePath(Object imagePath) {
        this.imagePath = imagePath;
    }

    @JsonProperty("govtId")
    public Object getGovtId() {
        return govtId;
    }

    @JsonProperty("govtId")
    public void setGovtId(Object govtId) {
        this.govtId = govtId;
    }

    @JsonProperty("personDescription")
    public Object getPersonDescription() {
        return personDescription;
    }

    @JsonProperty("personDescription")
    public void setPersonDescription(Object personDescription) {
        this.personDescription = personDescription;
    }

    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

    @JsonProperty("publishCalendar")
    public Boolean getPublishCalendar() {
        return publishCalendar;
    }

    @JsonProperty("publishCalendar")
    public void setPublishCalendar(Boolean publishCalendar) {
        this.publishCalendar = publishCalendar;
    }

    @JsonProperty("internalInd")
    public Boolean getInternalInd() {
        return internalInd;
    }

    @JsonProperty("internalInd")
    public void setInternalInd(Boolean internalInd) {
        this.internalInd = internalInd;
    }

    @JsonProperty("deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("welcomeEmailEnabled")
    public Object getWelcomeEmailEnabled() {
        return welcomeEmailEnabled;
    }

    @JsonProperty("welcomeEmailEnabled")
    public void setWelcomeEmailEnabled(Object welcomeEmailEnabled) {
        this.welcomeEmailEnabled = welcomeEmailEnabled;
    }

    @JsonProperty("homeAddress")
    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    @JsonProperty("homeAddress")
    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    @JsonProperty("businessAddress")
    public BusinessAddress getBusinessAddress() {
        return businessAddress;
    }

    @JsonProperty("businessAddress")
    public void setBusinessAddress(BusinessAddress businessAddress) {
        this.businessAddress = businessAddress;
    }

    @JsonProperty("personDomain")
    public List<PersonDomain> getPersonDomain() {
        return personDomain;
    }

    @JsonProperty("personDomain")
    public void setPersonDomain(List<PersonDomain> personDomain) {
        this.personDomain = personDomain;
    }

    @JsonProperty("personOrganization")
    public List<Object> getPersonOrganization() {
        return personOrganization;
    }

    @JsonProperty("personOrganization")
    public void setPersonOrganization(List<Object> personOrganization) {
        this.personOrganization = personOrganization;
    }

    @JsonProperty("personJob")
    public List<Object> getPersonJob() {
        return personJob;
    }

    @JsonProperty("personJob")
    public void setPersonJob(List<Object> personJob) {
        this.personJob = personJob;
    }

    @JsonProperty("personRelation")
    public PersonRelation getPersonRelation() {
        return personRelation;
    }

    @JsonProperty("personRelation")
    public void setPersonRelation(PersonRelation personRelation) {
        this.personRelation = personRelation;
    }

    @JsonProperty("personELM")
    public PersonELM getPersonELM() {
        return personELM;
    }

    @JsonProperty("personELM")
    public void setPersonELM(PersonELM personELM) {
        this.personELM = personELM;
    }

    @JsonProperty("personOptional")
    public PersonOptional getPersonOptional() {
        return personOptional;
    }

    @JsonProperty("personOptional")
    public void setPersonOptional(PersonOptional personOptional) {
        this.personOptional = personOptional;
    }

    @JsonProperty("personMobileUser")
    public PersonMobileUser getPersonMobileUser() {
        return personMobileUser;
    }

    @JsonProperty("personMobileUser")
    public void setPersonMobileUser(PersonMobileUser personMobileUser) {
        this.personMobileUser = personMobileUser;
    }

    @JsonProperty("userLogin")
    public UserLogin getUserLogin() {
        return userLogin;
    }

    @JsonProperty("userLogin")
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @JsonProperty("userLoginProfile")
    public List<Object> getUserLoginProfile() {
        return userLoginProfile;
    }

    @JsonProperty("userLoginProfile")
    public void setUserLoginProfile(List<Object> userLoginProfile) {
        this.userLoginProfile = userLoginProfile;
    }

    @JsonProperty("personTM")
    public PersonTM getPersonTM() {
        return personTM;
    }

    @JsonProperty("personTM")
    public void setPersonTM(PersonTM personTM) {
        this.personTM = personTM;
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