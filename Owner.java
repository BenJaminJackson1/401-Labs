public class Owner {
    private String name;
    private boolean hasCat;
    public Owner(String name, boolean hasCat){
        this.name=name;
        this.hasCat=hasCat;
    } 
    public String getName(){
        return this.name;
    }
    public boolean hasACat(){
        return this.hasCat;
    }
    public void adopted(boolean adopt){
        this.hasCat=true;
    }
}
