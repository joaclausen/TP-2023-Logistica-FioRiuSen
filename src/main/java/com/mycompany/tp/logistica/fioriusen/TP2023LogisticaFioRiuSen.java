/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tp.logistica.fioriusen;

import com.mycompany.consultorach.HibernateManager;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vulturius
 */
public class TP2023LogisticaFioRiuSen {

   //QUE PAJA LOCO ESTE TP DEL ORTO :/
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setContentPane(new Menu(ventana,null));
        ventana.setVisible(true);
        //QUE PAJA LOCO ESTE TP DEL ORTO :/
        //QUE PAJA LOCO ESTE TP DEL ORTO :/
        //HOLAAAAAAAAAAAAAAAAAAA: /
        System.out.println("UN COMENTARIO LO QUE SEA");
        
        
        SessionFactory sessionFactory  = HibernateManager.Configure();

    try (Session session = sessionFactory.openSession()) {
            // Aquí puedes realizar operaciones con la base de datos usando la sesión
            // Por ejemplo, crear una nueva persona y guardarla en la base de datos

            

           Producto pro = new Producto();
           pro.setNombre("FRUTILLA");
           pro.setDescripcion("HORRIBLES");
           pro.setPrecioUnitario(45.2);
           pro.setPeso(5.00);

            session.beginTransaction();
            session.save(pro);
            
            session.getTransaction().commit();
            System.out.println("En teoría está pasa el commit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    

}