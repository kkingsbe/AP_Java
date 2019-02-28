package Unit7;

public class Doctor extends Employee{
    private int patientID;
    private int id;
    public int getPatientID()
    {
        return patientID;
    }
    public void setPatientID(int id)
    {
        patientID = id;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int mId)
    {
        id = mId;
    }
}
