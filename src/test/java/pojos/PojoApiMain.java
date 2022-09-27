package pojos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PojoApiMain {

    private int id;
    private PojoApiCategory category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<PojoApiTag> tags;
    private String status;

    public PojoApiMain() {
    }

    public PojoApiMain(int id, PojoApiCategory category, String name, ArrayList<String> photoUrls, ArrayList<PojoApiTag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PojoApiCategory getCategory() {
        return category;
    }

    public void setCategory(PojoApiCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<PojoApiTag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<PojoApiTag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PojoApiMain{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
