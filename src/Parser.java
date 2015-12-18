    import java.io.File;  
    import java.io.FileWriter;
    import java.io.IOException;  
    import java.util.Scanner;
    import org.jsoup.Jsoup;  
    import org.jsoup.nodes.Document;  
    import org.jsoup.nodes.Element;  
    import org.jsoup.select.Elements; 
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;    
    import java.nio.channels.FileChannel;

    public class Parser {  
    public static void main(String[] args) throws IOException {  
        Scanner sc=new Scanner(System.in);
        int CF=sc.nextInt();
        String url = "http://codeforces.com/contest/"+CF+"/problems";
        //Document doc = Jsoup.connect(url).get();
        Document doc = Jsoup.parse(new File("/home/hena/OnlineJudge/Problems-Codeforces1.html"),"utf-8"); 
        //______________________________________________________________________________________
       //Creating a directory with the name of codeforces round
        File dir=new File(""+CF+"");
        if(dir.exists() && dir.isDirectory())
            System.out.println("Directory already exits.");
        else{
            boolean success=dir.mkdir();
            if(success)
                System.out.println("Successfully created");
            else
                 System.out.println("Not created");
        }

        //____________________________________________________________________________________
       Elements problems=doc.select("div.problemindexholder");
       
        for (Element problem : problems) {  
            String qid = problem.attr("problemindex");  
            File pdir=new File(""+CF+"/"+qid+"");
            boolean suc=pdir.mkdir();
              if(suc)
                 System.out.println("Problem directory created");
              else
                 System.out.println("Problem directory failed");
            System.out.println("Question id:"+qid);  
       //____________________________________________________________________________________________
         //Copying template.cpp to question directory
            File srcfile=new File("template.cpp");
            File desfile=new File(""+CF+"/"+qid+"/aprog.cpp");
            if(!desfile.exists())
                desfile.createNewFile();
            
            FileChannel source=null;
            FileChannel destination=null;
            try{
                source=new FileInputStream(srcfile).getChannel();
                destination=new FileOutputStream(desfile).getChannel();
                if(destination!=null && source!=null)
                {
                    destination.transferFrom(source, 0,source.size());
                }
            }catch(FileNotFoundException e)
            {}
              finally{
                if(source!=null)
                    source.close();
                if(destination!=null)
                    destination.close();
            }      
         //_______________________________________________________________________________________-
            StringBuilder ques=new StringBuilder();
            Elements questions=problem.getElementsByTag("p");
            for(Element question :questions){
                String que=question.text();
               ques.append(que);
               ques.append("\n");
            }
         
             File f=new File(""+CF+"/"+qid+"/ques.txt");
                f.createNewFile();
                try (FileWriter fw = new FileWriter(f)) {
                    fw.write(ques.toString());
                }
          //_______________________________________________________________________________________
                Elements testcases=problem.getElementsByTag("pre");
                int incounter=1;
                   for(Element testcase : testcases){
                
                       String item=testcase.text();
               
                //item.replaceAll("<pre>"," ");
                //item.replaceAll("</pre>"," ");
                //item.replaceAll("<br>","\n");
                     System.out.println("Testcases of problem "+qid+":"+item+"\n");
                //item.replaceAll(item, item)
      //_________________________________________________________________________________________
      //Creating files for test cases
                     if(incounter % 2 ==1)
                     {
                         File f1=new File(""+CF+"/"+qid+"/in"+(incounter/2)+".txt");
                         f1.createNewFile();
                         FileWriter fw=new FileWriter(f1);
                         fw.write(item);
                         fw.close();
                     }
                     else
                     {
                          File f2=new File(""+CF+"/"+qid+"/out"+((incounter/2)-1)+".txt");
                         f2.createNewFile();
                         FileWriter fw1=new FileWriter(f2);
                         fw1.write(item);
                         fw1.close();
                     }
                     incounter++;
                 }
      //____________________________________________________________________________________________
        }  
    }  
    }  