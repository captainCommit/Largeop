import javax.swing.*;
import java.awt.event.*;
class largeop
{
    public static class user
    {
       user()
       {
           new UI();
       }
       public class UI implements ActionListener
       {
            JFrame f;
            JTextField t1,t2,t3;
            JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
             largeint long1,long2;
            UI()
            {
                f=new JFrame("Large Operations");
                t1=new JTextField("Enter 1st Number");
                t2=new JTextField("Enter 2nd Number");
                t3=new JTextField("The Result Is Displayed Here" );
                b1=new JButton("Add");
                b2=new JButton("Subtract");
                b3=new JButton("Multiply");
                b8=new JButton("Divide");
                b4=new JButton("Increement");
                b5=new JButton("Decreement");
                b6=new JButton("Factorial");
                b7=new JButton("Clear");
                b9=new JButton("Compare");
                b0=new JButton("Modulo");
                t1.setBounds(30,40,280,30);
                t2.setBounds(30,80,280,30);
                t3.setBounds(30,120,280,30);
                b1.setBounds(30,160,120,40);
                b2.setBounds(160,160,120,40);
                b3.setBounds(30,210,120,40);
                b8.setBounds(160,210,120,40);
                b4.setBounds(30,260,120,40);
                b5.setBounds(160,260,120,40);
                b6.setBounds(30,310,120,40);
                b7.setBounds(160,310,120,40);
                b9.setBounds(30,360,120,40);
                b0.setBounds(160,360,120,40);
                f.add(t1);
                f.add(t2);
                f.add(t3);
                f.add(b0);
                f.add(b1);
                f.add(b2);
                f.add(b3);
                f.add(b4);
                f.add(b5);
                f.add(b6);
                f.add(b7);
                f.add(b8);
                f.add(b9);
                f.setLayout(null);
                f.setVisible(true);
                f.setSize(350,500);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setResizable(true);
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
                b4.addActionListener(this);
                b5.addActionListener(this);
                b6.addActionListener(this);
                b7.addActionListener(this);
                b8.addActionListener(this);
                b9.addActionListener(this);
                b0.addActionListener(this);
            }
            public void actionPerformed(ActionEvent e)
            {
                long1=new largeint(t1.getText());
                long2=new largeint(t2.getText());
                if(e.getSource()==b1)
                    t3.setText(add(long1,long2));
                if(e.getSource()==b2)
                    t3.setText(subtract(long1,long2));
                if(e.getSource()==b3)
                    t3.setText(multiply(long1,long2));
                if(e.getSource()==b4)
                   {
                       t2.setText("0");
                       long1.increement();
                       t3.setText(long1.ret_string());
                   }
                if(e.getSource()==b5)
                   {
                       t2.setText("0");
                       long1.decreement();
                       t3.setText(long1.ret_string());
                   } 
                if(e.getSource()==b6)
                {
                    t2.setText("0");
                    t3.setText(fact(long1));
                }
                if(e.getSource()==b7)
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                }
                if(e.getSource()==b8)
                {
                    t3.setText("");
                    int i=0;
                    for(i=0;i<divide(long1,long2).length();i++)
                    {
                        if(divide(long1,long2).charAt(i)=='0'&&(i<divide(long1,long2).length()-1))
                            continue;
                        else
                            t3.setText(t3.getText()+divide(long1,long2).charAt(i));
                    }
                }
                if(e.getSource()==b0)
                {
                    t3.setText(modulo(long1,long2));
                }
                if(e.getSource()==b9)
                {
                    String S1=long1.ret_string();
                    String S2=long2.ret_string();
                    if(S1.compareTo(S2)>0)
                        t3.setText(long1.ret_string()+" is greater than "+long2.ret_string());
                    else if(S1.compareTo(S2)==0)
                        t3.setText(long1.ret_string()+" is equal to "+long2.ret_string());
                    else if(S1.compareTo(S2)<0)
                        t3.setText(long1.ret_string()+" is smaller than "+long2.ret_string());    
                }
            }
       }
       public  class largeint
       {
            private String str;
            public String ret_string()
            {
                return str;
            }
            public largeint(String Str1)
            {
                str=Str1;
            }
            public largeint()
            {
                str="1";
            }
             void increement()
            {
                String S1=str;
                int n=0,carry=0,s=0;
                String Res=new String();
                for(int i=S1.length()-1;i>=0;i--)
                {
                    if(i==S1.length()-1)
                        n=1;
                    else
                        n=0;
                    s=(S1.charAt(i)-'0')+n+carry;
                    Res=s%10+Res;
                    carry=s/10;
                }
                Res=carry+Res;
                str=Res;
            }
            void decreement()
            {
                String S1=str;
                String Res=new String();
                int i=0,det=0,n=0,flag=0;
                for(i=S1.length()-1;i>=0;i--)
                {
                   if(i==S1.length()-1)
                         n=1;
                   else
                        n=0;
                   if((S1.charAt(i)-'0')>n)
                    {
                        if(det==1)
                        {
                            Res=((S1.charAt(i)-'0')-n-1)+Res;
                            det=0;
                        }
                        else
                        {
                            Res=((S1.charAt(i)-'0')-n)+Res;
                            det=0;
                        }
                    }
                    else if((S1.charAt(i)-'0')<n)
                    {
                        if(det==1)
                        {
                            Res=((S1.charAt(i)-'0')-n+9)+Res;
                            det=1;
                        }
                        else
                        {
                            Res=((S1.charAt(i)-'0')-n+10)+Res;
                            det=1;
                        }
                    }
                   else if((S1.charAt(i)-'0')==n)
                   {
                       if(det==0)
                       {
                            Res="0"+Res;
                            det=0;
                       }
                       if(det==1)
                       {
                            Res="9"+Res;
                            det=1;
                       }
                    }
                    str=Res;
                }
            }
       }
       boolean equal(largeint long1,largeint long2)
       {
            String S1=long1.ret_string();
            String S2=long2.ret_string();
            if(S1.length()!=S2.length())
                return false;
            else
            {
                for(int i=0;i<S1.length();i++)
                {
                    if(S1.charAt(i)!=S2.charAt(i))
                        return false;
                }
                return true;
            }
       }
       String add(largeint long1,largeint long2)//long1+long2
       {
            String S1=long1.ret_string();
            String S2=long2.ret_string();
            String Res=new String();
            String Max=new String();
            String Min=new String();
            int max=0,flag=0,s=0,carry=0;
            int flag_sign;
            int l1=S1.length();
            int l2=S2.length();
            int i=0;
            if(l1>l2)
            {
                for(i=0;i<l1-l2;i++)
                    S2="0"+S2;
                max=l1;
                flag=1;
                Max=S1;
                Min=S2;
            }
            else if(l2>l1)
            {
                for(i=0;i<l2-l1;i++)
                    S1="0"+S1;
                max=l2;
                flag=-1;
                Max=S2;
                Min=S1;
            }
            else
            {
                if(S1.compareTo(S2)>=0)
                {    
                    Max=S1;
                    Min=S2;
                    flag=1;
                    max=l1;
                }
                else
                {
                    Max=S2;
                    Min=S1;
                    flag=-1;
                    max=l1;
                }
            }
            for(i=max-1;i>=0;i--)
            {
                 s=(Max.charAt(i)-'0')+(Min.charAt(i)-'0')+carry;
                 Res=(s%10)+Res;
                 carry=s/10;
            }
            Res=carry+Res;
            return Res;
       }
       String subtract(largeint long1,largeint long2) //long1-long2
       {
            String S1=long1.ret_string();
            String S2=long2.ret_string();
            String Res=new String();
            String Max=new String();
            String Min=new String();
            int max=0,flag=0,det=0;
            int l1=S1.length();
            int l2=S2.length();
            int i=0;
            if(l1>l2)
            {
                for(i=0;i<l1-l2;i++)
                    S2="0"+S2;
                max=l1;
                flag=1;
                Max=S1;
                Min=S2;
            }
            else if(l2>l1)
            {
                for(i=0;i<l2-l1;i++)
                    S1="0"+S1;
                max=l2;
                flag=-1;
                Max=S2;
                Min=S1;
            }
            else
            {
                if(S1.compareTo(S2)>=0)
                {    
                    Max=S1;
                    Min=S2;
                    flag=1;
                    max=l1;
                }
                else
                {
                    Max=S2;
                    Min=S1;
                    flag=-1;
                    max=l1;
                }
            }
            for( i=max-1;i>=0;i--)
            {
                if(Max.charAt(i)>Min.charAt(i))
                {
                    if(det==1)
                    {
                        Res=((Max.charAt(i)-'0')-(Min.charAt(i)-'0')-1)+Res;
                        det=0;
                    }
                    else
                    {
                        Res=((Max.charAt(i)-'0')-(Min.charAt(i)-'0'))+Res;
                        det=0;
                    }
                }
                else if(Max.charAt(i)<Min.charAt(i))
                {
                    if(det==1)
                    {
                        Res=((Max.charAt(i)-'0')-(Min.charAt(i)-'0')+9)+Res;
                        det=1;
                    }
                    else
                    {
                        Res=((Max.charAt(i)-'0')-(Min.charAt(i)-'0')+10)+Res;
                        det=1;
                    }
                }
                else
                {
                    if(det==0)
                    {
                        Res="0"+Res;
                        det=0;
                    }
                    if(det==1)
                    {
                        Res="9"+Res;
                        det=1;
                    }
                }
            }
            if(flag==-1)
                Res="-"+Res;
            return Res;
       }
       String multiply(largeint long1,largeint long2)//long1*long2
       {
            String S1=long1.ret_string();
            String S2=long2.ret_string();
            String n1 = new StringBuilder(S1).reverse().toString();
            String n2 = new StringBuilder(S2).reverse().toString();
            int[] d = new int[S1.length()+S2.length()];
            for(int i=0; i<n1.length(); i++)
            {
                for(int j=0; j<n2.length(); j++)
                {
                    d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
                }
            }
            StringBuilder sb = new StringBuilder();
            //calculate each digit
            for(int i=0; i<d.length; i++)
            {
                int mod = d[i]%10;
                int carry = d[i]/10;
                if(i+1<d.length)
                {
                    d[i+1] += carry;
                }
                sb.insert(0, mod);
            }
            //remove front 0's
            while(sb.charAt(0) == '0' && sb.length()> 1)
            {
                sb.deleteCharAt(0);
            }
            return sb.toString();
       }
       String fact(largeint long1)
       {
            String n=new String();
            String S1=long1.ret_string();
            String temp=new String("1");
            String t1=new String();
            for(int i=0;i<S1.length();i++)
                t1="0"+t1;
            while(long1.ret_string().compareTo(t1)!=0)
            {
                largeint temp1=new largeint(temp);
                temp=multiply(long1,temp1);
                long1.decreement();
            }
            return temp;
       }
       int compare(String str1,String str2,int l1,int l2)
       {
            int i=0;
            if(l1>l2)
            {
                for(i=0;i<l1-l2;i++)
                {
                    str2="0"+str2;
                }
            }
            if(l2>l1)
            {
                for(i=0;i<l2-l1;i++)
                    str1="0"+str1;
            }
            return str1.compareTo(str2);
       }
       String divide(largeint long1,largeint long2)//long1/long2
       {
           String S1=long1.ret_string();
           String s1=new String("0");
           String S2=long2.ret_string();
           largeint l=new largeint("0");
           String temp=new String();
           if(compare(S1,S2,S1.length(),S2.length())<=0)
                return s1;
           while(compare(temp,S1,temp.length(),S1.length())<=0)
           {
               temp=multiply(long2,l);
               l.increement();
           }
           largeint l1=new largeint("2");
           return subtract(l,l1);
       }
       String modulo(largeint long1,largeint long2)
       {
           String temp=divide(long1,long2);
           largeint ex=new largeint(temp);
           largeint ex1=new largeint(multiply(ex,long2));
           String Res=subtract(long1,ex1);
           return Res;
       }
    }
    public static void main(String...s)
    {
          new user();
    }
}