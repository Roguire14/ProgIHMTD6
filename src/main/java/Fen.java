import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Fen extends JFrame {
    public Fen(){
        super();
        constrFen();
    }

    private void constrFen() {
        setTitle("JTable");
        setSize(800,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(constrPan());
        pack();
        setVisible(true);
    }

    private JPanel constrPan() {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        String[] lesColonnes = {"Animal","Espèce","Nombre","A surveiller"};
        Object[][] lesValeurs = {
                {"Chien","",16,false},
                {"Chat","",38,false},
                {"Raie","",14,false},
                {"Baleine","",2,true},
                {"Chouette Ambrée","",15,false},
                {"Ragondin","",68,false},
                {"Saumon","",36,true},
                {"Marsouin","",12,true},
                {"Aigle royal","",3,true},
                {"Pie","",21,false},
                {"Requin marteau","",4,true},
                {"Lieu noir","",41,false},
                {"Buse des forêts","",29,false},
                {"Perruche bleue","",15,true},
        };
        JTable table = new JTable(lesValeurs,lesColonnes);
        TableColumn column = null;
        for (int i = 0; i < lesColonnes.length;i++){
            column = table.getColumnModel().getColumn(i);
            switch (i){
                case 0:
                case 2:
                case 3:
                    column.setPreferredWidth(100);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
            }
        }
        setUpEspeceColonne(table.getColumnModel().getColumn(1));
        main.add(table.getTableHeader(), BorderLayout.NORTH);
        main.add(table, BorderLayout.CENTER);

        return main;
    }

    private void setUpEspeceColonne(TableColumn column) {
        String[] especes = {"Mammifère","Poisson","Oiseau"};
        JComboBox laBobox = new JComboBox(especes);
        column.setCellEditor(new DefaultCellEditor(laBobox));
    }
}
