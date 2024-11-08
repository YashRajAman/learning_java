public class table {
    public static void main(String[] args) {
        itsme obj = new itsme();
        obj.setHobby("Reading.");
        obj.setName("Yash");
        System.out.println(obj);
    }
}

class itsme{

    String name ;
    String hobby;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String toString() {
        String str = this.name + " "+this.hobby;
        return str;
    }

    
}