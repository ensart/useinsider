package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PojoApiTag {

    private int id;
    private String name;

    public PojoApiTag() {

    }

    public PojoApiTag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PojoApiTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
