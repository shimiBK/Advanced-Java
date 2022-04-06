public class Owner implements Cloneable{
    private String name;
    private String phoneNumber;

    public Owner(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public void setOwnerName(String name)
    {
        this.name = name;
    }

    public String getOwnerName()
    {return this.name;}

    public void setOwnerPhone(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getOwnerPhone()
    {return this.phoneNumber;}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
