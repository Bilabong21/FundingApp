import java.util.Scanner;
import java.text.DecimalFormat;
public class FundingApp
{
    // your static variable here
    public static final double VAT_RATE = 1.15;

    public static void main(String[] args)
    {
        // your static variable here
         //public static final double VAT_RATE = 1.15;
        // Your static methods here

        // Your main starts here

            Scanner input= new Scanner(System.in);
            int apsScore, engPoints, mathPoints;
            double courseFees, payment ;
            System.out.print("Enter APS score:" );
            apsScore = input.nextInt();
            System.out.print("Enter Maths score: ");
            mathPoints = input.nextInt();
            System.out.print("Enter English score:");
            engPoints = input.nextInt();

            boolean qualifyVarsity = qualify(apsScore,mathPoints,engPoints);

            if(qualifyVarsity == true)
              {
                  System.out.println("Enter the course fee : ");
                  courseFees = input.nextDouble();
                   payment = calcCourseFees(mathPoints,courseFees);
                  displayFee(payment,courseFees);

              }else
                  {
                      System.out.println("Application rejected");
                  }
    }
    public static boolean qualify(int p_apsScore,int p_mathPoints,int p_engPoints)
    {
        boolean ans = false;

        if(p_apsScore >= 28 && (p_mathPoints >= 5 && p_engPoints >= 4 ))

            ans = true;

         return ans;
    }
    public static double calcCourseFees(int p_mathPoints,double p_courseFees )
    {
        double ppayment = 0.00;

        if(p_mathPoints ==7 )
         {

             ppayment = (p_courseFees * 0.1) * VAT_RATE;

         }else if(p_mathPoints >= 5 || p_mathPoints <= 6)
               {
                   ppayment = (p_courseFees * 0.2)* VAT_RATE;
               }

        return ppayment;
    }
    public static void displayFee(double p_courseFees,double p_ppayment)
    {
         DecimalFormat df = new DecimalFormat("###.00");

        System.out.println("Course fees " + df.format(p_ppayment));
        System.out.println("Your balance( including VAT) " + df.format(p_courseFees));
    }
}
