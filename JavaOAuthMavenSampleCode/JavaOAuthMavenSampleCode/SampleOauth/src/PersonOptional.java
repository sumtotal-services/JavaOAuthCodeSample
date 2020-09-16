import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text1",
        "text2",
        "text3",
        "text4",
        "text5",
        "text6",
        "text7",
        "text8",
        "text9",
        "text10",
        "text11",
        "text12",
        "text13",
        "text14",
        "text15",
        "text16",
        "text17",
        "text18",
        "text19",
        "text20",
        "date1",
        "date2",
        "date3",
        "date4",
        "date5",
        "money1",
        "money2",
        "money3",
        "money4",
        "money5",
        "integer1",
        "integer2",
        "integer3",
        "integer4",
        "integer5",
        "float1",
        "float2",
        "float3",
        "float4",
        "float5",
        "ind1",
        "ind2",
        "ind3",
        "ind4",
        "ind5",
        "memo1",
        "memo2",
        "memo3",
        "memo4",
        "memo5",
        "decimal1",
        "decimal2",
        "decimal3",
        "decimal4",
        "decimal5"
})
public class PersonOptional implements Serializable {

    @JsonProperty("text1")
    private Object text1;
    @JsonProperty("text2")
    private Object text2;
    @JsonProperty("text3")
    private Object text3;
    @JsonProperty("text4")
    private Object text4;
    @JsonProperty("text5")
    private Object text5;
    @JsonProperty("text6")
    private Object text6;
    @JsonProperty("text7")
    private Object text7;
    @JsonProperty("text8")
    private Object text8;
    @JsonProperty("text9")
    private Object text9;
    @JsonProperty("text10")
    private Object text10;
    @JsonProperty("text11")
    private Object text11;
    @JsonProperty("text12")
    private Object text12;
    @JsonProperty("text13")
    private Object text13;
    @JsonProperty("text14")
    private Object text14;
    @JsonProperty("text15")
    private Object text15;
    @JsonProperty("text16")
    private Object text16;
    @JsonProperty("text17")
    private Object text17;
    @JsonProperty("text18")
    private Object text18;
    @JsonProperty("text19")
    private Object text19;
    @JsonProperty("text20")
    private Object text20;
    @JsonProperty("date1")
    private Object date1;
    @JsonProperty("date2")
    private Object date2;
    @JsonProperty("date3")
    private Object date3;
    @JsonProperty("date4")
    private Object date4;
    @JsonProperty("date5")
    private Object date5;
    @JsonProperty("money1")
    private Object money1;
    @JsonProperty("money2")
    private Object money2;
    @JsonProperty("money3")
    private Object money3;
    @JsonProperty("money4")
    private Object money4;
    @JsonProperty("money5")
    private Object money5;
    @JsonProperty("integer1")
    private Object integer1;
    @JsonProperty("integer2")
    private Object integer2;
    @JsonProperty("integer3")
    private Object integer3;
    @JsonProperty("integer4")
    private Object integer4;
    @JsonProperty("integer5")
    private Object integer5;
    @JsonProperty("float1")
    private Object float1;
    @JsonProperty("float2")
    private Object float2;
    @JsonProperty("float3")
    private Object float3;
    @JsonProperty("float4")
    private Object float4;
    @JsonProperty("float5")
    private Object float5;
    @JsonProperty("ind1")
    private Object ind1;
    @JsonProperty("ind2")
    private Object ind2;
    @JsonProperty("ind3")
    private Object ind3;
    @JsonProperty("ind4")
    private Object ind4;
    @JsonProperty("ind5")
    private Object ind5;
    @JsonProperty("memo1")
    private Object memo1;
    @JsonProperty("memo2")
    private Object memo2;
    @JsonProperty("memo3")
    private Object memo3;
    @JsonProperty("memo4")
    private Object memo4;
    @JsonProperty("memo5")
    private Object memo5;
    @JsonProperty("decimal1")
    private Object decimal1;
    @JsonProperty("decimal2")
    private Object decimal2;
    @JsonProperty("decimal3")
    private Object decimal3;
    @JsonProperty("decimal4")
    private Object decimal4;
    @JsonProperty("decimal5")
    private Object decimal5;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1895014694348910188L;

    /**
     * No args constructor for use in serialization
     */
    public PersonOptional() {
    }

    /**
     * @param ind2
     * @param ind1
     * @param ind4
     * @param ind3
     * @param ind5
     * @param text20
     * @param memo5
     * @param memo4
     * @param memo3
     * @param memo2
     * @param memo1
     * @param text15
     * @param text14
     * @param text17
     * @param text16
     * @param text19
     * @param text18
     * @param decimal5
     * @param text3
     * @param text11
     * @param decimal2
     * @param text4
     * @param text10
     * @param decimal1
     * @param text1
     * @param text13
     * @param decimal4
     * @param text2
     * @param text12
     * @param decimal3
     * @param text7
     * @param text8
     * @param text5
     * @param money5
     * @param text6
     * @param money4
     * @param money3
     * @param money2
     * @param text9
     * @param money1
     * @param integer1
     * @param integer4
     * @param integer5
     * @param integer2
     * @param integer3
     * @param float1
     * @param float2
     * @param float3
     * @param date5
     * @param date4
     * @param date3
     * @param date2
     * @param date1
     * @param float4
     * @param float5
     */
    public PersonOptional(Object text1, Object text2, Object text3, Object text4, Object text5, Object text6, Object text7, Object text8, Object text9, Object text10, Object text11, Object text12, Object text13, Object text14, Object text15, Object text16, Object text17, Object text18, Object text19, Object text20, Object date1, Object date2, Object date3, Object date4, Object date5, Object money1, Object money2, Object money3, Object money4, Object money5, Object integer1, Object integer2, Object integer3, Object integer4, Object integer5, Object float1, Object float2, Object float3, Object float4, Object float5, Object ind1, Object ind2, Object ind3, Object ind4, Object ind5, Object memo1, Object memo2, Object memo3, Object memo4, Object memo5, Object decimal1, Object decimal2, Object decimal3, Object decimal4, Object decimal5) {
        super();
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.text6 = text6;
        this.text7 = text7;
        this.text8 = text8;
        this.text9 = text9;
        this.text10 = text10;
        this.text11 = text11;
        this.text12 = text12;
        this.text13 = text13;
        this.text14 = text14;
        this.text15 = text15;
        this.text16 = text16;
        this.text17 = text17;
        this.text18 = text18;
        this.text19 = text19;
        this.text20 = text20;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
        this.date4 = date4;
        this.date5 = date5;
        this.money1 = money1;
        this.money2 = money2;
        this.money3 = money3;
        this.money4 = money4;
        this.money5 = money5;
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.integer3 = integer3;
        this.integer4 = integer4;
        this.integer5 = integer5;
        this.float1 = float1;
        this.float2 = float2;
        this.float3 = float3;
        this.float4 = float4;
        this.float5 = float5;
        this.ind1 = ind1;
        this.ind2 = ind2;
        this.ind3 = ind3;
        this.ind4 = ind4;
        this.ind5 = ind5;
        this.memo1 = memo1;
        this.memo2 = memo2;
        this.memo3 = memo3;
        this.memo4 = memo4;
        this.memo5 = memo5;
        this.decimal1 = decimal1;
        this.decimal2 = decimal2;
        this.decimal3 = decimal3;
        this.decimal4 = decimal4;
        this.decimal5 = decimal5;
    }

    @JsonProperty("text1")
    public Object getText1() {
        return text1;
    }

    @JsonProperty("text1")
    public void setText1(Object text1) {
        this.text1 = text1;
    }

    @JsonProperty("text2")
    public Object getText2() {
        return text2;
    }

    @JsonProperty("text2")
    public void setText2(Object text2) {
        this.text2 = text2;
    }

    @JsonProperty("text3")
    public Object getText3() {
        return text3;
    }

    @JsonProperty("text3")
    public void setText3(Object text3) {
        this.text3 = text3;
    }

    @JsonProperty("text4")
    public Object getText4() {
        return text4;
    }

    @JsonProperty("text4")
    public void setText4(Object text4) {
        this.text4 = text4;
    }

    @JsonProperty("text5")
    public Object getText5() {
        return text5;
    }

    @JsonProperty("text5")
    public void setText5(Object text5) {
        this.text5 = text5;
    }

    @JsonProperty("text6")
    public Object getText6() {
        return text6;
    }

    @JsonProperty("text6")
    public void setText6(Object text6) {
        this.text6 = text6;
    }

    @JsonProperty("text7")
    public Object getText7() {
        return text7;
    }

    @JsonProperty("text7")
    public void setText7(Object text7) {
        this.text7 = text7;
    }

    @JsonProperty("text8")
    public Object getText8() {
        return text8;
    }

    @JsonProperty("text8")
    public void setText8(Object text8) {
        this.text8 = text8;
    }

    @JsonProperty("text9")
    public Object getText9() {
        return text9;
    }

    @JsonProperty("text9")
    public void setText9(Object text9) {
        this.text9 = text9;
    }

    @JsonProperty("text10")
    public Object getText10() {
        return text10;
    }

    @JsonProperty("text10")
    public void setText10(Object text10) {
        this.text10 = text10;
    }

    @JsonProperty("text11")
    public Object getText11() {
        return text11;
    }

    @JsonProperty("text11")
    public void setText11(Object text11) {
        this.text11 = text11;
    }

    @JsonProperty("text12")
    public Object getText12() {
        return text12;
    }

    @JsonProperty("text12")
    public void setText12(Object text12) {
        this.text12 = text12;
    }

    @JsonProperty("text13")
    public Object getText13() {
        return text13;
    }

    @JsonProperty("text13")
    public void setText13(Object text13) {
        this.text13 = text13;
    }

    @JsonProperty("text14")
    public Object getText14() {
        return text14;
    }

    @JsonProperty("text14")
    public void setText14(Object text14) {
        this.text14 = text14;
    }

    @JsonProperty("text15")
    public Object getText15() {
        return text15;
    }

    @JsonProperty("text15")
    public void setText15(Object text15) {
        this.text15 = text15;
    }

    @JsonProperty("text16")
    public Object getText16() {
        return text16;
    }

    @JsonProperty("text16")
    public void setText16(Object text16) {
        this.text16 = text16;
    }

    @JsonProperty("text17")
    public Object getText17() {
        return text17;
    }

    @JsonProperty("text17")
    public void setText17(Object text17) {
        this.text17 = text17;
    }

    @JsonProperty("text18")
    public Object getText18() {
        return text18;
    }

    @JsonProperty("text18")
    public void setText18(Object text18) {
        this.text18 = text18;
    }

    @JsonProperty("text19")
    public Object getText19() {
        return text19;
    }

    @JsonProperty("text19")
    public void setText19(Object text19) {
        this.text19 = text19;
    }

    @JsonProperty("text20")
    public Object getText20() {
        return text20;
    }

    @JsonProperty("text20")
    public void setText20(Object text20) {
        this.text20 = text20;
    }

    @JsonProperty("date1")
    public Object getDate1() {
        return date1;
    }

    @JsonProperty("date1")
    public void setDate1(Object date1) {
        this.date1 = date1;
    }

    @JsonProperty("date2")
    public Object getDate2() {
        return date2;
    }

    @JsonProperty("date2")
    public void setDate2(Object date2) {
        this.date2 = date2;
    }

    @JsonProperty("date3")
    public Object getDate3() {
        return date3;
    }

    @JsonProperty("date3")
    public void setDate3(Object date3) {
        this.date3 = date3;
    }

    @JsonProperty("date4")
    public Object getDate4() {
        return date4;
    }

    @JsonProperty("date4")
    public void setDate4(Object date4) {
        this.date4 = date4;
    }

    @JsonProperty("date5")
    public Object getDate5() {
        return date5;
    }

    @JsonProperty("date5")
    public void setDate5(Object date5) {
        this.date5 = date5;
    }

    @JsonProperty("money1")
    public Object getMoney1() {
        return money1;
    }

    @JsonProperty("money1")
    public void setMoney1(Object money1) {
        this.money1 = money1;
    }

    @JsonProperty("money2")
    public Object getMoney2() {
        return money2;
    }

    @JsonProperty("money2")
    public void setMoney2(Object money2) {
        this.money2 = money2;
    }

    @JsonProperty("money3")
    public Object getMoney3() {
        return money3;
    }

    @JsonProperty("money3")
    public void setMoney3(Object money3) {
        this.money3 = money3;
    }

    @JsonProperty("money4")
    public Object getMoney4() {
        return money4;
    }

    @JsonProperty("money4")
    public void setMoney4(Object money4) {
        this.money4 = money4;
    }

    @JsonProperty("money5")
    public Object getMoney5() {
        return money5;
    }

    @JsonProperty("money5")
    public void setMoney5(Object money5) {
        this.money5 = money5;
    }

    @JsonProperty("integer1")
    public Object getInteger1() {
        return integer1;
    }

    @JsonProperty("integer1")
    public void setInteger1(Object integer1) {
        this.integer1 = integer1;
    }

    @JsonProperty("integer2")
    public Object getInteger2() {
        return integer2;
    }

    @JsonProperty("integer2")
    public void setInteger2(Object integer2) {
        this.integer2 = integer2;
    }

    @JsonProperty("integer3")
    public Object getInteger3() {
        return integer3;
    }

    @JsonProperty("integer3")
    public void setInteger3(Object integer3) {
        this.integer3 = integer3;
    }

    @JsonProperty("integer4")
    public Object getInteger4() {
        return integer4;
    }

    @JsonProperty("integer4")
    public void setInteger4(Object integer4) {
        this.integer4 = integer4;
    }

    @JsonProperty("integer5")
    public Object getInteger5() {
        return integer5;
    }

    @JsonProperty("integer5")
    public void setInteger5(Object integer5) {
        this.integer5 = integer5;
    }

    @JsonProperty("float1")
    public Object getFloat1() {
        return float1;
    }

    @JsonProperty("float1")
    public void setFloat1(Object float1) {
        this.float1 = float1;
    }

    @JsonProperty("float2")
    public Object getFloat2() {
        return float2;
    }

    @JsonProperty("float2")
    public void setFloat2(Object float2) {
        this.float2 = float2;
    }

    @JsonProperty("float3")
    public Object getFloat3() {
        return float3;
    }

    @JsonProperty("float3")
    public void setFloat3(Object float3) {
        this.float3 = float3;
    }

    @JsonProperty("float4")
    public Object getFloat4() {
        return float4;
    }

    @JsonProperty("float4")
    public void setFloat4(Object float4) {
        this.float4 = float4;
    }

    @JsonProperty("float5")
    public Object getFloat5() {
        return float5;
    }

    @JsonProperty("float5")
    public void setFloat5(Object float5) {
        this.float5 = float5;
    }

    @JsonProperty("ind1")
    public Object getInd1() {
        return ind1;
    }

    @JsonProperty("ind1")
    public void setInd1(Object ind1) {
        this.ind1 = ind1;
    }

    @JsonProperty("ind2")
    public Object getInd2() {
        return ind2;
    }

    @JsonProperty("ind2")
    public void setInd2(Object ind2) {
        this.ind2 = ind2;
    }

    @JsonProperty("ind3")
    public Object getInd3() {
        return ind3;
    }

    @JsonProperty("ind3")
    public void setInd3(Object ind3) {
        this.ind3 = ind3;
    }

    @JsonProperty("ind4")
    public Object getInd4() {
        return ind4;
    }

    @JsonProperty("ind4")
    public void setInd4(Object ind4) {
        this.ind4 = ind4;
    }

    @JsonProperty("ind5")
    public Object getInd5() {
        return ind5;
    }

    @JsonProperty("ind5")
    public void setInd5(Object ind5) {
        this.ind5 = ind5;
    }

    @JsonProperty("memo1")
    public Object getMemo1() {
        return memo1;
    }

    @JsonProperty("memo1")
    public void setMemo1(Object memo1) {
        this.memo1 = memo1;
    }

    @JsonProperty("memo2")
    public Object getMemo2() {
        return memo2;
    }

    @JsonProperty("memo2")
    public void setMemo2(Object memo2) {
        this.memo2 = memo2;
    }

    @JsonProperty("memo3")
    public Object getMemo3() {
        return memo3;
    }

    @JsonProperty("memo3")
    public void setMemo3(Object memo3) {
        this.memo3 = memo3;
    }

    @JsonProperty("memo4")
    public Object getMemo4() {
        return memo4;
    }

    @JsonProperty("memo4")
    public void setMemo4(Object memo4) {
        this.memo4 = memo4;
    }

    @JsonProperty("memo5")
    public Object getMemo5() {
        return memo5;
    }

    @JsonProperty("memo5")
    public void setMemo5(Object memo5) {
        this.memo5 = memo5;
    }

    @JsonProperty("decimal1")
    public Object getDecimal1() {
        return decimal1;
    }

    @JsonProperty("decimal1")
    public void setDecimal1(Object decimal1) {
        this.decimal1 = decimal1;
    }

    @JsonProperty("decimal2")
    public Object getDecimal2() {
        return decimal2;
    }

    @JsonProperty("decimal2")
    public void setDecimal2(Object decimal2) {
        this.decimal2 = decimal2;
    }

    @JsonProperty("decimal3")
    public Object getDecimal3() {
        return decimal3;
    }

    @JsonProperty("decimal3")
    public void setDecimal3(Object decimal3) {
        this.decimal3 = decimal3;
    }

    @JsonProperty("decimal4")
    public Object getDecimal4() {
        return decimal4;
    }

    @JsonProperty("decimal4")
    public void setDecimal4(Object decimal4) {
        this.decimal4 = decimal4;
    }

    @JsonProperty("decimal5")
    public Object getDecimal5() {
        return decimal5;
    }

    @JsonProperty("decimal5")
    public void setDecimal5(Object decimal5) {
        this.decimal5 = decimal5;
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
