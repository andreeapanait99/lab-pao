import java.util.Date;

public class Reservation
{
    private User user;
    private Item item;
    private Date startDate;
    private Date endDate;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Reservation(User user, Item item, Date startDate, Date endDate)
    {
        this.user = user;
        this.item = item;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
