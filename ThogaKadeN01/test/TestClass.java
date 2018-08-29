/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ranjith-suranga
 */
public class TestClass {
    
    public static void main(String[] args) {
        
        String sql = "INSERT INTO Customer VALUES ()";
        int paramCount = sql.split("[?]").length - 1;
        System.out.println(paramCount);
        
    }
    
    
}
