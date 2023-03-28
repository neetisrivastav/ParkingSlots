package collection;

class Test {
    public static void main(String[] args) {
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setCity("Varansi");
        addressInfo.setZipCode("23456");
        Employeesss employeesss = new Employeesss("neeti","10",addressInfo);
        addressInfo.setCity("345delhi");
        Employeesss employeesss1 = new Employeesss("hlo","20",addressInfo);
       // ads.setCity("mumbai");
        System.out.println(employeesss.getAddress().getCity());
        System.out.println(employeesss1.getAddress().getCity());
        // it will pring delhi when it is shallow clonning
    }
}

final class Employeesss {

    private final String empName;
    private final String empSalary;
    private final AddressInfo address;

    public Employeesss(String empName, String empSalary, AddressInfo address) {
        this.empName = empName;
        this.empSalary = empSalary;
        //shallow cloning
       // this.address=address;
        //deep cloning
        AddressInfo a = new AddressInfo();
        a.setZipCode(address.getZipCode());
        a.setCity(address.getCity());
        this.address = a;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public AddressInfo getAddress(){
        AddressInfo a = new AddressInfo();
        a.setZipCode(address.getZipCode());
        a.setCity(address.getCity());
        return a;
    }
}

class AddressInfo implements Cloneable
{

//    @Override
//    public AddressInfo clone()
//    {
//        return this;
//    }
    private String city;
    private String zipCode;

    public String getCity()
    {
        return city;
    }
    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city)
    {
        this.city=city;
    }
}

