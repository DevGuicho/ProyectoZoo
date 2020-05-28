/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZooProyecto;

import controlador.ctrlMenu;
import vista.menu;

/**
 *
 * @author beatl
 */
public class ZooProyecto {
    public static void main(String[] args) {
        menu m = new menu();
        m.setVisible(false);
        ctrlMenu ctrM = new ctrlMenu(m);
    }
}
