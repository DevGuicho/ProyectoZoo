/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 *
 * @author beatl
 */
public class Slide extends Object{
    
    public void slideJLabelRight(int star, int stop,int deley, JLabel label){
        
        if(label.getX() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i <= stop; i++) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        
                        label.setLocation(i, label.getY());
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        
        }
    }
    
    public void slideJLabelLeft(int star, int stop,int deley, JLabel label){
        if(label.getX() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i >= stop; i--) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        
                        label.setLocation(i, label.getY());
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJButtonlRight(int star, int stop,int deley, JButton button){
        if(button.getX() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i <= stop; i++) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        button.setLocation(i, button.getY());
                        
                    }
                    button.setLocation(stop, button.getY());
                } catch (Exception e) {
                }
            }
        };th.start();
        
        }
    }
    
    public void slideJButtonlLeft(int star, int stop,int deley, JButton button){
        if(button.getX() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i >= stop; i--) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        button.setLocation(i, button.getY());
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJpanelRight(int star, int stop,int deley, JPanel panel){
        if(panel.getX() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i <= stop; i++) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        panel.setLocation(i, panel.getY());
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJpanelLeft(int star, int stop,int deley, JPanel panel){
        if(panel.getX() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i >= stop; i--) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        panel.setLocation(i, panel.getY());
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJPanelUp(int star, int stop,int deley, JPanel panel){
        if(panel.getY() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i >= stop; i--) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        panel.setLocation(panel.getX(),i);
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJPanelDown(int star, int stop,int deley, JPanel panel){
        if(panel.getY() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i <= stop; i++) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        panel.setLocation(panel.getX(), i);
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJButtonUp(int star, int stop,int deley, JButton button){
        if(button.getY() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i >= stop; i--) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        button.setLocation(button.getX(),i);
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    }
    
    public void slideJButtonDown(int star, int stop,int deley, JButton button){
        if(button.getY() == star){
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i <= stop; i++) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        button.setLocation(button.getX(), i);
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
            
        }
    }
    
    public void slideJpanelRightTest(int star, int stop,int deley, JPanel panel){
        
            Thread th = new Thread(){
            public void run(){
                try {
                    for (int i = star; i <= stop; i++) {
                        Thread.sleep(deley);
                        Thread.sleep(deley);
                        panel.setSize(i, 640);
                        
                    }
                } catch (Exception e) {
                }
            }
        };th.start();
        }
    
    
    
}


