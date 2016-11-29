/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop;


import latihancruddesktop.dao.KelasDao;
import latihancruddesktop.dao.PesertaDao;
import latihancruddesktop.ui.MainMenu;
import latihancruddesktop.utils.DatabaseConnection;

/**
 *
 * @author KENDAY
 */
public class Main {

private static PesertaDao pesertaDao;
private static KelasDao kelasDao;
private static MainMenu mainForm;
private static void initContext() {
pesertaDao = new PesertaDao();
kelasDao = new KelasDao();
}
public static void initComponent() {
if (mainForm == null) {
mainForm = new MainMenu();
}
mainForm.setVisible(true);
}
public static void main(String[] args) {
initContext();
initComponent();
DatabaseConnection.testConnection();
}
public static PesertaDao getPesertaDao() {
return pesertaDao;
}
public static KelasDao getKelasDao() {
return kelasDao;
}
public static MainMenu getMainForm() {
return mainForm;
}

}
