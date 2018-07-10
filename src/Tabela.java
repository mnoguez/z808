import java.util.ArrayList;
import java.util.HashMap;

public class Tabela {

    private HashMap<String, ArrayList<String>> tabela;

    public Tabela() {
        this.tabela = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> getTabela() {
        return tabela;
    }

    public void setTabela(HashMap<String, ArrayList<String>> tabela) {
        this.tabela = tabela;
    }
}
