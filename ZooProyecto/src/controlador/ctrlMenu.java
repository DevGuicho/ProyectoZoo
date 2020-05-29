/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import modelo.Reloj;
import modelo.Slide;
import vista.HistorialActividades;
import vista.Home;
import vista.RegistroAnimales;
import vista.*;

/**
 *
 * @author beatl
 */
public class ctrlMenu implements ActionListener, MouseListener {

    private menu m;
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontClick;
    private Font fontNormal;
    private Reloj r;
    private int progress;
    
    private ctrlSplashScreen ctrlSS;
    private ctrlHistorialActividades ctrlHA;
    private ctrlHistorialHabitats ctrlHH;

    private ctrlRegistroActividades ctrlRA;
    private ctrlRegistroAnimales ctrlRAni;
    private ctrlRegistroCuidadores ctrlRC;
    private ctrlRegistroVeterinarios ctrlRV;
    private ctrlReporteHabitats ctrlRH;
    private ctrlReporteVisitaMedica ctrlRVM;
    private ctrlHome ctrlH;

    private Home h;
    private HistorialActividades ha;
    private HistorialHabitats hh;
    private SplashScreen ss;
    private RegistroActividades ra;
    private RegistroAnimales rani;
    private RegistroCuidadores rc;
    private RegistroVeterinarios rv;
    private ReporteHabitats rh;
    private ReporteVisitaMedica rvm;

    private Thread t;

    public ctrlMenu(menu m) {
        this.m = m;
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/isotipo1.png"));
        this.m.setIconImage(icon);
        iniPrograma();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m.btnClose) {
            m.setVisible(false);
            m.dispose();
            ctrlH.getR().setCerrar(false);

        } else if (e.getSource() == m.btnMinimize) {
            m.setExtendedState(ICONIFIED);
        } else if (e.getSource() == m.btnHome) {
            m.pnlMainMenu.removeAll();
            m.pnlMainMenu.add(h);
            m.pnlMainMenu.repaint();
            m.pnlMainMenu.revalidate();
        } else if (e.getSource() == m.btnRegistroCuidador) {
            setPanel(rc);
        } else if (e.getSource() == m.btnRegistroAnimales) {
            setPanel(rani);
        } else if (e.getSource() == m.btnRegistroActividades) {
            setPanel(ra);
        } else if (e.getSource() == m.btnReporteVisitaMedica) {
            setPanel(rvm);
        } else if (e.getSource() == m.btnReporteHabitat) {
            setPanel(rh);
        } else if (e.getSource() == m.btnRegistroVeterinario) {
            setPanel(rv);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == m.btnRegistroCuidador) {
            m.btnRegistroCuidador.setFont(fontClick);
        } else if (e.getSource() == m.btnRegistroAnimales) {
            m.btnRegistroAnimales.setFont(fontClick);
        } else if (e.getSource() == m.btnRegistroActividades) {
            m.btnRegistroActividades.setFont(fontClick);
        } else if (e.getSource() == m.btnReporteVisitaMedica) {
            m.btnReporteVisitaMedica.setFont(fontClick);
        } else if (e.getSource() == m.btnReporteHabitat) {
            m.btnReporteHabitat.setFont(fontClick);
        } else if (e.getSource() == m.lblBuscar) {
            m.lblBuscar.setText(null);
        } else if (e.getSource() == m.btnRegistroVeterinario) {
            m.btnRegistroVeterinario.setFont(fontClick);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == m.btnRegistroCuidador) {
            m.btnRegistroCuidador.setFont(fontNormal);
        } else if (e.getSource() == m.btnRegistroAnimales) {
            m.btnRegistroAnimales.setFont(fontNormal);
        } else if (e.getSource() == m.btnRegistroActividades) {
            m.btnRegistroActividades.setFont(fontNormal);
        } else if (e.getSource() == m.btnReporteVisitaMedica) {
            m.btnReporteVisitaMedica.setFont(fontNormal);
        } else if (e.getSource() == m.btnReporteHabitat) {
            m.btnReporteHabitat.setFont(fontNormal);
        } else if (e.getSource() == m.btnRegistroVeterinario) {
            m.btnRegistroVeterinario.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == m.btnHome) {
            m.btnHome.setBackground(verdeOn);
        } else if (e.getSource() == m.btnRegistroVeterinario) {
            m.btnRegistroVeterinario.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == m.btnHome) {
            m.btnHome.setBackground(verdePrincipal);
        } else if (e.getSource() == m.btnRegistroVeterinario) {
            m.btnRegistroVeterinario.setBackground(verdePrincipal);
        }
    }

    private void setPanel(JPanel panel) {
        m.pnlMainMenu.removeAll();
        m.pnlMainMenu.add(panel);
        m.pnlMainMenu.repaint();
        m.pnlMainMenu.revalidate();
    }

    private void iniComponents() {
        this.ctrlSS.setModulo("Cargando Fuentes");
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);
        this.fontClick = new Font("Segoe UI", Font.PLAIN, 14);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 18);
        this.ctrlSS.setProgress(83);
        
        this.ctrlSS.setModulo("Cargando Complementos");
        this.m.btnMinimize.addActionListener(this);
        this.m.btnClose.addActionListener(this);
        this.m.btnHome.addActionListener(this);
        this.m.btnRegistroActividades.addActionListener(this);
        this.m.btnRegistroAnimales.addActionListener(this);
        this.m.btnRegistroCuidador.addActionListener(this);
        this.m.btnRegistroVeterinario.addActionListener(this);
        this.m.btnReporteHabitat.addActionListener(this);
        this.m.btnReporteVisitaMedica.addActionListener(this);
        this.ctrlSS.setProgress(166);
        
        this.ctrlSS.setModulo("Cargando Complements");
        this.m.btnHome.addMouseListener(this);
        this.m.btnRegistroActividades.addMouseListener(this);
        this.m.btnRegistroAnimales.addMouseListener(this);
        this.m.btnRegistroCuidador.addMouseListener(this);
        this.m.btnRegistroVeterinario.addMouseListener(this);
        this.m.btnReporteHabitat.addMouseListener(this);
        this.m.btnReporteVisitaMedica.addMouseListener(this);
        this.m.lblBuscar.addMouseListener(this);
        this.m.btnMinimize.addMouseListener(this);
        this.m.btnClose.addMouseListener(this);
        this.ctrlSS.setProgress(249);
        
        this.ctrlSS.setModulo("Home");
        this.h = new Home();
        this.ctrlH = new ctrlHome(h);
        this.ctrlSS.setProgress(332);
        
        this.ctrlSS.setModulo("Actividades");
        this.ha = new HistorialActividades();
        this.ctrlHA = new ctrlHistorialActividades(ha);
        this.ctrlSS.setProgress(415);
        
        this.ctrlSS.setModulo("Habitats");
        this.hh = new HistorialHabitats();
        this.ctrlHH = new ctrlHistorialHabitats(hh);
        this.ctrlSS.setProgress(498);
        
        this.ctrlSS.setModulo("Registro Actividades");
        this.ra = new RegistroActividades();
        this.ctrlRA = new ctrlRegistroActividades(ra);
        this.ctrlSS.setProgress(581);
        
        this.ctrlSS.setModulo("Animales");
        this.rani = new RegistroAnimales();
        this.ctrlRAni = new ctrlRegistroAnimales(rani);
        this.ctrlSS.setProgress(664);
        
        this.ctrlSS.setModulo("Cuidadores");
        this.rc = new RegistroCuidadores();
        this.ctrlRC = new ctrlRegistroCuidadores(rc);
        this.ctrlSS.setProgress(747);
        
        this.ctrlSS.setModulo("Veterinarios");
        this.rv = new RegistroVeterinarios();
        this.ctrlRV = new ctrlRegistroVeterinarios(rv);
        this.ctrlSS.setProgress(830);
        
        this.ctrlSS.setModulo("Habitats");
        this.rh = new ReporteHabitats();
        this.ctrlRH = new ctrlReporteHabitats(rh);
        this.ctrlSS.setProgress(913);
        
        this.ctrlSS.setModulo("Visitas Medicas");
        this.rvm = new ReporteVisitaMedica();
        this.ctrlRVM = new ctrlReporteVisitaMedica(rvm);
        this.ctrlSS.setProgress(996);
        
        setPanel(h);
    }

    public void iniPrograma() {
        this.progress = 0;
        this.ss = new SplashScreen();
        this.ctrlSS = new ctrlSplashScreen(ss);
        this.t = new Thread(ctrlSS);

        this.t.start();
        this.m.setVisible(false);
        iniComponents();
        try {
            this.ctrlSS.setProgress(1000);
            this.ctrlSS.setModulo("Done");
            Thread.sleep(1500);
            this.ctrlSS.setFlag(false);
            this.m.setVisible(true);
        } catch (Exception e) {
        }
    }

}
