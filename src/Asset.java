/**
 * Created by jeril on 2014/08/04.
 */
public class Asset implements Cloneable {

    private String Asset_ID;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String Title;
    private String posterUrl;

    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    private String posterId;

    public String getAsset_ID() {
        return Asset_ID;
    }

    public void setAsset_ID(String asset_ID) {
        Asset_ID = asset_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "Asset_ID='" + Asset_ID + '\'' +
                ", Title='" + Title + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", posterId='" + posterId + '\'' +
                '}';
    }
}
