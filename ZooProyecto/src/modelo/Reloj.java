/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author beatl
 */
public class Reloj implements Runnable{

    private String hora, minutos, segundos, ampm;
    private Calendar calendario;
    private Thread h1; 
    private JLabel lblClock;
    private boolean stop;
    private boolean cerrar;
    
    public Reloj(JLabel lblClock){
        this.lblClock = lblClock;
        this.cerrar = true;
        h1 = new Thread(this);
        h1.start();
        
    }
    
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while(cerrar){
            calculs();
            if(stop){
                
            }else{
                lblClock.invalidate();
                lblClock.setText(hora+":"+minutos+":"+segundos+" "+ampm);
                lblClock.repaint();
                
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    
    public void calculs(){
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM? "AM":"PM";
        
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            
            hora = h>9?""+h:"0"+h;
        }else{        
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);     
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getSegundos() {
        return segundos;
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    public Thread getH1() {
        return h1;
    }

    public void setH1(Thread h1) {
        this.h1 = h1;
    }

    public JLabel getLblClock() {
        return lblClock;
    }

    public void setLblClock(JLabel lblClock) {
        this.lblClock = lblClock;
    }

    public boolean isCerrar() {
        return cerrar;
    }

    public void setCerrar(boolean cerrar) {
        this.cerrar = cerrar;
    }
    
    
    
}
