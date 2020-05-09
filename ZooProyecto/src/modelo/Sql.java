/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author beatl
 */
public class Sql extends Conexion{
    private static String sql;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;
    
    public static boolean registrarVeterinario(Veterinario vet) {
        try {
            
            sql = "INSERT INTO veterinario (VET_cedula,VET_correo,VET_telefono,VET_nombre,VET_nombre2,VET_apellido1,VET_apellido2) VALUES (?,?,?,?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, vet.getCedulaProfesional());
            ps.setString(2, vet.getCorreo());
            ps.setString(3, vet.getTelefono());
            ps.setString(4, vet.getNombre());
            ps.setString(5, vet.getNombre2());
            ps.setString(6, vet.getApellido1());
            ps.setString(7, vet.getApellido2());
           
            ps.execute();
            return true;
        } catch (Exception e) {
               System.out.println(e);
            return false;
        }
    }
    
    public static boolean registrarAnimal(Animal ani){
         try {
            
            sql = "INSERT INTO animal (ANI_CuidadorID,ANI_HabitatID,ANI_Nombre,ANI_Alimentacion,ANI_Anyo_cautiverio,ANI_Especie,ANI_Sexo,ANI_Edad,ANI_Peso,ANI_Observaciones) VALUES (?,?,?,?,?,?,?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,ani.getIdCuidador());
            ps.setInt(2, ani.getIdHabitat());
            ps.setString(3, ani.getNombre());
            ps.setString(4, ani.getAlimentacion());
            ps.setInt(5,ani.getAnyoCautiverio());
            ps.setString(6, ani.getEspecie());
            ps.setString(7, ani.getSexo());
            ps.setInt(8, ani.getEdad());
            ps.setFloat(9, ani.getPeso());
            ps.setString(10, ani.getObservaciones());
            ps.execute();
            if(ani.getProcedencia() == 1){
                sql = "INSERT INTO Procedencia_Local () values";
            }
           
            
            return true;
        } catch (Exception e) {
               System.out.println(e);
            return false;
        }
    }
    public static ArrayList<Cuidador> verCuidadores(){
        ArrayList<Cuidador> cuidadores = new ArrayList<>();
        Cuidador c = new Cuidador();
        try {
            sql = "SELECT * FROM cuidador";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                c = new Cuidador();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setNombre2(rs.getString(3));
                c.setApellido1(rs.getString(4));
                c.setApellido2(rs.getString(5));
                c.setSueldo(rs.getFloat(6));
                cuidadores.add(c);
            
               
            }
            
            return cuidadores;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return cuidadores;
        }
    }

    public static ArrayList<Veterinario> verVeterinarios() {
        ArrayList<Veterinario> veterinarios = new ArrayList<>();
        Veterinario v = new Veterinario();
        try {
            sql = "SELECT * FROM veterinario";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                v = new Veterinario();
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setNombre2(rs.getString(3));
                v.setApellido1(rs.getString(4));
                v.setApellido2(rs.getString(5));
                v.setCorreo(rs.getString(6));
                v.setCedulaProfesional(rs.getString(7));
                v.setTelefono(rs.getString(8));
                veterinarios.add(v);
            }

            return veterinarios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return veterinarios;
        }
    }

    public static ArrayList<Habitat> verHabitat() {
        ArrayList<Habitat> habitats = new ArrayList<>();
        Habitat h = new Habitat();
        try {
            sql = "SELECT * FROM Habitat";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                h = new Habitat();
                h.setId(rs.getInt(1));
                h.setClimaId(rs.getInt(2));
                h.setCuidadorId(rs.getInt(3));
                h.setNombre(rs.getString(4));
           
                habitats.add(h);
            }

            return habitats;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return habitats;
        }
    }
    
}
