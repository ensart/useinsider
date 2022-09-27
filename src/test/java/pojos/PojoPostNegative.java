package pojos;

public class PojoPostNegative {

    private int idNumber;
    private String category;
    private String lastName;
    private String photoUrls;
    private String tags;
    private String lastStatus;

    public PojoPostNegative() {
    }

    public PojoPostNegative(int idNumber, String category, String lastName, String photoUrls, String tags, String lastStatus) {
        this.idNumber = idNumber;
        this.category = category;
        this.lastName = lastName;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.lastStatus = lastStatus;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }

    @Override
    public String toString() {
        return "PojoPostNegative{" +
                "idNumber=" + idNumber +
                ", category='" + category + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photoUrls='" + photoUrls + '\'' +
                ", tags='" + tags + '\'' +
                ", lastStatus='" + lastStatus + '\'' +
                '}';
    }
}
