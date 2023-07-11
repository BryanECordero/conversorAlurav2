/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aluraconverter;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author bryan
 */
public class jComboBoxRender extends JLabel implements ListCellRenderer {

    Hashtable  <Object, ImageIcon> mElementos;
    ImageIcon mImg = new ImageIcon(this.getClass().getResource("/icons/bandera.png"));

    public jComboBoxRender(Hashtable<Object, ImageIcon> mElementos) {
        this.mElementos = mElementos;
    }
    
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(mElementos.get( value ) == null){
            setIcon(mImg);
        }else{
            setIcon(mElementos.get(value));
        }
        setText(value.toString());
        return this;
    }
    
}
