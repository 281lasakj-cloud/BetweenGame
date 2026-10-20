import java.util.Scanner;

public class Between
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        int money = 100;

        System.out.println("In-Between Game");

        while (money > 0)
        {
            System.out.println("\nMoney: $" + money);
            System.out.print("Enter your bet: ");

            String betInput = input.nextLine().trim();

            if (betInput.equalsIgnoreCase("q"))
            {
                break;
            }

            int bet;

            try
            {
                bet = Integer.parseInt(betInput);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Enter a valid whole number.");
                continue;
            }

            if (bet <= 0)
            {
                System.out.println("Your bet must be greater than zero.");
                continue;
            }

            if (bet > money)
            {
                System.out.println("Don't bet more than you have.");
                continue;
            }

            Card first = deck.drawCard();
            Card second = deck.drawCard();

            System.out.println("\nFirst card:  " + first);
            System.out.println("Second card: " + second);

            int firstValue = first.getValue();
            int secondValue = second.getValue();

            int low = Math.min(firstValue, secondValue);
            int high = Math.max(firstValue, secondValue);
            int difference = high-low;

            if (difference == 0)
            {
                System.out.println("Matching cards!");
                money += bet;
            }
            else if (difference == 1)
            {
                System.out.println("Cards are one apart.");
                money -= bet;
            }
            else
            {
                int finBet = bet;
                System.out.println("Do you want to double your bet? (Y/N)");

                String doubleChoice = input.nextLine().trim();

                if (doubleChoice.equalsIgnoreCase("Y") || doubleChoice.equalsIgnoreCase("YES"))
                {
                    if (bet <= money - bet)
                    {
                        finBet = bet * 2;
                        System.out.println(
                            "Your bet is $" + finBet + "."
                        );
                    }
                    else
                    {
                        System.out.println("You don't have enough money to double your bet." + bet + ".");
                    }
                }

                String guess;

                while (true)
                {
                    System.out.print(
                        "Will the third card be inside or outside? "
                        + " use I or O: "
                    );

                    guess = input.nextLine().trim();

                    if (guess.equalsIgnoreCase("I") || guess.equalsIgnoreCase("INSIDE"))
                    {
                        guess = "I";
                        break;
                    }
                    else if (guess.equalsIgnoreCase("O") || guess.equalsIgnoreCase("OUTSIDE"))
                    {
                        guess = "O";
                        break;
                    }
                    else
                    {
                        System.out.println(
                            "Enter I for inside or O for outside."
                        );
                    }
                }

                Card third = deck.drawCard();
                System.out.println("Third card: " + third);

                int thirdValue = third.getValue();

                boolean inside = thirdValue > low && thirdValue < high;

                boolean outside = thirdValue < low || thirdValue > high;

                boolean won = (guess.equals("I") && inside) || (guess.equals("O") && outside);

                if (won)
                {
                    System.out.println("Correct guess, you win $" + bet + "!");
                    money += finBet;
                }
                else
                {
                    System.out.println("Wrong guess, you lose $" + bet + ".");
                    money -= finBet;
                }
            }

            System.out.println("Money remaining: $" + money);

            if (money == 0)
            {
                System.out.println("You ran out of money.");
            }
        }

        input.close();
    }
}