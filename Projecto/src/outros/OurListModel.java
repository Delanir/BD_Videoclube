/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package outros;

import javax.swing.AbstractListModel;

/**
 *
 * @author Daniela
 */
public class OurListModel extends AbstractListModel{
    private String []lista;
    public OurListModel(String []lista){
        this.lista=lista;
    }
    public int getSize() {
        if(lista==null)
            return 0;
       return lista.length;
    }

    public Object getElementAt(int index) {
        return lista[index];
    }

}
