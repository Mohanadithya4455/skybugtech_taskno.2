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
class Task2{
    static List<A> questions;
    static int score;
    static boolean b;
    static int ind;
    static int common;
    Task2(){
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
    public static void main(String args[]){
        Task2 obj=new Task2();
       
        Scanner sc=new Scanner(System.in);
       while(ind<questions.size()-1){
         ind++;
         if(ind>0){
            System.out.println("Your present score is:"+score);
            System.out.println();
         }
        b=false;
        common=-1;
        
       int curr=ind;
        if(ind==0){
            System.out.println("                   **************START THE QUIZ***************                       ");
            System.out.println();
            System.out.println("                   *********INSTRUCTIONS FOR THE GAME*********                       ");
            System.out.println();
            System.out.println("*Time Limit to answer the question is 30 seconds");
            System.out.println("*If you answered after 30 seconds,Score will be not add to the existing score");
            System.out.println();
        }
        System.out.println("Your Time is 30 seconds");
        
        display();
        
        Timer time=new Timer();
        TimerTask t=new TimerTask() {
            public void run(){
                if(!b&&ind==curr){
                    if(ind==questions.size()-1){
                        common=-2;
                        System.out.println("Sorry,Time up!.Enter any number to get the result.");
                    }
                    else{
                    System.out.println("Sorry,Time up! .Enter any number for next question.");
                    common=-2;
                    }
                    time.cancel();
                    time.purge();
                    
                }
                
            }

        };
        time.schedule(t,30000);
        System.out.println("Enter your answer here:");
        int choosed=sc.nextInt();
        b=true;
        if(common==-2){
          //  ind++;
          if(ind==questions.size()-1){
            System.out.println("Your present score is:"+score);
          }
            continue;
        }
        
        if(b&&choosed==questions.get(ind).correct&&common==-1){
        System.out.println("Your answer is correct.");
        score++;
        }
        else if(ind==questions.size()-1&&b&&choosed==questions.get(ind).correct&&common==-1){
        System.out.println("Your answer is correct.");
        score++;
        }
        else if(b&&choosed!=questions.get(ind).correct&&common==-1){
            System.out.println("Your answer is wrong.");
        }
        else if(ind==questions.size()-1&&b&&choosed!=questions.get(ind).correct&&common==-1){
        System.out.println("Your answer is wrong.");
        
        }
        if(ind==questions.size()-1){
            System.out.println("Your present score is:"+score);
          }
       
        
       }
       System.out.println("*******QUIZ IS OVER*******");
       System.out.println("Your Final Score is:"+score);
    }
    public static void display(){
     A que=questions.get(ind);
     System.out.println(que.q);
     for(int i=0;i<que.options.size();i++){
      System.out.println(que.options.get(i));
     }
    }
}