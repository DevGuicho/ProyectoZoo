/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;

import vista.SplashScreen;

/**
 *
 * @author beatl
 */
public class ctrlSplashScreen implements Runnable {

    private SplashScreen ss;
    private Thread th1;
    private boolean flag;
    private int progress;
    private String modulo;
    
    public ctrlSplashScreen(SplashScreen ss) {

        this.ss = ss;
        this.ss.setVisible(true);
        this.ss.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/isotipo1.png"));
        this.ss.setIconImage(icon);
        
        flag = true;
        this.ss.barProgress.setMaximum(1000);
        progress = 0;

    }

    @Override
    public void run() {
        try {
            
            while (flag) {
                
                ss.barProgress.setValue(progress);  
                ss.lblModulo.setText(modulo);
            }

            this.ss.setVisible(false);
            this.ss.dispose();

        } catch (Exception e) {
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
    
    
}
