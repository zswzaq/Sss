package day.day08_0815.zuoye;

public class Locator {

    private String id;
    private String by;
    private String value;
    private String desc;
    @Override
    public String toString() {
        return "Locator:[by=" + by + ", value=" + value + ", desc=" + desc + "]";
    }
    public String getBy() {
        return by;
    }
    public void setBy(String by) {
        this.by = by;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Locator(String by, String value, String desc, String id) {
        super();
        this.by = by;
        this.value = value;
        this.desc = desc;
        this.id = id;
    }
    public Locator() {
    }
    
}
