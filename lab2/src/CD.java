public class CD extends Item
{
    private String description;
    private int CDItemId;

    public CD(int id, String title)
    {
        super(id, title);
    }

    public CD(int id, String title, String description, int id2)
    {
        super(id, title);
        this.setDescription(description);
        this.setCDItemId(id2);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCDItemId()
    {
        return CDItemId;
    }

    public void setCDItemId(int CDItemId)
    {
        this.CDItemId = CDItemId;
    }
}
