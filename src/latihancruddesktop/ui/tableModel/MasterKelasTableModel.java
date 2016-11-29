/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop.ui.tableModel;

/**
 *
 * @author KENDAY
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import latihancruddesktop.domain.Kelas;


public class MasterKelasTableModel extends AbstractTableModel {
    
private List<Kelas> listKelas = new ArrayList<Kelas>();
private String[] header = {
"Id", "Nama Kelas", "Nama Peserta"
};
public MasterKelasTableModel(List<Kelas> pegawais) {
this.listKelas = pegawais;
}
@Override
public int getRowCount() {
return listKelas.size();
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
Kelas kelas = listKelas.get(rowIndex);
switch (columnIndex) {
case 0:
return kelas.getId();
case 1:
return kelas.getNama_kelas();
case 2:
return kelas.getNama_peserta();
case 3:
default:
return "";
}
}
}
