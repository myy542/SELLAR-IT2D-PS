
package it2d.ps;

import java.util.Scanner;

public class IT2DPS {
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
       String response;
       
     do{
        System.out.println("1.ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
       
       
        System.out.print("Enter Action:");
        int action = sc.nextInt();
       
       IT2DPS employee = new IT2DPS();
        switch (action){
            case 1:
               employee.addemployee();
               
             break;
            case 2:
           employee.viewemployee();
           
            break;
            case 3:
                
            employee.viewemployee();
            employee.updateemployee();
            employee.viewemployee();  
            
            
            break;
            case 4:
                
           employee.viewemployee();
           employee.deleteemployee();
           employee.viewemployee();
           
        }
            System.out.print("Do you want to continue? (yes/no):");
            response = sc.next();
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thankyou,See you soonest");
       
       
           
        }

    public void addemployee() {
        Scanner sc =  new Scanner(System.in);
        config conf = new config();
        System.out.print("Employee First Name:");
        String fname= sc.next();
         System.out.print("Employee Last Name:");
        String lname= sc.next();
         System.out.print("Employee Position:");
        String position= sc.next();
       
         String sql = "INSERT INTO t_employee (e_fname, e_lname, e_position) VALUES (?, ?, ?)";
      conf.addRecord(sql, fname, lname, position);
       
    }private void viewemployee() {
       config conf = new config();
        String votersQuery = "SELECT * FROM t_employee";
        String[] votersHeaders = {"Employee_Id", "First Name", "Last Name", "Position"};
        String[] votersColumns = {"e_id", "e_fname", "e_lname", "e_position"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
           
       
       
    }

    private void updateemployee() {
        Scanner sc = new Scanner (System.in);
        config conf = new config();
        
        System.out.println("Enter the id to update:");
         int id = sc.nextInt();
         
         System.out.print(" New First Name:");
        String fname = sc.next();
        System.out.print("New Last Nane:");
        String lname = sc.next();
        System.out.print("New Position");
        String position = sc.next();
        
        String sql = " UPDATE t_employee SET e_fname = ?, e_lname = ?, e_position = ?, WHERE e_id = ?";
   
        conf.updateRecord(sql,fname,lname,position, id);
        
        
    }

    private void deleteemployee() {
      Scanner sc = new Scanner(System.in);
       System.out.print("Enter the id to delete:");
       
        int id= sc.nextInt();
        
          String qry = "DELETE FROM t_employee WHERE e_id = ?";
          
        config conf = new config();
        conf.deleteRecord(qry,id); 
          
    }
    
}
        
    
    

