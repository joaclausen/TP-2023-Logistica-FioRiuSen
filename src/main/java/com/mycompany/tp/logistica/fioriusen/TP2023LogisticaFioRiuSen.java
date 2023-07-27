/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tp.logistica.fioriusen;
import com.mycompany.tp.logistica.fioriusen.entidades.Producto;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 *
 * @author jlcla
 */
public class TP2023LogisticaFioRiuSen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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

         //TU PRODUCTO
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
