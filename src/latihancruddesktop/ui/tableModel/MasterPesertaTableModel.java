/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop.ui.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import latihancruddesktop.domain.Peserta;

/**
 *
 * @author KENDAY
 */
public class MasterPesertaTableModel extends AbstractTableModel {
private List<Peserta> listPeserta = new ArrayList<Peserta>();
private String[] header = {
"Id", "Nomor Induk", "Nama", "Jenis Kelamin", "Alamat"
};public MasterPesertaTableModel(List<Peserta> pegawais) {
this.listPeserta = pegawais;
}
@Override
public int getRowCount() {
return listPeserta.size();
}
@Override
public int getColumnCount() {
return header.length;
}
@Override
public String getColumnName(int column) {
return header[column];
}
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
Peserta peserta = listPeserta.get(rowIndex);
switch (columnIndex) {
case 0:
return peserta.getId();
case 1:
return peserta.getNomorInduk();
case 2:
return peserta.getNama();
case 3:
return peserta.getJenisKelamin();
case 4:
return peserta.getAlamat();
default:
return "";
}
}
}
