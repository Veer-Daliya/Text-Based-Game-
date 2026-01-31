//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Setting up the game

        World world1 = new World("The Open Fields");

        Weapon weapon1 = new Weapon("Sword", 5, 0, 0);

        Weapon weapon2 = new Weapon("Axe", 4, 0, 0);

        Item item1 = new Item("Potion", "Heals player", 10);

        Player player1 = new Player("Hero", 70, 2,20, weapon1,world1, item1);

        Enemy enemy = new Enemy ("Enemy", 50,2, 20, weapon2, world1);

        world1.setPlayer(player1);
        world1.setEnemy(enemy);






        //Scanner + print statement for the world
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Welcome to " + world1.getDescription());


        //Loop to check if player 1 and enemy is alive
        while(player1.isAlive() && enemy.isAlive()){
            System.out.println("\n" + "Type stats, attack, or heal, or quit" );
            String input = scanner.nextLine();

            if (input.equals("stats")){
            System.out.println(world1);
            }

            else if (input.equals("attack")){

                player1.attack(enemy);
                int playerDamage = player1.getAttack() + player1.getWeapon().getDamage();
                System.out.println(player1.getName() + " attacked " + enemy.getName() + " and dealt " + playerDamage + " damage!");


                if(!enemy.isAlive()){
                System.out.println (enemy.getName() + " has been defeated" );
                break;
                }
                else {
                System.out.println (enemy.getName() + " has survived");
                }



                enemy.attack(player1);
                int enemyDamage = enemy.getAttack() + enemy.getWeapon().getDamage();
                System.out.println("\n" + enemy.getName() + " attacked " + player1.getName() + " and dealt " + enemyDamage + " damage!");


                if(!player1.isAlive()){
                System.out.println (player1.getName() + " has survived");
                break;
                }
                else {
                System.out.println (player1.getName() + " has survived");
                }

                System.out.println("\n" + "Player: " + player1.getName() + "  " + "HP: " + player1.getHp() + "/" + player1.getMaxHp());
                System.out.println("Enemy: " + enemy.getName() + "  " + "HP: " + enemy.getHp() + "/" + enemy.getMaxHp()) ;



            }

            else if(input.equals ("heal")){
                player1.useItem();
                player1.setItem(null);
            }

            else if (input.equals ("quit")){
            System.out.println("Goodbye!");
             break;
            }




        }





        //add crit system if time






    }
}
