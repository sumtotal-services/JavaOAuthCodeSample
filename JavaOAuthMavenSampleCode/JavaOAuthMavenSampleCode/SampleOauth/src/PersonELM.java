import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "approverId",
        "defApproverId",
        "viewAllEmpsInd",
        "reqConfirm",
        "instructorActive"
})
public class PersonELM implements Serializable {

    @JsonProperty("approverId")
    private Object approverId;
    @JsonProperty("defApproverId")
    private Object defApproverId;
    @JsonProperty("viewAllEmpsInd")
    private Boolean viewAllEmpsInd;
    @JsonProperty("reqConfirm")
    private Integer reqConfirm;
    @JsonProperty("instructorActive")
    private Integer instructorActive;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7779268313397767952L;

    /**
     * No args constructor for use in serialization
     */
    public PersonELM() {
    }

    /**
     * @param reqConfirm
     * @param instructorActive
     * @param approverId
     * @param viewAllEmpsInd
     * @param defApproverId
     */
    public PersonELM(Object approverId, Object defApproverId, Boolean viewAllEmpsInd, Integer reqConfirm, Integer instructorActive) {
        super();
        this.approverId = approverId;
        this.defApproverId = defApproverId;
        this.viewAllEmpsInd = viewAllEmpsInd;
        this.reqConfirm = reqConfirm;
        this.instructorActive = instructorActive;
    }

    @JsonProperty("approverId")
    public Object getApproverId() {
        return approverId;
    }

    @JsonProperty("approverId")
    public void setApproverId(Object approverId) {
        this.approverId = approverId;
    }

    @JsonProperty("defApproverId")
    public Object getDefApproverId() {
        return defApproverId;
    }

    @JsonProperty("defApproverId")
    public void setDefApproverId(Object defApproverId) {
        this.defApproverId = defApproverId;
    }

    @JsonProperty("viewAllEmpsInd")
    public Boolean getViewAllEmpsInd() {
        return viewAllEmpsInd;
    }

    @JsonProperty("viewAllEmpsInd")
    public void setViewAllEmpsInd(Boolean viewAllEmpsInd) {
        this.viewAllEmpsInd = viewAllEmpsInd;
    }

    @JsonProperty("reqConfirm")
    public Integer getReqConfirm() {
        return reqConfirm;
    }

    @JsonProperty("reqConfirm")
    public void setReqConfirm(Integer reqConfirm) {
        this.reqConfirm = reqConfirm;
    }

    @JsonProperty("instructorActive")
    public Integer getInstructorActive() {
        return instructorActive;
    }

    @JsonProperty("instructorActive")
    public void setInstructorActive(Integer instructorActive) {
        this.instructorActive = instructorActive;
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
