/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jv.ui;

import java.util.Scanner;

/**
 * @author: Jorge Villa 
 * email: villajorge41@gmail.com
 * Date: 08/24/22
 * Purpose: Console implementation for UserIO
 * 
 */
public class UserIOConsoleImpl implements UserIO {
    private final Scanner SCAN = new Scanner(System.in);
    private boolean valid = false;
    private String strIn;
    private int intIn;
    private double doubleIn;
    private float floatIn;
    private long longIn;
    
    @Override
    public void print(String message){
        System.out.println(message);
    }
    
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        return SCAN.nextLine();
    }
    
    @Override
    public int readInt(String prompt){
        
        while(!valid){
            try{
                System.out.println(prompt);
                strIn = SCAN.nextLine();
                intIn = Integer.parseInt(strIn);
                valid = true;
                                
            }catch(NumberFormatException e){
                System.out.println("Invalid int entered");
            }
        }
        valid = false;
        return intIn;   
    }
    
    @Override
    public int readInt(String prompt, int min, int max){
        
        while(!valid){
            try{
                System.out.println(prompt);
                System.out.println("Beteween "+min+" and "+max);
                strIn = SCAN.nextLine();
                intIn = Integer.parseInt(strIn);
                if (intIn >= min && intIn <= max){
                   valid = true; 
                }
                
            }catch(NumberFormatException e){
                System.out.println("Invalid int entered try again");
            }
        }
        valid = false;
        return intIn;
    }
    
    @Override
    public double readDouble (String prompt){
        while(!valid){
            try{
                System.out.println(prompt);
                strIn = SCAN.nextLine();
                doubleIn = Double.parseDouble(strIn);
                valid = true;
                
            }catch(NumberFormatException e){
                System.out.println("Invalid double entered try again");
            }
        }
        valid = false;
        return doubleIn;
    }
    
    @Override
    public double readDouble(String prompt, double min, double max){
        while(!valid){
            try{
                System.out.println(prompt);
                System.out.println("Beteween "+min+" and "+max);
                strIn = SCAN.nextLine();
                doubleIn = Double.parseDouble(strIn);
                if (doubleIn >= min && doubleIn <= max){
                   valid = true; 
                }
                
                
                
            }catch(NumberFormatException e){
                System.out.println("Invalid double entered try again");
            }
        }
        valid = false;
        return doubleIn;
    }
    
    @Override
    public float readFloat(String prompt){
        while(!valid){
            try{
                System.out.println(prompt);
                strIn = SCAN.nextLine();
                floatIn = Float.parseFloat(strIn);
                valid = true;
                
            }catch(NumberFormatException e){
                System.out.println("Invalid float entered try again");
            }
        }
        valid = false;
        return floatIn;
    }
    
    @Override
    public float readFloat(String prompt, float min, float max){
        while(!valid){
            try{
                System.out.println(prompt);
                System.out.println("Beteween "+min+" and "+max);
                strIn = SCAN.nextLine();
                floatIn = Float.parseFloat(strIn);
                if (floatIn >= min && floatIn <= max){
                   valid = true; 
                }
                
                
                
            }catch(NumberFormatException e){
                System.out.println("Invalid float entered try again");
            }
        }
        valid = false;
        return floatIn;
    }
    
    public long readLong(String prompt){
       while(!valid){
            try{
                System.out.println(prompt);
                strIn = SCAN.nextLine();
                longIn = Long.parseLong(strIn);
                valid = true;
                
            }catch(NumberFormatException e){
                System.out.println("Invalid long entered try again");
            }
        }
        valid = false;
        return longIn; 
    }
    
    public long readLong(String prompt, long min, long max){
        while(!valid){
            try{
                System.out.println(prompt);
                System.out.println("Beteween "+min+" and "+max);
                strIn = SCAN.nextLine();
                longIn = Long.parseLong(strIn);
                if (longIn >= min && longIn <= max){
                   valid = true; 
                }
                
                
                
            }catch(NumberFormatException e){
                System.out.println("Invalid long entered try again");
            }
        }
        valid = false;
        return longIn;
    }

}
