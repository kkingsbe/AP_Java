package Unit7;

public class MonetaryCoin extends Coin
{
    private int value;

    public MonetaryCoin(int mValue)
    {
        value = mValue;
    }
    public int getValue()
    {
        return value;
    }
    public void setValue(int mValue)
    {
        value = mValue;
    }
}
