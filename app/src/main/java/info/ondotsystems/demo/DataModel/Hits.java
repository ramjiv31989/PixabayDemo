package info.ondotsystems.demo.DataModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hits implements Serializable
{
    @SerializedName("webformatHeight")
    @Expose
    private String webformatHeight;
    @SerializedName("imageWidth")
    @Expose
    private String imageWidth;
    @SerializedName("favorites")
    @Expose
    private String favorites;
    @SerializedName("webformatURL")
    @Expose
    private String webformatURL;
    @SerializedName("previewHeight")
    @Expose
    private String previewHeight;
    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("previewURL")
    @Expose
    private String previewURL;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("imageHeight")
    @Expose
    private String imageHeight;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("previewWidth")
    @Expose
    private String previewWidth;
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("downloads")
    @Expose
    private String downloads;
    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;
    @SerializedName("pageURL")
    @Expose
    private String pageURL;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("imageSize")
    @Expose
    private String imageSize;
    @SerializedName("webformatWidth")
    @Expose
    private String webformatWidth;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("likes")
    @Expose
    private String likes;

    public String getWebformatHeight ()
    {
        return webformatHeight;
    }

    public void setWebformatHeight (String webformatHeight)
    {
        this.webformatHeight = webformatHeight;
    }

    public String getImageWidth ()
    {
        return imageWidth;
    }

    public void setImageWidth (String imageWidth)
    {
        this.imageWidth = imageWidth;
    }

    public String getFavorites ()
    {
        return favorites;
    }

    public void setFavorites (String favorites)
    {
        this.favorites = favorites;
    }

    public String getWebformatURL ()
    {
        return webformatURL;
    }

    public void setWebformatURL (String webformatURL)
    {
        this.webformatURL = webformatURL;
    }

    public String getPreviewHeight ()
    {
        return previewHeight;
    }

    public void setPreviewHeight (String previewHeight)
    {
        this.previewHeight = previewHeight;
    }

    public String getUserImageURL ()
    {
        return userImageURL;
    }

    public void setUserImageURL (String userImageURL)
    {
        this.userImageURL = userImageURL;
    }

    public String getComments ()
    {
        return comments;
    }

    public void setComments (String comments)
    {
        this.comments = comments;
    }

    public String getPreviewURL ()
    {
        return previewURL;
    }

    public void setPreviewURL (String previewURL)
    {
        this.previewURL = previewURL;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getImageHeight ()
    {
        return imageHeight;
    }

    public void setImageHeight (String imageHeight)
    {
        this.imageHeight = imageHeight;
    }

    public String getTags ()
    {
        return tags;
    }

    public void setTags (String tags)
    {
        this.tags = tags;
    }

    public String getPreviewWidth ()
    {
        return previewWidth;
    }

    public void setPreviewWidth (String previewWidth)
    {
        this.previewWidth = previewWidth;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getDownloads ()
    {
        return downloads;
    }

    public void setDownloads (String downloads)
    {
        this.downloads = downloads;
    }

    public String getLargeImageURL ()
    {
        return largeImageURL;
    }

    public void setLargeImageURL (String largeImageURL)
    {
        this.largeImageURL = largeImageURL;
    }

    public String getPageURL ()
    {
        return pageURL;
    }

    public void setPageURL (String pageURL)
    {
        this.pageURL = pageURL;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getImageSize ()
    {
        return imageSize;
    }

    public void setImageSize (String imageSize)
    {
        this.imageSize = imageSize;
    }

    public String getWebformatWidth ()
    {
        return webformatWidth;
    }

    public void setWebformatWidth (String webformatWidth)
    {
        this.webformatWidth = webformatWidth;
    }

    public String getUser ()
    {
        return user;
    }

    public void setUser (String user)
    {
        this.user = user;
    }

    public String getViews ()
    {
        return views;
    }

    public void setViews (String views)
    {
        this.views = views;
    }

    public String getLikes ()
    {
        return likes;
    }

    public void setLikes (String likes)
    {
        this.likes = likes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [webformatHeight = "+webformatHeight+", imageWidth = "+imageWidth+", favorites = "+favorites+", webformatURL = "+webformatURL+", previewHeight = "+previewHeight+", userImageURL = "+userImageURL+", comments = "+comments+", previewURL = "+previewURL+", type = "+type+", imageHeight = "+imageHeight+", tags = "+tags+", previewWidth = "+previewWidth+", user_id = "+user_id+", downloads = "+downloads+", largeImageURL = "+largeImageURL+", pageURL = "+pageURL+", id = "+id+", imageSize = "+imageSize+", webformatWidth = "+webformatWidth+", user = "+user+", views = "+views+", likes = "+likes+"]";
    }
}

