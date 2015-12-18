
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author hena
 */
public class Judge {
    public String compile(String lang,String curdir)
    {
     System.out.println("Compilation started..");
     ProcessBuilder p=new ProcessBuilder();
     boolean compiled=true;
        switch (lang) {
            case "Java":
                p=new ProcessBuilder("javac","Main.java");
                p.directory(new File(curdir));
                p.redirectErrorStream(true);
                break;
            case "C":
                p=new ProcessBuilder("gcc","-std=c++0x","-w","-o","Main","Main.c");
                p.directory(new File(curdir));
                p.redirectErrorStream(true);
                break;
            case "C++":
                p=new ProcessBuilder("g++","-std=c++0x","-w","-o","Main","Main.cpp");
                p.directory(new File(curdir));
                p.redirectErrorStream(true);
                break;
        }
     
    
     StringBuilder response = new StringBuilder();
     try{
         Process pp=p.start();
         InputStream is=pp.getInputStream();
         String temp;
         
         try(BufferedReader b=new BufferedReader(new InputStreamReader(is))){
             while((temp=b.readLine())!=null)
             {
                 compiled=false;
                 response.append(temp);
                 response.append("\n");
                 System.out.println(temp);
             }
             pp.waitFor();
         }
         if(!compiled)
         {
             is.close();
             return response.toString();
         }
         is.close();
         String res="Compiled successfully";
         return res;
         
     }
     catch(IOException | InterruptedException e)
     {
         e.printStackTrace();
     }
     return response.toString();
    }
    
    public String run(String lang,int tno,String curdir,String input)
    {
        String res=null;
        System.out.println("Code started executing..");
        ProcessBuilder p=new ProcessBuilder();
        switch (lang) {
            case "Java":
                p=new ProcessBuilder("java","Main");
                p.directory(new File(curdir));
                break;
            case "C":
                p=new ProcessBuilder("./Main");
                p.directory(new File(curdir));
                break;
            case "C++":
                p=new ProcessBuilder("./Main");
                p.directory(new File(curdir));
                break;
        }
     File in=new File(input);
     p.redirectInput(in);
     p.redirectErrorStream(true);
     try{
     File out=new File(curdir+"o"+tno+".txt");
     out.createNewFile();
     p.redirectOutput(out);}
     catch(IOException e)
     {}  
 
     try{
         Process pp=p.start();
      
         pp.waitFor();
             int exitCode=pp.exitValue();
             if(exitCode!=0)
             {
                 res="SIGSEV";
                 return res;
             }
             
         
     }catch(IOException | InterruptedException e)
     {
     }
     System.out.println("Code execution finished");
     res="Run_success";
     return res;
    }
}
