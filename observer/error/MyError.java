package error;

public class MyError {

    private Object o;
    private int broj;
    private String string;

    public MyError(Object o, int broj, String string){
        this.o = o;
        this.broj = broj;
        this.string = string;
    }

    public Object getO() {
        return o;
    }

    public int getBroj() {
        return broj;
    }

    public String getString() {
        return string;
    }
}
