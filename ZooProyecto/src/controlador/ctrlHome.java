/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Reloj;
import vista.Home;

/**
 *
 * @author beatl
 */
public class ctrlHome implements ActionListener{
    private Home h;
    private Reloj r;
    public ctrlHome(Home h){
        this.h = h;
        this.r = new Reloj(h.lblClock);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public Reloj getR() {
        return r;
    }

    public void setR(Reloj r) {
        this.r = r;
    }
    
    
}
