package davidlevy.pollar;

/**
 * Created by David on 4/12/2015.
 */
public class Option {
    public String getOpttext() {
        return opttext;
    }

    public int getOptvote() {
        return optvote;
    }

    private String opttext;
    private int optvote;

    public Option(){}

    public Option(String text, int votes){
        this.opttext = text;
        this.optvote = votes;
    }


}
