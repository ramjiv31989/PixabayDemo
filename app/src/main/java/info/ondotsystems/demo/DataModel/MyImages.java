package info.ondotsystems.demo.DataModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MyImages implements Serializable
{
    @SerializedName("hits")
    @Expose
    private List<Hits> hits;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("totalHits")
    @Expose
    private String totalHits;

    public List<Hits> getHits ()
    {
        return hits;
    }

    public void setHits (List<Hits> hits)
    {
        this.hits = hits;
    }

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getTotalHits ()
    {
        return totalHits;
    }

    public void setTotalHits (String totalHits)
    {
        this.totalHits = totalHits;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hits = "+hits+", total = "+total+", totalHits = "+totalHits+"]";
    }
}
