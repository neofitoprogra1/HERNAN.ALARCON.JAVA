/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author Administrador
 */
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.Statement;


public class Menu {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int o=0;
        do{
            System.out.println("MENU");
            System.out.println("1.-Crear Nueva Mascota");
            System.out.println("2.-Mostrar Mascotas");
            System.out.println("3.-Eliminar Mascota");
            System.out.println("4.-Actualizar Datos de Mascota");
            System.out.println("5.-Salir");
        
            String usuario="root";
            String clave="12345";
        
            try{
                Class.forName("org.gjt.mm.mysql.Driver");
                String url="jdbc:mysql://localhost:3306/prueba";
                Connection con=DriverManager.getConnection(url,usuario,clave);
                Statement stmt=con.createStatement();
        
                int opt=Integer.parseInt(in.nextLine());
                switch(opt){
                    case 1:{
                        
                        System.out.println("Crear Nueva Mascota");
                        int id,edad,peso,f,i;
                        System.out.println("Ingrese cantidad de mascotas que desea crear:");
                        f=Integer.parseInt(in.nextLine());
                        String nom;
                        for(i=1;i<=f;i++){
                            //Mascota mascota=new Mascota();
                            //mascota.ingresar_id();
                            //mascota.nombrar();
                            //mascota.ingreso_edad();
                            //mascota.ingreso_peso();
                            System.out.println("Ingrese NÂ° de id de la Mascota numero "+i);
                            id=Integer.parseInt(in.nextLine());
                            System.out.println("Ingrese Nombre de la mascota numero "+i);
                            nom=in.nextLine();
                            System.out.println("Ingrese edad en aÃ±os de la mascota numero "+i+" en numeros enteros:");
                            edad=Integer.parseInt(in.nextLine());
                            System.out.println("Ingrese peso de la mascota numero "+i+" en kilos y nÃºmeros enteros:");
                            peso=Integer.parseInt(in.nextLine());                        
                            stmt.executeUpdate("insert into Mascota(Mascota_id,Nombre,Edad,Peso) values('"+id+"','"+nom+"','"+edad+"','"+peso+"')");
                            System.out.println("Mascota Creada!");
                            
                        }    
                        System.out.println("Para Volver al Menu principal presione 1:");
                        System.out.println("Para Salir Presione 2:");
                        o=Integer.parseInt(in.nextLine());
                        break;
                        
                    }
                    case 2:{
                        System.out.println("Mostrar Mascotas:");
                        ResultSet rs=stmt.executeQuery("select * from Mascota");
                        while(rs.next()){
                            System.out.println("MASCOTA_id:"+rs.getInt("Mascota_id"));
                            System.out.println("NOMBRE:"+rs.getString("Nombre"));
                            System.out.println("EDAD:"+rs.getInt("Edad")+" aÃ±os.");
                            System.out.println("PESO:"+rs.getInt("Peso")+" kilos.");
                            System.out.println("____________________________________");
                            
                        }
                        System.out.println("Para Volver al Menu principal presione 1:");
                        System.out.println("Para Salir Presione 2:");
                        o=Integer.parseInt(in.nextLine());
                        break;
                    }    
                    case 3:{
                        System.out.println("Eliminar Mascota");
                        System.out.println("Ingrese el id de la mascota que desea eliminar:");
                        int id=Integer.parseInt(in.nextLine());
                        stmt.executeUpdate("delete from Mascota where Mascota_id='"+id+"'");
                        System.out.println("Mascota Eliminada!");
                        System.out.println("Para Volver al Menu principal presione 1:");
                        System.out.println("Para Salir Presione 2:");
                        o=Integer.parseInt(in.nextLine());
                        break;
                    }
                    case 4:{
                        System.out.println("Actualizar datos de mascota:");
                        System.out.println("Seleccione el id del registro que desea actualizar:");
                        int id=Integer.parseInt(in.nextLine());
                        System.out.println("Ingrese Nuevo Nombre de la Mascota:");
                        String nom=in.nextLine();
                        stmt.executeUpdate("update Mascota set Nombre='"+nom+"' where Mascota_id='"+id+"'");
                        System.out.println("Ingrese Nueva edad de la mascota:");
                        int edad=Integer.parseInt(in.nextLine());
                        stmt.executeUpdate("update Mascota set Edad='"+edad+"' where Mascota_id='"+id+"'");
                        System.out.println("Ingrese Nuevo peso de la mascota:");
                        int peso=Integer.parseInt(in.nextLine());
                        stmt.executeUpdate("update Mascota set Peso='"+peso+"' where Mascota_id='"+id+"'");
                        System.out.println("Mascota Actualizada!");
                        System.out.println("____________________________________");
                        System.out.println("Para Volver al Menu principal presione 1:");
                        System.out.println("Para Salir Presione 2:");
                        o=Integer.parseInt(in.nextLine());
                        break;
                    }
                    case 5:{
                        System.out.println("Salir");
                        System.out.println("Para Volver al Menu principal presione 1:");
                        System.out.println("Para salir presione 2");
                        o=Integer.parseInt(in.nextLine());
                        break;
                    }
                }    
            }catch(Exception ex){
                System.out.println("ERROR:"+ex.getMessage());
            }
        }while (o==1);
        System.out.println("Saliendo....");
    }
}   
    

    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    


