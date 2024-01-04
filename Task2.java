 
 import java.util.*;

class A{
    String q;
    List<String> options;
    int correct;
    A(String q,List<String> options,int correct){
     this.q=q;
     this.options=options;
     this.correct=correct;
    }
}
class B{
    List<A> questions;
    int score;
    boolean b;
    int ind;
    int common;
    B(){
        score=0;
        b=false;
        common=-1;
        questions=new ArrayList<>();
        questions.add(new A("What is the capital of India?",
                new ArrayList<>(List.of("1.Hyderabad", "2.Delhi", "3.Chennai", "4.Mumbai")), 2));
        questions.add(new A("What is the value 2*2=?",
                new ArrayList<>(List.of("1.4", "2.6", "3.7", "4.8")), 1));
        questions.add(new A("What is the capital of Austraila?",
                new ArrayList<>(List.of("1.Canberra", "2.Malaysia", "3.Washington", "4.Qatar")), 1));
        questions.add(new A("What is the value of 15+5=?",
                new ArrayList<>(List.of("1.10", "2.20", "3.30", "4.40")), 2));
        
        questions.add(new A("What is the value of 10*4=?",
                new ArrayList<>(List.of("1.20", "2.60", "3.100", "4.40")), 4));
        questions.add(new A("What is the capital of russia?",
                new ArrayList<>(List.of("1.Moscow", "2.Delhi", "3.Chennai", "4.Mumbai")), 1));
         ind=-1;
    }
    public void display(){
     A que=questions.get(ind);
     System.out.println(que.q);
     for(int i=0;i<que.options.size();i++){
      System.out.println(que.options.get(i));
     }
    }
    
}
class Task2{
    public static void main(String args[]){
        B obj=new B();
       
        Scanner sc=new Scanner(System.in);
       while(obj.ind<obj.questions.size()-1){
         obj.ind++;
         if(obj.ind>0){
            System.out.println("Your present score is:"+obj.score);
            System.out.println();
         }
        obj.b=false;
        obj.common=-1;
        
       int curr=obj.ind;
        if(obj.ind==0){
            System.out.println("                   **************START THE QUIZ***************                       ");
            System.out.println();
            System.out.println("                   *********INSTRUCTIONS FOR THE GAME*********                       ");
            System.out.println();
            System.out.println("*Time Limit to answer the question is 15 seconds");
            System.out.println("*If you answered after 15 seconds,Score will be not add to the existing score");
            System.out.println();
        }
        System.out.println("Your Time is 15 seconds");
        
        obj.display();
        
        Timer time=new Timer();
        TimerTask t=new TimerTask() {
            public void run(){
                if(!obj.b&&obj.ind==curr){
                    if(obj.ind==obj.questions.size()-1){
                        obj.common=-2;
                        System.out.println("Sorry,Time up!.Enter any number to get the result.");
                    }
                    else{
                    System.out.println("Sorry,Time up! .Enter any number for next question.");
                    obj.common=-2;
                    }
                    time.cancel();
                    time.purge();
                    
                }
                
            }

        };
        time.schedule(t,15000);
        System.out.println("Enter your answer here:");
        int choosed=sc.nextInt();
        obj.b=true;
        if(obj.common==-2){
          //  obj.ind++;
          if(obj.ind==obj.questions.size()-1){
            System.out.println("Your present score is:"+obj.score);
          }
            continue;
        }
        
        if(obj.b&&choosed==obj.questions.get(obj.ind).correct&&obj.common==-1){
        System.out.println("Your answer is correct.");
        obj.score++;
        }
        else if(obj.ind==obj.questions.size()-1&&obj.b&&choosed==obj.questions.get(obj.ind).correct&&obj.common==-1){
        System.out.println("Your answer is correct.");
        obj.score++;
        }
        else if(obj.b&&choosed!=obj.questions.get(obj.ind).correct&&obj.common==-1){
            System.out.println("Your answer is wrong.");
        }
        else if(obj.ind==obj.questions.size()-1&&obj.b&&choosed!=obj.questions.get(obj.ind).correct&&obj.common==-1){
        System.out.println("Your answer is wrong.");
        
        }
        if(obj.ind==obj.questions.size()-1){
            System.out.println("Your present score is:"+obj.score);
          }
       
        
       }
       System.out.println("*******QUIZ IS OVER*******");
       System.out.println("Your Final Score is:"+obj.score);
       sc.close();
    }
    
    
}